package zadanie;


import java.util.Locale;
import java.util.Scanner;

public class CashMachine {
    public static final int EXIT = 1;
    public static final int WITHDRAW = 2;
    public static final int DEPOSIT = 3;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useLocale(Locale.US);
        Person Maciek = new Person("Maciej","Skólmowski");
        BankAccount account1 = new BankAccount(Maciek,15000, 500);
        int choice = -1;
        int amount = 0;

        while(choice!=EXIT){
            System.out.println("WItaj, wybierz opcje:");
            System.out.println("1 - Wyjście");
            System.out.println("2 - Wypłata");
            System.out.println("3 - Depozyt");
            choice = sc.nextInt();


            switch(choice){
                case EXIT:
                    System.out.println("Dziękujemy ze skorzystanie z naszego bankomatu.");
                    break;
                case WITHDRAW:


                    boolean check = true;
                    while(check) {
                        try {
                            System.out.println("Ile chcesz wypłacić?");
                            amount = sc.nextInt();
                            account1.withdraw(amount);
                            check = false;
                        } catch (NieMaszTylePieniedzyException e) {
                            System.out.println("Brak wystarczających środków na koncie, wprowadź mniejszą kwotę");
                            sc.nextLine();
                            continue;
                        } catch (LimitExceededException ex) {
                            System.out.println("Limit na wypłatę przekroczony, spróbuj ponownie");
                            sc.nextLine();
                            continue;
                        }
                    }
                    System.out.println("Twój stan konta: "+account1.getAccountMoney());
                    break;
                case DEPOSIT:
                    System.out.println("Ile chcesz wpłacić?");
                    amount = sc.nextInt();
                    account1.deposit(amount);
                    System.out.println("Twój stan konta: "+account1.getAccountMoney());
                    break;
            }
        }
    }
}
