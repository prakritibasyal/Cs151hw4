public class hw4 implements Runnable {

	Account account = new Account();

	public static void main(String[] args) {
		//using three different people
		hw4 ts = new hw4();
		Thread person1 = new Thread(ts, "person 1");
		Thread person2 = new Thread(ts, "person 2");
		Thread person3 = new Thread(ts, "person 3");
		
		
		person1.start();
		person2.start();
		person3.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			withDraw(100);
			if (account.getBalance() < 0) {
				System.out.println("The account is overdrawn!");
			}
			deposit(200);
		}
	}
	
    //synchronized methods below:-
	private synchronized void deposit(int balance) {
		if (balance > 0) {
			System.out.println(Thread.currentThread().getName() + " " + " is trying to deposit");
			try {
				Thread.sleep(200);//the time intervals
			} catch (Exception e) {
				e.printStackTrace();
			}
			account.deposit(balance);
			System.out.println(Thread.currentThread().getName() + " " + "The Deposit is Successful");
		} else {
			System.out.println(Thread.currentThread().getName() + " " + "The Deposit is Unsuccessful");
		}
	}

	private synchronized void withDraw(int bal1) {
		if (account.getBalance() >= bal1) {
			System.out.println(Thread.currentThread().getName() + " " + " is trying to withdraw");
			try {
				Thread.sleep(200);
			} catch (Exception e) {
				e.printStackTrace();
			}
			account.withdraw(bal1);
			System.out.println(Thread.currentThread().getName() + " " + "The Withdrawal is Successful");
		} else {
			System.out.println(Thread.currentThread().getName() + " " + " The balance is low");
		}
	}
}