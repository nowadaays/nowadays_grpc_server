package org.example.grpc;

import hello.HelloServiceGrpc;
import hello.HelloServiceOuterClass;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceGrpcImpl {
    @GrpcClient("GLOBAL")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    public String hello(String name){
        return helloServiceBlockingStub.hello(genetatedHelloRequest(name)).getHello();
    }

    private hello.HelloServiceOuterClass.HelloRequest genetatedHelloRequest(String name){
        return HelloServiceOuterClass.HelloRequest.newBuilder().setName(name).build();
    }
}
