package weiskopf.threads;

import java.math.BigInteger;

public class Factorial extends Thread {

	private final long n;

	public Factorial(int n) {
		this.n = n;
	}

	public static BigInteger factorial(long n) {
		BigInteger total = BigInteger.valueOf(n);
		for (long i = n - 1; i > 0; i--) {
			total = total.multiply(BigInteger.valueOf(i));
		}
		return total;
	}

	@Override
	public void run() {
		super.run();
		System.out.println("Value");
		System.out.println(factorial(n));
	}

}
