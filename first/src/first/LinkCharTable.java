package first;

public class LinkCharTable {
    private LinkCharNode head = null;
    private int counts = 0;
    public LinkCharNode getHead(){
        return head;
    }
    public void insert(char d){
        if(head == null){
            head = new LinkCharNode();
        }  
        LinkCharNode n = new LinkCharNode();//定义新的链表结点，并将数据赋给新结点
        n.setData(d);
        if(head.getNext() == null){		//如果头结点的后继无结点，注意头结点中无数据
            head.setNext(n);
        }
        else{
            n.setNext(head.getNext());  	//如果头结点的后继结点存在
            head.setNext(n);
        }
        counts ++;                  	//结点总数增加
    } public void delete(char d){
        if(head == null){
            System.out.println("链表中无数据!");
            return;
        }
        LinkCharNode p = head;
        LinkCharNode n = head.getNext();
        while(n != null){
            if(n.getData() == d){
                p.setNext(n.getNext());
            }
            p = n;
            n = n.getNext();
        }
    }
    
    public void print(){
        LinkCharNode n = head.getNext();
        int iCounter = 1;              //输出的字符个数
        while(n != null){
            System.out.print(n.getData() + " ");
            n = n.getNext();
            iCounter ++;
        }
        System.out.println();
    }
    public int size(){
        return this.counts;
    }
}
