package week4;

class Node {
	public String data;
	public Node left;
	public Node right;
	public Node parent;
	
	public Node(String data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}

class BST {
	public Node root = null;
	//데이터 삽입
	public void insert(String data) {
		Node newNode = new Node(data);
		if(root == null) {	//root == null은 원소가 없다는 것
			root = newNode; //root가 newNode가 됨
		} else {
			Node tmpRoot = root;
			while(tmpRoot != null) {
				if((tmpRoot.data).compareTo(data) < 0) {
					if(tmpRoot.right == null) {
						tmpRoot.right = newNode;
						newNode.parent = tmpRoot;
						return;
					} else {
						tmpRoot = tmpRoot.right;
					}
				} else { //tmpRoot.data가 > data보다 큼
					if(tmpRoot.left == null) {
						tmpRoot.left = newNode;
						newNode.parent = tmpRoot;
						return;
					} else {
						tmpRoot = tmpRoot.left;
					}
				}
			}
		}
	}
	//데이터 삭제
	public void deleteData(String data) {
		Node z = searchBST(data);
		if(z == null) { //삭제할 data가 트리에 없음
			return;
		}
		if((z.left ==null) && (z.right == null)) { //삭제하는 z의 자식이 없음, 아버지 끈 자르면 됨
			if(z.parent.data.compareTo(data) > 0) { //삭제하는 데이터보다 아버지 데이터가 큼
				z.parent.left = null; //z보다 큰거니 z는 parent의 왼쪽에 있음
			} else {
				z.parent.right = null; //z가 아버지 보다 크니 오른쪽에 위치함
			}
		} else if(z.left == null) { //삭제하려는 z에게 오른쪽에 자식이 하나 있음 
			if(z.parent.left == z) {
				z.parent.left = z.right; //z가 부모의 왼쪽에 있다면 거기에 z의 자식을 이어줌
			} else {
				z.parent.right = z.right;
			}
		} else if(z.right == null){ //삭제하려는 z에게 왼쪽에 자식이 있음
			if(z.parent.left == z) {
				z.parent.left = z.left; //z가 부모의 왼쪽에 있다면 거기에 z의 자식을 이어줌
			} else {
				z.parent.right = z.left;
			}
		} else {	//삭제하려는 z의 양쪽에 자식이 있음
			Node max = maximum(z.left); //maximum은 왼쪽 서브트리에서 가장 큰 애를 가져옴
			String maxData = max.data;
			deleteData(max.data);
			z.data = maxData;
		}
	}
	//가장 큰 데이터 찾기
	public Node maximum(Node z) {
		Node x = z;
		while(x.right != null) {
			x = x.right;
		}
		return x;
	}
	
	//전달받은 데이터와 같은 값 찾기 
	public Node searchBST(String data) {
			Node tmpRoot = root;
			while(tmpRoot != null) {
				if((tmpRoot.data).compareTo(data) < 0) {
					tmpRoot = tmpRoot.right;
				} else if((tmpRoot.data).compareTo(data) > 0) {
					tmpRoot = tmpRoot.left;
				} else { //크지도 작지도 않다 = 같다는것
					return tmpRoot;
				}
			}
			System.out.println("Data not exists");
			return null; //위 조건문을 실행했으나 찾고자 하는 데이터가 없음.
	}
	//데이터 출력 중위 순회
	public void printInorder() {
		pInorder(root);
		System.out.println();
	}
	
	public void pInorder(Node root) {
		if(root != null) {
			pInorder(root.left); //왼쪽
			System.out.print(" " + root.data); // 데이터 출력
			pInorder(root.right); //오른쪽
		}
	}
}

public class BSTmain {
	public static void main(String[] args) {
		BST t = new BST();	//이진탐색트리 생성
		t.insert("S");
		t.insert("J");
		t.insert("U");
		t.insert("B");
		t.insert("A");
		t.insert("M");
		t.insert("R");
		t.insert("Q");
		t.insert("D");
		t.insert("G");
		t.insert("E");
		
		t.printInorder();

		t.deleteData("Z");
		t.deleteData("A");
		t.printInorder();

	}
}
