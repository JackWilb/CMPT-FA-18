
public class Runner {

	public static void main(String[] args) {
		
		Gtree<Integer> tree1 = new Gtree<Integer>();
		tree1.root = 5;
		Gtree<Integer> tree2 = new Gtree<Integer>();
		tree2.root = 4;
		Gtree<Integer> tree3 = new Gtree<Integer>();
		tree3.root = 6;
		
		tree1.left = tree2;
		tree1.right = tree3;
		
		System.out.println(Integer.toString(tree1.root) + Integer.toString(tree1.left.root) + Integer.toString(tree1.right.root));
		
		preorder(tree1);
		inorder(tree1);
	}
	
	public static <T> void preorder(Gtree<T> t) {
		System.out.println(t.root);
		
		if (t.right == null && t.left == null) {
			return;
		} else {
			preorder(t.left);
			preorder(t.right);
		}
	}
	
	public static <T> void inorder(Gtree<T> t) {
		if (t.right == null && t.left == null) {
			return;
		} else {
			preorder(t.left);
			System.out.println(t.root);
			preorder(t.right);
		}
	}

}
