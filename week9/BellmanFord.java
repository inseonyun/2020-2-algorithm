package week9;

import java.util.Arrays;

public class BellmanFord {
	public static final int INF = Integer.MAX_VALUE; //INF�� ���Ѵ�

	public static void bellmanFord(int num, int [][] adj, int src) {
		int [] dist = new int[num];
		Arrays.fill(dist, INF);
		/*	�ؿ� for���� ���� Arrays.fill() �� ����
		for(int i = 0; i < num; i++) {
			dist[i] = INF;
		}
		*/
		dist[0] = 0;
		for(int v = 0; v < num; v++) {
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < num; j++) {
					if(adj[i][j] != INF) {
						dist[j] = Math.min(dist[j], dist[i] + adj[i][j]);
					}
				}
			}
		}
		for(int i = 0; i < num; i++) {
			System.out.println("dist["+ i + "] : "+ dist[i]);		
		}
	}
	
	public static void main(String[] args) {
		int num = 6;	
		int [][] adj = new int[][] {
			{0, 6, 5, 5, INF, INF},
			{INF, 0, INF, INF, -1, INF},
			{INF, -2, 0, INF, 1, INF},
			{INF, INF, -3, 0, INF, -1},
			{INF, INF, INF, INF, 0, 3},
			{INF, INF, INF, INF, INF, 0}
		};
		int src = 0; //������
		bellmanFord(num, adj, src);
	}
}
