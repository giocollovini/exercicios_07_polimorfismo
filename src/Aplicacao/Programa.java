package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produto;
import entidades.ProdutoImportado;
import entidades.ProdutoUsado;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Produto> list = new ArrayList<>();
		
		System.out.print("Enter com o número de Produtos: ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Produto #" + i + " data:");
			System.out.print("Comum, Usado ou Importado (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Preço: ");
			double preco = sc.nextDouble();
			if (ch == 'i') {
				System.out.print("Taxa Alfandegária: ");
				double valortaxa = sc.nextDouble();
				list.add(new ProdutoImportado(nome, preco, valortaxa));
			}
			else if (ch == 'u') {
				System.out.print("Data de Fabricação (dd/mm/yyyy): ");
				Date dataFabricacao = sdf.parse(sc.next());		
				list.add(new ProdutoUsado(nome, preco, dataFabricacao));				
			}
			else {
				list.add(new Produto(nome, preco));
			}
		}
		
		System.out.println();
		System.out.println("ETIQUETA DE PREÇOS:");
		for (Produto prod : list) {
			System.out.println(prod.etiquetaPreco());
		}
		
		sc.close();

		

	}

}
