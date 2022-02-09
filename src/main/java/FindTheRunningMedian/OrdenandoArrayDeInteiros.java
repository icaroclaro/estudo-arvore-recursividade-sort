package FindTheRunningMedian;

import java.util.Random;

public class OrdenandoArrayDeInteiros {
	static Integer[] arrayDeinteiros = new Integer[50000];

	public static void main(String[] args) {
		
		preencheArray();

		for (Integer i : arrayDeinteiros) {
			System.out.print(i + " ");
		}
		System.out.println("");

		System.out.println("Inicial com TrocasLaterais");
		var tempoInicial = System.currentTimeMillis();
		System.out.println("Mili Segundos Iniciais: " + tempoInicial);
		
		ordenarComTroca();
		
		var tempoFinal = System.currentTimeMillis();
		System.out.println("Mili Segundos Finais: " + tempoFinal);
		System.out.println("O Algoritimo foi executado em " + (tempoFinal - tempoInicial));
		
		
		
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println();

		preencheArray();
		
		System.out.println("Inicial com BUSCAMENOR");
		var tempoInicial2 = System.currentTimeMillis();
		System.out.println("Mili Segundos Iniciais: " + tempoInicial2);

		ordenarComBuscaMenor();

		var tempoFinal2 = System.currentTimeMillis();
		System.out.println("Mili Segundos Finais: " + tempoFinal);
		System.out.println("O Algoritimo foi executado em " + (tempoFinal2 - tempoInicial2));
	}

	public static void ordenarComTroca() {
		int i = 1;
		while (i < arrayDeinteiros.length - 1) {
			Integer aux = 0;

			if (arrayDeinteiros[i] > arrayDeinteiros[i + 1]) {
				aux = arrayDeinteiros[i];
				arrayDeinteiros[i] = arrayDeinteiros[i + 1];
				arrayDeinteiros[i + 1] = aux;
			}
			if (i > 0) {
				if (arrayDeinteiros[i] < arrayDeinteiros[i - 1]) {
					aux = arrayDeinteiros[i];
					arrayDeinteiros[i] = arrayDeinteiros[i - 1];
					arrayDeinteiros[i - 1] = aux;
					i = i - 2;
				}
			}
			i++;
		}
	}
	public static void ordenarComBuscaMenor() {
		for (int i = 0; i < arrayDeinteiros.length; i++) {
			int menor = buscaMenor(arrayDeinteiros, i, arrayDeinteiros.length);
			int aux = arrayDeinteiros[i];
			arrayDeinteiros[i] = arrayDeinteiros[menor];
			arrayDeinteiros[menor] = aux;
		}
	}

	public static int buscaMenor(Integer[] arrayInt, int inicio, int termino) {
		Integer menor = inicio;

		for (int atual = inicio; atual < termino; atual++)
			if (arrayInt[atual] < arrayInt[menor]) {
				menor = atual;
			}
		return menor;
	}

	public static void preencheArray() {
		for (int i = 0; i < arrayDeinteiros.length; i++) {
			arrayDeinteiros[i] = new Random().nextInt(500000);
		}
	}
}
