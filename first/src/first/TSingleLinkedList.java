package first;

public class TSingleLinkedList<T> {
	LinkNode<T> head; // 头结点，链表的首地址

	public TSingleLinkedList() {// 链表初始化
		super();
		head = new LinkNode<T>(null);// 头结点不保存数据
	}

	// 给定结点，头插法插入结点
	public void insertAtHead(LinkNode<T> node) {
		node.next = head.next;
		head.next = node;
	}

	// 给数据，先构造成结点，头插法插入结点
	public void insertAtHead(T data) {
		LinkNode<T> node = new LinkNode<T>(data);
		insertAtHead(node);
	}

	// 给定结点，尾插法插入结点
	public void insertAtEnd(LinkNode<T> node) {
		LinkNode<T> p = head;
		while (p.next != null) {
			p = p.next;
		}
		p.next = node;
	}

	// 给定结点，尾插法插入结点
	public void insertAtEnd(T data) {
		LinkNode<T> node = new LinkNode<T>(data);
		insertAtEnd(node);
	}

	public void showDatas() {
		LinkNode<T> p = head;
		while (p.next != null) {
			System.out.println(p.next.data);
			p = p.next;
		}
	}
	
//	5. 求链表的长度
	public int Size(){
		LinkNode<T> p = head;
		int len=0;
		while(p.next !=null){
			len++;
			p=p.next;
		}
		return len;
	}
//
//	6. 指定i之前插入数据结点
	public void insert(int i,LinkNode<T> node){
		if(i<0){
			System.out.printf("插入位置%d无效\n",i);
		}
		LinkNode<T> p = head;
		int index=-1;
		while(p.next !=null){
			index++;
			if(index==i){
				node.next=p.next;
				p.next =node;
				return;
			}
			p=p.next;
		}
		System.out.printf("插入位置%d无效，最后结点位置为%d\n",i,index);
		
	}
	//给定数据，构造成结点，再插入指定位置
	public void insert(int i,T s){
		LinkNode<T> LinkNode = new LinkNode<T>(s);
		insert(i,LinkNode);
	}
	
//	7. 删除指定结点,按位置删除 
	public void delete(int i){
		if(i<0){
			System.out.printf("删除位置%d无效\n",i);
			return;
		}
		LinkNode<T> p=head;
		int index=-1;
		while(p.next!=null){
			index++;
			if(index==i){
				p.next=p.next.next;
				return;
			}
			p=p.next;
		}
		System.out.printf("删除位置%d无效，最后结点位置为%d\n",i,index);
	}
	//指定数据删除结点
	public void delete(T data){
		LinkNode<T> p=head;
		while(p.next!=null){
			if(p.next.data.equals(data)){
				p.next=p.next.next;
				return;
			}
			p=p.next;
		}
	}
	
	
	
//	8. 读取第i个位置的节点
	public LinkNode<T> get (int i){
		if(i<0){ //判断i不能小于0
			System.out.printf("读取位置%d无效\n",i);
			return null;
		}
		
		LinkNode<T> p=head;  //从头
		int index=-1;		//计数
		while(p.next!=null){
			index++;
			if(index==i){		//p.next结点的位置是否为要读取的结点
				return p.next;
			}
			p=p.next;
		}
		return null;
	}
}

// 链表 中的每个结点类型，包含 data,next
class LinkNode<T> {
	T data;
	LinkNode<T>  next; // 默认为空

	public LinkNode(T data) {
		super();
		this.data = data;
	}
}



