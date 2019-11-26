package com.hackerearth;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

  
public class BinaryReplacement{
	
	private static class Pair{
	    int a;
	    int b;
	    Pair(int p,int q){
	        this.a=p;
	        this.b=q;
	    }
	    
	}
	
	
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        // Start writing your solution here. -------------------------------------
        int n = sc.nextInt();
        char[] l = sc.nextLine().replace(" ","").toCharArray();
        int q = sc.nextInt();
        Map<Integer,Pair> map = new HashMap<Integer,Pair>();
        Pair pair = null;
        for(int i=0; i<q; i++){
            int a = sc.nextInt() - 1 ;
            int b = sc.nextInt();
            pair = map.get(a);
            if (pair!=null) pair.a++;
            else map.put(a, new Pair(1,0));

            pair = map.get(b);
            if (pair!=null) pair.b++;
            else map.put(b, new Pair(0,1));       
        }
        
        long count = 0;
        int plus = 0;
        for (int i = 0; i < l.length; i++) {
        	pair = map.get(i);
        	if (pair!=null) plus = plus + pair.a - pair.b;
        	if (plus%2==1) {
        		if (l[i]=='1') l[i]='0';
        		else l[i]='1';
        	}
        	if (l[i]=='1') count++;
		}
        
        out.println(count);
        for (char c : l) {
        	out.print(c+" ");
		}
        // Stop writing your solution here. -------------------------------------
        out.close();
    }
	
	
    public static void mainOld(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        // Start writing your solution here. -------------------------------------
        int n = sc.nextInt();
        StringBuffer s   = new StringBuffer(sc.nextLine().replace(" ",""));
        int q = sc.nextInt();
        for(int i=0; i<q; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();            
            String temp = s.substring(a-1, b).replaceAll("1", "2").replaceAll("0", "1").replaceAll("2", "0");
            s.replace(a-1, b, temp);
            //s=s.substring(0,a-1)+temp+s.substring(b);
        }
        
        char[] l = s.toString().toCharArray();
        long count = 0;
        for (char c : l) {
			if (c=='1') count++;
		}
        out.println(count);
        for (char c : l) {
        	out.print(c+" ");
		}
        // Stop writing your solution here. -------------------------------------
        out.close();
    }
 
 
 
     
 
 
 
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
 
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
         
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    //--------------------------------------------------------
}
