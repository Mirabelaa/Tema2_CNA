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

    @Override
    public void getZodiacSign(Gate.ZodiacRequest request, StreamObserver<Gate.ZodiacResponse> responseObserver) throws FileNotFoundException, ParseException {
        ZodiacHelper helper = new ZodiacHelper();
        if(helper.isDateValid(request.getDate()))
        {
            Gate.ZodiacResponse response = Gate.ZodiacResponse.newBuilder().setZodiacSign(helper.findZodiacSign(request.getDate())).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        Status status = Status.INVALID_ARGUMENT.withDescription("Error");
        responseObserver.onError(status.asRuntimeException());
    }
    
}
