package Jogo;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import Arquivo.Escrita.EscreveArquivoEstatisticas;
import Arquivo.Leitura.Leitor;
import Excecoes.DadosLinhaException;
import Excecoes.IdJogadorException;
import Excecoes.IdLinhaArquivoException;
import Excecoes.MyException;
import Excecoes.NumJogadasException;
import Excecoes.TipoPosicaoException;
import Excecoes.ValorDadoException;
import Jogadores.Jogador;
import Tabuleiro.Tabuleiro;

/***
 * Representa o jogo banco imobiliario, que processa a sequencia de jogadas do arquivo de jogadas
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Jogo {
	/*Tabuleiro contendo o tabuleiro com as posições para o jogo*/
	private Tabuleiro tabuleiro;
	
	/**Lista de jogadores*/
	private ArrayList <Jogador> jogadores;
	
	/**Leitor de arquivos, para ler o arquivo de jogadas*/
	private Leitor leitura;
	
	/**Lista de jogadas, contendo os dados do arquivo de jogadas*/
	private ArrayList<ArrayList<Integer>> jogadas;
	
	/**Ecritor de arquivo, para escrever as estatisticas*/
	private EscreveArquivoEstatisticas estatisticas;
	
	/**Objeto para log*/
	private Logger log;
	
	/**Número de jogadas para serem processadas*/
	private int numJogadas;
	
	/**Número de jogadores*/
	private int numJogadores;
	
	/**Saldo inicial dos jogadores*/
	private int saldoInicial;
	
	/**
	 * Incializa o jogo, recebe os dados do arquivo de jogadas, 
	 * incializa o tabuleiro e os jogadores
	 * 
	 * @param arquivoJogadas Nome do arquivo de jogadas
	 * @param arquivoTabuleiro Nome do arquivo do tabuleiro
	 * @throws MyException Exceçao
	 */
	public Jogo(String arquivoJogadas, String arquivoTabuleiro) throws MyException{
		log = Logger.getLogger(Jogo.class);
		log.debug("Carregando jogo...");
		
		leitura = new Leitor();
		
		jogadas = leitura.lerArquivo(arquivoJogadas);
		
		jogadores = new ArrayList<Jogador>();
		
		jogadores.add(new Jogador(Double.POSITIVE_INFINITY, -1, 0)); //banco
		
		tabuleiro = new Tabuleiro(jogadores.get(0), arquivoTabuleiro);
		
		if(jogadas.get(0).size() < 3) {
			log.error("Lançando DadosLinhaException");
			throw new DadosLinhaException();
		}
		else{	
			numJogadas = jogadas.get(0).get(0);
			numJogadores = jogadas.get(0).get(1);
			saldoInicial = jogadas.get(0).get(2);
		}
		if(numJogadas!= jogadas.get(0).get(0)) {
			log.error("Lançando NumJogadasaException");
			throw new NumJogadasException();
		}
		inicializaJogadores(numJogadores, saldoInicial, tabuleiro.getPosicaoStart());
		
		log.debug("Jogo carregado");
	}
	
	/**
	 * Processa as jogadas de acordo com as regras do jogo
	 * @throws MyException Exceção
	 */
	public void Jogar()throws MyException{
		log.debug("Inciando jogo");
		
		int idJogador = -1;
		int valorDado = -1;
		int posicaoJogador = -1;
		
		int i;
		for(i = 1; i < numJogadas; i++){
			log.debug("Executando jogada da linha " +String.valueOf(i) + " do arquivo de jogadas");
			
			verificaPadrao(jogadas.get(i), i);
			idJogador = jogadas.get(i).get(1);
			posicaoJogador = jogadores.get(idJogador).getPosicaoAtual();
			valorDado = jogadas.get(i).get(2);
			
			if(jogadores.get(idJogador).getSaldo() != -1){
				jogadores.get(idJogador).jogarDados(valorDado, tabuleiro.getNumPosicoes());
				
				jogadores.get(idJogador).getEstatisticas().incrementarRodadas();
				
				if(tabuleiro.getTabuleiro().get(posicaoJogador).getId()/10 == 1){
					log.debug("O jogador caiu numa posicao start");
					jogadores.get(idJogador).receberAluguel(500);
					log.debug("Jogada realizada");
				}
				else if(tabuleiro.getTabuleiro().get(posicaoJogador).getId()/10 == 2){
					log.debug("O jogador caiu numa posicao passa a vez");
					jogadores.get(idJogador).getEstatisticas().incrementarPassaVez();
					log.debug("Jogada realizada");
				}
				else if(tabuleiro.getTabuleiro().get(posicaoJogador).getId()/10 == 3){
					log.debug("O jogador caiu numa posicao imovel");
					imovel(posicaoJogador, idJogador);
					log.debug("Jogada realizada");
				}
				else {
					log.error("Lançando TipoPosicaoException");
					throw new TipoPosicaoException();
				}
			}
		}
		
		if(i!= numJogadas && jogadas.get(i).get(0) != -1){
			log.error("Lançando NumJogadasException");
			throw new NumJogadasException();
		}
	}
	
	/**
	 * Processa quando um jogador cai em uma posição de imovel de acordo com as regras do jogo
	 * 
	 * @param posicaoJogador Posição atual do jogador no tabuleiro
	 * @param idJogador Id do jogador
	 */
	private void imovel(int posicaoJogador, int idJogador){
		if(tabuleiro.getTabuleiro().get(posicaoJogador).getDono().getId() == 0){
			log.debug("O imovel pertence ao banco");
			if(jogadores.get(idJogador).comprarImovel(tabuleiro.getTabuleiro().get(posicaoJogador).getValor(), posicaoJogador)){
				log.debug("Setando ao imovel o seu novo dono");
				tabuleiro.getTabuleiro().get(posicaoJogador).setDono(jogadores.get(idJogador));
			}
			else{
				falencia(idJogador);
			}
		}
		else if(tabuleiro.getTabuleiro().get(posicaoJogador).getDono().getId() != idJogador){
			log.debug("O imovel pertence a outro jogador");
			if(jogadores.get(idJogador).pagarAluguel(tabuleiro.getTabuleiro().get(posicaoJogador).getTaxaAluguel())){
				jogadores.get(tabuleiro.getTabuleiro().get(posicaoJogador).getDono().getId()).receberAluguel(tabuleiro.getTabuleiro().get(posicaoJogador).getTaxaAluguel());
			}
			else{
				falencia(idJogador);
			}
		}
		else log.debug("O imovel já pertence ao proprio jogador");
	}
	
	/**
	 * Processa a falencia de um jogador
	 * @param idJogador Id do jogador
	 */
	private void falencia(int idJogador){
		log.debug("O jogador " +String.valueOf(idJogador) + " está falido");
		
		ArrayList<Integer> imoveisJogador = jogadores.get(idJogador).getImoveis();
		
		log.debug("Devolvendo imoveis ao banco...");
		for(int i =0; i<imoveisJogador.size(); i++){
			tabuleiro.getTabuleiro().get(imoveisJogador.get(i)).setDono(jogadores.get(0));
		}
		log.debug("Imoveis devolvidos");
	}
	
	/**
	 * Incializa os jogadores para o jogo
	 * 
	 * @param numJogadores Número de jogadores
	 * @param saldoInicial Saldo inicial dos jogadores
	 * @param posicaoStart Posição incial dos jogadores no tabuleiro
	 */
	private void inicializaJogadores(int numJogadores, int saldoInicial, int posicaoStart){
		log.debug("Inicializando jogadores...");
		for(int i = 1; i<=numJogadores; i++)jogadores.add(new Jogador(saldoInicial, posicaoStart, i));
		log.debug("Jogadores inicializados");
	}
	
	/**
	 * Verifica se os dados da linha são validos
	 * 
	 * @param jogada Dados da jogada
	 * @param i Contador de linha
	 * @throws MyException Exceção
	 */
	private void verificaPadrao(ArrayList<Integer> jogada, int i)throws MyException	{
		log.debug("Verificando se a jogada é valida...");
		
		if(jogada.size() < 3){
			log.error("Lançando DadosLinhaException");
			throw new DadosLinhaException();
		}
		if(jogada.get(2)<1 || jogada.get(2)>6){
			log.error("Lançando ValorDadoException");
			throw new ValorDadoException();
		}
		if(jogada.get(0) != i){
			log.error("Lançando IdLinhaArquivoException");
			throw new IdLinhaArquivoException();
		}
		if(jogada.get(1)>numJogadores && jogada.get(1)<1){
			log.error("Lançando IdJogadorException");
			throw new IdJogadorException();
		}
		log.debug("Jogada valida");
	}
	
	/**Envia as estatisticas dos jogadores para serem escritas no arquivo de estatisticas*/
	public void mostrarEstatisticas(){
		estatisticas = new EscreveArquivoEstatisticas();

		for(int i=1; i<=numJogadores; i++){
			log.debug("Setando estatisticas do jogador " +String.valueOf(i));
			estatisticas.setEstatisticas(jogadores.get(i).getEstatisticas());
		}
		
		estatisticas.escreverEstatisticas("Estatisticas.txt");
	}
}
