package restaurante;

public class PilhaPrato {
	private Prato topo;
	private int tamanho = 0;
	private int limite = 0;
	
	public PilhaPrato (int limite) {
		this.limite = limite;
		
	}
	
	public boolean estaVazio() {
		return tamanho == 0;
	}
	
	public boolean temEspaco () {
		return limite > tamanho;
	}
	
	
	public void push(int dado) {
		if (temEspaco()) {
			Prato novoItem = new Prato(dado);
			novoItem.setProx(topo);
			topo = novoItem;
			tamanho ++;
		}else{
			System.out.println("Pilha de pratos está cheia Cheia");
		}		
	}
	
	public void pop() {
		if (!estaVazio()) {
			System.out.println("1 prato foi retirado da pilha");
			topo = topo.getProx();
			tamanho --;
		}else {
			System.out.println("A pilha está vazia");
		}
	}
	
	public int getTop() {
		return topo.getDado();
	}
}
