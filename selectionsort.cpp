//selection sort
#include<iostream>
using namespace std;
//swap the min element with the ith element 
//inplace sorting using address
void swap(int *i, int *min_index){
	int temp = *i;
	*i = *min_index ;
	*min_index = temp;
}
//compare the selected min element with each element in the array
//and find the min and call swap
void selection_Sort(int A[], int size){
	for(int i=0 ; i<size ; i++){
		int min_index = i ;
		for(int j=i+1 ; j<size-1 ; j++){
			if(A[j]<A[min_index]){
				min_index = j ;
			}
		}
		swap(&A[i],&A[min_index]);
	}
}
//print the sorted array
void print_array(int A[], int size){
	for(int i=0 ; i<size ; i++)
		cout<<A[i]<<" ";
}
int main(){
	int A[] = { 8,34,53,2,5,1,67};
	int size = sizeof(A)/sizeof(A[0]);
	selection_Sort(A,size);
	print_array(A,size);
	cout<<endl;
	return 0 ;
}