package com.wong.webservice.webservicetax.service;

import javax.jws.WebService;

@WebService(
        name = "TaxCalculationService",
        targetNamespace = "http://service.webservicetax.webservice.wong.com")
public interface TaxCalculationService {
    Double getTax(Double salary);
}
