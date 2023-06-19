package services;

public class BrazilTaxService implements TaxService{
    //se a quantia for menor ou igual a 100 a taxa é de 20%
    public double tax(double amount){
        if (amount <= 100.0) {
            return amount * 0.2;
        }
        else {
            return amount * 0.15;
        }
    }
}
