package AlgorithmDemo;

public class ReverseLinkNode_16 {
    public static void main(String args[]){

        LinkNode linkNode = new LinkNode(1,new LinkNode(9,new LinkNode(3,new LinkNode(6,null))));
        LinkNode reverseNode = reverse(linkNode);
        while(reverseNode != null && reverseNode.getValue()!=null){

            System.out.println(reverseNode.getValue());
            reverseNode = reverseNode.getNext();
        }
    }
    public static LinkNode reverse(LinkNode node){
        LinkNode reverseNode = null;
        LinkNode currentNode = node;
        LinkNode preNode = null;

        while(currentNode != null){
            LinkNode nextNode = currentNode.getNext();
            if(nextNode == null){
                reverseNode = currentNode;
            }
            currentNode.setNext(preNode);
            preNode = currentNode;
            currentNode = nextNode;
        }
        return reverseNode;

    }
}
