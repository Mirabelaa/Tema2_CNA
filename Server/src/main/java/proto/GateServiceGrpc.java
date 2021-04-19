package proto;

import java.io.FileNotFoundException;
import java.text.ParseException;

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
    comments = "Source: gate.proto")
public final class GateServiceGrpc {

  private GateServiceGrpc() {}

  public static final String SERVICE_NAME = "GateService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<proto.Gate.ZodiacRequest,
      proto.Gate.ZodiacResponse> getGetZodiacSignMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getZodiacSign",
      requestType = proto.Gate.ZodiacRequest.class,
      responseType = proto.Gate.ZodiacResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<proto.Gate.ZodiacRequest,
      proto.Gate.ZodiacResponse> getGetZodiacSignMethod() {
    io.grpc.MethodDescriptor<proto.Gate.ZodiacRequest, proto.Gate.ZodiacResponse> getGetZodiacSignMethod;
    if ((getGetZodiacSignMethod = GateServiceGrpc.getGetZodiacSignMethod) == null) {
      synchronized (GateServiceGrpc.class) {
        if ((getGetZodiacSignMethod = GateServiceGrpc.getGetZodiacSignMethod) == null) {
          GateServiceGrpc.getGetZodiacSignMethod = getGetZodiacSignMethod = 
              io.grpc.MethodDescriptor.<proto.Gate.ZodiacRequest, proto.Gate.ZodiacResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GateService", "getZodiacSign"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Gate.ZodiacRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  proto.Gate.ZodiacResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GateServiceMethodDescriptorSupplier("getZodiacSign"))
                  .build();
          }
        }
     }
     return getGetZodiacSignMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GateServiceStub newStub(io.grpc.Channel channel) {
    return new GateServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GateServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GateServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GateServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GateServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GateServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getZodiacSign(proto.Gate.ZodiacRequest request,
        io.grpc.stub.StreamObserver<proto.Gate.ZodiacResponse> responseObserver) throws FileNotFoundException, ParseException {
      asyncUnimplementedUnaryCall(getGetZodiacSignMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetZodiacSignMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                proto.Gate.ZodiacRequest,
                proto.Gate.ZodiacResponse>(
                  this, METHODID_GET_ZODIAC_SIGN)))
          .build();
    }
  }

  /**
   */
  public static final class GateServiceStub extends io.grpc.stub.AbstractStub<GateServiceStub> {
    private GateServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GateServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GateServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GateServiceStub(channel, callOptions);
    }

    /**
     */
    public void getZodiacSign(proto.Gate.ZodiacRequest request,
        io.grpc.stub.StreamObserver<proto.Gate.ZodiacResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetZodiacSignMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GateServiceBlockingStub extends io.grpc.stub.AbstractStub<GateServiceBlockingStub> {
    private GateServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GateServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GateServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GateServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public proto.Gate.ZodiacResponse getZodiacSign(proto.Gate.ZodiacRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetZodiacSignMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GateServiceFutureStub extends io.grpc.stub.AbstractStub<GateServiceFutureStub> {
    private GateServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GateServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GateServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GateServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<proto.Gate.ZodiacResponse> getZodiacSign(
        proto.Gate.ZodiacRequest request) {
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
    private final GateServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GateServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ZODIAC_SIGN:
          try {
            serviceImpl.getZodiacSign((Gate.ZodiacRequest) request,
                (io.grpc.stub.StreamObserver<Gate.ZodiacResponse>) responseObserver);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          } catch (ParseException e) {
            e.printStackTrace();
          }
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

  private static abstract class GateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GateServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return proto.Gate.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GateService");
    }
  }

  private static final class GateServiceFileDescriptorSupplier
      extends GateServiceBaseDescriptorSupplier {
    GateServiceFileDescriptorSupplier() {}
  }

  private static final class GateServiceMethodDescriptorSupplier
      extends GateServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GateServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GateServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GateServiceFileDescriptorSupplier())
              .addMethod(getGetZodiacSignMethod())
              .build();
        }
      }
    }
    return result;
  }
}
