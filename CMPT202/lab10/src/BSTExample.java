/**
 * Demo program of the binary search tree
 * 
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bridges.connect.Bridges;
import bridges.validation.RateLimitException;

public class BSTExample {
	public static void main(String[] args) throws IOException, RateLimitException {
		//create the Bridges object
		// Use YOUR API Sha1 key and username
		Bridges bridges = new Bridges(4, "Jackow","1498340097205");
		
		//Create elements and insert them into the tree
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		
		
		List<Integer> list = new ArrayList<Integer>();
		
		System.out.println(tree.isEmpty());
		
		list.add(50);
		list.add(75);
		list.add(20);
		list.add(10);
		list.add(30);
		list.add(5);
		list.add(15);
		list.add(25);
		list.add(35);
		list.add(3);
		list.add(8);
		list.add(13);
		list.add(28);
		list.add(33);
		list.add(38);
		list.add(85);
		list.add(95);
		
		// iterate through the list and insert the
		// elements into the tree
		Iterator<Integer> itr = list.iterator();
		
		while (itr.hasNext()) {
			tree.add(itr.next());
		}
		
		System.out.println(tree.isEmpty());
		System.out.println(tree.size());
		
		// Now perform some operations on the tree
		// i.e. isEmpty(), size(), iterator(), contains(), remove(), 
		
		tree.contains(10);
		//System.out.println(tree.remove(15));
		//System.out.println(tree.remove(20));
		//System.out.println(tree.remove(28));
		System.out.println(tree.remove(50));
		
		System.out.println(tree.getLargest());
		System.out.println(tree.getSmallest());
		
		System.out.println("In Order");
		Iterator iter = tree.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println(tree.contains(80));
		System.out.println(tree.contains(85));
		System.out.println();
		
		// visualize the tree
		bridges.setDataStructure(tree.getRoot());
		
		bridges.visualize();
		
	}

}
