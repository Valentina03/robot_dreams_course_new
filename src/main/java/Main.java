public class Main {
    public static void main(String[] args){
        Module module = new Module();
        try {
            module.processPayment(10,"USD","1");
        } catch (InvalidPaymentCurrencyException | InvalidPaymentAmountException | BankProcessingFailedException e) {
            System.out.println(e.getMessage());
        }

        try {
            module.processPayment(0,"USD","1");
        } catch (InvalidPaymentCurrencyException | InvalidPaymentAmountException | BankProcessingFailedException e) {
            System.out.println(e.getMessage());
        }

        try {
            module.processPayment(10,"RSD","1");
        } catch (InvalidPaymentCurrencyException | InvalidPaymentAmountException | BankProcessingFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}