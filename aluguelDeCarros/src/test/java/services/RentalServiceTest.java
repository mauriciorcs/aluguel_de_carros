package services;

import entities.CarRental;
import entities.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class RentalServiceTest {

    /*Calculos:
    *
    *Duracao = (25/06/2018 14:40) - (25/06/2018 10:30) = 4:10 = 5 horas
    *pagamento basico = 5 * 10 = 50
    *
    *Imposto = 50 * 20% = 50 * 0.2 = 10
    * se maior que 100 o imposto é multiplicado por 0,15
    */

    RentalService rentalService;
    CarRental cr;
    BrazilTaxService taxService;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    LocalDateTime start;
    LocalDateTime finish;



    @BeforeEach
    void setUp() {
        start = LocalDateTime.parse("25/06/2018 10:30", fmt);
        finish = LocalDateTime.parse("25/06/2018 14:40", fmt);
        taxService = new BrazilTaxService();
        rentalService = new RentalService(130.0, 10.0, taxService);
        cr = new CarRental(start, finish, new Vehicle("Civic"));

    }

    @Test
    void testVehicle(){
        assertEquals("Civic",cr.getVahicle().getModel());
    }

    @Test
    void testStart(){
        assertEquals("25/06/2018 10:30", cr.getStart().format(fmt));
    }

    @Test
    void testFinish(){
        assertEquals("25/06/2018 14:40", cr.getFinish().format(fmt));
    }

    @Test
    void processInvoice() {
        rentalService.processInvoice(cr);
        assertEquals(50, cr.getInvoice().getBasicPayment());
        assertEquals(10, cr.getInvoice().getTax());
    }
}