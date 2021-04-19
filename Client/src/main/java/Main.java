import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto.Gate;
import proto.GateServiceGrpc;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8999).usePlaintext().build();

        GateServiceGrpc.GateServiceStub zodiacStub = GateServiceGrpc.newStub(channel);

        System.out.println("MENU");
        System.out.println("Press 1 for European zodiac");
        System.out.println("Press 2 for chinese zodiac");
        System.out.println("Press 3 to quit");

        boolean isConnected = true;
        while (isConnected) {
            Scanner input = new Scanner(System.in);

            int option =0;
            try{
                option  = input.nextInt();
                int i;
                i= Integer.parseInt(String.valueOf(option));
            }catch(Exception e){
                System.out.println("Not an integer");
            }
            switch (option){
                case 1:
                case 2: {
                    Scanner read = new Scanner(System.in).useDelimiter("\n");
                    System.out.println("The date is: ");

                    String date = read.next();
                    ZodiacHelper helper = new ZodiacHelper();
                    while (!helper.isDateValid(date)) {
                        System.out.println("Incorrect date!");
                        date = input.next();
                    }


                        zodiacStub.getZodiacSign(Gate.ZodiacRequest.newBuilder().setOption(option).setDate(date).build(),
                                new StreamObserver<Gate.ZodiacResponse>() {
                                    @Override
                                    public void onNext(Gate.ZodiacResponse zodiacResponse) {
                                        System.out.println(zodiacResponse);
                                    }

                                    @Override
                                    public void onError(Throwable throwable) {
                                        System.out.println("Error : " + throwable.getMessage());
                                    }

                                    @Override
                                    public void onCompleted() {

                                    }
                                });
                        break;
                    }


            case 3: {
                isConnected = false;
                break;
            }
            default:
                System.out.println("Unknown command, insert a valid command!");
        }

    }
        channel.shutdown();
    }
}


