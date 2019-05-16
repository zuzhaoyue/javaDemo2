package AlgorithmDemo;

public class DeleteDupNode_57 {
    public static void main(String args[]){
        LinkNode  linkNode = new LinkNode(1,new LinkNode(2,new LinkNode(2,new LinkNode(3,new LinkNode(3,new LinkNode(5,null))))));
        LinkNode temp = linkNode;
        while(temp != null){
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
        delDul(linkNode);
        while(linkNode != null){
            System.out.println(linkNode.getValue());
            linkNode = linkNode.getNext();
        }

    }
    public static LinkNode delDul(LinkNode linkNode) {
        LinkNode pre = null;
        LinkNode current = linkNode;

        if(linkNode == null || linkNode.getNext() == null)
            return linkNode;
        while(current != null){
            LinkNode next = current.getNext();
            boolean needDelete = false;
            if(next != null && current.getValue() == next.getValue()){
                needDelete = true;
            }
            if(!needDelete){
                pre = current;
                current = current.getNext();
            }else{
                LinkNode toBeDelete = current;
                int temp = toBeDelete.getValue();
                while(toBeDelete != null && toBeDelete.getValue() == temp){
                    toBeDelete = toBeDelete.getNext();
                    next = toBeDelete.getNext();
                }
                current = next;
                if(pre == null){
                    return pre;
                }else {
                    pre.setNext(current);
                }
            }
        }

        return linkNode;
    }
}
