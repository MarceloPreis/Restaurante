package restaurante;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		FiladeChegada chegada = new FiladeChegada(20);
		FilaBuffet buffet = new FilaBuffet(20);
		FilaCaixa caixa = new FilaCaixa(20);
		PilhaPrato pratos = new PilhaPrato(20);
		ListaMesas mesas = new ListaMesas(1);
		ClienteMesas clienteMesa = new ClienteMesas(0, null);
		clienteMesa.deletePrimeiro();
		double valorTotal = 0;
		int clienteTotal = 0;
		
		for (int i = 0; i < 19; i++) {
			mesas.inserirInicio(i);
		}
		
		int selected;
		
		do {
			selected = MenuData();
			switch (selected) {
			case 1:
				System.out.println("Qual é o nome do cliente?");
				String nome;
				nome = in.next();
				System.out.println("Código da comanda?");
				int cod;
				cod = in.nextInt();
				chegada.inserir(nome, cod);
				System.out.println("\n Adicionado(a) a fila de Entrada");
				break;
			case 2:
				if (!pratos.estaVazio()) {
					buffet.inserir(chegada.getNomeInicio(), chegada.getCodInicio());
					chegada.remover();
					pratos.pop();
					System.out.println("\n Adicionado(a) a fila do buffet");
				}else System.out.println("Acabou os Pratos");
				break;
			case 3:
				System.out.println("Qual é o valor da comanda?");
				double valor; 
				valor = in.nextDouble();
				if (mesas.temMesa()) {
					clienteMesa.inserirInicio(buffet.getCodInicio(), buffet.getNomeInicio(), valor, mesas.ocuparMesa());
					buffet.remover();	
				}else System.out.println("\n Não há mesas disponíveis");
				break;
			case 4: 
				System.out.println("Qual é o Código da comanada?");
				int codComanda;
				codComanda = in.nextInt();
				caixa.inserir(clienteMesa.achaValor(codComanda).getCod(), 
													clienteMesa.achaValor(codComanda).getNomeCliente(), 
													clienteMesa.achaValor(codComanda).getNumMesa(), 
													clienteMesa.achaValor(codComanda).getValor());
				mesas.desocuparMesa(clienteMesa.achaValor(codComanda).getNumMesa());
				clienteMesa.deleteComValor(codComanda);
				System.out.println("\n O Cliente desocupou a mesa e passou para o Caixa");
				break;
			case 5:
				valorTotal+= caixa.getInicio().getValor();
				clienteTotal ++;
				caixa.remover();
				System.out.println("\n Volte sempre");
				break;
			case 6:
				System.out.println("1 - Quntos clientes na fila de chegada");
				System.out.println("2 - Quntos clientes na fila ddo buffet");
				System.out.println("3 - Quntos estão comendo");
				System.out.println("4 - Quantos clientes na fila do caixa");
				System.out.println("5 - Valor total");
				System.out.println("6 - Total de clientes atendidos");
				System.out.println("7 - Quantidade de mesas livres");				
				
				int op;
				op = in.nextInt();
				
				switch(op) {
				case 1: 
					System.out.println(chegada.getTamanho());
					break;
				case 2:
					System.out.println(buffet.getTamanho());
					break;
				case 3:
					System.out.println(clienteMesa.contaTodos());
					break;
				case 4:
					System.out.println(caixa.getTamanho());
					break;
				case 5:
					System.out.println(valorTotal);
					break;
				case 6:
					System.out.println(clienteTotal);
					break;
				case 7:
					System.out.println(mesas.qtdVazias());
					break;
				}
				break;
			case 7:
				System.out.println("Quer adicionar quantos pratos?");
				int qtd;
				qtd = in.nextInt();
				for (int i = 0; i < qtd; i++) {
					pratos.push(i);
				}
				System.out.println(qtd+" pratos adicionados na pilha");
				break;
			case 8:
				System.out.println("Encerrando");
				break;
			}			
		} while(selected < 8);
		
		
	}
		
		public static int MenuData() {
			Scanner in = new Scanner(System.in);
			int op;
 
			System.out.print("\n Restaurante\n");
			System.out.print("| Opção 1 - Nova Comanda      			                  \n");
			System.out.print("| Opção 2 - Passar cliente da fila de chegada para o buffet \n");
			System.out.print("| Opção 3 - Passar cliente do buffet para a mesa            \n");
			System.out.print("| Opção 4 - Passar cliente da mesa para o caixa             \n");
			System.out.print("| Opção 5 - Liberar cliente do caixa                        \n");
			System.out.print("| Opção 6 - Realtórios                                      \n");
			System.out.print("| Opção 7 - Adicionar pratos                                \n");
			System.out.print("| Opção 8 - Sair                                            \n");
			
			System.out.print("Digite uma opção: ");
			
			op = in.nextInt();
			return op;
			
			
		}

}
