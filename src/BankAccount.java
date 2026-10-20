void main() {
BankAccount acc1=new savingAccount("SAV-1240",200);
BankAccount acc2=new CurrentAccount("CAP-99240",200);
BankAccount acc3=new StudentAccount("FAG-30240",200);

acc1.deposit(50); acc1.withdraw(150);acc1.show();
acc2.deposit(50); acc2.withdraw(300);acc2.show();
acc3.deposit(50); acc3.withdraw(80);acc3.show();
}


abstract public class BankAccount{
    private String accountNumber;
    protected double balance;

    BankAccount(String accountNumber,double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    abstract void withdraw(double amount);
    public void deposit(double amount){
        if(amount<0){
            System.out.println("Deposit amount must be more than 0");
        }
        balance+=amount;
    }
    void refuse(String why){
        System.out.println(" "+accountNumber+"Refused "+why);
    }
    void show(){
        System.out.println(" "+accountNumber+", Balance: "+balance);
    }

}
class savingAccount extends BankAccount{
    savingAccount(String accountNumber,double balance){super(accountNumber,balance);}
    void withdraw(double amount){
        if(balance-amount<50) refuse("Balance must Keep atleast 50");
        else balance+=amount;
    }
}
class CurrentAccount extends BankAccount{
    CurrentAccount(String accountNumber,double balance){super(accountNumber,balance);}
    void withdraw(double amount){
        if(balance-amount<-200) refuse("Overdraft limit is 200");
        else balance+=amount;
    }
}
class StudentAccount extends BankAccount{
    StudentAccount(String accountNumber,double balance){super(accountNumber,balance);}
    void withdraw(double amount){
        if(amount>100) refuse("Max 100 per withdrawal");
        else if (amount>balance) {
            refuse("Not enough money");

        } else balance+=amount;
    }
}






