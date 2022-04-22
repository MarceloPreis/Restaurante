package restaurante;

public class ClienteMesas {
	private Comanda inicio;
	
	public ClienteMesas (int cod, String nome) {
		inicio = new Comanda(cod, nome);
	}

	public Comanda getInicio() {
		return inicio;
	}

	public void setInicio(Comanda inicio) {
		this.inicio = inicio;
	}
	
	public void inserirInicio(int cod, String nome, double valor, int numMesa) {
		Comanda novoComanda = new Comanda(cod, nome); 
		novoComanda.setProx(inicio);
		inicio = novoComanda;
		inicio.setNumMesa(numMesa);
		inicio.setValor(valor);
		System.out.println(cod+" - "+nome+". Sentou-se na mesa "+numMesa+". Valor da comanda: "+valor);
	}
	
	public String mostraLista () {
		String lista = "";
		Comanda aux = inicio;
		while (aux != null) {
			lista+=aux.getCod()+", ";
			aux=aux.getProx();
		}
		
		return lista;
		
	}
	
	public void deleteComValor(int valor) {
		if (inicio == null) return;
		if (inicio.getCod() == valor) {
			inicio = inicio.getProx();
			return;
		}
		Comanda aux = inicio;
		while (aux != null) {
			if (aux.getProx().getCod() == valor) {
				aux.setProx(aux.getProx().getProx());
				return;
			}
			aux = aux.getProx();
		}
	}

	public void deletePrimeiro ( ) {
		inicio = inicio.getProx();
	}
	
	public void deleteUltimo () {
		Comanda aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
			if (aux.getProx().getProx() == null) {
				aux.setProx(null);
			}
			
		}
	}

	public int contaTodos () {
		int i = 0;
		Comanda aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
			i++;
		}
		return i;
	}
	
	public Comanda achaValor (int valor) {
		Comanda aux = inicio;
		int i = 0;
		if (inicio == null) return null;
		if (inicio.getCod() == valor) return inicio;
		while (aux != null) {
			i++;
			if (aux.getCod() == valor) {
				return aux;
			}		
		}
		return null;
	}
}
