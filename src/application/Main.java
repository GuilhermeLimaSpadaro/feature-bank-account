package application;


import model.entities.Account;
import model.exceptions.DomainExceptions;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DomainExceptions {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Holder: ");
        String holder = sc.nextLine();
        System.out.print("Initial Balance: ");
        double initialBalance = sc.nextDouble();
        sc.nextLine();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();
        sc.nextLine();

        Account account = new Account(number, holder, initialBalance, withdrawLimit);
        System.out.print("Enter amount for withdraw: ");
        double amountWithDraw = sc.nextDouble();
        try {
            account.withDraw(amountWithDraw);
            System.out.printf("Withdraw Successful(New balance): %.2f\n", account.getBalance());
        } catch (DomainExceptions e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}