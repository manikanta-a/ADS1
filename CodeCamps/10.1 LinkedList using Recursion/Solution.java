import java.util.*;

class Solution{
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		Scanner sc = new Scanner(System.in);
			while(sc.hasNext()){
				String[] tokens = sc.nextLine().split(" ");
				try{
						switch(tokens[0]){
						case "insertAt": 
						// System.out.println("yoyoy");
							ll.insertAt(Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]));
							ll.display();
							break;
						case "reverse":
							ll.reverse();
							ll.display();
							break;
					}
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
		
		
	}
}
