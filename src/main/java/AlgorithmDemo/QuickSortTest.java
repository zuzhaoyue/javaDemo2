package AlgorithmDemo;

public class QuickSortTest {
    public static void main(String args[]){

        int[]L = {1,2,3,1,2,1,3,1,56,56,4};
        quickSort(L,0,L.length -1);
        for(int i = 0;i < L.length;i++){
            System.out.println(L[i]);
        }

    }
    public static void quickSort(int[]L,int low,int high){
        int pivotIndex;
        if(low<high){
            pivotIndex = partition(L,low,high);

            quickSort(L,low,pivotIndex -1);
            quickSort(L,pivotIndex+1,high);
        }
    }
    public static int partition(int[]L,int low,int high){
        int pivotValue = L[low];
        while(low < high){
            while(low < high && L[high] >= pivotValue ){
                high--;
            }
            swap(L,low,high);
            while(low < high && L[low] <= pivotValue){
                low ++;
            }
            swap(L,low,high);
        }
        return low;
    }
    public static void swap(int[]L,int i,int j){
        int temp = L[i];
        L[i] = L[j];
        L[j] = temp;
    }
}
