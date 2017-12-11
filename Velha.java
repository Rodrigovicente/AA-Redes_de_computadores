
public class Velha {
	
	int tabela[][];
	int sizeX;
	int sizeY;
	int sizeSeq;

	Velha() {
		this.sizeX = 3;
		this.sizeY = 3;
		this.sizeSeq = 3;
		tabela = new int[3][3];
		
		for(int i = 0; i < sizeX; i++) {
			for(int j = 0; j < sizeY; j++) {
				this.tabela[i][j] = 0;
			}
		}
	}
	
	Velha(int sizeM, int sizeSeq) {
		this.sizeX = sizeM;
		this.sizeY = sizeM;
		this.sizeSeq = (sizeSeq <= sizeM)?sizeSeq:sizeM;
		
		tabela = new int[sizeX][sizeY];
		
		for(int col = 0; col < sizeX; col++) {
			for(int lin = 0; lin < sizeY; lin++) {
				this.tabela[lin][col] = 0;
			}
		}
	}

	// 0 = vazio
	// 1 = X
	// 2 = O
	
	boolean putX(int x, int y) {
		if(x < this.sizeX && y < this.sizeY) {
			if(this.tabela[x][y] == 0) {
				this.tabela[x][y] = 1;
				printTabela();
				
				int estado = checkFim(1);
				if(estado != 0) {
					if(estado == 1) {
						System.out.println("Fim de jogo. Deu VELHA.");
					} else {
						System.out.println("Vitória! O 'X' VENCEU!");
					}
				}
				
				return true;
			} else {
				System.out.println("Posicao já ocupada");
				return false;
			}
		} else {
			System.out.println("Posicao fora da matriz");
			return false;
		}
	}
	

	boolean putO(int x, int y) {
		if(x < this.sizeX && y < this.sizeY) {
			if(this.tabela[x][y] == 0) {
				this.tabela[x][y] = 2;
				printTabela();
				
				int estado = checkFim(1);
				if(estado != 0) {
					if(estado == 1) {
						System.out.println("Fim de jogo. Deu VELHA.");
					} else {
						System.out.println("Vitória! O 'O' VENCEU!");
					}
				}
				
				return true;
			} else {
				System.out.println("Posicao já ocupada");
				return false;
			}
		} else {
			System.out.println("Posicao fora da matriz");
			return false;
		}
	}
	
	int checkVitoria() {
		int countSeq = 0;
		int lin, col, aux;
		
		for(col = 0; col < sizeX; col++) {
			for(lin = 0; lin < sizeY; lin++) {
				if(this.tabela[lin][col] != 0) {				
					
					if((lin + this.sizeSeq) <= this.sizeY) {
						for(aux = 0; aux <= this.sizeSeq; aux++) {
							if(this.tabela[lin+aux][col] == this.tabela[lin][col]) {
								countSeq++;
								if(countSeq >= this.sizeSeq) {
									if(this.tabela[lin][col] == 1)
										System.out.println("Vitória de X");
									else
										System.out.println("Vitória de O");
									
									return this.tabela[lin][col];
								}
							} else {
								break;
							}
						}
						countSeq = 0;
					}
				
					if((col + this.sizeSeq) <= this.sizeX) {
						for(aux = 0; aux <= this.sizeSeq; aux++) {
							if(this.tabela[lin][col+aux] == this.tabela[lin][col]) {
								countSeq++;
								if(countSeq >= this.sizeSeq) {
									if(this.tabela[lin][col] == 1)
										System.out.println("Vitória de X");
									else
										System.out.println("Vitória de O");
									
									return this.tabela[lin][col];
								} else {
									break;
								}
							}
						}
						countSeq = 0;
					}
				}
			}
		}
		
		return 0;
	}
	
	int checkFim(int player) {
		
		int vencedor = checkVitoria();
		
		if(player == vencedor) {
			return 2;
		} else {
			for(int col = 0; col < sizeX; col++) {
				for(int lin = 0; lin < sizeY; lin++) {
					if(this.tabela[lin][col] == 0) {
						return 0;
					}
				}					
			}
			return 1;
		}
	}
	
	String stringTabela() {
		String result = "  _   _   _ \n";
		String player;
		
		result += "| ";
		for(int lin = 0; lin < sizeY; lin++) {
			for(int col = 0; col < sizeX; col++) {
				if(this.tabela[lin][col] != 0) {
					if(this.tabela[lin][col] == 1)
						player = "X";
					else
						player = "O";
					result += player;
				} else
					result += " ";
				
				result += " | ";
			}
			result += "\n  _   _   _ \n| ";
			
		}
		
		return result;
	}
	
	void printTabela() {
		System.out.println(this.stringTabela());
	}
	
	
	
	public static void main(String[] args) {
		Velha jogo = new Velha();

		jogo.putX(1, 1);
		jogo.putO(0, 2);
		jogo.putX(1, 0);
		jogo.putO(1, 2);
		jogo.putX(2, 1);
		jogo.putO(2, 2);
		
		
	}
}
