package week13;

import java.util.Arrays;
import java.util.Random;

class Sorting {
	public static void printArray(int a[]) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	//버킷 정렬
	public static int[] bucket_sort(int []arr) {
		int []bucket = new int[maxValue(arr) + 1];
		int [] sorted_arr = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++)
			bucket[arr[i]]++;
		
		int pos = 0;
		for(int i = 0; i < bucket.length; i++)
			for(int j = 0; j < bucket[i]; j++)
				sorted_arr[pos++] = i;
		return sorted_arr;
	}
	public static int maxValue(int []arr) {
		int max_value = 0;
		for(int i = 0; i < arr.length; i++)
			if(arr[i] > max_value)
				max_value = arr[i];
		return max_value;
	}
	//기수 정렬 (radix_sort)
	public static int get_Max_val(int []arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) 
				max = arr[i];
		}
		return max;
	}
	public static void countSort(int[] arr, int exp) {
		int result[] = new int[arr.length];
		int count[] = new int[10];
		Arrays.fill(count, 0);
		
		//count 값 count 배열에 저장
		for(int i = 0; i < arr.length; i++) 
			count[(arr[i]/exp)%10]++;
		
		//count 값 포함시켜 count 배열에 저장
		for(int i = 1; i < 10; i++) 
			count[i] += count[i-1];
		//result 배열 빌드
		for(int i = arr.length - 1; i >= 0; i--) {
			result[count[(arr[i]/exp)%10]-1] = arr[i];
			count[(arr[i]/exp)%10]--;
		}
		//result 배열에 저장된 값을 arr 배열에 저장
		for(int i = 0; i < arr.length; i++)
			arr[i] = result[i];
	}
	public static void radix_sort(int []arr) {
		//최대값 찾기
		int max = get_Max_val(arr);
		for(int exp = 1; max/exp > 0; exp*=10)
			countSort(arr, exp);
	}
	//계수 정렬 (count_sort)
	public static int[] count_sort(int[] arr) {
		int max = getMax(arr);
		int countArr[] = new int[max + 1];
		int resultArr[] = new int[arr.length];	//결과를 담을 배열
		//배열에 있는 숫자들의 개수를 세어 countArr에 저장
		for(int i = 0; i < arr.length; i++)
			countArr[arr[i]]++;
		//countArr의 이전 값과 현재 값을 더하는 과정
		for(int i = 1; i < countArr.length; i++)
			countArr[i] += countArr[i - 1];
		//countArr[arr[i]]은 인자가 들어갈 n번째 자리이므로 실제 배열에서는 -1을 한 index가 되어야 함
		for(int i = arr.length - 1; i >= 0; i--) 
			resultArr[--countArr[arr[i]]] = arr[i];
		return resultArr;
	}
	public static int getMax(int []arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	//쉘 정렬 (shell_sort)
	public static int[] shell_sort(int []arr) {
		int n = arr.length;
		int h = 1;
		
		while(h < n/3)
			h = h*3 + 1;
		while(h >= 1) {
			for(int i = h; i < n; i++) {
				for(int j = i; j >= h && arr[j] < arr[j-h]; j-=h) {
					int t = arr[j];
					arr[j] = arr[j-h];
					arr[j-h] = t;
				}
			}
			h /= 3;
		}
		return arr;
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
//			a[i] = i;
//		}
		//역방향 데이터 삽입
		for(int i = 0; i < SIZE; i++) {
			a[i] = MAX - i;
		}
		long start = System.currentTimeMillis();
//		Sorting.printArray(Sorting.bucket_sort(a));
//		Sorting.radix_sort(a);
//		for(int i = 0; i < a.length; i++) {
//			System.out.print(a[i] + ", ");
//		}
//		Sorting.printArray(Sorting.count_sort(a));
		Sorting.printArray(Sorting.shell_sort(a));
		long end = System.currentTimeMillis();
		System.out.println("\n실행시간 : " + (double)(end - start)/1000);

		
	}
}
