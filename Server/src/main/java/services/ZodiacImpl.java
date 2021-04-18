package services;

import com.google.protobuf.InvalidProtocolBufferException;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import proto.ZodiacOuterClass;
import proto.ZodiacServiceGrpc;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.zip.DataFormatException;

public class ZodiacImpl extends ZodiacServiceGrpc.ZodiacServiceImplBase {

    private static String date_format="dd/MM/yyyy";

    public boolean isDateValid( String date){
        try{
            DateFormat dateFormat= new SimpleDateFormat(date_format);
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return true;
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
            return false;
        }
        catch (InputMismatchException ex)
        {
            System.out.println(ex);
            return false;
        }

        catch (DateTimeException ex)
        {
            System.out.println(ex);
            return false;
        }

    }

    public Map<Map<String,String>,String> readZodiacSignsFormFile() throws FileNotFoundException {
        Map<Map<String,String>,String> zodiacSigns=new HashMap<>();
        try{
            File file = new File("/facultate/an2/sem2/CNA/tema2/Server/src/main/resources/zodiac.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String beginDate = sc.next();
                String endDate = sc.next();
                Map<String,String> dates = new HashMap<>();
                dates.put(beginDate,endDate);
                String zodiacName = sc.next();
                zodiacSigns.put(dates, zodiacName);
            }
            sc.close();
            return zodiacSigns;
        }
        catch (FileNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return zodiacSigns;
    }

    public String findZodiacSign(String date) throws FileNotFoundException, ParseException {
        Map<Map<String,String>,String> zodiacSigns=new HashMap<>();
        zodiacSigns = readZodiacSignsFormFile();
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

    @Override
    public void getZodiacSign(ZodiacOuterClass.ZodiacRequest request, StreamObserver<ZodiacOuterClass.ZodiacResponse> responseObserver) throws FileNotFoundException, ParseException, InvalidProtocolBufferException {
        ZodiacOuterClass.ZodiacResponse response;
        ZodiacOuterClass.Zodiac zodiac = null;
        if(isDateValid(request.getDate())) {
            response = ZodiacOuterClass.ZodiacResponse.newBuilder().setInformation(new  ZodiacOuterClass.Zodiac(request.getDate(), findZodiacSign(request.getDate()))).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }

    }
}
