package services;

import io.grpc.stub.StreamObserver;
import proto.ChineseZodiacServiceGrpc;
import proto.Gate;
import proto.ZodiacServiceGrpc;

public class ChineseZodiacImpl extends ChineseZodiacServiceGrpc.ChineseZodiacServiceImplBase{
    @Override
    public void getZodiacSign(Gate.ZodiacRequest request, StreamObserver<Gate.ZodiacResponse> responseObserver) {
        super.getZodiacSign(request, responseObserver);
    }
}
