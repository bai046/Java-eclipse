package 线索化二叉树;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		HeroNode root = new HeroNode(1, "Tom");
		HeroNode node2 = new HeroNode(3, "Jack");
		HeroNode node3 = new HeroNode(6, "Smith");
		HeroNode node4 = new HeroNode(8, "Mary");
		HeroNode node5 = new HeroNode(10, "King");
		HeroNode node6 = new HeroNode(14, "dim");
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		ThreadedBinaryTree threadBinaryTree = new ThreadedBinaryTree();
		threadBinaryTree.setRoot(root);
		threadBinaryTree.ThreadedBinaryTree();
	
	//	System.out.print("前序遍历:");
	//	threadBinaryTree.preOrder();
		System.out.println("5号节点的前驱节点："+node5.getLeft());
		System.out.println("5号节点的后继节点："+node5.getRight());
		
		System.out.println("使用线索化的方式遍历：");
		threadBinaryTree.ThreadedList();
	}

}
//创建树

class ThreadedBinaryTree {
	private HeroNode root;
	// 为了实现线索化，需要创建一个当前节点的pre指针
	// 在递归时总是保留pre
	private HeroNode pre;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	public void ThreadedBinaryTree() {
		this.Threaded(root);
	}
	//遍历线索化后的二叉树
	public void ThreadedList() {
		HeroNode node = root;
		while(node!=null) {
			//循环找到leftType==1的节点
			while(node.getLeftType()==0) {
				node = node.getLeft();
			}
			System.out.println(node);
			//如果当前节点的右指针一直是后继节点就一直输出
			while(node.getRightType()==1) {
				node = node.getRight();
				System.out.println(node);
			}
			//替换遍历的节点
			node = node.getRight();
		}
	}
	// 线索化当前节点
	public void Threaded(HeroNode node) {
		if (node == null) {
			return;
		}
		// 左子树线索化
		Threaded(node.getLeft());
		// 该节点线索化
		// 如果node的左指针为空
		if (node.getLeft() == null) {
			// 将node的左指针指向前驱节点pre，此时pre为空
			node.setLeft(pre);
			// 将node的leftType置为1表示其左指针指向前驱节点
			node.setLeftType(1);
		}
		if (pre != null && pre.getRight() == null) {
			//此时的pre指代node的前一个数，通过pre来完成node前一个数的右指针索引
			pre.setRight(node);
			pre.setRightType(1);
		}
		//每处理一个节点后让当前节点指向下一个节点
		pre=node;
		// 右子树线索化
		Threaded(node.getRight());
	}

	// 前序遍历
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrderr();
		} else {
			System.out.println("二叉树为空");
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空");
		}
	}

	// 前序遍历查找
	public HeroNode preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}

	// 中序遍历查找
	public HeroNode infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}

	// 后序遍历查找
	public HeroNode postOrderSearch(int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		} else {
			return null;
		}
	}

	// 删除节点
	public void deleteNode(int no) {
		// 判断root是否为空
		if (root != null) {
			// 判断root是否为要删除的节点，因为之后就不会遍历到root了
			if (root.getNo() == no) {
				root = null;
			} else {
				root.deleteNode(no);
			}
		} else {
			System.out.println("该二叉树为空！！");
		}
	}

}

//创建节点
class HeroNode {
	private int no;
	private String name;
	private HeroNode left;
	private HeroNode right;
	// leftType==0,表示指向左子树，等于1代表指向前去节点
	// rightType == 0,表示指向右子树，等于1则代表指向后继节点
	private int leftType;
	private int rightType;

	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}

	// 前序遍历
	public void preOrder() {
		System.out.println(this);// 先输出父节点
		if (this.left != null) {
			this.left.preOrder();
		}
		if (this.right != null) {
			this.right.preOrder();
		}
	}

	// 中序遍历
	public void infixOrderr() {
		if (this.left != null) {
			this.left.infixOrderr();
		}
		System.out.println(this);// 输出父节点
		if (this.right != null) {
			this.right.infixOrderr();
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}

	// 前序遍历的查找
	@SuppressWarnings("unused")
	public HeroNode preOrderSearch(int no) {
		System.out.println("进入前序遍历——");
		if (this.no == no) {
			return this;
		}
		HeroNode resNode = null;
		// 判断该节点的左子节点是否为空，如果不为空，则向左进行递归查找
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		if (resNode != null) {// 说明左子树已经找到
			return resNode;
		}
		// 向右进行前序递归查找
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
		return resNode;
	}

	// 中序遍历查找
	@SuppressWarnings("null")
	public HeroNode infixOrderSearch(int no) {

		HeroNode resNode = null;
		if (this.left != null) {// 判断当前节点的左子节点是否为空，不为空，则向左递归
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入中序查找——");
		// 比较当前节点
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resNode.right.infixOrderr();
		}
		return resNode;
	}

	// 后序遍历查找
	public HeroNode postOrderSearch(int no) {

		HeroNode resNode = null;
		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		if (resNode != null) {// 向左递归找到
			return resNode;
		}
		// 向右子数递归进行有序遍历查找
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {// 向右递归找到
			return resNode;
		}
		// 如果左右子数都没右找到，则判断当前节点
		System.out.println("进入后序查找——");
		if (this.no == no) {
			return this;
		}
		return resNode;
	}

	// 递归删除指定节点
	// 思路
	/*
	 * 1. 因为我们的二叉树是单向的，所以我们是判断当前结点的子结点是否需要删除结点，而不能去判断当前这个结点是不是需要删除结点.
	 * 2.如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
	 * 3.如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
	 * 4.如果第2和第3步没有删除结点，那么我们就需要向左子树进行递归删除 5. 如果第4步也没有删除结点，则应当向右子树进行递归删除.
	 * 
	 */
	public void deleteNode(int no) {
		// 如果当前结点的左子结点不为空，并且左子结点 就是要删除结点，就将this.left = null; 并且就返回(结束递归删除)
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		// 如果当前结点的右子结点不为空，并且右子结点 就是要删除结点，就将this.right= null ;并且就返回(结束递归删除)
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		// 向左子树进行递归删除
		if (this.left != null) {
			this.left.deleteNode(no);
		}
		// 向右子树进行递归删除
		if (this.right != null) {
			this.right.deleteNode(no);
		}
	}
}
