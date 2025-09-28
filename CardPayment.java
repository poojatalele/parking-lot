public class CardPayment implements PaymentMethod {
    private String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        return amount >= 0 && cardNumber != null && cardNumber.length() >= 12;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}
