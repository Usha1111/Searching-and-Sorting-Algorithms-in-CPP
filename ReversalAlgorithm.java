import java.util.Arrays;
class ReversalAlgorithm{
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int d = 3 ;
		System.out.println(Arrays.toString(arr));
		reverseByDTimes(arr, d);
		System.out.println(Arrays.toString(arr));
	}
	public static void reverse(int[] arr, int start, int end){
		while(start < end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	public static void reverseByDTimes(int[] arr, int d){
		if(d==0)
			return;
		d = d%n;
		reverse(arr, 0, d-1);
		reverse(arr, d, arr.length-1);
		reverse(arr, 0, arr.length-1);
	}
}