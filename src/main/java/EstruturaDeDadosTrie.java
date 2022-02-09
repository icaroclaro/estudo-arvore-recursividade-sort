import java.util.HashMap;
import java.util.Map;

public class EstruturaDeDadosTrie {
	Nodea root = new Nodea('+');

	public class Nodea {
		char data;
		Map<Character, Nodea> map = new HashMap<Character, Nodea>();
		int counts = 0;
		public Nodea(char data) {
			this.data = data;
		}
		
		public void add(String nome) {
			counts++;
			if(nome.length() > 0) {
				String restoDoNome = nome.substring(1);
				if (map.get(nome.charAt(0)) == null) {
					map.put(nome.charAt(0), new Nodea(nome.charAt(0)));
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
	
	public static void main(String[] args) {
		EstruturaDeDadosTrie ed = new EstruturaDeDadosTrie();
		ed.root.add("icaro");
		ed.root.add("icardo");
		ed.root.add("ibra");
		ed.root.add("ictro");
		System.out.println(ed.root.find("ic"));
	}
}
