package com.oyo.acp;

import com.oyo.acp.handlers.MovieHandler;
import com.oyo.bookmyshow.TMovieService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }


    @Bean
    public TProtocolFactory tProtocolFactory(){
        return new TBinaryProtocol.Factory();
    }

    @Bean(name = "movieBean")
    public ServletRegistrationBean MovieServlet(TProtocolFactory protocolFactory, MovieHandler movieHandler){
        TServlet tServlet = new TServlet(new TMovieService.Processor<>(movieHandler), protocolFactory);
        ServletRegistrationBean bean = new ServletRegistrationBean(tServlet,"/movie");
        return bean;
    }
}
