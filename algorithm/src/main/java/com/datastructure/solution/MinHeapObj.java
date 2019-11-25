package com.datastructure.solution;

import java.util.ArrayList;
import java.util.List;



public class MinHeapObj {
	
	class InnerThing{
		int priority = 0;
		int value = 0;
		public InnerThing(int priority, int value) {
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
			return "InnerThing [priority=" + priority + ", value=" + value + "]";
		}
		
	}

	
	private List<InnerThing> heap = new ArrayList<InnerThing>();
	
	public List<InnerThing> getHeap() {
		return heap;
	}

	private void swap(int i, int j) {
		if (i > -1 && i < heap.size() && j > -1 && j < heap.size()) {
			InnerThing temp = new InnerThing(heap.get(i).getPriority(),heap.get(i).getValue());
			heap.set(i, heap.get(j));
			heap.set(j, temp);
		}
	}

	public int getParentIdx(int i) {
		return (i + 1) / 2 - 1;
	}

	public InnerThing getParent(int i) {
		int index = getParentIdx(i);
		if (index < heap.size())
			return heap.get(index);
		else
			return null;
	}
	public int getLeftChildIdx(int i) {
		return 2 * i + 1;
	}
	public InnerThing getLeftChild(int i) {
		int index = getLeftChildIdx(i);
		if (index < heap.size())
			return heap.get(index);
		else
			return null;
	}
	public int getRightChildIdx(int i) {
		return 2 * (i + 1);
	}
	public InnerThing getRightChild(int i) {
		int index = getRightChildIdx(i);
		if (index < heap.size())
			return heap.get(index);
		else
			return null;
	}

	public void siftUp(int i) {

		while (i > 0 && getParent(i).getPriority() > heap.get(i).getPriority()) {
			int parentIndex = getParentIdx(i);
			swap(i, parentIndex);
			i = parentIndex;
		}
	}

	public void siftDown(int i) {
		int minIndex = i;
		InnerThing left = getLeftChild(i);
		InnerThing right = getRightChild(i);

		if (left != null && left.getPriority() < heap.get(minIndex).getPriority()) {
			minIndex = getLeftChildIdx(i);
		}
		if (right != null && right.getPriority() < heap.get(minIndex).getPriority()) {
			minIndex = getRightChildIdx(i);
		}
		if (i != minIndex) {
			swap(i, minIndex);
			siftDown(minIndex);
		}
	}

	public void insert(int p, int v) {
		heap.add(new InnerThing(p,v));
		siftUp(heap.size() - 1);
	}

	public InnerThing extractMax() {
		InnerThing result = new InnerThing(heap.get(0).getPriority(),heap.get(0).getValue());
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		siftDown(0);
		return result;
	}

	public void remove(int i) {
		heap.get(i).setPriority(Integer.MIN_VALUE); 
		siftUp(i);
		extractMax();
	}

	public void changePriority(int i, Integer p) {
		int currentP = heap.get(i).getPriority();
		heap.get(i).setPriority(p);
		if (p.intValue() < currentP)
			siftUp(i);
		else
			siftDown(i);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (InnerThing t : heap) {
			//str.append(integer.intValue() + ",");
			str.append("[" + t.getPriority() + " , "+ t.getValue() + "]");
		}
		return str.toString();
	}

	public static void main(String[] args) {
		MinHeapObj minHeap = new MinHeapObj();
		minHeap.insert(12,1);
		minHeap.insert(3,2);
		minHeap.insert(5,3);
		minHeap.insert(14,4);
		minHeap.insert(35,5);
		System.out.println(minHeap.toString());
		minHeap.insert(7,6);
		System.out.println(minHeap.toString());
		System.out.println(minHeap.extractMax());
		System.out.println(minHeap.toString());
		minHeap.insert(1,7);
		System.out.println(minHeap.toString());
		System.out.println(minHeap.extractMax());
		minHeap.changePriority(2, new Integer(17));
		System.out.println(minHeap.toString());
		System.out.println(minHeap.extractMax());
		System.out.println(minHeap.toString());
		System.out.println(minHeap.extractMax());
		System.out.println(minHeap.toString());
		System.out.println(minHeap.extractMax());
		System.out.println(minHeap.toString());
		
	}
}
