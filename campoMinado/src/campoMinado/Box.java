package campoMinado;

import java.util.ArrayList;

public class Box {

	boolean minado;
	boolean revelado;
	boolean clicado;
	boolean marcado;
	ArrayList<Box> vizinho;
	JButtonEspaco button;

	public Box() { /* CONVERSOR INICIADO COM VALORES FALSE */
		this.minado = false;
		this.revelado = false;
		this.clicado = false;
		this.marcado = false;
		this.vizinho = new ArrayList<Box>();
	}

	public boolean minar() { /*
								 * METODO VERIFICA SE CAMPO ESTA MINADO SE SIM RETORNA VERDADEIRO SE NÃO FALSO
								 */

		if (!this.minado) {
			this.minado = true;
			return true;
		} else {
			return false;
		}

	}

	public boolean marcar() { /*
								 * VERIFICA SE CAMPO ESTA MARCADO INICIA COMO FALSO SE FOR MARCADO RETORNA
								 * VERDADEIRO
								 */

		boolean marcado = this.marcado;
		marcado = !marcado;
		return marcado;

	}

	public void addVizinho(Box e) { /* METODO ADICIONA VIZINHOS ALEATORIOS AO CAMPO EM QUESTÃO */
		this.vizinho.add(e);
	}

	public int numDeMinasVizinhas() { /* CONTADOR DE MINAS VIZINHAS RETORNANDO A QUANTIA */
		int i = 0;
		for (Box elem : this.vizinho) {
			if (elem.minado)
				i++;
		}
		return i;

	}

	public int clicar() {  /*METODO DE CLIQUE SE FOR MINADO RETORNA -1 SENÃO RETORNA O NUMERO DE MINAS*/
		if (this.minado) {
			return -1;
		} else {
			return numDeMinasVizinhas();
		}
	}

	

	public boolean finalizar() {
		if (this.minado && this.marcado)
			return true;
		if (!this.minado && !this.marcado)
			return true;
		return false;
	}

	public void setButtonEspaco(JButtonEspaco jb) {
		this.button = jb;
	}

	@Override
	public String toString() {
		if (this.minado)
			return " -1";
		return "+" + this.numDeMinasVizinhas();

	}

}
