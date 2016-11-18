public class Account{
	private int accountNumber;
	private double balance;

	public Account(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Account(int accountNumber){
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber(int accountNumber){
		return accountNumber;
	}

	public double getBalance(double balance){
		return balance;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}

	public void credit(double amount){
		this.balance = balance + amount;
	}
	public void debit(double amount){
		if(balance >= amount){
			this.balance = balance - amount;
		}
		else{
			throw new IllegalArgumentException("Amount withdrwan exceeds the current balance!");
		}
	}

	public String toString(){
		return String.format("Account Number: %d, Balance: %0.2f", accountBalance, balance);
	}

}