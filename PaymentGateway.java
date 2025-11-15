// Abstract Class
abstract class PaymentMethod {
    abstract void processPayment(double amount);
}

// Credit Card Payment
class CreditCardPayment extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment of ₹" + amount);
        System.out.println("Verifying card details...");
        System.out.println("Credit card payment successful!\n");
    }
}

// Debit Card Payment
class DebitCardPayment extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing Debit Card Payment of ₹" + amount);
        System.out.println("Checking bank balance...");
        System.out.println("Debit card payment successful!\n");
    }
}

// Digital Wallet Payment
class DigitalWalletPayment extends PaymentMethod {
    @Override
    void processPayment(double amount) {
        System.out.println("Processing Digital Wallet Payment of ₹" + amount);
        System.out.println("Verifying wallet ID...");
        System.out.println("Digital wallet payment successful!\n");
    }
}

// Main Class
public class PaymentGateway {
    public static void makePayment(PaymentMethod method, double amount) {
        method.processPayment(amount);
    }

    public static void main(String[] args) {
        PaymentMethod credit = new CreditCardPayment();
        PaymentMethod debit = new DebitCardPayment();
        PaymentMethod wallet = new DigitalWalletPayment();

        makePayment(credit, 500);
        makePayment(debit, 1000);
        makePayment(wallet, 300);
    }
}
