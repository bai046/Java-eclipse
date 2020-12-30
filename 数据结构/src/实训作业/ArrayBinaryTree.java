package 实训作业;

//简便树，不需要左右孩子，偷懒写法
public class ArrayBinaryTree<T>{
	T[] datas;

	public ArrayBinaryTree(T[] datas) {
		super();
		this.datas = datas;
	}
	
	//前序遍历  根左右 index为当前树的根编号
	public void preOrder(int index){
		if(datas==null || datas.length==0){
			System.out.println("空树，无需遍历~~");
		}
		System.out.println(datas[index]);		//输出根
		if(2*index+1<datas.length){
			preOrder(2*index+1);					//遍历左子树
		}
		if(2*index+2<datas.length){
			preOrder(2*index+2);					//遍历右子树
		}
	}
	
	//中序遍历 左根右
	public void infixOrder(int index){
		if(datas==null || datas.length==0){
			System.out.println("空树，无需遍历~~");
		}
		if(2*index+1<datas.length){
			infixOrder(2*index+1);					//遍历左子树
		}
		System.out.println(datas[index]);		//输出根
		if(2*index+2<datas.length){
			infixOrder(2*index+2);					//遍历右子树
		}
	}
	
	//后序遍历 左右根
	public void postOrder(int index){
		if(datas==null || datas.length==0){
			System.out.println("空树，无需遍历~~");
		}
		if(2*index+1<datas.length){
			postOrder(2*index+1);					//遍历左子树
		}
		if(2*index+2<datas.length){
			postOrder(2*index+2);					//遍历右子树
		}
		System.out.println(datas[index]);		//输出根
	}
	

}
