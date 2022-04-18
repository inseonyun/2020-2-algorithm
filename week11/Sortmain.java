package week11;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Sorting {
	
	public static void insertionSort(int []a) {
		for(int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;
			for(j = i-1; j > 0 && temp < a[j]; j--) {
				a[j+1] = temp;
			}
			a[j+1] = temp;
		}
	}
	public static void selectionSort(int []a) {
		for(int i = 0; i < a.length - 1; i++) {
			int min_idx = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[min_idx])
					min_idx = j;
			}
			int temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}
	}
	public static void bubbleSort(int []a) {
		int i, j, temp;
		for(i = 0; i < a.length - 1; i++) {
			for(j = 0; j < a.length -1; j++) {
				if(a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	public static void flagbubbleSort(int []a) {
		int i, j, temp;
		boolean swapped;
		for(i = 0; i < a.length - 1; i++) {
			swapped = false;
			for(j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swapped = true;
				}
			}
			if(swapped == false)
				break;
		}
	}
}

public class Sortmain {
	private static final int MAX = 1000;
	private static int SIZE = 2000;
	public static void main(String[] args) {
		//랜덤 데이터 삽입
		int a [] = new int[SIZE];
		Random r = new Random();
//		for(int i = 0; i < SIZE; i++) {
//			a[i] = r.nextInt(MAX); //난수 범위 : 0부터 MAX(1000)-1까지
//		}
		
		//정방향 데이터 삽입
//		for(int i = 0; i < SIZE; i++) {
//			a[i] = i;
//		}
		
		//역방향 데이터 삽입
		for(int i = 0; i < SIZE; i++) {
			a[i] = MAX - i;
		}

		long start = System.currentTimeMillis();
//		Sorting.insertionSort(a);
//		Sorting.selectionSort(a);
//		Sorting.bubbleSort(a);
		Sorting.flagbubbleSort(a);
		long end = System.currentTimeMillis();
		System.out.println("실행시간 : " + (double)(end - start)/1000);
	}
}
