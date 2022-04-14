package week6;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

class Edgee implements Comparable <Edgee> {
	//Edge 클래스가 이미 패키지 내에 있어 e를 하나 더 붙였습니다.
	int from;
	int to;
	int cost;
	
	public Edgee(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	@Override
	public int compareTo(Edgee e) {
		return this.cost = e.cost;
	}
}

class Graph {
	List<Edgee>[] edge;
	
	public Graph(int V) {
		edge = new LinkedList[V];
		for(int i = 0; i < V; i++) {
			edge[i] = new LinkedList<>();
		}
	}
	public void addEdge(int from, int to, int cost) {
		// Edgee e1 = new Edgee1(from, to, cost);
		// edge[from].add(e1);과 밑에 한 줄은 같다.
		edge[from].add(new Edgee(from, to, cost));
		edge[to].add(new Edgee(to, from, cost));
	}
}

public class Prim {
	static Graph g1;
	
	static int V, E, sum = 0;
	static boolean[] visited;
	static ArrayList<Edgee> mst;
	public static void Prim1() {
		PriorityQueue<Edgee> pq = new PriorityQueue<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0); // 시작 정점 0
		while(!queue.isEmpty()) {
			int from = queue.poll();
			visited[from] = true; // 방문했음
			for(Edgee edge : g1.edge[from]) {
				//edge.from, edge.to, edge.cost가 나옴
				if(!visited[edge.to]) {
					pq.add(edge);
				}
			}
			while(!pq.isEmpty()) {
				Edgee edge1 = pq.poll();
				if(!visited[edge1.to]) {
					queue.add(edge1.to);
					visited[edge1.to] = true;
					mst.add(edge1);
					sum = sum + edge1.cost;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		V = 6;	//정점의 개수
		E = 9;	//간선의 개수
		visited = new boolean[V];
		mst = new ArrayList<>();
		g1 = new Graph(V);
		g1.addEdge(0, 1, 5);
		g1.addEdge(0, 2, 4);
		g1.addEdge(1, 2, 2);
		g1.addEdge(1, 3, 7);
		g1.addEdge(2, 3, 6);
		g1.addEdge(2, 4, 11);
		g1.addEdge(3, 4, 3);
		g1.addEdge(3, 5, 8);
		g1.addEdge(4, 5, 8);
		
		Prim1();
		for(Edgee edge1 : mst) {
			System.out.println(edge1.from + " " + edge1.to + " " + edge1.cost);
		}
		System.out.println("Minimum cost = " + sum);
		
	}
}
