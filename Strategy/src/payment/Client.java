package payment;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.println("Selecione o método de pagamento:");
        System.out.println("1. Cartão de Crédito");
        System.out.println("2. PayPal");
        System.out.println("3. Transferência Bancária");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        switch (choice) {
            case 1 -> {
                System.out.print("Digite o número do cartão: ");
                String cardNumber = scanner.nextLine();
                context.setPaymentStrategy(new CreditCardPayment(cardNumber));
            }
            case 2 -> {
                System.out.print("Digite o e-mail do PayPal: ");
                String email = scanner.nextLine();
                context.setPaymentStrategy(new PayPalPayment(email));
            }
            case 3 -> {
                System.out.print("Digite o número da conta bancária: ");
                String accountNumber = scanner.nextLine();
                context.setPaymentStrategy(new BankTransferPayment(accountNumber));
            }
            default -> {
                System.out.println("Opção inválida!");
                return;
            }
        }

        System.out.print("Digite o valor do pagamento: ");
        double amount = scanner.nextDouble();

        context.processPayment(amount);
    }
}
