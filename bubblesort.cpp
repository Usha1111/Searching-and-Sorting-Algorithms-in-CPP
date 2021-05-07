//bubble sort
#include<iostream>
using namespace std;
//swap the elements
void swap(int *i, int *j){
	int temp = *i ;
	*i = *j ;
	*j = temp ;
}
//bubble sort 
//compare jth element to the (j+1)th element 
void bubble_Sort(int A[],  int size){
	for(int i=0 ; i<size ; i++){
		int flag = 0;
		for(int j=0 ; j<size-i-1 ; j++){
			if(A[j] > A[j+1]){
				swap(&A[j], &A[j+1]);
				flag = 1 ;
			}
		}
		//if there is no swap then the array is sorted 
		if(flag==0)
			break;
	}
}
//print the sorted array
void print_Array(int A[], int size){
	for(int i=0 ; i<size ; i++){
		cout<<A[i]<<" ";
	}
	cout<<endl;
}
int main(){
	int A[] = {5,23,57,1,4,8};
	int size = sizeof(A)/sizeof(A[0]);
	bubble_Sort(A, size);
	print_Array(A, size);
	return 0;
}