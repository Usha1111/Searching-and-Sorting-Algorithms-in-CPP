//sort maxHeap in ascending order
//inplace heapSort
//it can also be implemented using a temp array if the original heap has to be retained
class HeapSort{
	public static void main(String[] args){
		PriorityQueue maxHeap = new PriorityQueue();
		maxHeap.insertElement(10);
		maxHeap.insertElement(4);
		maxHeap.insertElement(6);
		maxHeap.insertElement(12);
		maxHeap.insertElement(2);
		maxHeap.insertElement(67);
		maxHeap.sortMaxHeap();
	}
}
class PriorityQueue{

	//use dynamic array

	ArrayList<Integer> maxHeap;
	PriorityQueue(){
		maxHeap = new ArrayList<>();
	}

	public void insertElement(int element){
		maxHeap.add(element);
		int childIndex = maxHeap.size()-1;
		int parentIndex = (childIndex-1)/2;
		while(childIndex > 0){
			if(maxHeap.get(parentIndex) < maxHeap.get(childIndex)){
				int temp = maxHeap.get(parentIndex);
				maxHeap.set(parentIndex, maxHeap.get(childIndex));
				maxHeap.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else
				return;
		}
	}

	public void heapify(int end){
		int parentIndex = 0;
		int leftChild = 1;
		int rightChild = 2 ;
		while(parentIndex < end-1){
			int maxIndex = parentIndex;
			if(leftChild < end){
				if(rightChild < end && maxHeap.get(leftChild) < maxHeap.get(rightChild) && arr[rightChild] > arr[maxIndex])
					maxIndex = rightChild;
				else if(maxHeap.get(leftChild) > maxHeap.get(maxIndex))
					maxIndex = leftChild ;
			}
			if(parentIndex != maxIndex){
				int temp = maxHeap.get(parentIndex);
				maxHeap.set(parentIndex, maxHeap.get(maxIndex));
				maxHeap.set(maxIndex, temp);
				parentIndex = maxIndex;
				leftChild = 2*parentIndex+1;
				rightChild = 2*parentIndex+2;
			}
			else
				return;
		}
	}

	//put the larget element at the end of the list
	//now downheapify upto the element which is not sorted that is 
	//separate the sorted array and unsorted array using a variable i and 
	//heapify the unsorted array to get the largest element
	//repeat the process until the entire array is sorted

	public void sortMaxHeap(){
		int i=maxHeap.size()-1;
		while(i>0){
			int temp = maxHeap.get(i);
			maxHeap.set(i, maxHeap.get(0));
			maxHeap.set(0, temp);
			this.heapify(i--);
		}
		System.out.println(maxHeap);
	}

}
