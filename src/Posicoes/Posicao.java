package Posicoes;

import Jogadores.Jogador;
/**
 * Representa uma posição no tabuleiro
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Posicao {
	/**Id da posição*/
	protected int id;

	/**Valor da posição*/
	protected double valor;
	
	/**Taxa de aluguel de imovel*/
	protected double taxaAluguel;
	
	/**Dono da posição*/
	protected Jogador dono;
	
	/**Tipo de imovel*/
	protected String tipoImovel;
	
	/**Inicializa posição*/
	public Posicao(){
		id 		= 0;
		valor 	= 0;
		taxaAluguel = 0;
		dono 		= null;
		tipoImovel 	= null;
	}
	
	/**@return id Id da posição*/
	public int getId() {
		return id;
	}
	
	/**
	 * Recebe um novo id da posição
	 * @param id Id da posição*/
	public void setId(int id) {
		this.id = id;
	}
	
	/**@return dono Dono da posição*/
	public Jogador getDono() {
		return dono;
	}
	
	/**
	 * Recebe um novo dono da posição
	 * @param Dono Dono do imovel
	 */
	public void setDono(Jogador Dono) {
		dono = Dono;
	}
	
	/**@return tipoImovel Tipo de imovel*/
	public String getTipoImovel() {
		return tipoImovel;
	}
	
	/**@return valor Valor da posição*/
	public double getValor() {
		return valor;
	}
	
	/**@return taxaAluguel Taxa de aluguel de imovel*/
	public double getTaxaAluguel() {
		return taxaAluguel;
	}
}
