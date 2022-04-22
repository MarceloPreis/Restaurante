package restaurante;

public class FilasClientes {
	protected Comanda inicio = null;
	protected Comanda fim = null;
	private int limite = 0;
	protected int tamanho = 0;
	
	public FilasClientes(int limite) {
		this.limite = limite;
	}
	public int getTamanho() {
		return tamanho;
	}
	
	public boolean temEspaco() {
		return limite > tamanho;
	}
	
	public boolean estaVazio() {
		return tamanho == 0;
	}
	
	public void inserir(String nome, int cod) {
		if (temEspaco()) {
			Comanda novoItem = new Comanda(cod, nome);
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
	
	public void remover() {
		if(tamanho > 0) {
			System.out.println(inicio.getCod()+" removido da Fila");
			if(tamanho == 1){
				inicio=null;
				fim=null;
			}else inicio = inicio.getProx();
			tamanho --;
		}else System.out.println("Fila Vazia");	
	}
	
	public Comanda getInicio() {
		if(!estaVazio()) return inicio;
		else return null;
	}
	
	public int getCodInicio() {
		if(!estaVazio()) return inicio.getCod();
		else { 
			System.out.println("Está vazia");
			return -1;
		}	
	}
	
	public String getNomeInicio() {
		if(!estaVazio()) return inicio.getNomeCliente();
		else { 
			return ("Está vazia");
		}	
	}

}
