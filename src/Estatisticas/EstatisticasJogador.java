package Estatisticas;

/**
 * Estatisticas dos jogadores
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 * */
public class EstatisticasJogador {
	/**Quantidade de voltas dadas pelo jogador no tabuleiro*/
	private int voltas;

	/**Quantidade de vezes que o jogador caiu numa posição do tipo passa a vez no tabuleiro*/
	private int passaVez;
	
	/**Quantidade de rodadas jogadas pelo jogador*/
	private int rodadas;
	
	/**Quantidade de dinheiro do jogador*/
	private double dinheiro;
	
	/**Quantidade de aluguel recebido pelo jogador*/
	private double aluguelRecebido;
	
	/**Quantidade de aluguel pago pelo jogador*/
	private double aluguelPago;
	
	/**Quantidade de dinheito gasta pelo jogador em compras de imoveis*/
	private double compraImoveis;
	
	/**
	 * Incializa todos os valores estatisticos com valor 0
	 */
	public EstatisticasJogador(){
		voltas = passaVez = rodadas = 0;
		dinheiro = aluguelRecebido = aluguelPago = compraImoveis = 0;
	}

	/**
	 * @return voltas Quantidade de voltas dadas pelo jogador no tabuleiro
	 * */
	public int getVoltas() {
		return voltas;
	}


	/**
	 * Incrementa a quantidade de voltas dadas pelo jogador no tabuleiro
	 * */
	public void incrementarVoltas() {
		voltas++;
	}


	/**
	 * @return rodadas Quantidade de rodadas jogadas pelo jogador
	 * */
	public int getRodadas() {
		return rodadas;
	}


	/**
	 * Incrementa a quantidade de rodadas jogadas pelo jogador
	 * */
	public void incrementarRodadas() {
		rodadas++;
	}


	/**
	 * @return passaVez Quantidade de vezes que o jogador 
	 * caiu numa posição do tipo passa a vez no tabuleiro
	 * */
	public int getPassaVez() {
		return passaVez;
	}


	/**
	 * Incrementa a quantidade de vezes que o jogador 
	 * caiu numa posição do tipo passa a vez no tabuleiro
	 * */
	public void incrementarPassaVez() {
		passaVez++;
	}


	/**
	 * @return dinheiro Quantidade de dinheiro do jogador
	 * */
	public double getDinheiro() {
		return dinheiro;
	}


	/**
	 * @param dinheiro Quantidade de dinheito do jogador
	 * */
	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}
	

	/**
	 * @return aluguelRecebido Quantidade de aluguel recebido pelo jogador
	 * */
	public double getAluguelRecebido() {
		return aluguelRecebido;
	}


	/**
	 * @param aluguelRecebido Quantidade de aluguel recebido pelo jogador
	 * */
	public void setAluguelRecebido(double aluguelRecebido) {
		this.aluguelRecebido += aluguelRecebido;
	}


	/**
	 * @return aluguelPago Quantidade de aluguel pago pelo jogador
	 * */
	public double getAluguelPago() {
		return aluguelPago;
	}


	/**
	 * @param aluguelPago Quantidade de aluguel pago pelo jogador
	 * */
	public void setAluguelPago(double aluguelPago) {
		this.aluguelPago += aluguelPago;
	}


	/**
	 * @return compraImoveis Quantidade de dinheito gasta pelo jogador em compras de imoveis
	 * */
	public double getCompraImoveis() {
		return compraImoveis;
	}


	/** 
	 * Soma o valor do imovel comprado a quantidade de 
	 * dinheito gasta pelo jogador em compras de imoveis
	 * @param valorImovel Valor do imovel comprado pelo jogador
	 */
	public void setCompraImoveis(double valorImovel) {
		compraImoveis += valorImovel;
	}
}
