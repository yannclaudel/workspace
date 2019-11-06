import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class JobQueue {
	private int numWorkers;
	private int[] jobs;

	private int[] assignedWorker;
	private long[] startTime;

	private FastScanner in;
	private PrintWriter out;

	public static void main(String[] args) throws IOException {
		new JobQueue().solve();
	}

	private void readData() throws IOException {
		numWorkers = in.nextInt();
		int m = in.nextInt();
		jobs = new int[m];
		for (int i = 0; i < m; ++i) {
			jobs[i] = in.nextInt();
		}
	}

	private class Process {
		int num;
		long priority;

		public Process(int num, long priority) {
			super();
			this.num = num;
			this.priority = priority;
		}

		@Override
		public String toString() {
			return "Process [num=" + num + ", priority=" + priority + "]";
		}

	}

	private class MinHeap {
		private List<Process> heap = new ArrayList<Process>();

		public Process getMinProcess() {
			return (heap.size() > 0 ? heap.get(0) : null);
		}

		public MinHeap(int n) {
			for (int i = 0; i < n; i++) {
				heap.add(new Process(i, 0));
			}
		}

		private void swap(int i, int j) {
			if (i > -1 && i < heap.size() && j > -1 && j < heap.size()) {
				Process temp = heap.get(i);
				heap.set(i, heap.get(j));
				heap.set(j, temp);
			}
		}

		public int getParentIdx(int i) {
			return (i + 1) / 2 - 1;
		}

		public Process getParent(int i) {
			int index = getParentIdx(i);
			if (index < heap.size())
				return heap.get(index);
			else
				return null;
		}

		public int getLeftChildIdx(int i) {
			return 2 * i + 1;
		}

		public Process getLeftChild(int i) {
			int index = getLeftChildIdx(i);
			if (index < heap.size())
				return heap.get(index);
			else
				return null;
		}

		public int getRightChildIdx(int i) {
			return 2 * (i + 1);
		}

		public Process getRightChild(int i) {
			int index = getRightChildIdx(i);
			if (index < heap.size())
				return heap.get(index);
			else
				return null;
		}

		private int getMin(int a, int b, int c) {
			if (heap.get(a).num <= heap.get(b).num && heap.get(a).num <= heap.get(c).num)
				return a;
			else if (heap.get(b).num <= heap.get(a).num && heap.get(b).num <= heap.get(c).num)
				return b;
			else
				return c;
		}

		public void siftDown2(int i) {
			int maxIndex = i;
			Process left = getLeftChild(i);
			Process right = getRightChild(i);
			if (left != null && right != null && left.priority <= heap.get(maxIndex).priority
					&& right.priority <= heap.get(maxIndex).priority && right.priority == left.priority) {
				// System.out.println(left.num +" "+ right.num);
				if (left.num <= right.num) {
					maxIndex = getLeftChildIdx(i);
				} else {
					maxIndex = getRightChildIdx(i);
				}
				// System.out.println(">>"+maxIndex);
			} else {
				if (left != null && left.priority < heap.get(maxIndex).priority) {
					maxIndex = getLeftChildIdx(i);
				}
				if (right != null && right.priority < heap.get(maxIndex).priority) {
					maxIndex = getRightChildIdx(i);
				}
				/*
				 * if (i == maxIndex) {
				 * 
				 * if (left != null && left.num < heap.get(maxIndex).num) { maxIndex =
				 * getLeftChildIdx(i); } if (right != null && right.num <
				 * heap.get(maxIndex).num) { maxIndex = getRightChildIdx(i); }
				 * 
				 * }
				 */
			}
			if (i != maxIndex) {
				// System.out.println("swap("+i+","+maxIndex+") " +
				// heap.get(i).toString()+heap.get(maxIndex).toString());
				swap(i, maxIndex);
				siftDown(maxIndex);
			}
		}

		public void siftDown(int i) {
			int swapWith = i;
			Process left = getLeftChild(i);
			Process right = getRightChild(i);

			if (left != null && left.priority < heap.get(swapWith).priority) {
				swapWith = getLeftChildIdx(i);
			}
			if (right != null && right.priority < heap.get(swapWith).priority) {
				swapWith = getRightChildIdx(i);
			}
			if (i != swapWith) {
				if (left != null && right != null && right.priority == left.priority) {
					if (left.num <= right.num) {
						swapWith = getLeftChildIdx(i);
					} else {
						swapWith = getRightChildIdx(i);
					}
				}				
			}else {
				if (left != null && left.priority == heap.get(swapWith).priority && left.num <heap.get(swapWith).num) {
					swapWith = getLeftChildIdx(i);
				}
				if (right != null && right.priority == heap.get(swapWith).priority  && right.num <heap.get(swapWith).num) {
					swapWith = getRightChildIdx(i);
				}
			}
			if (i != swapWith) {
				swap(i, swapWith);
				siftDown(swapWith);
			}
		}

		public void changePriorityToRoot(long p) {
			heap.get(0).priority = p;
			siftDown(0);
		}

		@Override
		public String toString() {
			StringBuffer str = new StringBuffer();
			for (Process p : heap) {

				str.append("[" + p.num + "," + p.priority + "]");
			}
			return str.toString();
		}
	}

	private void writeResponse() {
		for (int i = 0; i < jobs.length; ++i) {
			out.println(assignedWorker[i] + " " + startTime[i]);
		}
	}

	private void assignJobsOld() {
		// TODO: replace this code with a faster algorithm.
		assignedWorker = new int[jobs.length];
		startTime = new long[jobs.length];
		long[] nextFreeTime = new long[numWorkers];
		for (int i = 0; i < jobs.length; i++) {
			int duration = jobs[i];
			int bestWorker = 0;
			for (int j = 0; j < numWorkers; ++j) {
				if (nextFreeTime[j] < nextFreeTime[bestWorker])
					bestWorker = j;
			}
			assignedWorker[i] = bestWorker;
			startTime[i] = nextFreeTime[bestWorker];
			nextFreeTime[bestWorker] += duration;
		}
	}

	private void assignJobs() {
		// TODO: replace this code with a faster algorithm.
		assignedWorker = new int[jobs.length];
		startTime = new long[jobs.length];
		MinHeap heap = new MinHeap(numWorkers);
		// System.out.println(heap.toString());
		for (int i = 0; i < jobs.length; i++) {
			int duration = jobs[i];
			int bestWorker = heap.getMinProcess().num;

			assignedWorker[i] = bestWorker;
			startTime[i] = heap.getMinProcess().priority;
			heap.changePriorityToRoot(heap.getMinProcess().priority + duration);
			// System.out.println(bestWorker + " " + heap.getMinProcess().priority);
			//System.out.println(heap.toString());
		}
	}

	public void solve() throws IOException {
		in = new FastScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		readData();
		assignJobs();
		writeResponse();
		out.close();
	}

	static class FastScanner {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public FastScanner() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			tokenizer = null;
		}

		public String next() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				tokenizer = new StringTokenizer(reader.readLine());
			}
			return tokenizer.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}
}
