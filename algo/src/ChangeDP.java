import java.util.Scanner;

public class ChangeDP {
	private static int getChange(int m) {
		// 1 3 4
		int[] coins = { 1, 3, 4 };
		int[] minnumcoins = new int[m + 1];
		minnumcoins[0] = 0;

		for (int i = 1; i < minnumcoins.length; i++) {
			minnumcoins[i] = Integer.MAX_VALUE;
			for (int c : coins) {
				if (i >= c) {
					if (minnumcoins[i - c] + 1 < minnumcoins[i])
						minnumcoins[i] = minnumcoins[i - c] + 1;
				}				
			}			
		}

		return minnumcoins[m];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		System.out.println(getChange(m));

	}
}
