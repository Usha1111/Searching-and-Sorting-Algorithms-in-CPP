class KadanesAlgorithm{
	public static void main(String[] args){
		int[] arr = {-11, -2, -3, -1, -5};
		System.out.println(maxSumSubArray(arr));
	}
	public static int maxSumSubArray(int[] arr){
		if(arr.length <= 0)
			return Integer.MIN_VALUE;
		int sum = arr[0];
		int max = arr[0];
		int i=1;
		while(i<arr.length){
			if(sum < 0)
				sum=0;
			sum+=arr[i];
			if(sum > max)
				max = sum;
			i++;
		}
		return max;
	}
}