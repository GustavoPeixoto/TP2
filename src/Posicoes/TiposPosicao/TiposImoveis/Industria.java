package Posicoes.TiposPosicao.TiposImoveis;

import Jogadores.Jogador;
import Posicoes.TiposPosicao.Imovel;

/**
 * Representa um imovel do tipo industria no tabuleiro
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Industria extends Imovel {
	/**
	 * Incializa Industria
	 * @param Banco Dono incial do imovel
	 * @param Valor Valor incial do imovel
	 * @param TaxaAluguel Taxa de aluguel do imovel
	 */
	public Industria(Jogador Banco, Integer Valor, Integer TaxaAluguel){
		dono 		 = Banco;
		valor 		 = Valor;
		tipoImovel 	 = "Industria";
		taxaAluguel  = valor*(TaxaAluguel/100);
		id			+= 3;
	}
}
