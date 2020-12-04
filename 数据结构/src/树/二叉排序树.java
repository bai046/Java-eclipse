package Ê÷;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
class Node<T> implements Comparable<Node<T>> {
	private T data;
	private double weight;
	private Node<T> left;
	private Node<T> right;
	
	public Node(T data, double weight){
		this.data = data;
		this.weight = weight;
	}
	
	public T getData() {
		return data;
	}
 
	public void setData(T data) {
		this.data = data;
	}
 
	public double getWeight() {
		return weight;
	}
 
	public void setWeight(double weight) {
		this.weight = weight;
	}
 
	public Node<T> getLeft() {
		return left;
	}
 
	public void setLeft(Node<T> left) {
		this.left = left;
	}
 
	public Node<T> getRight() {
		return right;
	}
 
	public void setRight(Node<T> right) {
		this.right = right;
	}
 
	@Override
	public String toString(){
		return "data:"+this.data+";weight:"+this.weight;
	}
 
	@Override
	public int compareTo(Node<T> other) {
		if(other.getWeight() > this.getWeight()){
			return 1;
		}
		if(other.getWeight() < this.getWeight()){
			return -1;
		}
		
		return 0;
	}
}

 
 class HuffmanTree<T> {
	public static <T> Node<T> createTree(List<Node<T>> nodes){
		while(nodes.size() > 1){
			Collections.sort(nodes);
			Node<T> left = nodes.get(nodes.size()-1);
			Node<T> right = nodes.get(nodes.size()-2);
			Node<T> parent = new Node<T>(null, left.getWeight()+right.getWeight());
			parent.setLeft(left);
			parent.setRight(right);
			nodes.remove(left);
			nodes.remove(right);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	public static <T> List<Node<T>> breadth(Node<T> root){
		List<Node<T>> list = new ArrayList<Node<T>>();
		Queue<Node<T>> queue = new ArrayDeque<Node<T>>();
		
		if(root != null){
			queue.offer(root);
		}
		
		while(!queue.isEmpty()){
			list.add(queue.peek());
			Node<T> node = queue.poll();
			
			if(node.getLeft() != null){
				queue.offer(node.getLeft());
			}
			
			if(node.getRight() != null){
				queue.offer(node.getRight());
			}
		}
		return list;
	}
} 
public class ¶þ²æÅÅÐòÊ÷ {//HuffmanTree
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Node<String>> list = new ArrayList<Node<String>>();
		list.add(new Node<String>("a",7));
		list.add(new Node<String>("b",5));
		list.add(new Node<String>("c",4));
		list.add(new Node<String>("d",2));
		
		Node<String> root = HuffmanTree.createTree(list);
		System.out.println(HuffmanTree.breadth(root));
		//System.out.println(HuffmanTree.createTree(root));
	//	System.out.println(list);
	}
}


