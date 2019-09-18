import java.util.*;

public class PrimitiveCalculator {
	private static int getMin(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		else if (b <= a && b <= c)
			return b;
		else
			return c;
	}

	private static List<Integer> optimal_sequence(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
		int[] path = new int[n + 1];
		path[0] = 0;
		path[1] = 0;

		for (int i = 2; i < n + 1; i++) {
			int m1 = path[i - 1] + 1;
			int m2 = (i % 2 == 0 ? path[i / 2] + 1 : Integer.MAX_VALUE);
			int m3 = (i % 3 == 0 ? path[i / 3] + 1 : Integer.MAX_VALUE);
			path[i] = getMin(m1, m2, m3);
		}

		int i = n;
		sequence.add(n);
		while (i > 1) {
			int m1 = path[i - 1];
			int m2 = (i % 2 == 0 ? path[i / 2] : Integer.MAX_VALUE);
			int m3 = (i % 3 == 0 ? path[i / 3] : Integer.MAX_VALUE);
			if (m3 <= m1 && m3 <= m2) {
				i = i / 3;
			} else if (m2 <= m3 && m2 <= m1) {
				i = i / 2;
			} else if (m1 <= m3 && m1 <= m2) {
				i = i - 1;
			}
			sequence.add(i);
		}
		Collections.reverse(sequence);
		return sequence;
	}

	private static List<Integer> optimal_sequence2(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
		while (n >= 1) {
			sequence.add(n);
			if (n % 3 == 0) {
				n /= 3;
			} else if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
			}
		}
		Collections.reverse(sequence);
		return sequence;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<Integer> sequence = optimal_sequence(n);
		System.out.println(sequence.size() - 1);
		for (Integer x : sequence) {
			System.out.print(x + " ");
		}
	}
}
