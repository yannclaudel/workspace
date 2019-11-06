import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

	private static FastScanner in;
	private static PrintWriter out;
	
	
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";

    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static SecureRandom random = new SecureRandom();

	public static void main(String[] args) throws IOException {
		
		out = new PrintWriter(new BufferedOutputStream(System.out));
		out.println("here\n");
		printOccurrences(rabinKarp(generateData(1000000000)));
		out.println("\nhere0");
		out.close();
	}
/*
	public static void main(String[] args) throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		printOccurrences(rabinKarp(readInput()));
		out.close();
	}
*/
	
	private static long hashFunc(String s, int multiplier, int prime) {
		long hash = 0;
		for (int i = s.length() - 1; i >= 0; --i)
			hash = (hash * multiplier + s.charAt(i)) % prime;
		return (long) hash;
	}

	private static long[] precomputeHash(String t, int m, int multiplier, int prime) {
		long[] result = new long[t.length() - m + 1];
		result[t.length() - m] = hashFunc(t.substring(t.length() - m, t.length()), multiplier, prime);
		
		long y = 1;
		for (int i = 0; i < m; i++) {
			y = (y * multiplier) % prime;
		}
		
		for (int i = t.length() - m - 1; i>-1; i--) {
			result[i] = (multiplier*result[i+1] + t.charAt(i) - y*t.charAt(i+m)) % prime;
		}
		
		return result;
	}

	private static List<Integer> rabinKarp(Data input) {
		String p = input.pattern, t = input.text;
		int m = p.length(), n = t.length();
		List<Integer> occurrences = new ArrayList<Integer>();
		if (m>n) return occurrences;
		int prime = 1000003;//1000000007;
		int multiplier = (int) (Math.random() * prime);

		long pHash = hashFunc(p, multiplier, prime);

		long[] hash =  precomputeHash(t, m, multiplier, prime);
		
		for (int i = 0; i < n - m + 1; i++) {
			//long tHash = hashFunc(sub, multiplier, prime);
			//out.println(sub +" "+tHash + " "+hash[i]+(tHash!=hash[i]?" NOK":""));
			
			if (hash[i] == pHash && t.substring(i, i + m).equals(p)) {
				occurrences.add(i);
			}
		}
		return occurrences;
	}

	private static Data readInput() throws IOException {
		String pattern = in.next();
		String text = in.next();
		return new Data(pattern, text);
	}

	private static Data generateData(int length) throws IOException {
		StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(DATA_FOR_RANDOM_STRING.charAt(random.nextInt(DATA_FOR_RANDOM_STRING.length())));
        }
		String text = sb.toString();
		String pattern = sb.toString().substring(text.length()-5,text.length());
		//out.print(pattern);
		//out.print(text);
		return new Data(pattern, text);
	}


	private static void printOccurrences(List<Integer> ans) throws IOException {
		for (Integer cur : ans) {
			out.print(cur);
			out.print(" ");
		}
	}

	private static List<Integer> getOccurrences(Data input) {
		String s = input.pattern, t = input.text;
		int m = s.length(), n = t.length();
		List<Integer> occurrences = new ArrayList<Integer>();
		for (int i = 0; i + m <= n; ++i) {
			boolean equal = true;
			for (int j = 0; j < m; ++j) {
				if (s.charAt(j) != t.charAt(i + j)) {
					equal = false;
					break;
				}
			}
			if (equal)
				occurrences.add(i);
		}
		return occurrences;
	}

	static class Data {
		String pattern;
		String text;

		public Data(String pattern, String text) {
			this.pattern = pattern;
			this.text = text;
		}
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
