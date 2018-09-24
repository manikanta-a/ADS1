// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }
import java.util.*;

class Percolation{
	boolean[][] arr;
	WeightedQuickUnionUF uf;
	int numOfOpenSite;
	int size;
	int gridSize;

	public Percolation(int size){
		gridSize = size*size;
		this.size = size;
		uf =new WeightedQuickUnionUF(gridSize+2);
		arr = new boolean[size][size];
		numOfOpenSite = 0;
	}

	public void open(int row, int col){
		int top = size;
		if(!isOpen(row-1,col-1)){
			// System.out.println("inside open method == "+(row-1)+" - "+(col-1));
			arr[row-1][col-1] = true;

			if(col-2>=0 && isOpen(row-1, col-2)) {
				uf.union(size*row-1+col-1, size*row-1+col-2);
			}

			if(row-2>=0 && isOpen(row-2, col-1)) {
				uf.union(size*row-1+col-1, size*row-2+col-1);
			}

			if(col < size && isOpen(row-1, col)) {
				uf.union(size*row-1+col-1, size*row-1+col);
			}

			if(row < size && isOpen(row, col-1)) {
				uf.union(size*row-1+col-1, size*row+col-1);
			}

		}
	}

	public boolean isOpen(int row, int col){ 
		// System.out.println(row +" "+col);
		// System.out.println("Here " + arr[row-1][co]);
		return arr[row][col];
	}

	public int numberOfOpenSites(){
		return numOfOpenSite;
	}

	public boolean percolates(){
		for(int i = 0;i<size; i++){
			uf.union(gridSize,i);
			uf.union(gridSize+1,size*(size-1)+i);
		}
		return uf.connected(gridSize, gridSize+1);
	}
}

// You can implement the above API to solve the problem



class Solution{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nodes = scan.nextInt();
		Percolation objPercolation = new Percolation(nodes);

		while(scan.hasNext()){
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			// System.out.println("IN MAIN = "+node1+" -  "+node2);
			objPercolation.open(node1,node2);

		}
		System.out.println(objPercolation.percolates());
	}


}