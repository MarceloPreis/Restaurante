package restaurante;

public class FilaBuffet extends FilasClientes {
	
	public FilaBuffet(int limite) {
		super(limite);
	}
	
	public void remover() {
		if(tamanho > 0) {
			if(tamanho == 1){
				inicio=null;
				fim=null;
			}else inicio = inicio.getProx();
			tamanho --;
		}else System.out.println("Fila Vazia");	
	}
}
