package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu {
	private int numberOfCases;
	private int testCase;
	
	public void showMenu() {
		System.out.println("\nSeleccione la opción que tu desees: ");
		System.out.println("[1] Jugar con las Torres de Hanoi:\n"+
		                   "[2] Salir del programa.\n");
	}
	
	public int readOption(BufferedReader br) throws NumberFormatException, IOException {
		int option = Integer.parseInt(br.readLine());
		return option;
	}
	
	public void doOption(BufferedReader br, int option) throws NumberFormatException, IOException {
		switch(option) {
		
		case 1:
			System.out.println("-------------------------------------------------------");
			System.out.println("                    TORRES DE HANOI");
			System.out.println("-------------------------------------------------------\n");
			readDisksData(br);
			break;
			
		case 2:
			System.out.println("Bye! ;)");
			br.close();
			break;

		default:
			System.out.println("Opción equivocada. Intenta de nuevo...");
			break;
			
		}
	}
	
	public void startProgram() throws NumberFormatException, IOException {
		int exit = 2;
		int option = 0;
		
		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			showMenu();
			option = readOption(br);
			doOption(br, option);
			
		}while(option != exit);
	}
	
	
	public void hanoi(int numberOfArches, int tower1, int tower2, int tower3){
		if(numberOfArches==1) {
			System.out.println("Moviendo de la torre de "+tower1+" a la torre "+tower3);
			
		}else {
			hanoi(numberOfArches-1, tower1, tower3, tower2);
			
			System.out.println("Moviendo de la torre de inicio "+tower1+" a la torre de destino "+tower3);
			hanoi(numberOfArches-1,tower2,tower1,tower3);
		}
	}
	
	public void readDisksData(BufferedReader br) throws NumberFormatException, IOException {

		System.out.println("Escribe (en valor entero) el numero de casos que quieres probar: ");
		numberOfCases = Integer.parseInt(br.readLine());
		int[] testCases = new int[numberOfCases];

		System.out.println("Escribe abajo en cada línea (en valores enteros) el número de arcos de cada caso:");

		for (int i = 0; i < testCases.length; i++) {
			testCase = Integer.parseInt(br.readLine());
			testCases[i] = testCase;
		}
		
		for(int j=0; j<testCases.length;j++) {
			System.out.println("---- CASO DE PRUEBA CON "+testCases[j]+" ARCOS ----");
			hanoi(testCases[j],1,2,3);
			System.out.println("Fin del juego!\n");
			System.out.println();
		}
	}
	
	
	
}
