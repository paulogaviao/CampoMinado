package campoMinado;


public class CampoMinado {

	public static void main(String[] args) {
        CampoMatriz campo = new CampoMatriz();/*INICIALIZA O CAMPO DE MATRIZES*/
        campo.addMina();/*ADICIONA MINAS AOS CAMPOS*/
		Tela tela = new Tela(campo); /*APRESENTA A TELA AO USUÁRIO*/
	
		
	}

	
	
}