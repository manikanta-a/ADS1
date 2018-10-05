import java.util.*;
class Library{

	Book[] books;
	int size;


	public Library(){
		books = new Book[4];
		size = 0;
	}

	public void addBook(Book obj){
		books[size++] = obj;
	}

	public Book[] getArray(){
		return books;
	}
}
