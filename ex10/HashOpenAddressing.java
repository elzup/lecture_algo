package ex10;

public class HashOpenAddressing {
	private static class MyKey {
		String key;
		String data;

		public MyKey(String key, String data) {
			this.key = key;
			this.data = data;
		}
	}

	private MyKey[] table;
	private int bucketSize;
	private int n;

	private static final String REMOVED = "REMOVED";
	private static final String EMPTY = "EMPTY";
	private static final int BUCKET_SIZE = 23;

	public HashOpenAddressing() {
		this(BUCKET_SIZE);
	}

	public HashOpenAddressing(int bucketSize) {
		// ここを作る
		this.bucketSize = bucketSize;
		this.table = new MyKey[bucketSize];
		for (int i = 0; i < bucketSize; i++)
			this.table[i] = new MyKey(EMPTY, null);
	}

	public int hash(String key) {
		int sum = 0;
		for (int i = 0; i < key.length(); i++)
			sum += (int) key.charAt(i);
		return sum % bucketSize;
	}

	public int rehash(int hash) {
		// ここを作る
		return (hash + 1) % bucketSize;
	}

	public String search(String key) {
		// ここを作る
		int h = hash(key);
		while (this.table[h].key != key) {
			if (table[h].key == EMPTY) return null;
			h = rehash(h);
		}
		return this.table[h].data;
	}

	public boolean add(String key, String data) {
		// ここを作る
		if (key == EMPTY || key == REMOVED ||
				n == bucketSize)
			return false;
		int h = hash(key);

		while (this.table[h].key != EMPTY && this.table[h].key != REMOVED)
			h = rehash(h);
		this.table[h] = new MyKey(key, data);
		this.n++;
		return true;
	}

	public boolean remove(String key) {
		// ここを作る
		if (key == EMPTY || key == REMOVED)
			return false;
		int h = hash(key);
		while (this.table[h].key != key) {
			if (table[h].key == EMPTY) return false;
			h = rehash(h);
		}
		table[h].key = REMOVED;
		this.n --;
		return true;
	}

	public String toString() {
		// ここを作る
		String text = "";
		for (int i = 0; i < this.bucketSize; i++) {
			MyKey mk = this.table[i];
			text += "bucket" + i + ":";
			if (mk.key == EMPTY || mk.key == REMOVED)
				text += mk.key;
			else
				text += String.format("key=[%s] data=[%s]", mk.key, mk.data);
			text += "\n";
		}
		text += "要素数:" + this.n + "\n";
		return text;

	}

	public static void main(String[] args) {
		HashOpenAddressing bucket = new HashOpenAddressing(11);

		bucket.add("one", "one1");
		bucket.add("two", "two2");
		bucket.add("three", "three3");
		bucket.add("four", "four4");
		bucket.add("five", "five5");
		bucket.add("six", "six6");
		bucket.add("seven", "seven7");

		System.out.println(bucket.toString());

		System.out.print("key:fiveを探索: ");
		System.out.println(bucket.search("five"));
		System.out.println();

		System.out.println("key:threeを削除");
		if (bucket.remove("three")) {
			System.out.println(bucket.toString());
		}

		System.out.print("key:threeを探索: ");
		System.out.println(bucket.search("three"));
		System.out.println();

		System.out.print("key:twoを探索: ");
		System.out.println(bucket.search("two"));
		System.out.println();

		System.out.print("key:fiveを探索: ");
		System.out.println(bucket.search("five"));
		System.out.println();

		bucket.add("eight", "eight8");
		bucket.add("nine", "nine9");
		bucket.add("ten", "ten10");

		System.out.println(bucket.toString());

		System.out.println("key:nineを削除");
		if (bucket.remove("nine")) {
			System.out.println(bucket.toString());
		}
	}
}