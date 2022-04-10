package week2;

class BinaryTree {
	TreeNode root;
	int count = 0;
	int countleaf = 0;
	
	public TreeNode makenode(TreeNode left, int data, TreeNode right)	{
		root = new TreeNode(data);
		root.left = left;
		root.data = data;
		root.right = right;
		
		return root;
	}
	public void preorder(TreeNode root) {
		if(root != null) {
			System.out.print(root.data + ", ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	public void postorder(TreeNode root)	{
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + ", ");
		}
	}
	public void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data + ", ");
			inorder(root.right);
		}
	}
	public int countNode(TreeNode root) {
		if(root != null) {
			this.count++;
			countNode(root.left);
			countNode(root.right);
		}
		return count;
	}
	public int countLeaf(TreeNode root) {
		if(root != null) {
			if((root.left == null) && (root.right == null))	{
				countleaf++;
			}
			countLeaf(root.left);
			countLeaf(root.right);
		}
		return countleaf;
	}
	public int countDepth(TreeNode root) {
		int countdepth = 0;
		/*int depL, depR;  			//Math.max() 함수를 이용하지 않고 하는법
		if(root != null) {
			depL = countDepth(root.left);
			depR = countDepth(root.right);
			if(depL >= depR)
				countdepth = depL + 1;
			else
				countdepth = depR + 1;
		}
		*/
		if(root != null) {
			countdepth = 1 + Math.max(countDepth(root.left), countDepth(root.right));
		}
		return countdepth;
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
	
}

public class BT {
	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();
		TreeNode node1 = tree1.makenode(null, 1, null);
		TreeNode node2 = tree1.makenode(null, 7, null);
		TreeNode node3 = tree1.makenode(node1, 3, node2);
		TreeNode node4 = tree1.makenode(null, 14, null);
		TreeNode node5 = tree1.makenode(node3, 9, node4);
		TreeNode node6 = tree1.makenode(null, 44, null);
		TreeNode node7 = tree1.makenode(null, 36, node6);
		TreeNode node8 = tree1.makenode(null, 97, null);
		TreeNode node9 = tree1.makenode(null, 94, node8);
		TreeNode node10 = tree1.makenode(node7, 67, node9);
		TreeNode node11 = tree1.makenode(node5, 22, node10);
		System.out.println("Preorder");
		tree1.preorder(node11);
		System.out.println();
		
		System.out.println("Postorder");
		tree1.postorder(node11);
		System.out.println();
		
		System.out.println("inorder");
		tree1.inorder(node11);
		System.out.println();
		
		System.out.println("countNode : " + tree1.countNode(node11));
		System.out.println("countLeaf : " + tree1.countLeaf(node11));
		System.out.println("countDepth : " + tree1.countDepth(node11));
	}
}
