package AlgorithmDemo;

public class HeapSortTest {
    public static void main(String args[]){

        int[]L = {0,293,423,123,434,56,23,67,89};
        heapSort(L,1,L.length -1);
        for(int i = 1;i<L.length;i++){
            System.out.println(L[i]);
        }
    }
    public static void heapSort(int[]L,int low,int high){
        int length = L.length -1;
        for(int i = length/2;i>0;i--){
            heapAdjust(L,i,length);//先把大顶堆调整好
        }
        for(int i = length;i>1;i--){
            swap(L,1,i);
            heapAdjust(L,1,i-1);
        }
    }
    public static void heapAdjust(int []L,int s,int m){
        int temp = L[s];
        for(int j = s*2;j<=m;j=j*2){//这边肯定是要有等于m的，不然都没法遍历完整
            if(j<m&& L[j]<L[j+1]){
                j++;
            }
            if(temp >= L[j]){
                break;
            }
            L[s] = L[j];
            s = j;
        }
        L[s] = temp;
    }
    public static void swap(int[]L,int i,int j){
        int temp = L[i];
        L[i] = L[j];
        L[j] = temp;
    }
}
