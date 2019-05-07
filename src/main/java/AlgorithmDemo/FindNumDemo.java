package AlgorithmDemo;

/**
 * Created by zuzhaoyue on 2019/1/12.
 */
public class FindNumDemo {

    public static boolean find(int[][] matrix,int a){
        int rows = matrix.length;
        int columns = matrix[0].length;
        int currentRow = 0;
        int currentColumn = columns -1;
        Boolean found = false;
        while( currentRow < rows && currentColumn >= 0){
            if(matrix[currentRow][currentColumn] == a){
                found = true;
                break;
            }
            if(matrix[currentRow][currentColumn] > a){
                currentColumn--;
            }
            if(matrix[currentRow][currentColumn] < a){
                currentRow ++;
            }
        }
        return found;
    }
    public static void testReplace(){
        String a = "aa";
        a.replace("a","b");
    }
    public static void main(String[] args){
//        int[][] matrix = new int[3][3];
//        int[][] a  = {{1,2,3},{4,5,6},{7,8,9}};
////        matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        Boolean result = find(a,10);
//        System.out.println(result);

        testReplace();

    }
}
