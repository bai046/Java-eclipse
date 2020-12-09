package LinkedList;
//头
public class StuLinkList {
private StuNode head;
public StuLinkList(StuNode head) {
	super();
	this.head = head;
}

public void addAtHead(StuNode node) {//头插法
	node.next=head.next;
	head.next=node;	
}


public void addAtEnd(StuNode node) {//尾插法
	StuNode p=head;
	while(p.next!=null) {
		p=p.next;//指针后移一
	}
	node.next=null;p.next=node;
}

public void insertAfter(StuNode p,StuNode s) {//后插入
	s.setNext(p.getNext());
	p.setNext(s);
}

public void insertbefor(StuNode p,StuNode s) {//前插入
	if(head==null)return;
	StuNode q=head;
	while(q.getNext()!=null) {
		if(q.getNext()==p) {
			q.setNext(s);
			s.setNext(p);
			break;
		}
		q=q.getNext();
	}
	
}

public void delete(StuNode p) {//单链表删除操作
	if(head==null)return;
	StuNode s1=head;
	while(s1.getNext()!=null) {
		if(s1.getNext()==p) {
			s1.setNext(p.getNext());
			break;
		}
		s1=s1.getNext();
	}
}

public void showDatas() {
	StuNode p=head.next;
	if(p==null) {
		System.out.println(head.data);
	}
	while(p!=null) {
		System.out.println(p.data);
		p=p.next;//指针下移
	}
}



}
