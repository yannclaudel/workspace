import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {

	/*
	 * public static void randomizedQuickSort0(int[] a, int l, int r) { if (l >= r)
	 * { return; } int k = random.nextInt(r - l + 1) + l; int t = a[l]; a[l] = a[k];
	 * a[k] = t; //use partition3 int m = partition2(a, l, r);
	 * randomizedQuickSort(a, l, m - 1); randomizedQuickSort(a, m + 1, r); }
	 */
	public static void main(String[] args) {

		try {
			LocalDateTime dateTime = conversorStringToLocalDateTime("");
			System.out.println(dateTime.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		List<String> words = new ArrayList<String>();
		words.add("egg");
		words.add("salad");
		words.add("bread");
		words.add("tomat");
		List<String> firstnames = words.stream().map(String::toUpperCase)
				.filter(nom->nom.length()>4) 
				.limit(2) 
				.collect(Collectors.toList());

		

	}

	public static LocalDateTime conversorStringToLocalDateTime(String convertDate) throws ParseException {
		LocalDateTime dateTime = LocalDateTime.parse(convertDate);
		return dateTime;
	}

	public static void mainZZ(String[] args) {

		
		Set<String> set = new HashSet<String>();
		
		
		int nbr = 100;
		int dim = 40;
		int scale = 20;
		int[] a = new int[dim];
		int[] b = new int[dim];
		for (int i = 0; i < a.length; i++) {
			double rand = Math.random() < 0.2 ? 5 : Math.random() * scale;
			a[i] = (int) rand;
			b[i] = (int) rand;
		}
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("");
		// Sorting.randomizedQuickSort0(a, 0, a.length-1);
		Sorting.randomizedQuickSort(b, 0, b.length - 1);
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println("\n------------");
		for (int i : b) {
			System.out.print(i + " ");
		}
		System.out.println("\n------------");
		/*
		 * for (int k = 0; k < nbr; k++) {
		 * 
		 * for (int i = 0; i < a.length; i++) { double rand =
		 * Math.random()<0.3?0:Math.random()*scale; a[i] = (int)rand; }
		 * 
		 * int result = MajorityElement.getMajorityElement(a, 0, a.length); int resultB
		 * = MajorityElement.getMajorityElementBulk(a, 0, a.length);
		 * 
		 * 
		 * for (int i : a) { System.out.print(i+" "); } System.out.println("result=" +
		 * result + "\tresultB=" + resultB); if (result!=resultB) {
		 * System.out.println("ERROR"); break; } }
		 */
	}
}
