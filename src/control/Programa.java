package control;

import java.util.Random;
import java.util.Scanner;

public class Programa {

	/**
	 * exemplo de Javadoc
	 * @param args
	 */
	public static void main(String[] args) {
			Scanner leia = new Scanner(System.in);
			System.out.println("Digite o valor mínimo: ");
			int min = leia.nextInt();
			System.out.println("Digite o valor máximo: ");
			int max = leia.nextInt();
			int vet[] = testeClassesEquivalentes(min, max);
			leia.close();
		}

		public static int[] testeClassesEquivalentes (int min, int max) {
			Random gerador = new Random();
			int valorInferiorInvalido = gerador.nextInt(min);
			int valorValido = gerador.nextInt((max+1)-min) + min;
			int valorSuperiorInvalido = gerador.nextInt(2147483647-(max+1))+(max+1);
			
			int vet[] = {valorInferiorInvalido, valorValido, valorSuperiorInvalido};
			for (int i=0; i < vet.length; i++){
				System.out.println("Dado de Teste " + (i+1) + ": " + vet[i]);
			}
			return vet;
		}

}
