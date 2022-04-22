package restaurante;

public class ListaMesas {
	private Mesa inicio;
	
	public ListaMesas (int num) {
		inicio = new Mesa(num);
	}

	public Mesa getInicio() {
		return inicio;
	}

	public void setInicio(Mesa inicio) {
		this.inicio = inicio;
	}
	
	public void inserirInicio(int num) {
		Mesa novoMesa = new Mesa(num); 
		novoMesa.setProx(inicio);
		inicio = novoMesa;
	}
	
	public void inserirFinal (int num) {
		Mesa novoMesa = new Mesa(num);
		Mesa aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
			aux.setProx(novoMesa);
		}
		
	}
	
	public String mostraLista () {
		String lista = "";
		Mesa aux = inicio;
		while (aux != null) {
			lista+=aux.getNum()+", ";
			aux=aux.getProx();
		}
		
		return lista;
		
	}
	
	public void deleteComValor(int valor) {
		if (inicio == null) return;
		if (inicio.getNum() == valor) {
			inicio = inicio.getProx();
			return;
		}
		Mesa aux = inicio;
		while (aux != null) {
			if (aux.getProx().getNum() == valor) {
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
		Mesa aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
			if (aux.getProx().getProx() == null) {
				aux.setProx(null);
			}
			
		}
	}

	public int contaTodos () {
		int i = 0;
		Mesa aux = inicio;
		while (aux.getProx() != null) {
			aux = aux.getProx();
			i++;
		}
		return i;
	}
	
	public int achaValor (int valor) {
		Mesa aux = inicio;
		int i = 0;
		if (inicio == null) return -1;
		if (inicio.getNum() == valor) return i = 0;
		while (aux != null) {
			i++;
			if (aux.getNum() == valor) {
				return i;
			}		
		}
		return -1;
	}
	
	public boolean temMesa() {
		Mesa aux = inicio;
		if (inicio == null) return false;
		while (aux != null) {
			if (aux.isVazia()) return true;
			aux = aux.getProx();
		}
		return false;
	}
	
	public int ocuparMesa() {
		Mesa aux = inicio;
		while (aux != null) {
			if (aux.isVazia()) {
				aux.setVazia(false);
				return aux.getNum();
			}
			aux = aux.getProx();
		}
		return -1;
	}
	
	public void desocuparMesa(int numMesa) {
		Mesa aux = inicio;
		while (aux != null) {
			if (aux.getNum() == numMesa) {
				aux.setVazia(true);
			}
			aux = aux.getProx();
		}
	}
	
	public int qtdVazias () {
		Mesa aux = inicio;
		int i = 0;
		while (aux != null) {
			if(aux.isVazia()) {
				i++;
			}
			aux = aux.getProx();
		}
		return i;
	}
	

}
