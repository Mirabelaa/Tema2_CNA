package services;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import proto.ChineseZodiac;
import proto.ChineseZodiacServiceGrpc;
import proto.Gate;
import proto.ZodiacServiceGrpc;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ChineseZodiacImpl extends ChineseZodiacServiceGrpc.ChineseZodiacServiceImplBase {

    private static String date_format = "dd/MM/yyyy";

    public String findZodiacSign(String date) throws FileNotFoundException, ParseException {
        Map<ArrayList<String>, String> zodiacSigns = new HashMap<>();
        ReadZodiac zod = new ReadZodiac();
        try {
            zodiacSigns = zod.readChineseZodiacSignsFormFile("/facultate/an2/sem2/CNA/tema2/Server/src/main/resources/chineseZodiac.txt");
        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String saa=date.substring(6,10);

        for (Map.Entry<ArrayList<String>, String> entry : zodiacSigns.entrySet()) {
            ArrayList<String> years = entry.getKey();
            String name = entry.getValue();
            System.out.println(name);
            for (String s : years) {

                if (saa.equals(s)) {
                    return name;
                }
            }
        }
        return "not found";
    }

    @Override
    public void getZodiacSign(Gate.ZodiacRequest request, StreamObserver<Gate.ZodiacResponse> responseObserver) throws FileNotFoundException, ParseException {
        Validation v = new Validation();
        if (v.isDateValid(request.getDate())) {
            Gate.ZodiacResponse response = Gate.ZodiacResponse.newBuilder().setZodiacSign(findZodiacSign(request.getDate())).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        Status status = Status.INVALID_ARGUMENT.withDescription("Error");
        responseObserver.onError(status.asRuntimeException());
    }
}
