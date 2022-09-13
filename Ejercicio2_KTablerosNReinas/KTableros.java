package kTableros2;

import java.util.ArrayList;
import java.util.Scanner;

public class KTableros {

	public static void main(String[] args) {
		
		int ktab;
		
		NReinas nreinas = new NReinas(8);
		nreinas.Soluciona();
		
		ArrayList<?> soluciones = nreinas.getSoluciones();
		
		//System.out.println("Introduce el número de tableros: ");
		
		Scanner teclado = new Scanner(System.in);
		ktab = teclado.nextInt();
		
		int[][][]ktablero = new int[ktab][8][8];
		
		//System.out.println("Introduce los tableros: ");
		
		for(int i = 0; i < ktab; i++) {
			for(int j = 0; j < 8; j++) {
				for(int k = 0; k < 8; k++) {
					ktablero[i][j][k] = teclado.nextInt();
				}
			}
		}
		teclado.close();
		
		//imprimeTablero(ktab, ktablero);
		max(soluciones, ktablero, ktab);

	}
	
	public static void max(ArrayList<?> soluciones, int[][][] tablero, int ktab) {
		
		int[]suma = new int[92];
		int[]v = new int[8];
		int max;
		int suma2;
		
		max = 0;
		for(int x = 0; x < ktab; x++) {	
			for(int i = 0; i < 92; i++) {
				for(int j = 0; j < soluciones.size(); j++) {
					
					suma2 = 0;
					v = (int []) soluciones.get(j);
					
					for(int k = 0; k < 8; k++) {
						
						suma2 = tablero[x][k][v[k]]+suma2;
					}
					suma[i] = suma2;
				}
				for(int l = 0; l < 92; l++) {
					
					if(suma[l] > max) {
						max = suma[l];
					}
				}
			}
			
		}
		System.out.println(max);
		
	}
	
/*	public static void imprimeTablero(int ktab, int[][][]tablero) {		
		
		for(int i = 0; i < ktab; i++) {
			System.out.println("......................");
			System.out.println("Tablero "+i);
			System.out.println("......................");
			
			for(int j = 0; j < 8; j++) {
				
				for(int k = 0; k < 8; k++) {
					
					if(tablero[i][j][k] < 10) {
						System.out.print(tablero[i][j][k] + "  ");
					}
					else {
						System.out.print(tablero[i][j][k] + " ");
					}
				}
				System.out.println();
			}
		}
		System.out.println("......................");
	}*/
	
}
