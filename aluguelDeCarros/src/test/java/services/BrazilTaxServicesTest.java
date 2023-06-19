package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrazilTaxServicesTest {

    @Test
    public void testTax(){
        BrazilTaxService taxService = new BrazilTaxService();
        assertEquals(10, taxService.tax(50));
        assertEquals(19.5, taxService.tax(130));
    }




}