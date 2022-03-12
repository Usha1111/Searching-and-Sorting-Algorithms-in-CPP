class KMPStringMatcher{
	public static void main(String[] args){
		String str = "ushausha";
		String pattern = "haus";
		KMPMatcher(str, pattern);
	}

	public static void findCount(int[] countArr, String pattern){
		int i=0, j=1;
		countArr[0] = 0;
		while(j<pattern.length()){
			if(pattern.charAt(i) == pattern.charAt(j)){
				i++;j++;
				countArr[j] = i;
			}
			else{
				if(i==0){
					countArr[j] = 0;
					j++;
				}
				else{
					i=countArr[i-1];
				}
			}
		}
	}
	public static void KMPMatcher(String str, String pattern){
		if(str.length() < pattern.length() || pattern.length() ==0){
			System.out.println("Do not match to any substring");
			return;
		}
		int[] countArr = new int[pattern.length()];
		findCount(countArr, pattern);
		int i=0, j=0;
		for( ; i<str.length() ;){
			if(str.charAt(i) != pattern.charAt(j)){
				if(j==0)
					i++;
				else
					j=countArr[j-1];
			}
			else{
				i++;j++;
				if(j>=pattern.length()){
					System.out.println("Found match at index : "+(i-j));
					return;
				}
			}
		}
		System.out.println("Do not match to any substring");
	}
}