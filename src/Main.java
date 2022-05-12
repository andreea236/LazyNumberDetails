
public class Main {

	public static void main(String[] args) {
		LazyNumberDetails nr = new LazyNumberDetails(19);

		// PRIME
		boolean isPrime = false;

		System.out.println("PRIME:");

		long start = System.nanoTime();
		isPrime = nr.isPrime();
		long end = System.nanoTime();

		System.out.println((end - start) + " ns to complete: " + isPrime);

		start = System.nanoTime();
		isPrime = nr.isPrime();
		end = System.nanoTime();

		System.out.println("Caching: " + (end - start) + " ns to complete: " + isPrime);

		// PERFECT
		boolean isPerfect = false;
		System.out.println();
		System.out.println("PERFECT:");

		start = System.nanoTime();
		isPerfect = nr.isPerfect();
		end = System.nanoTime();

		System.out.println((end - start) + " ns to complete: " + isPerfect);

		start = System.nanoTime();
		isPerfect = nr.isPerfect();
		end = System.nanoTime();

		System.out.println("Caching: " + (end - start) + " ns to complete: " + isPerfect);

		// Magic
		boolean isMagic = false;
		System.out.println();
		System.out.println("MAGIC:");

		start = System.nanoTime();
		isMagic = nr.isMagic();
		end = System.nanoTime();

		System.out.println((end - start) + " ns to complete: " + isMagic);

		start = System.nanoTime();
		isMagic = nr.isMagic();
		end = System.nanoTime();

		System.out.println("Caching: " + (end - start) + " ns to complete: " + isMagic);
		
		nr.updateNumber(2);
		
		start = System.nanoTime();
		isMagic = nr.isMagic();
		end = System.nanoTime();

		System.out.println((end - start) + " ns to complete: " + isMagic);

		start = System.nanoTime();
		isMagic = nr.isMagic();
		end = System.nanoTime();
		
		System.out.println("After update:");
		System.out.println("Caching: " + (end - start) + " ns to complete: " + isMagic);
		
	}
}
