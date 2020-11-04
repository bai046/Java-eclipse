package 树;

import java.util.*;

//节点数据结构
class TreeNode {

	String value = null;
	TreeNode leftchildren = null;
	TreeNode middlechildren = null;
	TreeNode rightchildre = null;

	public TreeNode(String value, TreeNode leftchildren, TreeNode middlechildren, TreeNode rightchildre) {
		this.value = value;
		this.leftchildren = leftchildren;
		this.middlechildren = middlechildren;
		this.rightchildre = rightchildre;
	}

	public TreeNode(String value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setLeftchildren(TreeNode leftchildren) {
		this.leftchildren = leftchildren;
	}

	public void setMiddlechildren(TreeNode middlechildren) {
		this.middlechildren = middlechildren;
	}

	public void setRightchildre(TreeNode rightchildre) {
		this.rightchildre = rightchildre;
	}

	public String getValue() {
		return value;
	}

	public TreeNode getLeftchildren() {
		return leftchildren;
	}

	public TreeNode getMiddlechildren() {
		return middlechildren;
	}

	public TreeNode getRightchildre() {
		return rightchildre;
	}
}

public class TreeSearch {

	// 创建一个二叉树
	public TreeNode getTargetTree() {
		// 叶子节点
		TreeNode E = new TreeNode("E");
		TreeNode F = new TreeNode("F");
		TreeNode B = new TreeNode("B", E, F, null);
		TreeNode C = new TreeNode("C", null, null, null);
		TreeNode I = new TreeNode("I");
		TreeNode J = new TreeNode("J");
		TreeNode K = new TreeNode("K");
		TreeNode H = new TreeNode("H", I, J, K);
		TreeNode G = new TreeNode("G", H, null, null);
		TreeNode D = new TreeNode("D", G, null, null);
		// 构造根节点
		TreeNode root = new TreeNode("A", B, C, D);
		return root;
	}

	/**
	 * 前序遍历
	 */
	public void preorderVistTreeNode(TreeNode node) {
		if (null != node) {

			System.out.print(node.value);

			if (null != node.leftchildren) {
				preorderVistTreeNode(node.leftchildren);
			}
			if (null != node.middlechildren) {
				preorderVistTreeNode(node.middlechildren);
			}
			if (null != node.rightchildre) {
				preorderVistTreeNode(node.rightchildre);
			}
		}
	}

	/**
	 * 后序遍历
	 */
	public void postorderVistTreeNode(TreeNode node) {
		if (null != node) {
			if (null != node.leftchildren) {
				postorderVistTreeNode(node.leftchildren);
			}
			if (null != node.middlechildren) {
				preorderVistTreeNode(node.middlechildren);
			}
			if (null != node.rightchildre) {
				postorderVistTreeNode(node.rightchildre);
			}

			System.out.print(node.value);

		}
	}

	/**
	 * 层次遍历
	 */
	public void levelorderVistTreeNode(TreeNode node) {
		if (null != node) {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			list.add(node);
			TreeNode currentNode;

			while (!list.isEmpty()) {
				currentNode = list.poll(); // 获取并移除此列表的头

				System.out.print(currentNode.value);

				if (null != currentNode.leftchildren) {
					list.add(currentNode.leftchildren);
				}

				if (null != currentNode.middlechildren) {
					list.add(currentNode.middlechildren);
				}

				if (null != currentNode.rightchildre) {
					list.add(currentNode.rightchildre);
				}
			}
		}
	}

	public static void main(String[] args) {

		TreeSearch treeSearch = new TreeSearch();
		TreeNode tree = treeSearch.getTargetTree();

		System.out.print("前序遍历:");
		treeSearch.preorderVistTreeNode(tree);
		System.out.println("");

		System.out.print("后序遍历:");
		treeSearch.postorderVistTreeNode(tree);
		System.out.println("");

		System.out.print("层次遍历:");
		treeSearch.levelorderVistTreeNode(tree);
		System.out.println("");
	}
}
