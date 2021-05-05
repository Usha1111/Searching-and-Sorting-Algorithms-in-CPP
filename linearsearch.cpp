//linear search
#include<iostream>
using namespace std;
//linear search function which returns 
//index at which the element is present else it returns -1
int linear_Search(int A[], int size, int element){
	//search each element one at a time 
	//check if the element is present in the array
	for(int i=0 ; i<size ; i++){
		if(A[i]==element)
			return i ;
	}
	return -1 ;
}
int main() {
	int A[] = {5, 2, 9, 24, 78, 84, 79};
	int element = 2 ;
	int size = sizeof(A) / sizeof(A[0]);
	//call linear search function
	int result = linear_Search(A, size, element);
	if(result != -1)
		cout<<"element found at index "<<result<<"\n";
	else
		cout<<"element not found"<<"\n";
	return 0 ;
}