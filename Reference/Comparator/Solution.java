import java.util.*;
class Solution{

	public static void main(String[] args) {
		Library l = new Library();
		l.addBook(new Book("ALGS4",200, 4000));
		l.addBook(new Book("JAVA",215, 1600));
		l.addBook(new Book("PYTHON",215, 519));
		l.addBook(new Book("C++",10, 5103));


		Insertion insert = new Insertion();

		Book[] temp = l.getArray();
		insert.sort(temp, Book.pageComparator);

		for(int i=0;i < 4;i++){
			System.out.println(temp[i]);
		}
	// System.out.println(Arrays.toString(l.getArray()));
	}

}
