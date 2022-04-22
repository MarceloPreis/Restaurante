package restaurante;

public class FilaCaixa extends FilasClientes{	
	public FilaCaixa (int limite) {
		super(limite);
	}
	
	public void inserir(int cod, String nomeCliente, int numMesa, double valor) {
		if (temEspaco()) {
			Comanda novoItem = new Comanda(cod, nomeCliente);
			novoItem.setNumMesa(numMesa);
			novoItem.setValor(valor);
			System.out.println(novoItem.getCod()+" - "+novoItem.getNomeCliente()+" inserido na Fila");
			if(estaVazio()) {
				inicio=novoItem;
				fim=novoItem;
			}else {
				fim.setProx(novoItem);
				fim=novoItem;
			}
			tamanho++;
		}else System.out.println("Fila Cheia");
	}
}
