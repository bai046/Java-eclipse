package LinkedList;
//½ÚµãÀà
public class StuNode {
	 Student data;
	 StuNode next;

	public StuNode(Student data) {
		super();
		this.data = data;
	}


	public Student getData() {
		return data;
	}
	public void setData(Student data) {
		this.data = data;
	}
	public StuNode getNext() {
		return next;
	}
	public void setNext(StuNode next) {
		this.next = next;
	}
	
}
