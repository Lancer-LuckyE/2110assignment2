/***
 * This is class implements a compressed trie that holds a set of strings.
 * MyCompressedTrie stores nodes using class TreeNodeWithData
 * 
 * Name: Haoyangliu Number: 8313693 Uottawa Email: hliu107@uottawa.ca
 * 
 *
 */
public class MyTrie {

	private TreeNode root = null;

	private int numNodes;

	// Constructor. Note that an empty trie (no strings added) contains the root
	// node
	public MyTrie() {
		root = new TreeNode(null, null, null, false);
		numNodes = 1;
	}

	// Method to be implemented by you. See handout part 1A
	public boolean insert(String s) {
		TreeNode curr = root;
		try {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					if (curr.getLeftChild() == null) {
						TreeNode left = new TreeNode(curr, null, null, false);
						curr.setLeftChild(left);
						curr = left;
						numNodes++;
					} else {
						curr = curr.getLeftChild();
					}
				} else{
					if (curr.getRightChild() == null) {
						TreeNode right = new TreeNode(curr, null, null, false);
						curr.setRightChild(right);
						curr = right;
						numNodes++;
					} else {
						curr = curr.getRightChild();
					}
				}
			}
			if (curr.getIsUsed() == true) {
				return false;
			}else{
				curr.setIsUsed(true);
			}			
		} catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}
	// ***** method code to be added in this class *****
	// now we just have a dummy that prints message and returns true.

	// Method to be implemented by you. See handout part 1A
	public boolean search(String s) {
		// **** method code to be added in this class *****
		// now we just have a dummy that prints message and returns true.
		TreeNode curr = root;
		try {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					if (curr.getLeftChild() == null) {
						return false;
					} else {
						curr = curr.getLeftChild();
					}
				} else{
					if (curr.getRightChild() == null) {
						return false;
					} else {
						curr = curr.getRightChild();
					}
				}
			}
			if (curr.getIsUsed() == false) {
				return false;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return true;
	}

	// Method to be implemented by you. See handout part 1A
	public void printStringsInLexicoOrder() {
		String print = new String("");
		printStringsInLexicoOrder_recursive(root, print);
	}
	
	private void printStringsInLexicoOrder_recursive(TreeNode curr, String print) {
		if (curr == null) {
			return;
		}
		if (curr.getIsUsed() == true) {
			System.out.print(print + ",");
		}
		printStringsInLexicoOrder_recursive(curr.getLeftChild(), print + "0");
		printStringsInLexicoOrder_recursive(curr.getRightChild(), print + "1");
	}

	// the following method that calls its recursive counterpart
	// prints the tree and its boolean values at nodes in
	// in-order traversal order

	public void printInOrder() { // not to be changed
		printInOrder(root);
	}

	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N != null) {
			printInOrder(N.getLeftChild());
			System.out.print(N.getIsUsed());
			printInOrder(N.getRightChild());

		}
		System.out.print(")");
	}

	public TreeNode root() { // not to be changed
		return root;
	}

	public int numNodes() { // not to be changed
		return numNodes;
	}

}
