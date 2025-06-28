package com.estoquegeral;

import com.estoquegeral.model.Estoque;
import com.estoquegeral.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class EstoqueGeralApplication implements CommandLineRunner {

	@Autowired
	private EstoqueService estoqueService;

	public static void main(String[] args) {
		SpringApplication.run(EstoqueGeralApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("--- Cadastro de Estoque ---");
		while (true) {
			Estoque estoque = new Estoque();

			System.out.print("Grupo (ou 'sair' para encerrar): ");
			String grupo = scanner.nextLine();
			if ("sair".equalsIgnoreCase(grupo)) break;
			estoque.setGrupo(grupo);

			System.out.print("Nome: ");
			estoque.setName(scanner.nextLine());

			System.out.print("Marca: ");
			estoque.setMark(scanner.nextLine());

			System.out.print("Descrição: ");
			estoque.setDescription(scanner.nextLine());

			System.out.print("Unidade: ");
			estoque.setUnit(scanner.nextLine());

			Double quantidade = null;
			while (quantidade == null) {
				System.out.print("Quantidade: ");
				try {
					quantidade = Double.parseDouble(scanner.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("Quantidade inválida. Tente novamente.");
				}
			}
			estoque.setQuantity(quantidade);

			System.out.print("Localização: ");
			estoque.setLocation(scanner.nextLine());

			try {
				estoqueService.save(estoque);
				System.out.println("Estoque cadastrado com sucesso!");
				System.out.println(estoque);
			} catch (Exception e) {
				System.out.println("Erro ao salvar no banco de dados: " + e.getMessage());
			}
			System.out.println();
		}
		System.out.println("Cadastro encerrado.");
	}
}