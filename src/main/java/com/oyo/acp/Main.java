package com.oyo.acp;

import com.oyo.acp.handlers.MovieHandler;
import com.oyo.acp.handlers.TheatreHandler;
import com.oyo.bookmyshow.TMovieService;
import com.oyo.bookmyshow.TTheatreService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;

@EnableAutoConfiguration
@SpringBootApplication
public class Main {

    @Autowired
    MovieHandler movieHandler;

    @Autowired
    TheatreHandler theatreHandler;

    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @Bean
    public TProtocolFactory tProtocolFactory(){
        return new TBinaryProtocol.Factory();
    }

//    @Bean(name = "movieBean")
//    public ServletRegistrationBean MovieServlet(TProtocolFactory protocolFactory, MovieHandler movieHandler){
//        TServlet tServlet = new TServlet(new TMovieService.Processor<>(movieHandler), protocolFactory);
//        ServletRegistrationBean bean = new ServletRegistrationBean(tServlet,"/movie");
//        return bean;
//    }

    @Bean
    public Servlet movie() {
        TProcessor processor =
                new TMovieService.Processor<>(movieHandler);
        TProtocolFactory protoFactory = new TJSONProtocol.Factory();
        return new TServlet(processor, protoFactory);
    }

    @Bean
    public Servlet theatre() {
        TProcessor processor =
                new TTheatreService.Processor<>(theatreHandler);
        TProtocolFactory protoFactory = new TJSONProtocol.Factory();
        return new TServlet(processor, protoFactory);
    }

}
