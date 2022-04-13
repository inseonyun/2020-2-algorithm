package week5;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
/*
class Node { //���� ��Ű���� ��� Ŭ������ �־� �ּ� ó�� �մϴ�.
	int data;
	Node link;
	
	public Node(int data, Node tmpNode) {
		this.data = data;
		link = tmpNode;
	}
}
*/

class Graph2 {
	int n = 7; // ����
	Node header[] = new Node [n];
	boolean visited[] = new boolean[n]; // true : �湮����, false : �湮���� ����
	
	public void build() {
		Node tmpNode;
		tmpNode = new Node(3, null);
		tmpNode = new Node(2, tmpNode);
		tmpNode = new Node(1, tmpNode);
		header[0] = tmpNode;
		
		//�ٸ� ���
		 header[1] = new Node(0, new Node(4, null));
		 header[2] = new Node(0, new Node(4, new Node(5, null)));
		 header[3] = new Node(0, new Node(5, null));
		 header[4] = new Node(1, new Node(5, new Node(6, null)));
		 header[5] = new Node(2, new Node(3, new Node(6, null)));
		 header[6] = new Node(4, new Node(5, null));
	}
	
	public void DFS(int startV) { //startV : �����
		Node tmpNode;
		int v;
		
		for(int i = 0; i < n; i++) {
			visited[i] = false; //��� false�� �ʱ�ȭ
		}
		Stack s = new Stack();
		s.push(startV);
		while(!s.isEmpty()) { // ������ �� �� ������
			v = (int) s.pop();
			if(visited[v] == false) {
				visited[v] = true;
				System.out.print("->" + v);
				tmpNode = header[v];
				while(tmpNode != null) {
					if(visited[tmpNode.data] == false) { //�湮���� ����
						s.push(tmpNode.data);
					}
					tmpNode = tmpNode.link;
				}
			}
		}
		System.out.println();
	}
	
	public void BFS(int startV) { //startV : �����
		Node tmpNode;
		int v;
		
		for(int i = 0; i < n; i++) {
			visited[i] = false; //��� false�� �ʱ�ȭ
		}
		Queue<Integer> q = new LinkedList();
		q.add(startV);
		while(!q.isEmpty()) { // ������ �� �� ������
			v = (int)q.remove();
			if(visited[v] == false) {
				visited[v] = true;
				System.out.print("->" + v);
				tmpNode = header[v];
				while(tmpNode != null) {
					if(visited[tmpNode.data] == false) { //�湮���� ����
						q.add(tmpNode.data);
					}
					tmpNode = tmpNode.link;
				}
			}
		}
		System.out.println();
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
public class GraphTraversal {
	public static void main(String[] args) {
		Graph2 g1 = new Graph2();
		g1.build();
		System.out.println("Graph G1");
		g1.printList();
		System.out.println("DFS");
		g1.DFS(0);
		System.out.println("BFS");
		g1.BFS(0);
	}
}
