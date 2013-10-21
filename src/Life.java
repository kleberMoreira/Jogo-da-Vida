class Life {
		int MAX = 10;									//Tamanho da matriz
		int [][] matriz = new int[MAX][MAX];			//Instanciação da matriz matriz
		
		void inicializa()
		{
			int i, j;
			
			for(i=1; i < MAX-1; i++)
				for(j=1; j < MAX-1; j++)
					matriz[i][j] = (int)(Math.random() * 1.5);
		}
		
		void imprimeTabuleiro()
		{
			int i, j;
			
			for(i=0; i < MAX; i++)
			{
				for(j=0; j < MAX; j++)
					if(matriz [i][j] == 1)
						System.out.println("*");
					else
						System.out.println(".");
				System.out.println();
			}
			
		System.out.println();
		}		
		
		int vizinhos(int i, int j)
		{
			return matriz[i-1][j-1] + matriz[i-1][j] + matriz[i-1][j+1] + 
					matriz[i][j-1] + matriz[i][j+1] +
					matriz[i][j-1] + matriz[i+1][j] + matriz[i+1][j+1];
		}
		
		int [][] iteracao()
		{
			int [][] aux = new int [MAX][MAX];
			int i,j;
			
			for(i=1; i<MAX-1; i++)
				for(j=1; j<MAX-1; j++)
					{
						if(matriz[i][j] == 1)
						{
							if((vizinhos(i, j) < 2) || (vizinhos(i, j) > 3))
								aux[i][j] = 0;					//Morre
							else
								aux[i][j] = 1;					//Continua vivo
						}
			
						else
						{
							if(vizinhos(i, j) == 3)
								aux[i][j] = 1;				//Aparece vida
							else 
								aux[i][j] = 0; 			//Continua como estava
						}		
					}
			return aux;
		}
		
		void simulaVida(int qtde)
		{
			int i;
			
			//faremos a simulação de quantos ciclos
			
			for(i = 0; i < qtde; i++)
			{
				imprimeTabuleiro();
				matriz = iteracao();
			}
		}
}
