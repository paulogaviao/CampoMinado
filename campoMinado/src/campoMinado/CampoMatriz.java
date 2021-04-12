package campoMinado;

import java.util.Random;

public class CampoMatriz {

	Box[][] matriz;

	public CampoMatriz() {

		matriz = new Box[AdminLC.NUM_LINHA][AdminLC.NUM_COLUNA];/*INICIA A MATRIZ COM NUMERO DE LINHAS E COLUNAS EXPECIFICADAS NO "AdminLC" */

		for (int i = 0; i < AdminLC.NUM_LINHA; i++) { /* CRIA O CAMPO COM O NUMERO DE i LINHAS E j COLUNAS*/
			for (int j = 0; j < AdminLC.NUM_COLUNA; j++) {
				matriz[i][j] = new Box();
			}
		}
		/*ADICIONA OS VIZINHOS */
		for (int i = 0; i < AdminLC.NUM_LINHA; i++) {
			for (int j = 0; j < AdminLC.NUM_COLUNA; j++) {
				if (i > 0) {
					if (j > 0)
						matriz[i][j].addVizinho(matriz[i - 1][j - 1]);
					matriz[i][j].addVizinho(matriz[i - 1][j]);
					if (j < AdminLC.NUM_COLUNA - 1)
						matriz[i][j].addVizinho(matriz[i - 1][j + 1]);
				}
				if (j > 0)
					matriz[i][j].addVizinho(matriz[i][j - 1]);
				if (j < AdminLC.NUM_COLUNA - 1)
					matriz[i][j].addVizinho(matriz[i][j + 1]);
				if (i < AdminLC.NUM_LINHA - 1) {
					if (j > 0)
						matriz[i][j].addVizinho(matriz[i + 1][j - 1]);
					matriz[i][j].addVizinho(matriz[i + 1][j]);
					if (j < AdminLC.NUM_COLUNA - 1)
						matriz[i][j].addVizinho(matriz[i + 1][j + 1]);
				}
			}
		}

	}
	
	public void addMina() { /*ADICIONA ALEATORIAMENTE AS MINAS NO CAMPO*/
		int n = AdminLC.NUM_MINAS;
		Random rand = new Random();
		while(n>0) {
			int l = rand.nextInt(AdminLC.NUM_LINHA);
			int c = rand.nextInt(AdminLC.NUM_COLUNA);
			if(matriz[l][c].minar()) {
				n--;
			}
		}
		
	}

	public int clicar(int i, int j ) { /*VERIFICA SE É MINA SENÃO RETORNA O NÚMERO DE MINAS VIZINHAS*/
		return matriz[i][j].clicar();
	}
	
	public boolean finalizar() { /*FINALIZA O PROCESSO CONFORME ENCONTRE UMA MINA*/
		for (int i = 0; i < AdminLC.NUM_LINHA; i++) {
			for (int j = 0; j < AdminLC.NUM_COLUNA; j++) {
				if(!matriz[i][j].finalizar())return false;
				
			}
		}
		return true;
	}
	public Box getPosicao(int l , int c) {
		return matriz[l][c];
	}
	
	@Override
	public String toString() {
		String st ="";
		for (int i = 0; i < AdminLC.NUM_LINHA; i++) {
			for (int j = 0; j < AdminLC.NUM_COLUNA; j++) {
				st += matriz[i][j]+"";
			}
			st +="\n";
		}
		return st;
	}
	
}
