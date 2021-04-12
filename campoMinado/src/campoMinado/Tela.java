package campoMinado;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel painel = new JPanel();
	JButtonEspaco[][] botao;
	CampoMatriz c;

	public Tela(CampoMatriz c) { /*CONFIGURAÇÃO DA TELA COM JFRAME*/
		this.c = c;
		this.painel = new JPanel();
		this.add(painel);
		this.painel.setLayout(null);
		botao = new JButtonEspaco[AdminLC.NUM_LINHA][AdminLC.NUM_COLUNA];

		this.setVisible(true);
		this.setSize(700, 710);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < AdminLC.NUM_LINHA; i++) {
			for (int j = 0; j < AdminLC.NUM_COLUNA; j++) {
				botao[i][j] = new JButtonEspaco(this.c , this);

				botao[i][j].posicao(i, j);
				botao[i][j].setSize(45, 44);
				botao[i][j].setLocation(45 * i, 45 * j);

				painel.add(botao[i][j]);
			}
		}
	}

}
