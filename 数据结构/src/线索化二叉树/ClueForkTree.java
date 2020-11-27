package 线索化二叉树;

class ClueNode {

	private Object data;
	private ClueNode left;
	private ClueNode right;
	private boolean leftIsThread;
	private boolean rightIsThread;
	
	public ClueNode(Object data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.leftIsThread = false;
		this.rightIsThread = false;
	}
	
	public ClueNode(Object data, ClueNode left, ClueNode right, boolean leftIsThread, boolean rightIsThread) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.leftIsThread = leftIsThread;
		this.rightIsThread = rightIsThread;
	}
	
	
	public Object getData() {
		return this.data;
	}
	public void setData(Object data ) {
		this.data = data;
	}
	public ClueNode getLeft() {
		return left;
	}
	

	public void setLeft(ClueNode left)
	{
		this.left = left;
	}

	public boolean isLeftIsThread()
	{
		return leftIsThread;
	}
 
	public void setLeftIsThread(boolean leftIsThread)
	{
		this.leftIsThread = leftIsThread;
	}
 
	public ClueNode getRight()
	{
		return right;
	}
 
	public void setRight(ClueNode right)
	{
		this.right = right;
	}
 
	public boolean isRightIsThread()
	{
		return rightIsThread;
	}
 
	public void setRightIsThread(boolean rightIsThread)
	{
		this.rightIsThread = rightIsThread;
	}

	public boolean equals(Object o) {
		if(o instanceof ClueNode) {
			ClueNode clue = (ClueNode)o;
			return (clue.getData() == this.data) ? true : false;
		}
		else return false;
	}
	
}
 
public class ClueForkTree {

	private ClueNode preNode;
	
	
	
	//根据数组构建完全二叉树
	public static ClueNode createClueForkTree(Object[] array, int index) {
		ClueNode node = null;
		if(index < array.length) {
			node = new ClueNode(array[index]);
			ClueNode left = createClueForkTree(array, index * 2 + 1);
			ClueNode right = createClueForkTree(array, index * 2 + 2);
			node.setLeft(left);
			node.setRight(right);
			return node;
		}
		else return null;
	}
	
	
	//中序线索化二叉树
	public void inThReading(ClueNode node) {
		if(node == null) return;
		
		inThReading(node.getLeft());
		
		if(node.getLeft() == null) {
			node.setLeft(preNode);
			node.setLeftIsThread(true);
		}
		
		if(preNode != null && preNode.getRight() == null) {
			preNode.setRight(node);
			preNode.setRightIsThread(true);
		}
		preNode = node;
		
		inThReading(node.getRight());
	}
	
	//中序按后继方式遍历线索二叉树
	public void inThreadList(ClueNode node) {
		while(node != null && !node.isLeftIsThread()) {
			node = node.getLeft();
		}
		
		while(node != null) {
			System.out.print(node.getData() + ",");
			
			if(node.isRightIsThread()) {
				node = node.getRight();
			}
			else {
				node = node.getRight();
				while(node != null && !node.isLeftIsThread()) {
					node = node.getLeft();
				}
			}
		}
	}
	
	//中序按前驱方式遍历线索二叉树
	public void inPreThreadList(ClueNode node) {
		while(node.getRight() != null && !node.isRightIsThread()) {
			node = node.getRight();
		}
		while(node != null) {
			System.out.print(node.getData() + ",");
			if(node.isLeftIsThread()) {
				node = node.getLeft();
			}
			else {
				node = node.getLeft();
				while(node.getRight() != null && !node.isRightIsThread()) {
					node = node.getRight();
				}
			}
		}
	}
	
	
	//前序线索化二叉树
	public void inThFrontReading(ClueNode node) {
		if(node == null) return;
		
		if(node.getLeft() == null) {
			node.setLeft(preNode);
			node.setLeftIsThread(true);
		}
		
		if(preNode != null && preNode.getRight() == null) {
			preNode.setRight(node);
			preNode.setRightIsThread(true);
		}
		
		preNode = node;
		if(!node.isLeftIsThread()) {
			inThFrontReading(node.getLeft());
		}
		
		if(!node.isRightIsThread()) {
			inThFrontReading(node.getRight());
		}
		
	}
	
	
	//前序按后继方式进行遍历二叉树
	public void preThreadList(ClueNode node) {
		while(node != null) {
			while(!node.isLeftIsThread()) {
				System.out.print(node.getData() + ",");
				node = node.getLeft();
			}
			System.out.print(node.getData() + ",");
			node = node.getRight();
					
		}
	}
	
	public static void main(String[] args) {
		//String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
		String[] array = {"A", "B", "C", "D", "E", "F", "G"};
		ClueNode root = createClueForkTree(array, 0);
		ClueForkTree tree = new ClueForkTree();
		tree.inThReading(root);
		System.out.println("中序按后继节点遍历线索二叉树结果：");
	    tree.inThreadList(root);
	    
	    System.out.println("\n中序按前驱节点遍历线索二叉树结果：");
        tree.inPreThreadList(root);
        
        ClueNode root1 = createClueForkTree(array, 0);
        tree.inThFrontReading(root1);
        tree.preNode = null;
        System.out.println("\n前序按后继节点遍历线索二叉树结果：");
        tree.preThreadList(root1);

	}
}

 