//binary search using resurssion
#include<iostream>
using namespace std;
//binary_Search() returns the index at which the element is present 
//if the element is found 
//else it returns -1
int binary_Search(int A[], int low, int high, int element){
	if(low<=high){
		//to contro overflow error
		int mid = low+(high-low)/2;
		if(A[mid] == element)
			return mid;
		else
			//if the element is less than the element at index mid 
			//then the element might be present in the left sub array
			if(element < A[mid])
				return binary_Search(A, low, mid-1, element);
			//if the element is greater than the element at index mid 
			//then the element might be present in the right sub array
			else
				return binary_Search(A, mid+1, high, element);
	}
	//return -1 if element is not found
	return -1;
}
int main(){
	int A[] = {4,8,2,94,87};
	int size = sizeof(A)/sizeof(A[0]);
	int element = 94 ;
	//call to binary_Search function
	int result = binary_Search(A, 0, size-1, element);
	(result == -1)
	? cout<<"element not found"<<"\n"
	: cout<<"element found at index "<<result<<"\n";
	return 0 ;
}