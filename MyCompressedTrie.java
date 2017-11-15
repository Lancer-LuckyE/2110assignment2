
/***
 * This is class implements a compressed trie that holds a set of strings.
 * MyCompressedTrie stores nodes using class TreeNodeWithData
 * 
 * Name: Haoyangliu Number: 8313693 Uottawa Email: hliu107@uottawa.ca
 * 
 *
 */
public class MyCompressedTrie {

	private TreeNodeWithData root;

	private int numNodes;

	public MyCompressedTrie() { // simple constructor (empty trie consisting of
								// root only)
		root = new TreeNodeWithData(null, null, null, false, null);
		numNodes = 1;
	}

	// to be implemented by you see handout Part 2A
	// Constructor that receives a regular trie and ceates this
	// instance that is a compressed trie
	//
	public MyCompressedTrie(MyTrie trie) {
		this();
		String save = new String("");
		iterator(trie.root(), root, save);

	}

	private void iterator(TreeNode current, TreeNodeWithData D_current, String s) {
		if (current == null) {			
			return;
		}
		//save instance memory		
		TreeNode left = current.getLeftChild();
		TreeNode right = current.getRightChild();
		TreeNodeWithData D_left, D_right;
		//check left tree
		if(left != null){
			if (left.getIsUsed() || left.getLeftChild() != null && left.getRightChild() != null) {
				TreeNodeWithData New_Node = new TreeNodeWithData(D_current, null, null, left.getIsUsed(), s + "0");
				numNodes++;
				D_current.setLeftChild(New_Node);
				D_left = (TreeNodeWithData)D_current.getLeftChild();
				iterator(left, D_left, s + "0");
			}else {
				iterator(left, D_current, s + "0");
			}
		}else {
			iterator(left, D_current, s + "0");
		}
		//check right tree
		if(right != null){
			if (right.getIsUsed() || right.getLeftChild() != null && right.getRightChild() != null) {
				TreeNodeWithData New_Node = new TreeNodeWithData(D_current, null, null, right.getIsUsed(), s + "1");
				numNodes++;
				D_current.setRightChild(New_Node);
				D_right = (TreeNodeWithData)D_current.getRightChild();
				iterator(right, D_right, s + "1");
			}else {
				iterator(right, D_current, s + "1");
			}
		}else {
			iterator(right, D_current, s + "1");
		}
	}
		
	// Method to be implemented by you. See handout part 2A public void
	public void printStringsInLexicoOrder() {
		printStringsInLexicoOrder_recursive(root);
	}

	private void printStringsInLexicoOrder_recursive(TreeNodeWithData curr) {
		if (curr == null) {
			return;
		}
		if (curr.getIsUsed() == true) {
			System.out.print(curr.getData() + ",");
		}
		printStringsInLexicoOrder_recursive((TreeNodeWithData) curr.getLeftChild());
		printStringsInLexicoOrder_recursive((TreeNodeWithData) curr.getRightChild());
	}

	// the following method that calls its recursive counterpart
	// prints the tree and its data values at nodes in
	// in-order traversal order

	public void printInOrder() { // not to be changed
		printInOrder(root);
	}

	private void printInOrder(TreeNode N) { // not to be changed
		System.out.print("(");
		if (N != null) {
			printInOrder(N.getLeftChild());
			System.out.print(((TreeNodeWithData) N).getData());
			printInOrder(N.getRightChild());

		}
		System.out.print(")");
	}

	public int numNodes() {
		return numNodes;
	}

}
