package Hackerrank;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindTheRunningMedian {
	
    private static PriorityQueue<Integer> setLeft = new PriorityQueue(Collections.reverseOrder());
    private static PriorityQueue<Integer> setRight = new PriorityQueue();
    
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int[] a = new int[t];
        
        for(int i=0; i < t;i++) {
            a[i] = scan.nextInt();
        }
        scan.close();

		double[] arrayResult = new double[a.length];
			
		for(int i = 0; i < a.length;i++) {
			add(a[i]);
			arrayResult[i] = getMediana();
			System.out.println(getMediana());
		}
	}
	
	static void add(Integer intToAdd) {
		if(setLeft.isEmpty()) {
			setLeft.add(intToAdd);
			return;
		}
		
		if(setLeft.size() == setRight.size()) {
			if(intToAdd < setRight.peek()) {
				setLeft.add(intToAdd);
			}else {
				setLeft.add(setRight.peek());
				setRight.remove(setRight.peek());
				setRight.add(intToAdd);
			}
		}else if (setLeft.size() > setRight.size()) {
			if(intToAdd > setLeft.peek()) {
				setRight.add(intToAdd);
			}else {
				setRight.add(setLeft.peek());
				setLeft.remove(setLeft.peek());
				setLeft.add(intToAdd);
			}
		}
	}
	
	static Double getMediana() {
		if(setLeft.size()==setRight.size() && setLeft.size() > 0) {
			return Double.valueOf(setLeft.peek() + setRight.peek()) / 2;
		}else {
			return setLeft.size() > setRight.size() ? Double.valueOf(setLeft.peek()) : Double.valueOf(setRight.peek());
		}
	}
}
	
