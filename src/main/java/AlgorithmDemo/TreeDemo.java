package AlgorithmDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zuzhaoyue on 2019/1/12.
 */
public class TreeDemo {
    public Node getTree(List<Integer> front, List<Integer> middle){
        Node node  =new Node();
        int root = front.get(0);
        node.data = root;
        List leftMiddle = getLeftMiddle(middle,root);
        List righhtMiddle = getLeftMiddle(middle,root);
//        List leftFront = //这里是左面的前序
//        List leftFront = //这里是右面的前序
        if(leftMiddle.size() > 0){
//            getTree()
        }
        return null;
    }
    public List<Integer> getLeftMiddle(List<Integer> middle,int num){
        List<Integer> leftMiddle = new ArrayList<Integer>();
        for(int i = 0 ; i < middle.size();i++){
            if(middle.get(i) < num){
                leftMiddle.add(middle.get(i));
            }
        }
        return leftMiddle;
    }
    public List<Integer> getRightMiddle(List<Integer> middle,int num){
        List<Integer> rightMiddle = new ArrayList<Integer>();
        for(int i = 0 ; i < middle.size();i++){
            if(middle.get(i) < num){
                rightMiddle.add(middle.get(i));
            }
        }
        return rightMiddle;
    }

}
class Node{
    int data;
    Node left;
    Node right;
}
