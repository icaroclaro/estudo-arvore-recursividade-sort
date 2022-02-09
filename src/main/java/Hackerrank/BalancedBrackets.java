package Hackerrank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	public class BalancedBrackets {
		private static final Scanner scanner = new Scanner(System.in);
		static String exp = "([\\(]|[\\[]|[\\{]|[\\)]|[\\]]|[\\}])+";
		static String novaStr="";
	    
	    public static void main(String[] args) throws IOException {

	    	int t = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        for (int tItr = 0; tItr < t; tItr++) {
	            String s = scanner.nextLine();

	            String result = isBalanced(s);

	            System.out.println((result));
	        }

	        scanner.close();
	    }
	    
	    
	    
		static String isBalanced(String s) {
	    	Pattern pattern = Pattern.compile(exp);
	    	Matcher matcher = pattern.matcher(s);
	    	while(matcher.find()) {
	    		 novaStr = novaStr + matcher.group();	
	    	}
	    	return (removePares(novaStr).length() == 0 ? "YES":"NO");
	    }
	    
	    static String removePares(String str) {
	    	if (!str.contains("()") && !str.contains("[]") && !str.contains("{}"))
	    		return str;
	    		
	    	str = str.replaceAll("\\(\\)", "")
    	      .replaceAll("\\[\\]", "")
    	      .replaceAll("\\{\\}", "");
	    	return removePares(str);
	    }
	}
