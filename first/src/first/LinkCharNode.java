package first;

class LinkCharNode {
    private char data = '\0';
    private LinkCharNode next = null;
    public void setData(char data) {
        this.data = data; 
     }
    public void setNext(LinkCharNode next) {
        this.next = next; 
    }
    public char getData() {
        return (this.data); 
    }
    public LinkCharNode getNext() {
        return (this.next); 
    }
}

