package FindTheRunningMedian;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ArvoreBinaria {
	static Integer[] arrayDeinteiros = new Integer[50000];
	static Integer[] arrayOrdenado = new Integer[50000];
	static Node node = null;
	static Long tempoInicial = 0l;
	static Long tempoFinal= 0l;
	public static void main(String[] args) {
		System.out.println("Preenchendo Array");
		preencheArray();
				
		imprimeTempoInicial("Criando Arvore Binaria");
		criaArvoreBinaria();
		ImprimeTempoFinal("Criando Arvore Binaria");
		
		System.out.println("");
		
		
		imprimeTempoInicial("OrdenaArray");
		ordenaArray();
		ImprimeTempoFinal("OrdenaArray");
		
		/*
		var tempoInicial = System.currentTimeMillis();
		System.out.println("Mili Segundos Iniciais: " + tempoInicial);
		
		for(int i = 0; i < arrayDeinteiros.length; i++) {
			if(i==0) {
				node = new Node(arrayDeinteiros[i], i);
			}else {
				node.add(arrayDeinteiros[i], i);
			}
		}
		
		var tempoFinal = System.currentTimeMillis();
		System.out.println("Tempo Final " +tempoFinal+ "- O Algoritimo foi executado em " + (tempoFinal - tempoInicial));
		
		System.out.println("------------------------------");
		
		var tempoInicial2 = System.currentTimeMillis();
		System.out.println("Mili Segundos Iniciais: " + tempoInicial2);
		
		System.out.println("posição: " + node.findIndex(arrayDeinteiros[20001]));
		
		var tempoFinal2 = System.currentTimeMillis();
		System.out.println("Final: " + tempoFinal);
		System.out.println("O Algoritimo foi executado em " + (tempoFinal2 - tempoInicial2));
		*/
	}
	private static void ordenaArray() {
		Integer menor=0;
		for(int i = 0; i < arrayDeinteiros.length; i++) {
			menor = node.findLess(menor);
			arrayOrdenado[i]=menor;
		}
		
		//for(int i = 0; i < arrayDeinteiros.length; i++) {
		//	System.out.println(arrayOrdenado[i]);
		//}
		
	}
	private static void criaArvoreBinaria() {
		
		for(int i = 0; i < arrayDeinteiros.length; i++) {
			if(i==0) {
				node = new Node(arrayDeinteiros[i], i);
			}else {
				node.add(arrayDeinteiros[i], i);
			}
		}
		
	}
	public static void imprimeTempoInicial(String metodo) {
		tempoInicial = System.currentTimeMillis();
		System.out.println(metodo + "Mili Segundos Iniciais: " + tempoInicial);
	}
	public static void ImprimeTempoFinal(String metodo) {
		tempoFinal = System.currentTimeMillis();
		System.out.println(metodo + "Tempo Final: " +tempoFinal+ "- O Algoritimo foi executado em " + (tempoFinal - tempoInicial));
	}
	public static void preencheArray() {
		Set<Integer> numbers = new HashSet<>();
		Random r = new Random();
		while (numbers.size() < 50000) {
		    numbers.add(r.nextInt(500000));
		}
		Integer[] a = new Integer[numbers.size()];
		arrayDeinteiros = numbers.toArray(a);
		
		//for (int i = 0; i < arrayDeinteiros.length; i++) {
		//	arrayDeinteiros[i] = new Random().nextInt(1000000);
		//}
	}
}

class Node{
	Integer data;
	Integer index;
	Node left;
	Node right;
	
	Node(Integer data, Integer index){
		this.data = data;
		this.index = index;
	}
	
	void add(Integer numberToAdd, Integer index) {
		if(numberToAdd > data) {
			if(right != null) {
				right.add(numberToAdd, index);
			}else {
				right = new Node(numberToAdd, index);
			}
		}else {
			if(left != null) {
				left.add(numberToAdd, index);
			}else {
				left = new Node(numberToAdd, index);
			}
		}
	}
	Integer findIndex(Integer numberToFind) {
		if(numberToFind == data) return index;
		if(numberToFind > data) {
			if(right != null)
			return right.findIndex(numberToFind);
		}else {
			if(left !=null)
			return left.findIndex(numberToFind);	
		}
		return null;
	}
	
	Integer findLess() {
		if(left !=null) {
			return left.findLess();
		}else {
			return data;
		}
	}
	Integer findLess(Integer entrada) {
		if(entrada < data) {
			if(left !=null) {
				Integer a = left.findLess(entrada);
				if(a==null && entrada < data) {
					return data;
				}else {
					return a;
				}
			}else {
				return data;
			}
		}else {
			if(right != null) {
				return right.findLess(entrada);
			}else {
				return null;
			}
		}
		
	}
}
