package services;


import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import proto.Gate;
import proto.GateServiceGrpc;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class GateImpl extends GateServiceGrpc.GateServiceImplBase
{

    @Override
    public void getZodiacSign(Gate.ZodiacRequest request, StreamObserver<Gate.ZodiacResponse> responseObserver) throws FileNotFoundException, ParseException {
        switch(request.getOption())
        {
            case 1:
            {
                new ZodiacImpl().getZodiacSign(request, responseObserver);
                break;
            }

            case 2:
            {
                new ChineseZodiacImpl().getZodiacSign(request, responseObserver);
                break;
            }

            default:
            {
                Status status = Status.INVALID_ARGUMENT.withDescription("Invalid input from client.");
                responseObserver.onError(status.asRuntimeException());
            }
        }

    }
}
