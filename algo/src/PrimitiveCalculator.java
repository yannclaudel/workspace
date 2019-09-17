import java.util.*;

public class PrimitiveCalculator {
	
	private static List<Integer> optimal_sequence(int n) {
		List<Integer> sequence = new ArrayList<Integer>();
		int[] path = new int[n + 1];
		path[0] = 0;
		path[1] = 1;

		for (int i = 2; i < n+1; i++) {
			path[i] = path[i-1]+1;
			if (i % 2 == 0 && path[i/2]+1<path[i]) {
				path[i] = path[i/2]+1;
			}
			if (i % 3 == 0 && path[i/3]+1<path[i]) {
				path[i] = path[i/3]+1;
			}
		}
		
		int i = n;
		sequence.add(n);
		while(i>1) {
			int min1 = path[]
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

