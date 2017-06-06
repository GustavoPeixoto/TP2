package Posicoes;

import Jogadores.Jogador;
/**
 * Representa uma posi��o no tabuleiro
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Posicao {
	/**Id da posi��o*/
	protected int id;

	/**Valor da posi��o*/
	protected double valor;
	
	/**Taxa de aluguel de imovel*/
	protected double taxaAluguel;
	
	/**Dono da posi��o*/
	protected Jogador dono;
	
	/**Tipo de imovel*/
	protected String tipoImovel;
	
	/**Inicializa posi��o*/
	public Posicao(){
		id 		= 0;
		valor 	= 0;
		taxaAluguel = 0;
		dono 		= null;
		tipoImovel 	= null;
	}
	
	/**@return id Id da posi��o*/
	public int getId() {
		return id;
	}
	
	/**
	 * Recebe um novo id da posi��o
	 * @param id Id da posi��o*/
	public void setId(int id) {
		this.id = id;
	}
	
	/**@return dono Dono da posi��o*/
	public Jogador getDono() {
		return dono;
	}
	
	/**
	 * Recebe um novo dono da posi��o
	 * @param Dono Dono do imovel
	 */
	public void setDono(Jogador Dono) {
		dono = Dono;
	}
	
	/**@return tipoImovel Tipo de imovel*/
	public String getTipoImovel() {
		return tipoImovel;
	}
	
	/**@return valor Valor da posi��o*/
	public double getValor() {
		return valor;
	}
	
	/**@return taxaAluguel Taxa de aluguel de imovel*/
	public double getTaxaAluguel() {
		return taxaAluguel;
	}
}
