import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
    	
    	Arrays.sort(segments, Comparator.comparing(Segment::getEnd));
    	ArrayList<Integer> pts = new ArrayList<Integer>();
    	
    	for (int j = 0; j < segments.length; j++) {
			Segment segment = segments[j];
			pts.add(new Integer(segment.end));
			while(j < segments.length-1 && segments[j+1].start <= segment.end) {
				j++;
			}			
		}
    	
        //write your code here
    	int[] points = pts.stream().mapToInt(i -> i).toArray();
//        int[] points = new int[2 * segments.length];
//        for (int i = 0; i < segments.length; i++) {
//            points[2 * i] = segments[i].start;
//            points[2 * i + 1] = segments[i].end;
//        }
        return points;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
		public int getEnd() {
			return end;
		}  
		public int getStart() {
			return start;
		}        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
