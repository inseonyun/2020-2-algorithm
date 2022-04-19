package week12;

import java.util.Random;

class Sorting {
	//퀵 정렬
	public static int partition(int[] a, int i, int j) {
		int pivot = a[i]; // 가장 왼쪽 값
		int p = i;
		int temp;
		for(int k = i + 1; k <= j; k++) { // 피벗보다 작은 원소를 찾음
			if(a[k] < pivot) {
				p = p + 1;
				temp = a[p];
				a[p] = a[k];
				a[k] = temp;
			}	
		}
		temp = a[i];
		a[i] = a[p];
		a[p] = temp;
		
		return p;
	}
	public static void internalQuickSort(int[] a, int m, int n) {
		int p;
		if(m >= n) {
			return;
		}
		p = partition(a, m, n);
		internalQuickSort(a, m, p-1); //왼쪽 파트
		internalQuickSort(a, p+1, n); //오른쪽 파트
	}
	public static void quickSort(int[] a) {
		internalQuickSort(a, 0, a.length - 1);
	}
	
	//합병 정렬
	public static void merge(int[] a, int[] temp, int m, int p, int q, int n) {
		int t = m;
		int numElements = n - m + 1;
		while(m <= p && q <= n) {
			if(a[m] < a[q])
				temp[t++] = a[m++];
			else
				temp[t++] = a[q++];
		}
		while(m <= p) //왼쪽 부분 배열에 원소가 남아 있는 경우
			temp[t++] = a[m++];
		while(q <= n) // 오른쪽 부분 배열에 원소가 남아 있는 경우
			temp[t++] = a[q++];
		for(int i = 0; i < numElements; i++, n--) // 배열 temp[]를 a[]로 복사
			a[n] = temp[n];
	}
	public static void internalMergeSort(int[] a, int[] temp, int m, int n) {
		if(m < n) {
			int middle = (m + n) / 2;
			internalMergeSort(a, temp, m, middle);
			internalMergeSort(a, temp, middle + 1, n);
			merge(a, temp, m, middle, middle + 1, n);
		}
	}
	public static void mergeSort(int[] a) {
		int[] temp= new int[a.length]; //원소의 개수에 비례하는 추가적인 공간
		internalMergeSort(a, temp, 0, a.length - 1);
	}

	public static void printArray(int a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	
	//히프 정렬
	public static void swap(int[] a, int i, int j) {
		int tmp = a[j];
		a[j] = a[i];
		a[i] = tmp;
	}
	public static void heapify(int[] a, int size, int pNode) {
		int parent = pNode;
		int lNode = (pNode * 2) + 1;
		int rNode = (pNode * 2) + 2;
		
		if(size > lNode && a[parent] < a[lNode]) 
			parent = lNode;
		
		if(size > rNode && a[parent] < a[rNode]) 
			parent = rNode;
		if(parent != pNode) {
			swap(a, pNode, parent);
			heapify(a, size, parent);
		}
		/*
		for(int j = 2*h; j <= m; j=2*j) {
			if(j < m)
				if(a[j] < a[j + 1])
					j = j+1;
			if(a[h] >= a[j])
				break;
			else 
				a[j/2] = a[j];
			
		}
		*/
	}
	public static void heapSort(int[] a) {
		for(int i = a.length/2-1; i >= 0; i--) {
			heapify(a, a.length, i);
		}
		for(int i = a.length-1; i >= 0; i--) {
			swap(a, i, 0);
			heapify(a, i, 0);
		}
	}
}

public class SortMain {
	private static int x = 2000;
	private static int SIZE = x;
	private static final int MAX = x;
	public static void main(String[] args) {
		
		int a[] = new int[SIZE];
		Random R = new Random();
		//1. 랜덤값 대입
//		for(int i = 0; i < SIZE; i++) {
//			a[i] = R.nextInt(MAX);
//		}
		//2. 정방향 데이터 대입
//		for(int i = 0; i < SIZE; i++) {
//		a[i] = i;
//		}
		//역방향 데이터 삽입
		for(int i = 0; i < SIZE; i++) {
			a[i] = MAX - i;
		}
		long start = System.currentTimeMillis();
//		Sorting.quickSort(a);	//퀵 정렬
//		Sorting.mergeSort(a);	//합병 절렬
		Sorting.heapSort(a);	//힙 정렬
		long end = System.currentTimeMillis();
		System.out.println("실행시간 : " + (double)(end - start)/1000);

		
	}
}
