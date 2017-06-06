package Posicoes.TiposPosicao.TiposImoveis;

import Jogadores.Jogador;
import Posicoes.TiposPosicao.Imovel;

/**
 * Representa um imovel do tipo hotel no tabuleiro
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Hotel extends Imovel{
	/**
	 * Incializa Hotel
	 * @param Banco Dono incial do imovel
	 * @param Valor Valor incial do imovel
	 * @param TaxaAluguel Taxa de aluguel do imovel
	 */
	public Hotel(Jogador Banco, Integer Valor, Integer TaxaAluguel){
		dono 	     = Banco;
		valor		 = Valor;
		tipoImovel 	 = "Hotel";
		taxaAluguel  = valor*(TaxaAluguel/100);
		id			+= 4;
	}
}
