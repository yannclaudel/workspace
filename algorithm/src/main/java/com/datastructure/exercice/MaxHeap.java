package com.datastructure.exercice;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
	private List<Integer> heap = new ArrayList<Integer>();
	
	public List<Integer> getHeap() {
		return heap;
	}

	private void swap(int i, int j) {
		if (i > -1 && i < heap.size() && j > -1 && j < heap.size()) {
			Integer temp = new Integer(heap.get(i).intValue());
			heap.set(i, heap.get(j));
			heap.set(j, temp);
		}
	}

	public int getParentIdx(int i) {
		// TODO
		return 0;
	}

	public Integer getParent(int i) {
		int index = getParentIdx(i);
		if (index < heap.size())
			return heap.get(index);
		else
			return null;
	}
	public int getLeftChildIdx(int i) {
		// TODO
		return 0;
	}
	public Integer getLeftChild(int i) {
		int index = getLeftChildIdx(i);
		if (index < heap.size())
			return heap.get(index);
		else
			return null;
	}
	public int getRightChildIdx(int i) {
		// TODO
		return 0;
	}
	public Integer getRightChild(int i) {
		int index = getRightChildIdx(i);
		if (index < heap.size())
			return heap.get(index);
		else
			return null;
	}

	public void siftUp(int i) {
		// TODO
		while (i > 0 /* && TODO */) {
			// TODO
		}
	}

	public void siftDown(int i) {
		int maxIndex = i;
		Integer left = getLeftChild(i);
		Integer right = getRightChild(i);

		if (left != null && left.intValue() > heap.get(maxIndex).intValue()) {
			maxIndex = getLeftChildIdx(i);
		}
		if (right != null && right.intValue() > heap.get(maxIndex).intValue()) {
			maxIndex = getRightChildIdx(i);
		}
		if (i != maxIndex) {
			// TODO
					}
	}

	public void insert(Integer o) {
		// TODO
	}

	public Integer extractMax() {
		Integer result = new Integer(heap.get(0).intValue());
		// TODO
		return result;
	}

	public void remove(int i) {
		// TODO
	}

	public void changePriority(int i, Integer p) {
		int currentP = heap.get(i).intValue();
		heap.set(i, p);
		// TODO
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (Integer integer : heap) {
			str.append("[" + integer.intValue() + "]");
		}
		return str.toString();
	}

	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.insert(42);
		maxHeap.insert(29);
		maxHeap.insert(18);
		maxHeap.insert(14);
		maxHeap.insert(7);
		maxHeap.insert(18);
		maxHeap.insert(12);
		maxHeap.insert(11);
		// maxHeap.insert(5);
		System.out.println(maxHeap.toString());
		maxHeap.insert(30);
		System.out.println(maxHeap.toString());
		maxHeap.extractMax();
		System.out.println(maxHeap.toString());
		maxHeap.insert(50);
		System.out.println(maxHeap.toString());
		maxHeap.changePriority(2, new Integer(17));
		System.out.println(maxHeap.toString());
	}
}
