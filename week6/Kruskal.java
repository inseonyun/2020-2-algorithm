package week6;

import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable<Edge> {
	int v1;
	int v2;
	int cost;
	
	public Edge(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edge o) {
		if(this.cost < o.cost) 
			return -1;
		else if(this.cost == o.cost) 
			return 0;
		else 
			return 1;
	}
}
public class Kruskal {
	public static int[] parent;
	public static ArrayList<Edge> edgeList;
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) {
			parent[y] = x;
		}
	}
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		return find(parent[x]);
	}
	public static boolean isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) { //사이클이 만들어짐
			return true;
		} else
			return false;
	}
	public static void main(String[] args) {
		int sum = 0;
		edgeList = new ArrayList<Edge> ();
		Edge e1 = new Edge(0, 1, 5);
		edgeList.add(e1);				 //e1생성 및 정의 후 삽입 가능
		edgeList.add(new Edge(0, 2, 4)); //이렇게도 가능하다.
		edgeList.add(new Edge(1, 2, 2)); 
		edgeList.add(new Edge(1, 3, 7)); 
		edgeList.add(new Edge(2, 3, 6)); 
		edgeList.add(new Edge(3, 4, 3)); 
		edgeList.add(new Edge(3, 5, 8)); 
		edgeList.add(new Edge(4, 5, 8)); 
		
		parent = new int[8];
		for(int i = 1; i <= 7; i++) {
			parent[i] = i;
		}
		Collections.sort(edgeList);
		
		for(int i = 0; i < edgeList.size(); i++) {
			Edge edge1 = edgeList.get(i);
			if(!isSameParent(edge1.v1, edge1.v2)) { //부모가 같지 않으면 싸이클이 아님
				System.out.println(edge1.v1 + " " + edge1.v2 + " " + edge1.cost);
				sum = sum + edge1.cost;
				union(edge1.v1, edge1.v2);
			}
		}
		System.out.println("Minimum cost sum = " + sum);
	}
}
