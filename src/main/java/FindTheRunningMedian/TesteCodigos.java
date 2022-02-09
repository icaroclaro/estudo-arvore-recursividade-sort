package FindTheRunningMedian;

public class TesteCodigos {
	public static void main(String[] args) {
		Integer[] array = new Integer[20];
		
		System.out.println(fib(10, array));
		System.out.println(fibEasy(10, array));
		//System.out.println(fibLinear(6));
	}
	
	static Integer fib(int n, Integer[] memo) {
		Integer result;
		
		if(memo[n] != null)
			return memo[n];
		
		if(n==1 | n==2) {
			result = 1;
		}else {
			Integer a = fib(n-1,memo);
			Integer b = fib(n-2,memo);
			result = a + b;
		}
		memo[n] = result;
		
		return result;
	}


	
	static Integer fibEasy(int n, Integer[] memo) {
		Integer result =0;
		
		if(n>1) {
			fibEasy(n-1, memo);
		}
		
		if(n==1 | n==2) {
			result = 1;
		}

		if(n > 2) {
			result = memo[n-1] + memo[n-2];
		}		

		memo[n] = result;
		
		return result;
	}
	
	static int fibLinear(int n) {
		Integer[] ints = new Integer[n+1];
		ints[1]=1;
		ints[2]=1;

		for(int i = 3; i<=n ;i++) {
			ints[i] = ints[i-1]+ints[i-2];
		}

		return ints[n];
	}

}
