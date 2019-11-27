package com.datastructure.solution;

import java.util.ArrayList;
import java.util.List;


class Thing{
	int priority = 0;
	int value = 0;
	public Thing(int priority, int value) {
		super();
		this.priority = priority;
		this.value = value;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Thing [priority=" + priority + ", value=" + value + "]";
	}
	
}

public class MaxHeapObj {
	private List<Thing> heap = new ArrayList<Thing>();
	
	public List<Thing> getHeap() {
		return heap;
	}

	private void swap(int i, int j) {
		if (i > -1 && i < heap.size() && j > -1 && j < heap.size()) {
			Thing temp = new Thing(heap.get(i).getPriority(),heap.get(i).getValue());
			heap.set(i, heap.get(j));
			heap.set(j, temp);
		}
	}

	public int getParentIdx(int i) {
		return (i + 1) / 2 - 1;
	}

	public Thing getParent(int i) {
		int index = getParentIdx(i);
		if (index < heap.size()) {
			return heap.get(index);
		} else {
			return null;
		}
	}
	public int getLeftChildIdx(int i) {
		return 2 * i + 1;
	}
	public Thing getLeftChild(int i) {
		int index = getLeftChildIdx(i);
		if (index < heap.size()) {
			return heap.get(index);
		} else {
			return null;
		}
	}
	public int getRightChildIdx(int i) {
		return 2 * (i + 1);
	}
	public Thing getRightChild(int i) {
		int index = getRightChildIdx(i);
		if (index < heap.size()) {
			return heap.get(index);
		} else {
			return null;
		}
	}

	public void siftUp(int i) {

		while (i > 0 && getParent(i).getPriority() < heap.get(i).getPriority()) {
			int parentIndex = getParentIdx(i);
			swap(i, parentIndex);
			i = parentIndex;
		}
	}

	public void siftDown(int i) {
		int maxIndex = i;
		Thing left = getLeftChild(i);
		Thing right = getRightChild(i);

		if (left != null && left.getPriority() > heap.get(maxIndex).getPriority()) {
			maxIndex = getLeftChildIdx(i);
		}
		if (right != null && right.getPriority() > heap.get(maxIndex).getPriority()) {
			maxIndex = getRightChildIdx(i);
		}
		if (i != maxIndex) {
			swap(i, maxIndex);
			siftDown(maxIndex);
		}
	}

	public void insert(Thing o) {
		heap.add(o);
		siftUp(heap.size() - 1);
	}

	public Thing extractMax() {
		Thing result = new Thing(heap.get(0).getPriority(),heap.get(0).getValue());
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		siftDown(0);
		return result;
	}

	public void remove(int i) {
		heap.get(i).setPriority(Integer.MAX_VALUE); 
		siftUp(i);
		extractMax();
	}

	public void changePriority(int i, Integer p) {
		int currentP = heap.get(i).getPriority();
		heap.get(i).setPriority(p);
		if (p.intValue() > currentP) {
			siftUp(i);
		} else {
			siftDown(i);
		}
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (Thing t : heap) {
			//str.append(integer.intValue() + ",");
			str.append("[" + t.getPriority() + " , "+ t.getValue() + "]");
		}
		return str.toString();
	}

	public static void main(String[] args) {
		MaxHeapObj maxHeap = new MaxHeapObj();
		maxHeap.insert(new Thing(12,1));
		maxHeap.insert(new Thing(3,2));
		maxHeap.insert(new Thing(5,3));
		maxHeap.insert(new Thing(14,4));
		maxHeap.insert(new Thing(35,5));
		System.out.println(maxHeap.toString());
		maxHeap.insert(new Thing(7,6));
		System.out.println(maxHeap.toString());
		System.out.println(maxHeap.extractMax());
		System.out.println(maxHeap.toString());
		maxHeap.insert(new Thing(1,7));
		System.out.println(maxHeap.toString());
		System.out.println(maxHeap.extractMax());
		maxHeap.changePriority(2, new Integer(17));
		System.out.println(maxHeap.toString());
		System.out.println(maxHeap.extractMax());
		System.out.println(maxHeap.toString());
		System.out.println(maxHeap.extractMax());
		System.out.println(maxHeap.toString());
		System.out.println(maxHeap.extractMax());
		System.out.println(maxHeap.toString());
		
	}
}
