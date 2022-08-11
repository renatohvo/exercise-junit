package app;

import entities.Financing;

public class Program {

	public static void main(String[] args) {
		try {
			Financing f1 = new Financing(100000.0, 2000.0, 80);
			System.out.println("Primeiro Financiamento:");
			System.out.printf("Entrada: %.2f%n", f1.entry());
			System.out.printf("Prestação: %.2f%n", f1.quota());
		}
		catch (IllegalArgumentException e) {
			System.out.println("Erro no Primeiro Financiamento: " + e.getMessage());
		}
		
		try {
			Financing f2 = new Financing(100000.0, 2000.0, 90);
			System.out.println("\nSegundo Financiamento:");
			System.out.printf("Entrada: %.2f%n", f2.entry());
			System.out.printf("Prestação: %.2f%n", f2.quota());
		}
		catch (IllegalArgumentException e) {
			System.out.println("Erro no Segundo Financiamento: " + e.getMessage());
		}
		
		try {
			Financing f3 = new Financing(100000.0, 2000.0, 50);
			System.out.println("\nTerceiro Financiamento:");
			System.out.printf("Entrada: %.2f%n", f3.entry());
			System.out.printf("Prestação: %.2f%n", f3.quota());
		}
		catch (IllegalArgumentException e) {
			System.out.println("\nErro no Terceiro Financiamento: " + e.getMessage());
		}

	}

}
