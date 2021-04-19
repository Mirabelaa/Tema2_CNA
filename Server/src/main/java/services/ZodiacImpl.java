package services;

import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import proto.Gate;
import proto.Zodiac;
import proto.ZodiacServiceGrpc;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ZodiacImpl extends ZodiacServiceGrpc.ZodiacServiceImplBase {

    private static String date_format="dd/MM/yyyy";



    public String findZodiacSign(String date) throws FileNotFoundException, ParseException {
        Map<Map<String,String>,String> zodiacSigns=new HashMap<>();
        ReadZodiac zod = new ReadZodiac();
        try {
            zodiacSigns = zod.readZodiacSignsFormFile("/facultate/an2/sem2/CNA/tema2/Server/src/main/resources/zodiac.txt");
        }
        catch(java.io.FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        DateFormat dateFormat= new SimpleDateFormat(date_format);
        Date date1 = dateFormat.parse(date);

        System.out.println(date1);
        for(Map.Entry<Map<String,String>,String> entry : zodiacSigns.entrySet())
        {
            Map<String,String> dates = entry.getKey();
            String name = entry.getValue();
            for(Map.Entry<String,String> entry1 : dates.entrySet()) {
                String b= entry1.getKey()+date.substring(5,10);

                Date begin = dateFormat.parse(b);
                String e= entry1.getValue()+date.substring(5,10);

                Date end = dateFormat.parse(e);

                if (date1.after(begin) && date1.before(end) || date1.equals(begin) || date1.equals(end)) {

                    System.out.println("daaaa");
                    return name;
                }
            }


        }
        return "not found";
    }

    Map<Map<String,String>,String> zodiacSigns = new HashMap<>();


    @Override
    public void getZodiacSign(Gate.ZodiacRequest request, StreamObserver<Gate.ZodiacResponse> responseObserver) throws FileNotFoundException, ParseException {
        Validation v = new Validation();
        if(v.isDateValid(request.getDate()))
        {
            Gate.ZodiacResponse response = Gate.ZodiacResponse.newBuilder().setZodiacSign(findZodiacSign(request.getDate())).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        Status status = Status.INVALID_ARGUMENT.withDescription("Error");
        responseObserver.onError(status.asRuntimeException());
    }
    
}
