import java.util.Arrays;
class SortArrayUsingHeapSort{
	public static void main(String[] args){
		int[] arr = {10, 6, 7, 5, 15, 17, 12};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void heapify(int[] arr, int parentIndex, int end){
		if(parentIndex >= end-1)
			return;
		int leftChild = 2*parentIndex+1;
		int rightChild = 2*parentIndex+2;
		int maxIndex = parentIndex;
		if(leftChild < end){
			if(rightChild < end && arr[leftChild] < arr[rightChild] && arr[rightChild] > arr[maxIndex])
				maxIndex = rightChild;
			else if(arr[leftChild] > arr[maxIndex])
				maxIndex = leftChild;
		}
		if(parentIndex != maxIndex){
			int temp = arr[parentIndex];
			arr[parentIndex] = arr[maxIndex];
			arr[maxIndex] = temp;
			heapify(arr, maxIndex, end);
		}
		else
			return;
	}
	public static void sortArray(int[] arr, int end){
		if(end == 0)
			return;
		int temp = arr[0];
		arr[0] = arr[end];
		arr[end] = temp;
		heapify(arr, 0, end);
		sortArray(arr, end-1);
	}

	//do heapify from the middle index of the array
	//heapify until all the nodes satisfy the heap order property
	//if heapify is done from the last index, you get the same results
	
	public static void heapSort(int[] arr){
		int index = arr.length/2;
		while(index > -1){
			heapify(arr, index, arr.length);
			index--;
		}
		sortArray(arr, arr.length-1);
	}
}
