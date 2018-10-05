import java.util.*;

class Solution{
	public static void main(String[] args) {
		// String a = "man";
		// String b = "mom";
		// // String c = 10;

		// System.out.println(a.compareTo(b));

		Person p1 = new Person("Venkatesh",23);
		Person p2 = new Person("Teza",22);
		Person p3 = new Person("Romio",25);

		Person[] arr = {p1, p2, p3};

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

	}
}
