package proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: chineseZodiac.proto")
public final class ChineseZodiacServiceGrpc {

  private ChineseZodiacServiceGrpc() {}

  public static final String SERVICE_NAME = "ChineseZodiacService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.ChineseZodiac.ZodiacRequest,
      proto.ChineseZodiac.ZodiacResponse> getGetZodiacSignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getZodiacSign",
      requestType = proto.ChineseZodiac.ZodiacRequest.class,
      responseType = proto.ChineseZodiac.ZodiacResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.ChineseZodiac.ZodiacRequest,
      proto.ChineseZodiac.ZodiacResponse> getGetZodiacSignMethod() {
    io.grpc.MethodDescriptor<proto.ChineseZodiac.ZodiacRequest, proto.ChineseZodiac.ZodiacResponse> getGetZodiacSignMethod;
    if ((getGetZodiacSignMethod = ChineseZodiacServiceGrpc.getGetZodiacSignMethod) == null) {
      synchronized (ChineseZodiacServiceGrpc.class) {
        if ((getGetZodiacSignMethod = ChineseZodiacServiceGrpc.getGetZodiacSignMethod) == null) {
          ChineseZodiacServiceGrpc.getGetZodiacSignMethod = getGetZodiacSignMethod = 
              io.grpc.MethodDescriptor.<proto.ChineseZodiac.ZodiacRequest, proto.ChineseZodiac.ZodiacResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "ChineseZodiacService", "getZodiacSign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ChineseZodiac.ZodiacRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.ChineseZodiac.ZodiacResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ChineseZodiacServiceMethodDescriptorSupplier("getZodiacSign"))
                  .build();
          }
        }
     }
     return getGetZodiacSignMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChineseZodiacServiceStub newStub(io.grpc.Channel channel) {
    return new ChineseZodiacServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChineseZodiacServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ChineseZodiacServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChineseZodiacServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ChineseZodiacServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ChineseZodiacServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getZodiacSign(proto.ChineseZodiac.ZodiacRequest request,
        io.grpc.stub.StreamObserver<proto.ChineseZodiac.ZodiacResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetZodiacSignMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetZodiacSignMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.ChineseZodiac.ZodiacRequest,
                proto.ChineseZodiac.ZodiacResponse>(
                  this, METHODID_GET_ZODIAC_SIGN)))
          .build();
    }
  }

  /**
   */
  public static final class ChineseZodiacServiceStub extends io.grpc.stub.AbstractStub<ChineseZodiacServiceStub> {
    private ChineseZodiacServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChineseZodiacServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChineseZodiacServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChineseZodiacServiceStub(channel, callOptions);
    }

    /**
     */
    public void getZodiacSign(proto.ChineseZodiac.ZodiacRequest request,
        io.grpc.stub.StreamObserver<proto.ChineseZodiac.ZodiacResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetZodiacSignMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChineseZodiacServiceBlockingStub extends io.grpc.stub.AbstractStub<ChineseZodiacServiceBlockingStub> {
    private ChineseZodiacServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChineseZodiacServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChineseZodiacServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChineseZodiacServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.ChineseZodiac.ZodiacResponse getZodiacSign(proto.ChineseZodiac.ZodiacRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetZodiacSignMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChineseZodiacServiceFutureStub extends io.grpc.stub.AbstractStub<ChineseZodiacServiceFutureStub> {
    private ChineseZodiacServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ChineseZodiacServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChineseZodiacServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ChineseZodiacServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.ChineseZodiac.ZodiacResponse> getZodiacSign(
        proto.ChineseZodiac.ZodiacRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetZodiacSignMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ZODIAC_SIGN = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChineseZodiacServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChineseZodiacServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ZODIAC_SIGN:
          serviceImpl.getZodiacSign((proto.ChineseZodiac.ZodiacRequest) request,
              (io.grpc.stub.StreamObserver<proto.ChineseZodiac.ZodiacResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChineseZodiacServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChineseZodiacServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.ChineseZodiac.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChineseZodiacService");
    }
  }

  private static final class ChineseZodiacServiceFileDescriptorSupplier
      extends ChineseZodiacServiceBaseDescriptorSupplier {
    ChineseZodiacServiceFileDescriptorSupplier() {}
  }

  private static final class ChineseZodiacServiceMethodDescriptorSupplier
      extends ChineseZodiacServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChineseZodiacServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChineseZodiacServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChineseZodiacServiceFileDescriptorSupplier())
              .addMethod(getGetZodiacSignMethod())
              .build();
        }
      }
    }
    return result;
  }
}
