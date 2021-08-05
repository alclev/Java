
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 22, 2021 
 * Last Date Modified: April 25, 2021
 *
 * @param <E>
 * Class BST to model a BST
 */
public class BST<E extends Comparable<E>> {
//private data members
	private TreeNode root;
	private int size;
//private class for the node
	private class TreeNode {
		E value;
		TreeNode left;
		TreeNode right;

		TreeNode(E val) {
			value = val;
			left = right = null;
		}
	}
//constructors
	public BST() {
		root = null;
		size = 0;
	}

	public BST(E[] dataArray) {
		for (int i = 0; i < dataArray.length; i++)
			insert(dataArray[i]);
	}

/**
 * Size of the BST
 * @param no parameters 
 * @return int 
 */
	public int size() {
		return size;
	}
	/**
	 * Checks if empty 
	 * @param no parameters
	 * @return boolean
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	/**
	 * Clears BST
	 * @param no parameters 
	 * @return no return value
	 */
	public void clear() {
		root = null;
	}
	/**
	 * Searchs for element in BST
	 * @param E item
	 * @return int 
	 */
	public int search(E item) { //modified to count iterations
		int iterations = 0;
		TreeNode current = root;
		while (current != null) {
			iterations++;
			if (item.compareTo(current.value) < 0)
				current = current.left;
			else if (item.compareTo(current.value) > 0)
				current = current.right;
			else
				return iterations;
		}
		return iterations;
	}
	/**
	 * Inserts element in correct position in BST
	 * @param E item
	 * @return int 
	 */
	public int insert(E item) { //modified to count iterations
		int iterations = 0;
		if (root == null) // first node to be inserted
			root = new TreeNode(item);
		else {
			TreeNode parent, current;
			parent = null;
			current = root;
			while (current != null) {// Looking for a leaf node
				iterations++;
				parent = current;
				if (item.compareTo(current.value) < 0) {
					current = current.left;
				} else if (item.compareTo(current.value) > 0) {
					current = current.right;
				} else
					return iterations; // duplicates are not allowed
			}
			if (item.compareTo(parent.value) < 0)
				parent.left = new TreeNode(item);
			else
				parent.right = new TreeNode(item);
		}
		size++;
		return iterations;
	}
	/**
	 * Deletes an element in the BST
	 * @param E item
	 * @return boolean
	 */
	public boolean delete(E item) {
		TreeNode parent, current;
		parent = null;
		current = root;
		// Find item first
		while (current != null) {
			if (item.compareTo(current.value) < 0) {
				parent = current;
				current = current.left;
			} else if (item.compareTo(current.value) > 0) {
				parent = current;
				current = current.right;
			} else
				break; // item found
		}
		if (current == null) // item not in the tree
			return false;
		// Case 1: node found and has no left child
		if (current.left == null) { // No left child
			if (parent == null) // delete root
				root = current.right;
			else {// modify link from parent to current’s child
				if (item.compareTo(parent.value) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		} else { // Case 2: current has a left child
			TreeNode rightMostParent = current;
			TreeNode rightMost = current.left;
			// going right on left subtree
			while (rightMost.right != null) {
				rightMostParent = rightMost;
				rightMost = rightMost.right;
			}
			current.value = rightMost.value;
			// delete rigthMost node
			if (rightMostParent.right == rightMost)
				rightMostParent.right = rightMost.left;
			else
				rightMostParent.left = rightMost.left;
		}
		size--;
		return true;
	}


	/**
	 * Recursive method inorder()
	 * @param no parameters
	 * @return no return value
	 */
	public void inorder() {
		inorder(root);
	}
/**
 * Private recursive method inorder(TreeNode node)
 * @param node
 * @return no return value
 */
	private void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}

	
	/**
	 * Recursive method preorder()
	 * @param no parameters
	 * @return no return value
	 */
	public void preorder() {
		preorder(root);
	}
	/**
	 * Private recursive method preorder(TreeNode node)
	 * @param node
	 * @return no return value
	 */
	private void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	/**
	 * Recursive method postorder()
	 * @param no parameters
	 * @return no return value
	 */
	public void postorder() {
		postorder(root);
	}
	/**
	 * Recursive method postorder(TreeNode node)
	 * @param node
	 * @return no return value
	 */
	private void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.value + " ");
		}
	}
	
}