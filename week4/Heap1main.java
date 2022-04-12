package week4;

class Heap1 {
	int maxSize;
	int count;
	int heap[];
	
	public Heap1() {
		maxSize = 50;
		count = 0;
		heap = new int[maxSize];
	}
	//히프 원소 삽입
	public void insertHeap(int data) {
		int i;
		if(count == maxSize) {
			System.out.println("Heap full");
			return;
		}
		count = count + 1;	//데이터 삽입으로 개수 증가
		i = count; 
		int flag = 1;
		while(flag == 1) {
			if(i == 1) {
				flag = 0;
			} else if(data <= heap[i/2]) { //자식 데이터가 부모보다 작음
				flag = 0;
			} else {
				heap[i] = heap[i/2];
				i = i/2;
			}
		}
		heap[i] = data;
	}
	//히프 원소 삭제
	public int deleteHeap() {
		int data;
		int i, j;
		if(count == 0) { //원소가 없음
			System.out.println("Empty Heap");
			return -1;
		}
		data = heap[1];
		int tmpData = heap[count];
		count = count - 1;
		i = 1; j = 2;
		while(j <= count) {
			if(j < count) {
				if(heap[j] < heap[j+1]) { //왼쪽 오른쪽
					j = j + 1;
				}
			}
			if(tmpData > heap[j]) {
				break;
			} else { //부모가 자식보다 작음
				heap[i] = heap[j]; //데이터 교체
				i = j;
				j = j*2;
			}
		}
		heap[i] = tmpData;
		
		return data;
	}
	//히프 원소 출력
	public void printHeap() {
		for(int i = 1; i <= count; i++) {
			System.out.print(" " + heap[i]);
		}
		System.out.println();
	}
}

public class Heap1main { //max heap
	public static void main(String[] args) {
		Heap1 hp = new Heap1();
		hp.insertHeap(19);
		hp.insertHeap(13);
		hp.insertHeap(5);
		hp.insertHeap(12);
		hp.insertHeap(8);
		hp.insertHeap(99);
		hp.printHeap();
		System.out.println();
		System.out.print(" " + hp.deleteHeap());
		System.out.print(" " + hp.deleteHeap());
		System.out.print(" " + hp.deleteHeap());
		System.out.print(" " + hp.deleteHeap());
		System.out.print(" " + hp.deleteHeap());
		System.out.print(" " + hp.deleteHeap());
		
	}
}
