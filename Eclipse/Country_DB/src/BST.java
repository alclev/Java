import java.util.ArrayList;

/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: April 22, 2021 
 * Last Date Modified: April 28, 2021
 *
 * @param <E> Class BST to model a BST
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

	public BST(ArrayList<E> data) {
		for (int i = 0; i < data.size(); i++)
			insert(data.get(i));
	}

	/**
	 * Size of the BST
	 * 
	 * @param no parameters
	 * @return int
	 * Time complexity: O(1)
	 */
	public int size() {
		return size;
	}

	/**
	 * Checks if empty
	 * 
	 * @param no parameters
	 * @return boolean
	 * Time complexity: O(1)
	 */
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Clears BST
	 * 
	 * @param no parameters
	 * @return no return value
	 * Time complexity: O(1)
	 */
	public void clear() {
		root = null;
		size = 0;
	}

	/**
	 * Searchs for element in BST
	 * 
	 * @param E item
	 * @return int
	 * Time complexity: O(n) or O(log n) depending on whether list is shuffled or not
	 */
	public boolean search(E item) {
		TreeNode current = root;
		while (current != null) {
			if (item.compareTo(current.value) < 0)
				current = current.left;
			else if (item.compareTo(current.value) > 0)
				current = current.right;
			else
				return true;
		}
		return false;
	}

	/**
	 * Inserts element in correct position in BST
	 * 
	 * @param E item
	 * @return int
	 * Time complexity: O(n) or O(log n) depending on whether list is shuffled or not
	 */
	public boolean insert(E item) {
		if (root == null) // first node to be inserted
			root = new TreeNode(item);
		else {
			TreeNode parent, current;
			parent = null;
			current = root;
			while (current != null) {// Looking for a leaf node
				parent = current;
				if (item.compareTo(current.value) < 0) {
					current = current.left;
				} else if (item.compareTo(current.value) > 0) {
					current = current.right;
				} else
					return false; // duplicates are not allowed
			}
			if (item.compareTo(parent.value) < 0)
				parent.left = new TreeNode(item);
			else
				parent.right = new TreeNode(item);
		}
		size++;
		return true;
	}

	/**
	 * Deletes an element in the BST
	 * 
	 * @param E item
	 * @return boolean
	 * Time complexity: O(n) or O(log n) depending on whether list is shuffled or not
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
 * gets the amount of leafNodes in a BST
 * @param no parameters 
 * @return int
 * Time complexity: O(n)
 */
	public int leafNodes() {
		return leafNodes(root);
	}
//helper recursive method for leafNodes()
	private int leafNodes(TreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1; //is a leafnode
		} else {
			return leafNodes(node.left) + leafNodes(node.right); //goes deeper looking for more
		}
	}
	/**
	 * gets the of a BST
	 * @param no parameters 
	 * @return int
	 * Time complexity: O(n)
	 */
	public int height() {
		return height(root);
	}
//recursive helper method for height()
	private int height(TreeNode node) {
		int left = 1;
		int right = 1;
		if (node == null) {
			return 0;
		} else {
			left = height(node.left); //recursive portion
			right = height(node.right);
		}
		int max = Math.max(left, right);//this is really identifying the max depth
		return max + 1;//the end summation should be + 1 so = height
		
	}
	/**
	 * Determines whether the BST is balanced
	 * @param no parameters 
	 * @return boolean
	 * Time complexity: O(n)
	 */
	public boolean isBalanced() {

		return isBalanced(root);
	}
//recursive helper method for isBalanced()
	private boolean isBalanced(TreeNode node) {

		if (Math.abs((height(node.left) + 1) - (height(node.right) + 1)) <= 1) {
			return isBalanced(node.left) && isBalanced(node.right); 
			//makes sure the difference of height does not exceed 1 for each not on opposite sides of the tree
		}
		return false; //not balanced
	}

	/**
	 * Recursive method inorder()
	 * 
	 * @param no parameters
	 * @return no return value
	 * Time complexity: O(n)
	 */
	public void inorder() {
		inorder(root);
	}

	/**
	 * Private recursive method inorder(TreeNode node)
	 * 
	 * @param node
	 * @return no return value
	 */
	private void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.println(node.value + " ");
			inorder(node.right);
		}
	}

	/**
	 * Recursive method preorder()
	 * 
	 * @param no parameters
	 * @return no return value
	 * Time complexity: O(n)
	 */
	public void preorder() {
		preorder(root);
	}

	/**
	 * Private recursive method preorder(TreeNode node)
	 * 
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
	 * 
	 * @param no parameters
	 * @return no return value
	 * Time complexity: O(n)
	 */
	public void postorder() {
		postorder(root);
	}

	/**
	 * Recursive method postorder(TreeNode node)
	 * 
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
