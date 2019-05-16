package AlgorithmDemo;

import java.util.Stack;

public class PrintLinkReverse_5 {
    public static void main(String args[]){

        Stack stack = new Stack<LinkNode>();
        LinkNode node = new LinkNode();
        node.setValue(1);
        node.setNext(new LinkNode(4,new LinkNode(3,null)));
        stack.push(node);
        while(node.getNext() != null){
            stack.push(node.getNext());
            node = node.getNext();
        }
        while(!stack.empty()){
            LinkNode tmp = (LinkNode) stack.pop();
            System.out.println(tmp.getValue());

        }

    }

}
class LinkNode{
    private Integer value ;
    private LinkNode next;

    public LinkNode() {
    }

    public LinkNode(int value, LinkNode next) {
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }
}
