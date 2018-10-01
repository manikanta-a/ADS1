import java.util.*;

class Steque{
	private Node head;
	private Node tail;
	private int size;

	class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		} 
	}

	public Steque(){
		head = null;
		tail = null;
		size = 0;
	}

	public void push(int data){
		// System.out.println("inside push method");
		Node newNode = new Node(data);
		// System.out.println(newNode);
		if(size == 0){
			// System.out.println("size == 0");
			head = newNode;
			tail = head;
			size++;
			return;
		}

		newNode.next = head;
		head  = newNode;
		size++;
		return;
	}

	public void pop() throws Exception{
		if(size == 0){
			// System.out.println("here");
			throw new Exception("Steque is empty.");
		}

		head = head.next;
		size--;
		// System.out.println("size == "+size);
	}

	public void enqueue(int data){
		Node newNode = new Node(data);

		if(size == 0){
			tail = newNode;
			head = tail;
			size++;
			return;
		}

		tail.next = newNode;
		tail = newNode;
		size++;
		return;
	}

	public void clear(){
		head = null;
		tail  = null;
		size = 0;
	}


	public String display(){
		// System.out.println("inside display");
		String result = "";
		Node curr = head;
		if(size == 0){
			result = "Steque is empty.";
			return result;
		}

		while(curr != null){


			if(curr.next  == null){
				result += curr.data;	
			}
			else{
				result += curr.data+", ";
				// System.out.println(curr.data);
			}
			curr = curr.next;
		}

		return result;

	}


}

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Steque stq = new Steque();
		int testcases = Integer.parseInt(sc.nextLine());

		for(int i=0;i<testcases;i++){

			while(sc.hasNext()){
				String input = sc.nextLine();
				if(input.length() == 0){
					System.out.println();
					stq.clear();
					break;
				}
				try{
					String[] tokens = input.split(" ");
					switch(tokens[0]){
						case "push": 
							// System.out.println("push-->"+Arrays.toString(tokens));
							stq.push(Integer.parseInt(tokens[1]));
							System.out.println(stq.display());
							break;
						case "pop": 
							// System.out.println("pop-->"+Arrays.toString(tokens));
							stq.pop();
							System.out.println(stq.display());
							break;
						case "enqueue": 
							// System.out.println("enqueue-->"+Arrays.toString(tokens));
							stq.enqueue(Integer.parseInt(tokens[1]));
							System.out.println(stq.display());
							break;
					}	
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
		}
	}
}
