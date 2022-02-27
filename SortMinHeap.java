import java.util.ArrayList;
class SortMinHeap{
	public static void main(String[] args){
		PriorityQueue minHeap = new PriorityQueue();
		minHeap.insertElement(10);
		minHeap.insertElement(4);
		minHeap.insertElement(6);
		minHeap.insertElement(12);
		minHeap.insertElement(2);
		minHeap.insertElement(67);
		minHeap.sortMinHeap();
	}
}
class PriorityQueue{
	ArrayList<Integer> minHeap;
	PriorityQueue(){
		minHeap = new ArrayList<>();
	}
	
	public void insertElement(int element){
		minHeap.add(element);
		int childIndex = minHeap.size()-1;
		int parentIndex = (childIndex-1)/2;
		while(childIndex > 0){
			if(minHeap.get(parentIndex) > minHeap.get(childIndex)){
				int temp = minHeap.get(parentIndex);
				minHeap.set(parentIndex, minHeap.get(childIndex));
				minHeap.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex-1)/2;
			}
			else
				return;
		}
	}

	public void heapify(int end){
		int parentIndex = 0;
		int leftChild = 1 ;
		int rightChild = 2 ;
		while(parentIndex < end-1){
			int minIndex = parentIndex;
			if(leftChild < end){
				if(rightChild < end && minHeap.get(leftChild) > minHeap.get(rightChild))
					minIndex = rightChild;
				else if(minHeap.get(leftChild) < minHeap.get(minIndex))
					minIndex = leftChild;
			} 
			if(parentIndex != minIndex){
				int temp = minHeap.get(parentIndex);
				minHeap.set(parentIndex, minHeap.get(minIndex));
				minHeap.set(minIndex, temp);
				parentIndex = minIndex;
				leftChild = 2*parentIndex+1;
				rightChild = 2*parentIndex+2;
			}
			else
				return;
		}
	}
	public void sortMinHeap(){
		int i=minHeap.size()-1;
		while(i>0){
			int temp = minHeap.get(i);
			minHeap.set(i, minHeap.get(0));
			minHeap.set(0, temp);
			heapify(i--);
		}
		System.out.println(minHeap);
	}
	
}