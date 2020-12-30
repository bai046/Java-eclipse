package 实训作业;

public class ArrayBinaryTreeDemo {
	public static void main(String[] args) {
		Character[] cs ={'a','b','c','d','e','f','g','h','i','j','k'};
		ArrayBinaryTree<Character> bt  =new ArrayBinaryTree<>(cs);
		System.out.println("前序遍历~~");
		bt.preOrder(0);//a bdhiejk cfg
		System.out.println("中序遍历~~");
		bt.infixOrder(0);//hdibjek a fcg 
		System.out.println("后序遍历~~");
		bt.postOrder(0);//hid jke b  fgc a
	}
	

}
