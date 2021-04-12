package campoMinado;

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonEspaco extends JButton {
	private static final long serialVersionUID = 1L;

	int linha;
	int coluna;
	CampoMatriz c;
	String text;
	Box e;
    Tela tela;
	public JButtonEspaco(CampoMatriz c , Tela t) { /*BOTÃO RECEBE A MATRIZ E A TELA AO EVENTO DE CLICAR */
		this.tela = t ;
		this.text = "";
		this.setText(text);
		this.c = c;
		this.addActionListener((ActionEvent evt) -> {

			pressionaBotao(evt);

		});
	}

	public void pressionaBotao(ActionEvent evt) { /* CHAMA O METODO CLICAR*/
		pressionar();
		
	}

	public void posicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.e = c.getPosicao(linha, coluna);
	}


	public void pressionar() {/*AO CLICAR REVELA UMA MINA OU A QUANTIA DE MINAS VIZINHAS*/
		
		
		int rt = e.clicar();
  
		this.text = Integer.toString(rt);
		if(this.text.equals("-1")) {
			try {
				Image img = ImageIO.read(getClass().getResource("minaxx.png"));
				this.setIcon(new ImageIcon(img));
				
			} catch (Exception e) {
				this.setText("X");
				System.out.println("Erro na leitura da imagem");
			}
		}
		
		
		
		this.setText(text);
		this.setEnabled(false);
	}

	
}
