package com.wong.webservice.webservicetax;

import com.wong.webservice.webservicetax.service.TaxCalculationService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws Exception {
        System.setProperty("javax.xml.bind.JAXBContext", "com.sun.xml.internal.bind.v2.ContextFactory");
        URL url = new URL("http://localhost:8080/ws/api?wsdl");
        QName qName = new QName("http://service.webservicetax.webservice.wong.com", "TaxCalculationServiceImplService");
        Service service = Service.create(url, qName);
        TaxCalculationService myServer = service.getPort(TaxCalculationService.class);
        System.out.println("15000.00的个人所得税为 : " + myServer.getTax(15000.00) + "元");
    }
}
