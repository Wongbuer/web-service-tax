package com.wong.webservice.webservicetax.service.impl;

import com.wong.webservice.webservicetax.service.TaxCalculationService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service(value = "taxCalculationService")
@WebService(
        name = "TaxCalculationService",
        targetNamespace = "http://service.webservicetax.webservice.wong.com",
        endpointInterface = "com.wong.webservice.webservicetax.service.TaxCalculationService"
)
public class TaxCalculationServiceImpl implements TaxCalculationService {
    private double taxRate;

    @Override
    public Double getTax(Double salary) {
        double taxIncome = salary - 3500;
        double tax = 0.0;
        if(salary < 3500) {
            tax = 0.0;
        }else if(taxIncome <= 4500) {
            tax = taxIncome * 3/100;
        }else if(taxIncome <= 4500) {
            tax = taxIncome * 10/100 - 105;
        }else if(taxIncome <= 9000) {
            tax = taxIncome * 20/100 - 555;
        }else if(taxIncome <= 35000) {
            tax = taxIncome * 25/100 - 1005;
        }else if(taxIncome <= 55000) {
            tax = taxIncome * 30/100 - 2755;
        }else if(taxIncome <= 80000) {
            tax = taxIncome * 35/100 - 5505;
        }else {
            tax = taxIncome * 45/100 - 13505;
        }
        return tax;
    }
}
