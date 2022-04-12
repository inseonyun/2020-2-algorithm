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
	//������ ����
	public void insert(String data) {
		Node newNode = new Node(data);
		if(root == null) {	//root == null�� ���Ұ� ���ٴ� ��
			root = newNode; //root�� newNode�� ��
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
				} else { //tmpRoot.data�� > data���� ŭ
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
	//������ ����
	public void deleteData(String data) {
		Node z = searchBST(data);
		if(z == null) { //������ data�� Ʈ���� ����
			return;
		}
		if((z.left ==null) && (z.right == null)) { //�����ϴ� z�� �ڽ��� ����, �ƹ��� �� �ڸ��� ��
			if(z.parent.data.compareTo(data) > 0) { //�����ϴ� �����ͺ��� �ƹ��� �����Ͱ� ŭ
				z.parent.left = null; //z���� ū�Ŵ� z�� parent�� ���ʿ� ����
			} else {
				z.parent.right = null; //z�� �ƹ��� ���� ũ�� �����ʿ� ��ġ��
			}
		} else if(z.left == null) { //�����Ϸ��� z���� �����ʿ� �ڽ��� �ϳ� ���� 
			if(z.parent.left == z) {
				z.parent.left = z.right; //z�� �θ��� ���ʿ� �ִٸ� �ű⿡ z�� �ڽ��� �̾���
			} else {
				z.parent.right = z.right;
			}
		} else if(z.right == null){ //�����Ϸ��� z���� ���ʿ� �ڽ��� ����
			if(z.parent.left == z) {
				z.parent.left = z.left; //z�� �θ��� ���ʿ� �ִٸ� �ű⿡ z�� �ڽ��� �̾���
			} else {
				z.parent.right = z.left;
			}
		} else {	//�����Ϸ��� z�� ���ʿ� �ڽ��� ����
			Node max = maximum(z.left); //maximum�� ���� ����Ʈ������ ���� ū �ָ� ������
			String maxData = max.data;
			deleteData(max.data);
			z.data = maxData;
		}
	}
	//���� ū ������ ã��
	public Node maximum(Node z) {
		Node x = z;
		while(x.right != null) {
			x = x.right;
		}
		return x;
	}
	
	//���޹��� �����Ϳ� ���� �� ã�� 
	public Node searchBST(String data) {
			Node tmpRoot = root;
			while(tmpRoot != null) {
				if((tmpRoot.data).compareTo(data) < 0) {
					tmpRoot = tmpRoot.right;
				} else if((tmpRoot.data).compareTo(data) > 0) {
					tmpRoot = tmpRoot.left;
				} else { //ũ���� ������ �ʴ� = ���ٴ°�
					return tmpRoot;
				}
			}
			System.out.println("Data not exists");
			return null; //�� ���ǹ��� ���������� ã���� �ϴ� �����Ͱ� ����.
	}
	//������ ��� ���� ��ȸ
	public void printInorder() {
		pInorder(root);
		System.out.println();
	}
	
	public void pInorder(Node root) {
		if(root != null) {
			pInorder(root.left); //����
			System.out.print(" " + root.data); // ������ ���
			pInorder(root.right); //������
		}
	}
}

public class BSTmain {
	public static void main(String[] args) {
		BST t = new BST();	//����Ž��Ʈ�� ����
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
