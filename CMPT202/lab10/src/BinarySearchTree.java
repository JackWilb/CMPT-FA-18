/**
 * Binary search tree implementation.
 * 
 * We do not allow duplicates.
 * 
 * @author Greg Gagne
 */
import java.util.Iterator;

import bridges.base.BSTElement;
import bridges.base.BinTreeElement;

public class BinarySearchTree <K extends Comparable<? super K>> implements SearchTreeInterface<K> 
{
	// the root of the binary search tree
	private BSTElement<K, String> root;

	/**
	 * Create an empty binary search tree
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * This method has nothing to do with a binary search tree,
	 * but is necessary to provide the bridges visualization.
	 */
	public BSTElement<K, String> getRoot() {
		return root;
	}

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Solution that uses recursive helper method.
	 * We disallow duplicate elements in the tree. 
	 */
	public K add(K key) {
		if (contains(key))
			return null;
		else {
			root = add(key, root);

			return key;
		}
	}


	/**
	 * private helper method for adding a node to the binary search tree
	 * @param key
	 * @param subtree
	 * @return the root of the tree
	 */
	private BSTElement<K, String> add(K key, BSTElement<K,String> subtree) {
		if (subtree == null) {
			// we have found the spot for the addition

			// create the new node
			// parameters are (1) label (2) key (3) empty string [not used]
			BSTElement<K, String> newNode = new BSTElement<K, String>(key.toString(), key, "");

			// we also set the color of a new node to red
			newNode.getVisualizer().setColor("blue");

			return newNode;
		}

		int direction = key.compareTo(subtree.getKey());

		if (direction < 0) {
			subtree.setLeft( add(key, subtree.getLeft()) );
		}
		else if (direction > 0) {
			subtree.setRight( add(key, subtree.getRight()) );
		}

		return subtree;
	}


	/**
	 * Non-recursive algorithm for addition
	 * This only serves the purpose of demonstrating the
	 * differences between the recursive and non-recursive approaches.
	 */
	/*
	public K add(K key) {
		// we disallow duplicates
		if (contains(key))
			return null;

		// create the new node
		// parameters are (1) label (2) key (3) null [not used]
		BSTElement<K, String> newNode = new BSTElement<K, String>(key.toString(), key, "");
		newNode.getVisualizer().setColor("red");

		// if the tree is empty, set the root to the new node
		if (isEmpty()) {
			root = newNode;
		}
		else {
			// else treat it like an unsuccessful search
			BSTElement<K, String> node = root;
			boolean keepLooking = true;

			while (keepLooking) {
				int direction = key.compareTo(node.getKey());

				if (direction < 0) {
					// go left
					if (node.getLeft() == null) {
						// we found the place for the insert
						node.setLeft(newNode);
						keepLooking = false;
					}
					else
						node = node.getLeft();
				}
				else if (direction > 0) {
					// go right
					if (node.getRight() == null) {
						// we found the place for the insert
						node.setRight(newNode);
						keepLooking = false;
					}
					else
						node = node.getRight();
				}
			}
		}

		return key;
	}
	 */

	public K getLargest() {
		if (root == null)
			return null;
		else
			return getLargestHelper(root);
	}

	/**
	 * Helper method to get the value and highlight the
	 * node to green.
	 * @param node
	 * @return
	 */
	private K getLargestHelper(BSTElement<K, String> node) {
		if (node.getRight() != null) {
			return getLargestHelper(node.getRight());
		} else {
			node.getVisualizer().setColor("red");
			return node.getKey();
		}
	}

	public K getSmallest() {
		if (root == null)
			return null;
		else
			return getSmallestHelper(root);
	}

	/**
	 * Helper method to get the value and highlight the
	 * node to green.
	 * @param node
	 * @return
	 */
	private K getSmallestHelper(BSTElement<K, String> node) {
		if (node.getLeft() != null) {
			return getSmallestHelper(node.getLeft());
		} else {
			node.getVisualizer().setColor("yellow");
			return node.getKey();
		}
	}

	public boolean contains(K key) {		
		return containsHelper(key, root);
	}
	
	private boolean containsHelper(K key, BSTElement<K, String> subtree) {
		if (subtree == null) {
			return false;
		} else if (key == null) {
			return false;
		} else if (key == subtree.getKey()){
			subtree.getVisualizer().setColor("pink");
			return true;
		} else if (key.compareTo(subtree.getKey()) < 0) {
			return containsHelper(key, subtree.getLeft());
		} else {
			return containsHelper(key, subtree.getRight());
		}
		
	}

	public K remove(K key) {
		if (!contains(key)) {
			return null;
		} else {
			root = removeHelper(key, root);
			return key;
		}
	}
	
	private BSTElement<K, String> removeHelper(K key, BSTElement<K, String> root) {
		if (root == null) {
			return root;
		} else {
			if (key.compareTo(root.getKey()) < 0) {
				BSTElement<K, String> left = removeHelper(key, root.getLeft());
				return left;
			} else if (key.compareTo(root.getKey()) > 0) {
				BSTElement<K, String> right = removeHelper(key, root.getRight());
				return right;
			} else if (root.getLeft() != null && root.getRight() != null) {
				return root;
				
			} else {
				if (root.getLeft() != null) {
					BSTElement<K, String> left = root.getLeft();
					return left;
				} else {
					BSTElement<K, String> right = root.getRight();
					return right;
				}
			}
 		}
		
	}

	public int size() {
		if (root == null) {
			return 0;
		} else
			return getSizeHelper(root);
	}
	
	
	private int getSizeHelper(BSTElement<K, String> node) {
		    if (node == null)
		        return 0;
		    else {
		        int Size = getSizeHelper(node.getLeft()) + getSizeHelper(node.getRight());

		        return Size + 1;
		    }
	}

	public Iterator<K> iterator() {
		return new InOrderIterator();
	}
	
	private class InOrderIterator implements Iterator<K>
	{
		private K[] elements;
		private int next;

		private InOrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (K[])new Comparable[size()];
			next = 0;

			// now perform an inorder traversal
			inOrder(root);

			// reset next back to the beginning of the array
			next = 0;
		}

		private void inOrder(BSTElement<K, String> root) {
			if (root != null) {
				inOrder(root.getLeft());
				elements[next++] = root.getKey();
				inOrder(root.getRight());
			}
		}

		public boolean hasNext() {
			return (next < size());
		}

		public K next() {
			return elements[next++];
		}
	}
}
