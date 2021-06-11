#include<bits/stdc++.h>
using namespace std;
void merge(int arr[], int low, int mid, int high){

	int nl = mid - low +1 ;
	int nr = high - mid ;
	int L[nl];
	int R[nr];

	for(int i=0 ; i<nl ; i++){
		L[i] = arr[i+low];
	}
	for(int j=0 ; j<nr ; j++){
		R[j] = arr[j+mid+1];
	}

	int i=0, j=0 , k=low ;
	while(i<nl && j<nr){
		if(L[i] <= R[j])
			arr[k++] = L[i++];
		else
			arr[k++] = R[j++]; 
	}

	while(i < nl)
		arr[k++] = L[i++];
	while(j < nr)
		arr[k++] = R[j++];
}

void merge_sort(int arr[], int low, int high){
	if(low >= high)
		return;

	int mid = (low+high)/2;
	merge_sort(arr, low, mid);
	merge_sort(arr, mid+1, high);
	merge(arr, low, mid, high);
}

int main(){
	int arr[] = {18,8,2,6,10,16,12,4};
	int size = sizeof(arr)/sizeof(arr[0]);
	merge_sort(arr,0,size-1);
	for(int i=0 ; i<size ; i++)
		cout<<arr[i]<<" ";
	return 0;
}