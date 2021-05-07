//insertion sort
#include<iostream>
using namespace std;
void insertion_Sort(int A[], int size){
	int value;//to store the current element
	int index;//index of the element to be replaced with "value"
	for(int i=1 ; i<size ; i++){//start from i=1 and compare backwords and rewrite the elements
		value = A[i];
		index = i ;
		while(index>0 && A[index-1]>value){//compare the current element to the previous element and swap
			A[index] = A[index-1];
			index--;
		}
		A[index] = value ;
	}
}
void print_Array(int A[], int size){
	for(int i=0 ; i<size ; i++){
		cout<<A[i]<<" ";
	}
	cout<<endl;
}
int main(){
	int A[] = {7,34,67,32,1,8,44};
	int size = sizeof(A)/sizeof(A[0]);
	insertion_Sort(A, size);
	print_Array(A, size);
	return 0;
}