void main() {
    Bankaccount acc1=new Bankaccount(200);
    try {
        acc1.withdraw(220);
    }
    catch (InsufficientBalanceException e){
        System.out.println(e.getMessage()+"You need "+e.getShotfall()+" more");
    }
}
public class InsufficientBalanceException extends Exception {
    private double shotfall;
    InsufficientBalanceException(String message,double shotfall){
        super(message);
        this.shotfall=shotfall;
    }

    public double getShotfall() {
        return shotfall;
    }
}

class Bankaccount{
    private double balance=200;
    Bankaccount(double balance){
        this.balance=balance;
    }
    public void withdraw(double amount) throws InsufficientBalanceException{
        if(amount>balance) throw new InsufficientBalanceException("Insufficient balance",amount-balance);
        else balance-=amount;
    }
    public double getBalance() {
        return balance;
    }
}