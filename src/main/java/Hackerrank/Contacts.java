package Hackerrank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Contacts {
	
	Node root = new Node('+');
	
	public class Node {
		char data;
		Map<Character, Node> map = new HashMap<Character, Node>();
		int counts = 0;
		public Node(char data) {
			this.data = data;
		}
		
		public void add(String nome) {
			counts++;
			if(nome.length() > 0) {
				String restoDoNome = nome.substring(1);
				if (map.get(nome.charAt(0)) == null) {
					map.put(nome.charAt(0), new Node(nome.charAt(0)));
					map.get(nome.charAt(0)).add(restoDoNome);
				}else {
					map.get(nome.charAt(0)).add(restoDoNome);
				}
			}
		}
		
		public int find(String busca) {
			if(busca.length() == 0) return counts;
			if(map.get(busca.charAt(0)) == null) return 0;
			return map.get(busca.charAt(0)).find(busca.substring(1));
		}
	}
    private int[] contacts(String[][] queries) {
        List<Integer> finds = new ArrayList<>();
        for (String[] query : queries) {
            if (query[0].equals("add")) {
                root.add(query[1]);
            } else if (query[0].equals("find")) {
                finds.add(root.find(query[1]));
            }
        }

        int[] arr = new int[finds.size()];
        for(int i = 0; i < finds.size(); i++) {
            arr[i] = finds.get(i);
        }
        return arr;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int queriesRows = Integer.parseInt(scanner.nextLine().trim());

		String[][] queries = new String[queriesRows][2];

		for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
				String queriesItem = queriesRowItems[queriesColumnItr];
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}

		int[] result = new Contacts().contacts(queries);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			System.out.print(result[resultItr]);

			if (resultItr != result.length - 1) {
				System.out.println("");
			}
		}
	}
}
