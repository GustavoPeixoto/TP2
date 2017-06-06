package Posicoes.TiposPosicao.TiposImoveis;

import Jogadores.Jogador;
import Posicoes.TiposPosicao.Imovel;

/**
 * Representa um imovel do tipo comercio no tabuleiro
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Comercio extends Imovel{
	/**
	 * Incializa Comercio
	 * @param Banco Dono incial do imovel
	 * @param Valor Valor incial do imovel
	 * @param TaxaAluguel Taxa de aluguel do imovel
	 */
	public Comercio(Jogador Banco, Integer Valor, Integer TaxaAluguel){
		dono 		 = Banco;
		valor		 = Valor;
		tipoImovel	 = "Comercio";
		taxaAluguel  = valor*(TaxaAluguel/100);
		id			+= 2;
	}	
}
