public class CashPayment implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        return amount >= 0;
    }

    @Override
    public String getPaymentType() {
        return "CASH";
    }
}
