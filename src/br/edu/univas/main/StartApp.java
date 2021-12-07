package br.edu.univas.main;

import java.util.Scanner;
import vo.Veiculo;

public class StartApp {
	public static int contV = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Veiculo[] veiculo$ = new Veiculo[50];
		int op;
		do {
			op = menu(in);
			switch(op) {
				case 1:{
					cadastrar(in, veiculo$);
					break;
				}
				case 2:{
					listar(veiculo$);
					break;
				}
				case 3:{
					apagar(in, veiculo$);
					break;
				}
			}
			System.out.println("-----------------------------");
		}while(op != 4);
		System.out.println("Até mais!");
	}
	public static int menu(Scanner in) {
		System.out.print(""
				+ "[1] Cadastro de cliente\n"
				+ "[2] Listar todos os veículos\n"
				+ "[3] Remover um veículo cadastrado\n"
				+ "[4] Sair\n>>");
		int op = in.nextInt();
		while(op < 1 || op > 4) {
			System.out.print("Por favor, digite uma opção do menu.\n>>");
			op = in.nextInt();
		}
		in.nextLine();
		return op;
	}
	public static void cadastrar(Scanner in, Veiculo[] veiculo$) {
		if(contV == 49) {
			System.out.println("Limite de 50 cadastros alcançado.");
		}
		else {
			System.out.println("--------Cadastro--------");
			Veiculo v = new Veiculo();
			System.out.print("Marca: ");
			v.marca = in.nextLine();
			System.out.print("Cor:");
			v.cor = in.nextLine();
			System.out.print("Ano de fabricação:");
			v.anoFabricacao = in.nextInt();
			System.out.print("Ano modelo:");
			v.anoModelo = in.nextInt();
			System.out.print("Motor:\n-Potência:");
			v.motor.potencia = in.nextFloat();
			System.out.print("-Cilindros:");
			v.motor.cilindros = in.nextInt();
			int p = procuraNull(veiculo$);
			veiculo$[p] = v;
			contV++;
		}
	}
	public static void listar(Veiculo[] veiculo$) {
		int contNull = 0;
		System.out.println("---------Cadastrados---------");
		if(contV == 0) {
			System.out.println("Não há veículos cadastrados ainda.");
		}
		else {
			for(int i = 0; i <= contV;i++) {
				if(veiculo$[i] != null) {
					System.out.println("-----------------------------");
					Veiculo v = veiculo$[i];
					System.out.println("Marca: "+v.marca);
					System.out.println("Cor: "+v.cor);
					System.out.println("Ano de fabricação: "+v.anoFabricacao);
					System.out.println("Ano modelo: "+v.anoModelo);
					System.out.println("Motor:\n"
							+ "-Pontência: "+v.motor.potencia+"\n"
							+ "-Cilindros: "+v.motor.cilindros);
				}
				else {
					contNull++;
				}
			}
			if(contNull == (contV + 1)) {
				System.out.println("Não há veículos cadastrados.");
			}
		}
	}
	public static void apagar(Scanner in, Veiculo[] veiculo$) {
		System.out.println("-----------Remover-----------");
		Veiculo vRemover = new Veiculo();
		int iRemover = 0;
		System.out.println("Informe as especificações do veículo a remover:");
		System.out.print("Marca: ");
		vRemover.marca = in.nextLine();
		System.out.print("Cor:");
		vRemover.cor = in.nextLine();
		System.out.print("Ano de fabricação:");
		vRemover.anoFabricacao = in.nextInt();
		System.out.print("Ano modelo:");
		vRemover.anoModelo = in.nextInt();
		System.out.print("Motor:\n-Potência:");
		vRemover.motor.potencia = in.nextFloat();
		System.out.print("-Cilindros:");
		vRemover.motor.cilindros = in.nextInt();
		in.nextLine();		
		for(int i = 0;i <= contV; i++) {
			Veiculo v = veiculo$[i];
			if(v != null) {
				if(v.marca.equalsIgnoreCase(vRemover.marca)) {
					iRemover++;
				}
				if(v.cor.equalsIgnoreCase(vRemover.cor)) {
					iRemover++;
				}
				if(v.anoFabricacao == vRemover.anoFabricacao) {
					iRemover++;
				}
				if(v.anoModelo == vRemover.anoModelo) {
					iRemover++;
				}
				if(v.motor.potencia == vRemover.motor.potencia) {
					iRemover++;
				}
				if(v.motor.cilindros == vRemover.motor.cilindros) {
					iRemover++;
				}
				if(iRemover == 6) {
					veiculo$[i] = null;
					System.out.println("Cadastro removido com sucesso.");
					break;
				}
			}
			
		}
	}
	public static int procuraNull (Veiculo[] veiculo$) {
		for(int i = 0;i <= contV; i++) {
			if(veiculo$[i] == null) {
				return i;
			}
		}
		return contV;
	}
}
