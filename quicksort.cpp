//quicksort
#include<iostream>
using namespace std;
void swap(int *a , int *b){
	int temp = *a;
	*a = *b ;
	*b = temp;
}
int partition(int A[], int low , int high){
	int pivot = A[low];
	int i=low , j = high ;
	while(i<j){
		do{
			i++;
		}while(A[i]<= pivot);
		do{
			j--;
		}while(A[j] > pivot);
		if(i<j)
			swap(&A[i], &A[j]);
	}
	swap(&A[j], &A[low]);
	return j;
}
void quick_Sort(int A[], int low, int high){
	if(low<high){
		int pivot = partition(A,low , high);
		quick_Sort(A, low, pivot-1);
		quick_Sort(A, pivot+1, high);
	}
}
int main(){
	int A[] = {5,23,9,1,67,90};
	int size = sizeof(A)/sizeof(A[0]);
	quick_Sort(A, 0, size-1);
	for(int i=0 ; i<size ; i++)
		cout<<A[i]<<" ";
	return 0;
}
