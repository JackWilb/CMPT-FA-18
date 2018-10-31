import bridges.connect.Bridges;

import bridges.base.BinTreeElement;

import java.util.Iterator;

public class BinaryTreeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//create the Bridges object
		// Use YOUR API Sha1 key and username
		Bridges bridge = new Bridges(0, "Jackow","1498340097205");

		// create elements
		// First parameter is String depicted when using mouseover with bridges animation
		// Second parameter is data object stored at that tree element
		BinTreeElement<String> root = new BinTreeElement<String>("M", "Mango");

		BinaryTree<String> tree = new BinaryTree<String>(root);
		
		// set the color and label of an Element
		root.getVisualizer().setColor("red");
		root.setLabel("Root");

		BinTreeElement<String> fTree = new BinTreeElement<String>("F", "Fig");
		BinTreeElement<String> rTree = new BinTreeElement<String>("R", "Ramen");
		BinTreeElement<String> tTree = new BinTreeElement<String>("T", "Tea");

		
		// link elements
		rTree.setRight(tTree);
		
		root.setLeft(fTree);
		root.setRight(rTree);
		
		// Print Levels
		tree.printLevels();
		
		// Get left most data
		System.out.println(tree.getLeftMostData());
		
		// Get right most data
		System.out.println(tree.getRightMostData());
		
		// Get height
		System.out.println(tree.getHeight());
		
		// Get size
		System.out.println(tree.getSize());
		
		// Remove right most node
		tree.removeRightMostNode();
		
		// Iterators
		System.out.println("Pre Order");
		Iterator iter = tree.getPreOrderIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("In Order");
		iter = tree.getInOrderIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		System.out.println("Post Order");
		iter = tree.getPostOrderIterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		
		
		if (tree.getRoot() != null) {
			// make sure we have a data structure to visualize!
			
			//pass root element of data structure
			bridge.setDataStructure(root);

			//visualize data structure
			// THIS SHOULD BE THE LAST METHOD YOU CALL!
			bridge.visualize();
		}
		
	}

}
