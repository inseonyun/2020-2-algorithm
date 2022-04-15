package week7;

class Dijkstra {
	int V = 5;
	
	public Dijkstra(int v) {
		this.V = v;
	}
	
	public void shortestPath(int graph[][], int src) {
		int dist[] = new int[V];
		Boolean visited[] = new Boolean[V];
		for (int i = 0; i < V; i++) {
			dist[i] = 99;
			visited[i] = false;
		}
		dist[src] = 0;
		for (int count = 0; count < V-1; count++) {
			int u = minDistance(dist, visited);
			visited[u] = true;
			// update shortest value
			for(int v = 0; v < V; v++) {
				if(!visited[v] && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		printShortestPath(dist);
	}
	
	public void printShortestPath(int dist[]) {
		for(int i = 0; i < V; i++) {
			System.out.println("from 0" + " to " + i + " dist = " + dist[i]);
		}
	}
	
	int minDistance(int dist[], Boolean visited[]) {
		int min = 99;
		int minIndex = -1;
		for(int v = 0; v < V; v++) {
			if(visited[v] == false && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
}

public class DijkstraMain {
	public static void main(String[] args) {
		int graph[][] = new int[][]{
			//99 = infinite
			/* 실습 영상 그래프
			{0, 5, 10, 99, 99},
			{99, 0, 3, 9, 2},
			{99, 2, 0, 1, 99},
			{99, 99, 99, 0, 4},
			{7, 99, 99, 6, 0}
			*/
			{0, 3, 7, 5, 99, 99, 99},
			{99, 0, 2, 99, 9, 99, 99},
			{99, 99, 0, 1, 6, 12, 25},
			{99, 99, 99, 0, 99, 99, 20},
			{99, 99, 99, 99, 0, 4, 99},
			{99, 99, 99, 99, 99, 0, 8},
			{99, 99, 99, 99, 99, 99, 0}
		};
		// 정점의 개수를 매개변수로 보내줘서 생성자로 받음
		Dijkstra g1 = new Dijkstra(7);
		g1.shortestPath(graph, 0);
	}
}
