package Hackerrank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Nodeb {
    Nodeb left;
    Nodeb right;
    int data;
    
    Nodeb(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LevelOrderTraversal {

	public static void levelOrder(Nodeb root) {
		
		List<Nodeb> listNodePai = new ArrayList<Nodeb>();
		List<Nodeb> listNodeFilho = new ArrayList<Nodeb>();
		listNodePai.add(root);
		
		while(listNodePai.size() > 0) {
			listNodeFilho.clear();
			for(int i = 0; listNodePai.size() > i; i++) {
				Nodeb node = listNodePai.get(i);
				System.out.print(node.data + " ");
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
		}
    }

	public static Nodeb insert(Nodeb root, int data) {
        if(root == null) {
            return new Nodeb(data);
        } else {
            Nodeb cur;
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
        Nodeb root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}