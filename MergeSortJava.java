package Recurssion;

public class MergeSortJava {
    public static void main(String[] args){
        int[] arr = {9,8,7,6,5,4,3,2,1};
        mergeSort(arr, 0, arr.length-1);
        for(int i : arr)
            System.out.print(i+" ");
        System.out.println();
    }

    static void merge(int[] arr, int start, int mid, int end){
        int i=start, j=mid+1 ,k=0;
        int[] temp = new int[end-start+1];
        while(i<=mid && j<=end){

            if(arr[i] < arr[j])
                temp[k++] = arr[i++];

            else
                temp[k++] = arr[j++];

        }

        while(i<=mid)
            temp[k++] = arr[i++];

        while(j<=end)
            temp[k++] = arr[j++];
        k=start;
        for(i=0; i<temp.length ; i++){
            arr[k++] = temp[i];
        }

    }
    static void mergeSort(int[] arr, int start, int end){
        if(start >= end)
            return ;
        int mid = start + (end-start)/2 ;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

}
