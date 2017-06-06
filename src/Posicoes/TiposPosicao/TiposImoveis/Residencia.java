package Posicoes.TiposPosicao.TiposImoveis;

import Jogadores.Jogador;
import Posicoes.TiposPosicao.Imovel;

/**
 * Representa um imovel do tipo residencia no tabuleiro
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Residencia extends Imovel{
	/**
	 * Incializa Residencia
	 * @param Banco Dono incial do imovel
	 * @param Valor Valor incial do imovel
	 * @param TaxaAluguel Taxa de aluguel do imovel
	 */
	public Residencia(Jogador Banco, Integer Valor, Integer TaxaAluguel){
		dono 	     = Banco;
		valor	     = Valor;
		tipoImovel	 = "Residencia";
		taxaAluguel  = valor*(TaxaAluguel/100);
		id			+= 1;
	}
}
