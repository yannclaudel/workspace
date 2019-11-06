import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PhoneBook {

	private FastScanner in = new FastScanner();
	// Keep list of all existing (i.e. not deleted yet) contacts.
	//private List<Contact> contacts = new ArrayList<>();
	private Contact[] phoneBook = new Contact[10000000];

	public static void main(String[] args) {
		new PhoneBook().processQueries();
	}

	private Query readQuery() {
		String type = in.next();
		int number = in.nextInt();
		if (type.equals("add")) {
			String name = in.next();
			return new Query(type, name, number);
		} else {
			return new Query(type, number);
		}
	}

	private void writeResponse(String response) {
		System.out.println(response);
	}

	private void processQuery(Query query) {
		if (query.type.equals("add")) {
			// if we already have contact with such number,
			// we should rewrite contact's name

			if (phoneBook[query.number] != null)
				phoneBook[query.number].name = query.name;
			else
				phoneBook[query.number] = new Contact(query.name, query.number);

		} else if (query.type.equals("del")) {
			phoneBook[query.number] = null;
		} else {
			String response = "not found";
			if (phoneBook[query.number] != null)
				response = phoneBook[query.number].name;
			writeResponse(response);
		}
	}


	public void processQueries() {
		int queryCount = in.nextInt();
		for (int i = 0; i < queryCount; ++i)
			processQuery(readQuery());
	}

	static class Contact {
		String name;
		int number;

		public Contact(String name, int number) {
			this.name = name;
			this.number = number;
		}
	}

	static class Query {
		String type;
		String name;
		int number;

		public Query(String type, String name, int number) {
			this.type = type;
			this.name = name;
			this.number = number;
		}

		public Query(String type, int number) {
			this.type = type;
			this.number = number;
		}
	}

	class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
