package Recurssion;

public class QuickSortJava {
    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        quickSort(arr, 0,arr.length-1);
        for(int i : arr)
            System.out.print(i+" ");
        System.out.println();
    }
    static int findPivot(int[] arr, int start, int end){
        int pivEle = arr[start];
        int count = 0 ;
        for(int i=start+1 ; i<=end ; i++){
            if(arr[i] <= pivEle)
                count++;
        }

        int pos = start+count;
        if(count > 0){
            arr[start] = arr[pos];
            arr[pos] = pivEle ;
        }
        int i=start ;
        int j=end ;
        while(i< pos && j > pos){
            while(arr[i] <= pivEle)
                i++;
            while(arr[j] > pivEle)
                j--;
            if(i<j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t ;
//                i++;j++;
            }
        }

        return pos ;
    }
    static void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return ;
        int pivotPos = findPivot(arr, start, end);
        quickSort(arr, start, pivotPos-1);
        quickSort(arr, pivotPos+1, end);
    }
}
