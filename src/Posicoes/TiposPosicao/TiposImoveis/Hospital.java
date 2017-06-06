package Posicoes.TiposPosicao.TiposImoveis;


import Jogadores.Jogador;
import Posicoes.TiposPosicao.Imovel;

/**
 * Representa um imovel do tipo hospital no tabuleiro
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Hospital extends Imovel {
	/**
	 * Incializa Hospital
	 * @param Banco Dono incial do imovel
	 * @param Valor Valor incial do imovel
	 * @param TaxaAluguel Taxa de aluguel do imovel
	 */
	public Hospital(Jogador Banco, Integer Valor, Integer TaxaAluguel){
		dono 		 = Banco;
		valor 		 = Valor;
		tipoImovel 	 = "Hospital";
		taxaAluguel  = valor*(TaxaAluguel/100);
		id          += 5;
	}
}
