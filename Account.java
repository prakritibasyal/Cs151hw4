public class Account {
	private final Object lock = new Object();
	// Must be private to be thread-safe!
	private int balance = 1500;

	public int getBalance() {
		return balance;
	}

	public synchronized void withdraw(int balance1) {
		synchronized (lock) {
			balance = balance - balance1;
		}
	}

	public synchronized void deposit(int balance2) {
		synchronized (lock) {
			balance = balance + balance2;
		}
	}
}