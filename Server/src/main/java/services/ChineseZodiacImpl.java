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

    @Override
    public void getZodiacSign(Gate.ZodiacRequest request, StreamObserver<Gate.ZodiacResponse> responseObserver) throws FileNotFoundException, ParseException {
        ZodiacHelper helper = new ZodiacHelper();
        if (helper.isDateValid(request.getDate())) {
            Gate.ZodiacResponse response = Gate.ZodiacResponse.newBuilder().setZodiacSign(helper.findChineseZodiacSign(request.getDate())).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        Status status = Status.INVALID_ARGUMENT.withDescription("Error");
        responseObserver.onError(status.asRuntimeException());
    }
}
