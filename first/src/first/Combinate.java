package first;

public class Combinate {
    public Combinate() {
    }
    public static void main(String[] args){
        LinkCharTable linkTable = new LinkCharTable();
        linkTable.insert('Y');
        linkTable.insert('D');
        linkTable.insert('U');
        linkTable.insert('T');
        linkTable.insert('S');
        linkTable.print();
        reverse(linkTable);
        linkTable.print();
    }
 
public static void reverse(LinkCharTable lct){
        LinkCharNode n = lct.getHead().getNext();
        while(n != null)
        {
            char ch = n.getData();
            lct.delete(ch);
            lct.insert(ch);
            n = n.getNext();
        }
    }
}

