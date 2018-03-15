
public class AVL_BST{

	public static boolean checkAVL(BST b){
		if(b == null){
			return true;
		}
		int rheight = treeHeight(b.right);
		int lheight = treeHeight(b.left);
		if((rheight - lheight <= 1) && (lheight - rheight <=1) && checkAVL(b.right) && checkAVL(b.left)){
			return true;
		}
		return false;
	}

	public static BST createBST(int[] a){
		BST tree = new BST(a[0]);
		for(int count = 1;count < a.length;count++){
			insert(a[count], tree);
		}
		return tree;
	}

	public static int treeHeight(BST tree){
		if(tree == null){
			return 0;
		}
		return 1 + max(treeHeight(tree.left),treeHeight(tree.right));
	}

	public static int max(int a, int b){
		if(a > b){
			return a;
		}
		return b;
	}

	public static void insert(int val, BST tree){
		while(true){
			if(val < tree.value){
				if(tree.left == null){
					tree.left = new BST(val);
					break;
				}
				tree = tree.left;
			}
			else{
				if(tree.right == null){
					tree.right = new BST(val);
					break;
				}
				tree = tree.right;
			}
		}
	}

	public static void main(String[] args){
		int[] A = {5,1,98,100,-3,-5,55,3,56,50};
		BST b = createBST(A);
		System.out.println(checkAVL(b));
	}

}

class BST{
	BST left;
	BST right;
	int value;

	BST(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
