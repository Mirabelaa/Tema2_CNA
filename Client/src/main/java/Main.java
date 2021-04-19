import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto.Gate;
import proto.GateServiceGrpc;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8999).usePlaintext().build();
        /* Synchronous stub */
        //BookServiceGrpc.BookServiceBlockingStub zodiacStub = BookServiceGrpc.newBlockingStub(channel);

        /* To be capable to stream with out client we must use a Asynchronous stub */
        GateServiceGrpc.GateServiceStub zodiacStub = GateServiceGrpc.newStub(channel);

        System.out.println("MENU");
        System.out.println("Press 1 for European zodiac");
        System.out.println("Press 2 for chinese zodiac");

        boolean isConnected = true;
        while (isConnected) {
            Scanner input = new Scanner(System.in);
            System.out.println("Choose:");
            int option = input.nextInt();
            Scanner read = new Scanner(System.in).useDelimiter("\n");
            System.out.println("The date is: ");

            String date = read.next();

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

        }
        isConnected = false;
        channel.shutdown();

    }
}


