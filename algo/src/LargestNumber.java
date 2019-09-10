import java.util.*;

public class LargestNumber {
	private static String largestNumber(String[] a) {
		// write your code here

		Arrays.sort(a, new Comparator<String>() {
			@Override
			public int compare(String u1, String u2) {
				StringBuilder a = new StringBuilder(u1);
				StringBuilder b = new StringBuilder(u2);
				if (u1.length() < u2.length()) {
					for (int i = 0; i < u2.length()-u1.length(); i++) {
					    a.append("9");
					}
				} else {
					for (int i = 0; i < u1.length()-u2.length(); i++) {
					    b.append("9");
					}
				}
				return a.toString().compareTo(b.toString());
			}
		});

		String result = "";
		for (int i = 0; i < a.length; i++) {
			result += a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] a = new String[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.next();
		}
		System.out.println(largestNumber(a));
	}
}
