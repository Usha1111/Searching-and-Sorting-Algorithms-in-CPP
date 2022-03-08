import java.util.Arrays;
class CyclicSort{
	public static void main(String[] args){
		int[] arr1 = {0,3,1,4,2};
		sortInRange0toN(arr1);
		int[] arr2 = {3,5,4,2,1};
		sortInRange1toN(arr2);
	}

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//index is calculated based on the range of the given numbers
	public static void sortInRange1toN(int[] arr){
		System.out.println(Arrays.toString(arr));
		//if the range is from 1 to n, then the numbers must be corrected to its index position i.e., index == number-1
		int index = 0 ;
		for(int i=0 ; i<arr.length ; ){
			index = arr[i]-1;
			if(arr[i] != arr[index]){
				swap(arr, i, index);
			}
			else
				i++;
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void sortInRange0toN(int[] arr){
		System.out.println(Arrays.toString(arr));
		//if the range is from 0 to n, then the numbers must be corrected to its index position i.e., index == number
		int index = 0 ;
		for(int i=0 ; i<arr.length ; ){
			index = arr[i];
			if(arr[i] != arr[index]){
				swap(arr, i, index);
			}
			else
				i++;
		}
		System.out.println(Arrays.toString(arr));
	}
}