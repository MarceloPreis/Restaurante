package restaurante;

public class Mesa {
	private boolean vazia;
	private Mesa prox;
	private int num;
	
	public Mesa(int num) {
		this.num = num;
		this.vazia = true;
		this.prox = null;
	}

	public boolean isVazia() {
		return vazia;
	}

	public void setVazia(boolean vazia) {
		this.vazia = vazia;
	}

	public Mesa getProx() {
		return prox;
	}

	public void setProx(Mesa prox) {
		this.prox = prox;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	
}
