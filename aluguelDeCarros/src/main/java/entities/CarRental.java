package entities;

import java.time.LocalDateTime;

public class CarRental {

    private LocalDateTime start;
    private LocalDateTime finish;

    private Vehicle vahicle;
    private Invoice invoice;

    public CarRental() {

    }

    public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vahicle) {
        this.start = start;
        this.finish = finish;
        this.vahicle = vahicle;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getFinish() {
        return this.finish;
    }

    public void setFinish(LocalDateTime finish) {
        this.finish = finish;
    }

    public Vehicle getVahicle() {
        return this.vahicle;
    }

    public void setVahicle(Vehicle vahicle) {
        this.vahicle = vahicle;
    }

    public Invoice getInvoice() {
        return this.invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }


}
