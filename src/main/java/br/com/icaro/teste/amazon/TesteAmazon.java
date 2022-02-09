package br.com.icaro.teste.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteAmazon {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
    	int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            TesteAmazon.isBalanced(s);
            
        }

        scanner.close();

	}
	private static void isBalanced(String s) {
		List<Integer> listInt = new ArrayList<>();
		String[] arrS = s.split(" ");
		for(int i = 1; i < arrS.length; i ++) {
			listInt.add(Integer.parseInt(arrS[i]));
		}
		
		howManySwaps(listInt);
		
	}
	
    List<Integer> newArr = new ArrayList<>();
    static Integer indexA = 0;
    static Integer indexB =1;
    static Integer aux = 0;
    static Long steps = 0L;

	private static Long howManySwaps(List<Integer> arr) {
		while(indexA+2 < arr.size()) {
	        if(indexB >= arr.size()){
	            indexA++;
	            indexB = indexA+1;
	        }
	        
	        if(arr.get(indexA) > arr.get(indexB)){
	            aux = arr.get(indexA);
	            arr.set(indexA, arr.get(indexB));
	            arr.set(indexB, aux);
	            steps++;
	        }
	        indexB++;
		}
		System.out.print(steps);
        return steps;
	}
}
