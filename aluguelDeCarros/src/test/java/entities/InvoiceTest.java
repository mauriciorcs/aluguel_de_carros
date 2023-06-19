package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.BrazilTaxService;
import services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    LocalDateTime start;
    LocalDateTime finish;
    RentalService rentalService;
    CarRental cr;
    BrazilTaxService taxService;

    @BeforeEach
    void setUp() {
        start = LocalDateTime.parse("25/06/2018 10:30", fmt);
        finish = LocalDateTime.parse("25/06/2018 14:40", fmt);
        rentalService = new RentalService(130.0, 10.0, new BrazilTaxService());
        cr = new CarRental(start, finish, new Vehicle("Civic"));
        taxService = new BrazilTaxService();
    }

    @Test
    void getIvoiceTest1() {
        rentalService.processInvoice(cr);
        assertEquals(50, cr.getInvoice().getBasicPayment());
        assertEquals(10, cr.getInvoice().getTax());
        assertEquals(60, cr.getInvoice().getTotalPayment());

    }

    @Test
    void getIvoiceTest2(){
        LocalDateTime started = LocalDateTime.parse("25/06/2023 10:30", fmt);
        LocalDateTime finished = LocalDateTime.parse("27/06/2023 14:40", fmt);
        cr = new CarRental(started, finished, new Vehicle("Palio"));
        rentalService.processInvoice(cr);
        assertEquals(390, cr.getInvoice().getBasicPayment());
        assertEquals(58.5, cr.getInvoice().getTax());
        assertEquals(448.5, cr.getInvoice().getTotalPayment());
    }
}