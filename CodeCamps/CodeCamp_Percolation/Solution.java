// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
import java.util.*;

class Percolation{

	private boolean[][] grid;
	private WeightedQuickUnionUF uf;
	private int numberOfOpenSites;
	private int size;
	private int gridSize;


	public Percolation(int size){
		grid = new boolean[size][size];
		uf = new WeightedQuickUnionUF(size*size+2);
		numberOfOpenSites = 0;
		this.size = size;
		gridSize = size * size;
	}

	public void open(int row, int col){
		if(grid[row][col]) return;

		grid[row][col] = true;
		numberOfOpenSites++;

		// size * row + col

		//top
		if(row-1>=0 && isOpen(row-1,col)){
			uf.union(getIndex(row,col), getIndex(row-1,col));
		}

		//bottom
		if(row+1 < size && isOpen(row+1,col)){
			uf.union(getIndex(row,col), getIndex(row+1,col));
		}

		//left
		if(col-1>=0 && isOpen(row, col-1)){
			uf.union(getIndex(row,col), getIndex(row,col-1));
		}

		//right
		if(col+1 < size && isOpen(row, col+1)){
			uf.union(getIndex(row,col), getIndex(row,col+1));
		}

		//top virtual node
		if(row == 0){
			uf.union(getIndex(row,col), gridSize);
		}

		//bottom virtual node
		if(row == size-1){
			uf.union(getIndex(row,col), gridSize+1);
		}
	}

	public int getIndex(int row, int col){
		return size*row+col;
	}

	public boolean isOpen(int row, int col){
		// System.out.println("Inside isOpen = "+row +" - "+col);
		return grid[row][col];
	}

	public int countOfOpenSites(){
		return numberOfOpenSites;
	}

	public boolean percolate()
	{
		return uf.connected(gridSize, gridSize+1);
	}
}


class Solution{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Percolation objPercolation = new Percolation(scan.nextInt());
		while(scan.hasNext()){
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			// System.out.println("Inside main = "+(node1-1)+" - "+(node2-1));
			objPercolation.open(node1-1,node2-1);
		}
		System.out.println(objPercolation.percolate());
	}
}
