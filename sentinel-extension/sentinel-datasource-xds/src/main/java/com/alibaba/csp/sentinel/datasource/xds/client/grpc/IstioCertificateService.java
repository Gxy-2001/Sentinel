// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ca.proto

package com.alibaba.csp.sentinel.datasource.xds.client.grpc;

/**
 * <pre>
 * Service for managing certificates issued by the CA.
 * </pre>
 * <p>
 * Protobuf service {@code istio.v1.auth.IstioCertificateService}
 */
public abstract class IstioCertificateService implements com.google.protobuf.Service {

    protected IstioCertificateService() {
    }

    public static com.google.protobuf.Service newReflectiveService(final Interface impl) {
        return new IstioCertificateService() {
            @Override
            public void createCertificate(com.google.protobuf.RpcController controller,
                                          IstioCertificateRequest request,
                                          com.google.protobuf.RpcCallback<IstioCertificateResponse> done) {
                impl.createCertificate(controller, request, done);
            }

        };
    }

    public static com.google.protobuf.BlockingService newReflectiveBlockingService(
        final BlockingInterface impl) {
        return new com.google.protobuf.BlockingService() {
            public final com.google.protobuf.Descriptors.ServiceDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public final com.google.protobuf.Message callBlockingMethod(
                com.google.protobuf.Descriptors.MethodDescriptor method,
                com.google.protobuf.RpcController controller,
                com.google.protobuf.Message request)
                throws com.google.protobuf.ServiceException {
                if (method.getService() != getDescriptor()) {
                    throw new IllegalArgumentException(
                        "Service.callBlockingMethod() given method descriptor for "
                            + "wrong service type.");
                }
                switch (method.getIndex()) {
                    case 0:
                        return impl.createCertificate(controller,
                            (IstioCertificateRequest) request);
                    default:
                        throw new AssertionError("Can't get here.");
                }
            }

            public final com.google.protobuf.Message getRequestPrototype(
                com.google.protobuf.Descriptors.MethodDescriptor method) {
                if (method.getService() != getDescriptor()) {
                    throw new IllegalArgumentException(
                        "Service.getRequestPrototype() given method "
                            + "descriptor for wrong service type.");
                }
                switch (method.getIndex()) {
                    case 0:
                        return IstioCertificateRequest.getDefaultInstance();
                    default:
                        throw new AssertionError("Can't get here.");
                }
            }

            public final com.google.protobuf.Message getResponsePrototype(
                com.google.protobuf.Descriptors.MethodDescriptor method) {
                if (method.getService() != getDescriptor()) {
                    throw new IllegalArgumentException(
                        "Service.getResponsePrototype() given method "
                            + "descriptor for wrong service type.");
                }
                switch (method.getIndex()) {
                    case 0:
                        return IstioCertificateResponse.getDefaultInstance();
                    default:
                        throw new AssertionError("Can't get here.");
                }
            }

        };
    }

    public static final com.google.protobuf.Descriptors.ServiceDescriptor getDescriptor() {
        return Ca.getDescriptor().getServices().get(0);
    }

    public static Stub newStub(com.google.protobuf.RpcChannel channel) {
        return new Stub(channel);
    }

    public static BlockingInterface newBlockingStub(
        com.google.protobuf.BlockingRpcChannel channel) {
        return new BlockingStub(channel);
    }

    /**
     * <pre>
     * Using provided CSR, returns a signed certificate.
     * </pre>
     *
     * <code>rpc CreateCertificate(.istio.v1.auth.IstioCertificateRequest) returns
     * (.istio.v1.auth.IstioCertificateResponse);</code>
     */
    public abstract void createCertificate(com.google.protobuf.RpcController controller,
                                           IstioCertificateRequest request,
                                           com.google.protobuf.RpcCallback<IstioCertificateResponse> done);

    public final com.google.protobuf.Descriptors.ServiceDescriptor getDescriptorForType() {
        return getDescriptor();
    }

    public final void callMethod(com.google.protobuf.Descriptors.MethodDescriptor method,
                                 com.google.protobuf.RpcController controller,
                                 com.google.protobuf.Message request,
                                 com.google.protobuf.RpcCallback<com.google.protobuf.Message> done) {
        if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
                "Service.callMethod() given method descriptor for wrong "
                    + "service type.");
        }
        switch (method.getIndex()) {
            case 0:
                this.createCertificate(controller, (IstioCertificateRequest) request,
                    com.google.protobuf.RpcUtil
                        .<IstioCertificateResponse>specializeCallback(done));
                return;
            default:
                throw new AssertionError("Can't get here.");
        }
    }

    public final com.google.protobuf.Message getRequestPrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
                "Service.getRequestPrototype() given method "
                    + "descriptor for wrong service type.");
        }
        switch (method.getIndex()) {
            case 0:
                return IstioCertificateRequest.getDefaultInstance();
            default:
                throw new AssertionError("Can't get here.");
        }
    }

    public final com.google.protobuf.Message getResponsePrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
        if (method.getService() != getDescriptor()) {
            throw new IllegalArgumentException(
                "Service.getResponsePrototype() given method "
                    + "descriptor for wrong service type.");
        }
        switch (method.getIndex()) {
            case 0:
                return IstioCertificateResponse.getDefaultInstance();
            default:
                throw new AssertionError("Can't get here.");
        }
    }

    public interface Interface {

        /**
         * <pre>
         * Using provided CSR, returns a signed certificate.
         * </pre>
         *
         * <code>rpc CreateCertificate(.istio.v1.auth.IstioCertificateRequest) returns
         * (.istio.v1.auth.IstioCertificateResponse);</code>
         */
        public abstract void createCertificate(
            com.google.protobuf.RpcController controller,
            IstioCertificateRequest request,
            com.google.protobuf.RpcCallback<IstioCertificateResponse> done);

    }

    public interface BlockingInterface {

        public IstioCertificateResponse createCertificate(
            com.google.protobuf.RpcController controller,
            IstioCertificateRequest request)
            throws com.google.protobuf.ServiceException;

    }

    public static final class Stub extends IstioCertificateService implements Interface {

        private final com.google.protobuf.RpcChannel channel;

        private Stub(com.google.protobuf.RpcChannel channel) {
            this.channel = channel;
        }

        public com.google.protobuf.RpcChannel getChannel() {
            return channel;
        }

        public void createCertificate(com.google.protobuf.RpcController controller,
                                      IstioCertificateRequest request,
                                      com.google.protobuf.RpcCallback<IstioCertificateResponse> done) {
            channel.callMethod(getDescriptor().getMethods().get(0), controller, request,
                IstioCertificateResponse.getDefaultInstance(),
                com.google.protobuf.RpcUtil.generalizeCallback(done,
                    IstioCertificateResponse.class,
                    IstioCertificateResponse.getDefaultInstance()));
        }

    }

    private static final class BlockingStub implements BlockingInterface {

        private final com.google.protobuf.BlockingRpcChannel channel;

        private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
            this.channel = channel;
        }

        public IstioCertificateResponse createCertificate(
            com.google.protobuf.RpcController controller,
            IstioCertificateRequest request)
            throws com.google.protobuf.ServiceException {
            return (IstioCertificateResponse) channel.callBlockingMethod(
                getDescriptor().getMethods().get(0), controller, request,
                IstioCertificateResponse.getDefaultInstance());
        }

    }

    // @@protoc_insertion_point(class_scope:istio.v1.auth.IstioCertificateService)

}
