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
