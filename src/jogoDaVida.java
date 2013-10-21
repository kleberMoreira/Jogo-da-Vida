import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;


public class jogoDaVida {
	
	
	public static void main(String[] args) throws IOException
	{
		int vidas, coluna, linha, celulaViva = 0;
		
		//Preparação de leitura do teclado
		InputStreamReader leitorEntrada = new InputStreamReader(System.in);
		BufferedReader leitor = new BufferedReader(leitorEntrada);
		
		JOptionPane.showMessageDialog(null, "            Jogo da vida\n\n Clique em ok para continuar");
		
		System.out.println("Digite a quantidade de vidas desejadas: ");
		
		//Lendo a quantidade de vidas
		vidas = Integer.parseInt(leitor.readLine());
		
		while(vidas <= 0)
		{
			JOptionPane.showMessageDialog(null, "Erro!!!. Digite corretamente no console abaixo!!!");
				System.out.println("Digite a quantidade de vidas desejadas corretamente: ");
				//Lendo a quantidade de vidas
				vidas = Integer.parseInt(leitor.readLine());
		}
		Life jogo = new Life();
		
		jogo.inicializa();
				
		while(vidas > 0)
		{
			do{
			System.out.println("Digite a linha correspondente no intervalo de <1 a 8>:");
				linha = Integer.parseInt(leitor.readLine());
			System.out.println("Digite a coluna correspondente no intervalo de <1 a 8>:");
				coluna = Integer.parseInt(leitor.readLine());
				}while(linha < 1 || linha > 8 || coluna < 1 || coluna > 8);
		
			jogo.vizinhos(linha, coluna);
			
			if(jogo.matriz[linha][coluna] == 1)
			{
				JOptionPane.showMessageDialog(null, "Célula viva. Permanece no jogo");
				celulaViva++;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Célula morta, perdeu. \nImpressão do campo no console. \n2Tente novamente caso houver vidas");
				jogo.simulaVida(vidas);
				vidas--;
				jogo.inicializa();
				celulaViva = 0;
			}
		
			if(vidas == 0)
			{
				JOptionPane.showMessageDialog(null, "Acabaram as vidas.\nFim de jogo.\nImpressão do campo no console!!!");
					break;
			}
		
			if(celulaViva == 21)				//Quantidade estimada de células vivas no início do jogo para um campo com 80 casas
			{
				JOptionPane.showMessageDialog(null, "Parabéns. Você ganhou o jogo!!!");
				
			}
		}

	}
}

