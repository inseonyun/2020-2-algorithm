package week5;

class Node {
	int data;
	Node link;
	
	public Node(int data, Node tmpNode) {
		this.data = data;
		link = tmpNode;
	}
}

class Graph1 {
	int n = 7; // 정점
	Node header[] = new Node [n];
	
	public void build() {
		Node tmpNode;
		tmpNode = new Node(3, null);
		tmpNode = new Node(2, tmpNode);
		tmpNode = new Node(1, tmpNode);
		header[0] = tmpNode;
		
		//다른 방법
		 header[1] = new Node(0, new Node(4, null));
		 header[2] = new Node(0, new Node(4, new Node(5, null)));
		 header[3] = new Node(0, new Node(5, null));
		 header[4] = new Node(1, new Node(5, new Node(6, null)));
		 header[5] = new Node(2, new Node(3, new Node(6, null)));
		 header[6] = new Node(4, new Node(5, null));
	}
	public void printList() {
		Node tmpNode;
		for(int i = 0; i < n; i++) {
			tmpNode = header[i];
			System.out.print(i + " : ");
			while (tmpNode != null) {
				System.out.print("-> " + tmpNode.data);
				tmpNode = tmpNode.link;
			}
			System.out.println();
		}
	}
}

public class GraphList {
	public static void main(String[] args) {
		Graph1 g1 = new Graph1();
		g1.build();
		System.out.println("Graph G1");
		g1.printList();
	}
}
