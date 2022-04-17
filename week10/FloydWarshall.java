package week10;

class ShortestPath {
	int V = 5;
	final static int INF = 99999;
	public void printDist(int dist[][]) {
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				if (dist[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
	public void floydWarshall(int graph[][]) {
		int dist[][] = new int[V][V];
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				dist[i][j] = graph[i][j];
			}
		}
		for(int k = 0; k < V; k++) {
			//k´Â Á¤Á¡
			for(int i = 0; i < V; i++) {
				for(int j = 0; j < V; j++) {
					if(dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		printDist(dist);
	}
}

public class FloydWarshall {
	final static int INF = 99999;
	public static void main(String[] args) {
		int graph [][] = {{0, 3, 8, INF, -4 },
				{INF, 0, INF, 1, 7 },
				{INF, 4, 0 , INF, INF},
				{2, INF, -5, 0, INF},
				{INF, INF, INF, 6, 0}
		};
		ShortestPath a = new ShortestPath();
		a.floydWarshall(graph);
	}
}
