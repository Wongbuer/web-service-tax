package com.wong.webservice.webservicetax.config;

import com.wong.webservice.webservicetax.service.TaxCalculationService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class StartClas {

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean(name = "wsBean")
    public ServletRegistrationBean dispatcherServlet() {
        ServletRegistrationBean wbsServlet = new ServletRegistrationBean(new CXFServlet(), "/ws/*");
        return wbsServlet;
    }


    @Bean
    public Endpoint endpointPurchase(SpringBus springBus, TaxCalculationService taxCalculationService) {
        EndpointImpl endpoint = new EndpointImpl(springBus(), taxCalculationService);
        endpoint.publish("/api");
        System.out.println("服务发布成功！地址为：http://localhost:8080/ws/api?wsdl");
        return endpoint;


    }
}


