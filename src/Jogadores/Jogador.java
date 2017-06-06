package Jogadores;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import Estatisticas.EstatisticasJogador;

/***
 * Representa um jogador de banco imobiliario de acordo com as regras do jogo
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Jogador {
	/***Saldo do jogador*/
	private double saldo;
	
	/***Posição atual do jogador no tabuleiro*/
	private int posicaoAtual;
	
	/***Id do jogador*/
	private int id;
	
	/***Estatisticas do jogador*/
	private EstatisticasJogador estatisticas;
	
	/***Lista de posições dos imoveis adquiridos pelo jogador*/
	private ArrayList<Integer> imoveis;
	
	/***Objeto para log*/
	private Logger log;
	
	/***
	 * Incializa o jogador
	 * 
	 * @param saldoInicial Saldo do jogador
	 * @param posicaoStart Posição inicial do jogador
	 * @param id Id do jogador
	 */
	public Jogador(double saldoInicial, int posicaoStart, int id){
		log = Logger.getLogger(Jogador.class);
		log.debug("Incializando dados do jogador...");
		
		saldo = saldoInicial;
		posicaoAtual = posicaoStart;
		estatisticas = new EstatisticasJogador();
		this.id = id;
		imoveis = new ArrayList<Integer>();
	}

	/***@return imoveis Lista das posições dos imoveis adquiridos pelo jogador*/
	public ArrayList<Integer> getImoveis() {
		return imoveis;
	}

	/***@return saldo Saldo do jogador*/
	public double getSaldo() {
		return saldo;
	}

	/***@return posicaoAtual Posição atual do jogador no tabuleiro*/
	public int getPosicaoAtual() {
		return posicaoAtual;
	}
	
	/***@return Id do jogador*/
	public int getId() {
		return id;
	}
	
	/***@return estatisticas Estatisticas do jogador*/
	public EstatisticasJogador getEstatisticas() {
		return estatisticas;
	}

	/***
	 * Joga o valor do dado recebido e atualiza a posição do jogador no tabuleiro, 
	 * se o jogador der uma volta no tabuleiro é incrementado nas estatiscas a
	 * quantidade de voltas dadas no tabuleiro pelo jogador
	 * 
	 * @param valorDado Valor tirado no dado
	 * @param numPosicoesTabuleiro Número de posições do tabuleiro
	 */
	public void jogarDados(int valorDado, int numPosicoesTabuleiro){
		log.debug("Jogador "+ String.valueOf(id) +" jogando o dado");
		if(posicaoAtual + valorDado > numPosicoesTabuleiro){
			posicaoAtual = (posicaoAtual + valorDado) - numPosicoesTabuleiro;
			
			estatisticas.incrementarVoltas();
		}
		else posicaoAtual += valorDado;
	}
	
	/***
	 * Compra um imovel, desconta o valor do imovel no saldo do jogador, 
	 * adiciona o imovel para a lista de imoveis adiquiridos pelo jogador, 
	 * adiciona as estatisticas o saldo atualizado e soma o valor gasto em 
	 * compras de imoveis
	 * 
	 * @param valorImovel Valor do imovel
	 * @param posImovel Posição do imovel
	 * @return true Se o jogador comprou o imovel
	 * @return false Se o jogador não tem saldo suficiente para comprar o imovel
	 */
	public boolean comprarImovel(double valorImovel, int posImovel){
		if(saldo >= valorImovel){
			log.debug("Jogador "+ String.valueOf(id) +" comprando imovel");
			
			saldo -= valorImovel;
			imoveis.add(posImovel);
			
			estatisticas.setDinheiro(saldo);
			estatisticas.setCompraImoveis(valorImovel);
			
			return true;
		}
		else{
			log.debug("Jogador "+ String.valueOf(id) +" não tem saldo suficiente para comprar o imovel");
			
			saldo = -1;
			
			estatisticas.setDinheiro(0);
			
			return false;
		}
	}
	
	/***
	 * Recebe o aluguel, soma o valor do aluguel ao saldo do jogador, 
	 * adiciona as estatisticas o saldo atualizado e soma o valor de 
	 * aluguel recebido
	 * 
	 * @param valorAluguel Valor de aluguel a ser recebido
	 */
	public void receberAluguel(double valorAluguel){
		log.debug("Jogador "+ String.valueOf(id) +" recebendo aluguel");
		
		saldo += valorAluguel;
		
		estatisticas.setDinheiro(saldo);
		estatisticas.setAluguelRecebido(valorAluguel);
	}
	
	/***
	 * Paga o aluguel, desconta o valor do aluguel do saldo do jogador, 
	 * adiciona as estatisticas o saldo atualizado e caso o jogador tenha 
	 * saldo suficiente para pagar o aluguel soma as estatisticas o valor
	 * de aluguel pago
	 * 
	 * @param valorAluguel Valor de aluguel para ser pago
	 * @return true Se o jogador pagou o aluguel
	 * @return false Se o jogador não tem saldo suficiente para pagar o aluguel
	 */
	public boolean pagarAluguel(double valorAluguel){
		if(saldo < valorAluguel){
			log.debug("Jogador "+ String.valueOf(id) +" pagando aluguel");
			
			saldo = -1;
			
			estatisticas.setDinheiro(0);
			
			return false;
		}
		else{
			log.debug("Jogador "+ String.valueOf(id) +" não tem saldo suficiente para pagar aluguel");
			
			
			saldo -= valorAluguel;
			
			estatisticas.setDinheiro(saldo);
			estatisticas.setAluguelPago(valorAluguel);
			
			return true;
		}
	}

}
