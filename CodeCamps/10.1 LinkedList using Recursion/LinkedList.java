class LinkedList{

	Node head;
	Node tail;
	int size;
	
	class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	public LinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void insertAt(int index, int data) throws Exception{

		if(index < 0 || index > size){
			throw new Exception("Can't insert at this position.");
		}

		head = insertAt(head, new Node(data), index, 0);
		size++;

	}

	private Node insertAt(Node curr, Node newNode, int index, int currIndex){
		if(curr == null){
			// newNode.next = head;
			// System.out.println("yep");
			return newNode;
		}
		else if(currIndex == index){
			newNode.next = curr;
			return newNode;
		}

		curr.next = insertAt(curr.next, newNode, index, currIndex+1);
		return curr;

	}


	public void reverse()
	{
		reverse(head, null);
	}

	private Node reverse(Node curr, Node prev){

		if(curr.next == null){
			head = curr;
			head.next = prev;
			return null;
		}

		Node temp = curr.next;
		curr.next = prev;

		reverse(temp,curr);
		return head;
	}

	public void display(){
		Node curr = head;
		String result = "";
		while(curr!=null){
			if(curr.next == null){
				result += curr.data;
			}
			else{
				result += curr.data+", ";
			}
			curr = curr.next;
		}

		System.out.println(result);
	}
}
