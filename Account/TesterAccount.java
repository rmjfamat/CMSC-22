public class TesterAccount{
	public static void main(String[] args){
		Account a1 = new Account(12345, 100000.50);
		System.out.println(a1);

		a1.setBalance(20000.00);
		System.out.println(a1);
		a1.credit(25000.00);
		System.out.println(a1);
		a1.debit(2000.00);
		System.out.println(a1);
		a1.debit(2500);
		System.out.println(a1);
		a1.debit(4000.00);
		System.out.println(a1);
		a1.credit(5000.00);
		System.out.println(a1);
		a1.debit(50000);
		System.out.println(a1);

	}
}