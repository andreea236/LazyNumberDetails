
public class LazyNumberDetails {
	private int number;

	private boolean primeCacheisDirty;
	private boolean isPrime;

	private boolean perfectCacheisDirty;
	private boolean isPerfect;

	private boolean magicCacheisDirty;
	private boolean isMagic;

	public LazyNumberDetails(int number) {
		this.number = number;

		this.primeCacheisDirty = true;
		this.perfectCacheisDirty = true;
		this.magicCacheisDirty = true;
	}

	public void updateNumber(int number) {
		this.number = number;

		if (number != this.number) {
			this.primeCacheisDirty = true;
			this.perfectCacheisDirty = true;
			this.magicCacheisDirty = true;
		}
	}

	public boolean isPrime() {
		if (this.primeCacheisDirty) {
			this.primeCacheisDirty = false;
			for (int i = 2; i * i <= this.number; i++) {
				if (this.number % i == 0) {
					this.isPrime = false;
					return false;
				}
			}
			this.isPrime = true;
		}
		return this.isPrime;
	}

	public boolean isPerfect() {
		if (this.number == 1)
			return false;
		int sumPerfect = 1;
		if (this.perfectCacheisDirty) {
			this.perfectCacheisDirty = false;
			for (int i = 2; i < this.number; i++) {
				if (this.number % i == 0) {
					sumPerfect += i;
				}
			}
			this.isPerfect = sumPerfect == this.number;
		}
		return this.isPerfect;
	}

	public boolean isMagic() {
		if (this.magicCacheisDirty) {
			this.magicCacheisDirty = false;
			int magicNr = this.number;
			int sumMagic = 0;
			while (magicNr > 0 || sumMagic > 9) {
				if (magicNr == 0) {
					sumMagic = 0;
				}
				sumMagic += magicNr % 10;
				magicNr /= 10;
			}
			if (sumMagic == 0) {
				this.isMagic = false;
				return this.isMagic;
			}
			this.isMagic = sumMagic % 3 == 0 || sumMagic % 7 == 0 || sumMagic % 9 == 0;
		}
		return this.isMagic;
	}
}