import java.util.Arrays;
class DutchNationalFlag{
	public static void main(String[] args){
		int[] arr = {0,1,2,0,1,2,2,1,0,1,2,1,2,0,0,1};
		partition(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//0 -> low space for 0's
	//low -> mid space for 1's
	//mid -> high space of other values
	// high -> arr.length-1 space for 2's

	//we move low such that it mostly points to 1 in the space for 0's
	//so when a mid encounters 0 in 1's space it swaps with low
	//and increace mid and low

	//when mid == 1 increase mid as mid include space for 1's

	//when mid == 2 swap with high and decrease high
	public static void partition(int[] arr){
		int low = 0;
		int mid = 0 ;
		int high = arr.length-1;
		while(mid <= high){
			if(arr[mid] == 0){
				swap(arr, mid, low);
				mid++;
				low++;
			}
			else if(arr[mid] == 1)
				mid++;
			else{
				swap(arr, mid, high);
				high--;
			}
		}
	}
}