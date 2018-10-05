import java.util.*;
class Book{

	private String bookName;
	private int numOfPage;
	private int price;

	public Book(String b, int n, int c){
		this.bookName = b;
		this.numOfPage = n;
		this.price = c;
	}

	static Comparator<Book> nameComparator = new Comparator<Book>(){
		public int compare(Book b1, Book b2){
			return b1.bookName.compareTo(b2.bookName);
		}
	};

	static Comparator<Book> pageComparator = new Comparator<Book>(){
		public int compare(Book b1, Book b2){

			// if(b1.numOfPage - b2.numOfPage != 0)
			// 	return b1.numOfPage - b2.numOfPage;
			// else
			// 	return b1.bookName.compareTo(b2.bookName);

			return b1.numOfPage - b2.numOfPage;
		}
	};


	public String toString(){
		return "BookName: "+this.bookName+" | Number of Pages: "+this.numOfPage+" | Price: "+this.price;
	}


}
