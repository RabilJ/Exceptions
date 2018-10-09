package zadanie;

public class BankAccount {
    private Person person;
    private double accountMoney;
    private double limit;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(double accountMoney) {
        this.accountMoney = accountMoney;
    }

    public BankAccount(Person person, double accountMoney, double limit) {
        if(person==null){
            throw new NullPointerException("Nie można stworzyć konta, bez użytkownika");
        }
        this.person = person;
        this.accountMoney = accountMoney;
        this.limit = limit;
    }

    public  void deposit(double deposit) {

        accountMoney+=deposit;
    }

    public  void withdraw(double withdraw) {
        if (withdraw <= accountMoney) {
            if(withdraw <=limit) {
                accountMoney -= withdraw;
            }else{
                throw new LimitExceededException();
            }
        } else{
            throw new NieMaszTylePieniedzyException();
        }
    }
}