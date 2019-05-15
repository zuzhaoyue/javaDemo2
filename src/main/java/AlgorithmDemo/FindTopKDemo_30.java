package AlgorithmDemo;

public class FindTopKDemo_30 {
    public static void main(String args[]){

        int k= 0;
        int L[] = {3,2,6,7,43,21,8};
        System.out.println(getTopk(L,k));
    }
    public static int getTopk(int[]L,int k){

        int pivotIndex = partition(L,0,L.length -1);
        while(pivotIndex != k) {
            if (pivotIndex < k) {
                pivotIndex = partition(L, pivotIndex + 1, L.length - 1);
            }
            if (pivotIndex > k) {
                pivotIndex = partition(L, 0, pivotIndex - 1);
            }
        }
        int res = L[k];
        return res;

    }
    public static int partition(int[]L,int low,int high){
        int pivotValue= L[low];

        while(low < high){
            while (low < high && L[high] >= pivotValue){
                high--;
            }
            swap(L,low,high);
            while(low<high &&L[low]<= pivotValue){
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
