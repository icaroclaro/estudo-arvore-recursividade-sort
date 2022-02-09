import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArvoreBinaria {
	
	public static int heightOld(Nodec root) {
				
		List<Nodec> listNodePai = new ArrayList<Nodec>();
		List<Nodec> listNodeFilho = new ArrayList<Nodec>();
		Integer alturaArvore = 0;
		listNodePai.add(root);
		
		while(listNodePai.size() > 0) {
			listNodeFilho.clear();
			for(int i = 0; listNodePai.size() > i; i++) {
				Nodec node = listNodePai.get(i);

				if(node.left != null)
				{
					listNodeFilho.add(node.left);
				}
				if(node.right != null) {
					listNodeFilho.add(node.right);
				}
			}
			listNodePai.clear();
			listNodePai.addAll(listNodeFilho);
			
			if(listNodeFilho.size() != 0) {
				alturaArvore++;	
			}
		}
		return alturaArvore;
    }
	
	public static int height(Nodec root) {
		if (root == null) {
			return -1;
		}
		int a = height(root.left);
		int b = height(root.right);
		
		int c = 1 + Math.max(a, b);
		return c;
    }

	public static Nodec insert(Nodec root, int data) {
        if(root == null) {
            return new Nodec(data);
        } else {
            Nodec cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Nodec root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }

}
class Nodec {
    Nodec left;
    Nodec right;
    int data;
    
    Nodec(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

