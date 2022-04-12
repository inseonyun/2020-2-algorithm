package week4;

class Heap2 { //min heap
	int count;
	
	public Heap2() {
		count = 0;
	}
	
	public void makeTreeHeap(int H[]) {
		int p = 0;
		int tmpData;
		count = H.length - 1;
		for (int i = count/2; i >= 1; i--) {
			p = i; //서브트리의 루트
			for(int j = 2*p; j <= count; j = 2*j) {
				if(j < count) {
					if(H[j] < H[j+1]) { //왼쪽이 오른쪽보다 작으면
						j = j + 1;
					}
				}
				if(H[p] >= H[j]) {	//부모 데이터가 자식 데이터보다 크면
					break; //반복문에서 나옴
				}
				//부모 데이터와 자식 데이터 교체
				tmpData = H[p];
				H[p] = H[j];
				H[j] = tmpData;
				p = j;
			}
		}
		//print Heap
		for(int i = 1; i <= count; i++) {
			System.out.print(" " + H[i]);
		}
		System.out.println();
	}
	
}

public class Heap2main {
	public static void main(String[] args) {
		int a[] = {0, 15, 11, 7, 5, 13, 50}; //완전 이진 트리
		Heap2 hp2 = new Heap2();
		hp2.makeTreeHeap(a);
	}
}
