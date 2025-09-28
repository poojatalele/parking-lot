public class DigitalPayment implements PaymentMethod {
    private String walletType;

    public DigitalPayment(String walletType) {
        this.walletType = walletType;
    }

    @Override
    public boolean processPayment(double amount) {
        return amount >= 0 && walletType != null && !walletType.isEmpty();
    }

    @Override
    public String getPaymentType() {
        return "DIGITAL:" + walletType;
    }
}
