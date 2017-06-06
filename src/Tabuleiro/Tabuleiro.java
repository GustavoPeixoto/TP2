package Tabuleiro;

import Posicoes.Posicao;
import Posicoes.TiposPosicao.*;
import Posicoes.TiposPosicao.TiposImoveis.*;
import Excecoes.*;
import Jogadores.Jogador;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import Arquivo.Leitura.Leitor;

/**
 * Recebe e processa os dados para construção do tabuleiro 
 * de acordo com as regras do jogo
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Tabuleiro{
	/**Tabuleiro contendo as posicoes*/
	private ArrayList<Posicao> tabuleiro;
	
	/**Número de posições*/
	private int numPosicoes;
	
	/**Controlador do start, para garantir somente uma posição de start no tabuleiro 
	 * e apos inserida a posição start ela guardará a posição dela no tabuleiro*/
	private int startControl;	
	
	/**Leitor de arquivo para ler os dados do tabuleiro*/
	private Leitor leArquivo;
	
	/**Lista das linhas contendo os dados lidos pelo arquivo*/
	private ArrayList<ArrayList<Integer>> dadosArquivo;
	
	/**Objeto para log*/
	private Logger log;
	
	/**
	 * Constroi o tabuleiro 
	 * 
	 * @param banco Dono incial de todos os imoveis
	 * @param nomeArquivo Nome do arquivo com os dados do tabuleiro
	 * @throws MyException Exceção
	 */
	public Tabuleiro(Jogador banco, String nomeArquivo)	throws	MyException{	
		log = Logger.getLogger(Tabuleiro.class);
		log.debug("Construindo tabuleiro...");
		
		startControl = -1; 
		
		leArquivo = new Leitor();
		tabuleiro = new ArrayList<Posicao>();
		
		log.debug("Recebendo dados do arquivo " +nomeArquivo);
		dadosArquivo = leArquivo.lerArquivo(nomeArquivo); 
		
		numPosicoes = dadosArquivo.get(0).get(0); 
		
		if(numPosicoes != dadosArquivo.size()-1){
			log.error("Lançando NumPosicoesException");
			throw new NumPosicoesException(); 
		}
		
		inicializaTabuleiroDefault(); 
		
		log.debug("Inserindo posições...");
		for(int i=1; i<numPosicoes; i++){ 
			if(verificaIdLinhaArquivo(dadosArquivo.get(i), i) == true){	
				if(posicaoVazia(tabuleiro.get(dadosArquivo.get(i).get(1)))){
					startControl = inserirPosicao(dadosArquivo.get(i), startControl, banco); 
				}
			}
		}
		if(startControl == -1){
			log.error("Lançando SemStartException");
			throw new SemStartException();
		}
	}
	
	/**
	 * Verifica se o id da linha no arquivo está correto
	 * @param linha Dados da posição
	 * @param i Contador de linha
	 * @return true Se o id da linha estiver correto
	 * @throws MyException O ID da linha está incorreto
	 */
	private boolean verificaIdLinhaArquivo(ArrayList<Integer> linha, int i)throws MyException{ 
		log.debug("Verificando id da linha do arquivo...");
		
		if(linha.get(0).equals(i) == true)return true; 
		else {
			log.error("Lançando IdLinhaArquivoException");
			throw new IdLinhaArquivoException();
		}
	}
	
	/**
	 * Insere uma posição no tabuleiro
	 * @param linha Linha com os dados da posição
	 * @param startControl Controlador para garantir apenas uma posição start no tabuleiro
	 * @param banco Dono incial de todos os imoveis
	 * @return startControl Controlador para garantir apenas uma posição start no tabuleiro
	 * @throws MyException Exceção
	 */
	private int inserirPosicao(ArrayList<Integer> linha, int startControl, Jogador banco)throws MyException{
		
		if(linha.size()>=3){
			log.debug("Verificando tipo da posição a ser inserida");
			if(linha.get(2).equals(1)) startControl = insereStart(linha.get(1), startControl);
			
			else if(linha.get(2).equals(2)) inserePassaVez(linha.get(1));
			
			else if(linha.get(2).equals(3)) insereImovel(linha, banco);
			
			else{
				log.error("Lançando TipoPosicaoException");
				throw new TipoPosicaoException();
			}
			
		}
		else{
			log.error("Lançando DadosLinhaException");
			throw new DadosLinhaException();
		}
		
		return startControl;
	}
	
	/**
	 * Insere uma posição do tipo passa a vez no tabuleiro
	 * @param index Posição no tabuleiro
	 */
	private void inserePassaVez(Integer index){
		log.debug("Inserindo passa a vez na posição [" +String.valueOf(index)+ "]");
		tabuleiro.set(index, new PassaVez());
	}
	
	/**
	 * Insere uma posição do tipo start no tabuleiro
	 * @param index Posição no tabuleiro
	 * @param startControl Controlador para garantir apenas uma posição start no tabuleiro
	 * @return index Posição do start no tabuleiro
	 * @throws MyException Exceção
	 */
	private Integer insereStart(Integer index, int startControl)throws MyException{
		if(startControl == -1){	
			log.debug("Inserindo start na posição [" +String.valueOf(index)+ "]");
			tabuleiro.set(index, new Start());
			
			return index;
		}
		
		else{
			log.error("Lançando StartException");
			throw new StartException();
		}
	}
	
	/**
	 * Insere uma posição do tipo imovel no tabuleiro
	 * @param linha Linha com os dados da posição
	 * @param banco Dono incial de todos os imoveis
	 * @throws MyException Exceção
	 */
	private void insereImovel(ArrayList<Integer> linha, Jogador banco) throws MyException{		
		if(linha.size()<6) {
			log.error("Lançando DadosLinhaException");
			throw new DadosLinhaException();
		}
		else{
			log.debug("Verificando tipo do imovel...");
			if(linha.get(3).equals(1)){
				log.debug("Inserindo residencia na posicao [" +String.valueOf(linha.get(1))+ "]");
				tabuleiro.set(linha.get(1), new Residencia(banco, linha.get(4), linha.get(5)));
			}
		
			else if(linha.get(3).equals(2)){
				log.debug("Inserindo comercio na posicao [" +String.valueOf(linha.get(1))+ "]");
				tabuleiro.set(linha.get(1), new   Comercio(banco, linha.get(4), linha.get(5)));
			}
		
			else if(linha.get(3).equals(3)){
				log.debug("Inserindo industria na posicao [" +String.valueOf(linha.get(1))+ "]");
				tabuleiro.set(linha.get(1), new  Industria(banco, linha.get(4), linha.get(5)));
			}
		
			else if(linha.get(3).equals(4)){
				log.debug("Inserindo Hotel na posicao [" +String.valueOf(linha.get(1))+ "]");
				tabuleiro.set(linha.get(1), new 	 Hotel(banco, linha.get(4), linha.get(5)));
			}
		
			else if(linha.get(3).equals(5)){
				log.debug("Inserindo Hospital na posicao [" +String.valueOf(linha.get(1))+ "]");
				tabuleiro.set(linha.get(1), new   Hospital(banco, linha.get(4), linha.get(5)));
			}
		
			else {
				log.error("Lançando TipoImovelException");
				throw new TipoImovelException();
			}
		}
	}
	
	/**
	 * Verifica se a posição está vazia para inserção
	 * @param pos Posição do tabuleiro
	 * @return true Se a posição estiver vazia
	 * @throws MyException Exceção
	 */
	private boolean posicaoVazia(Posicao pos)throws MyException{
		log.debug("Verificando se a posição a ser inserida está vazia...");
		
		if(pos.getId()==0)return true;
		else {
			log.error("Lançando PosicaoException");
			throw new PosicaoException();
		}
	}
	
	/**Incializa o tabuleiro com posições vazias*/
	private void inicializaTabuleiroDefault(){
		log.debug("Incializando o tabuleiro com posições vazias...");
		
		for(int i=0; i<numPosicoes; i++){
		/*iterção em que, i tem valor incial 0 e é incrementado até assumir um valor 
		  maior ou igual ao numero de posiçoes do tabuleiro(numPosicoes)
		 */
			
			tabuleiro.add(new Posicao());
			//adicionando uma posição vazia ao tabuleiro a cada iteração
		}
	}

	/**@return numPosicoes Número de posições do tabuleiro*/
	public int getNumPosicoes() {
		return numPosicoes;
	}

	/**@return tabuleiro Tabuleiro com as posições*/
	public ArrayList<Posicao> getTabuleiro() {	
		return tabuleiro;
	}

	/**@return startControl Posição do start no tabuleiro*/
	public int getPosicaoStart() {
		return startControl;
	}	
}
