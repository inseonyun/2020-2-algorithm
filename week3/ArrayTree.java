package week3;

public class ArrayTree {
	static void inorder(char T[], int i) {
		if(T[i*2] != '\0') {
			inorder(T, i*2);
		}
		System.out.print(" " + T[i]);
		if(T[i*2+1] != '\0') {
			inorder(T, i*2+1);
		}
	}
	static void preorder(char T[], int i) {
		System.out.print(" " + T[i]);
		if(T[i*2] != '\0') {
			inorder(T, i*2);
		}
		if(T[i*2+1] != '\0') {
			inorder(T, i*2+1);
		}
	}
	static void postorder(char T[], int i) {
		if(T[i*2] != '\0') {
			inorder(T, i*2);
		}
		if(T[i*2+1] != '\0') {
			inorder(T, i*2+1);
		}
		System.out.print(" " + T[i]);
	}
	static void descendents(char T[], int i) {
		if(T[i] == '\0') 
			return;
		else {
			System.out.print(T[i] + " ");
			descendents(T, i*2);
			descendents(T, i*2+1);
		}
	}
	static void ancestors(char T[], int i) {
		System.out.print(T[i] + " ");
		if(i == 1)
			return;
		else {
			ancestors(T, i/2);
		}
	}
	public static void main(String[] args) {
		char [] T = new char[30];
		T[1] = 'A';
		T[2] = 'B';
		T[3] = 'C';
		T[4] = 'D';
		T[5] = 'E';
		T[6] = 'F';
		T[7] = 'G';
		T[11] = 'H';
		T[14] = 'I';
		System.out.println("Inorder");
		inorder(T, 1);
		System.out.println("\nEend of inorder\n");
		
		System.out.println("Preorde");
		preorder(T, 1);
		System.out.println("\nEnd of preorder\n");
		
		System.out.println("Postorde");
		postorder(T, 1);
		System.out.println("\nEnd of postorder\n");
		
		System.out.println("Descendents");
		descendents(T, 1);
		System.out.println("\nEnd of Descendents\n");
		
		System.out.println("Ancestors");
		ancestors(T, 14);
		System.out.println("\nEnd of Ancestors");
		
	}
}
