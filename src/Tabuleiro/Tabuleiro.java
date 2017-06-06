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
 * Recebe e processa os dados para constru��o do tabuleiro 
 * de acordo com as regras do jogo
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Tabuleiro{
	/**Tabuleiro contendo as posicoes*/
	private ArrayList<Posicao> tabuleiro;
	
	/**N�mero de posi��es*/
	private int numPosicoes;
	
	/**Controlador do start, para garantir somente uma posi��o de start no tabuleiro 
	 * e apos inserida a posi��o start ela guardar� a posi��o dela no tabuleiro*/
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
	 * @throws MyException Exce��o
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
			log.error("Lan�ando NumPosicoesException");
			throw new NumPosicoesException(); 
		}
		
		inicializaTabuleiroDefault(); 
		
		log.debug("Inserindo posi��es...");
		for(int i=1; i<numPosicoes; i++){ 
			if(verificaIdLinhaArquivo(dadosArquivo.get(i), i) == true){	
				if(posicaoVazia(tabuleiro.get(dadosArquivo.get(i).get(1)))){
					startControl = inserirPosicao(dadosArquivo.get(i), startControl, banco); 
				}
			}
		}
		if(startControl == -1){
			log.error("Lan�ando SemStartException");
			throw new SemStartException();
		}
	}
	
	/**
	 * Verifica se o id da linha no arquivo est� correto
	 * @param linha Dados da posi��o
	 * @param i Contador de linha
	 * @return true Se o id da linha estiver correto
	 * @throws MyException O ID da linha est� incorreto
	 */
	private boolean verificaIdLinhaArquivo(ArrayList<Integer> linha, int i)throws MyException{ 
		log.debug("Verificando id da linha do arquivo...");
		
		if(linha.get(0).equals(i) == true)return true; 
		else {
			log.error("Lan�ando IdLinhaArquivoException");
			throw new IdLinhaArquivoException();
		}
	}
	
	/**
	 * Insere uma posi��o no tabuleiro
	 * @param linha Linha com os dados da posi��o
	 * @param startControl Controlador para garantir apenas uma posi��o start no tabuleiro
	 * @param banco Dono incial de todos os imoveis
	 * @return startControl Controlador para garantir apenas uma posi��o start no tabuleiro
	 * @throws MyException Exce��o
	 */
	private int inserirPosicao(ArrayList<Integer> linha, int startControl, Jogador banco)throws MyException{
		
		if(linha.size()>=3){
			log.debug("Verificando tipo da posi��o a ser inserida");
			if(linha.get(2).equals(1)) startControl = insereStart(linha.get(1), startControl);
			
			else if(linha.get(2).equals(2)) inserePassaVez(linha.get(1));
			
			else if(linha.get(2).equals(3)) insereImovel(linha, banco);
			
			else{
				log.error("Lan�ando TipoPosicaoException");
				throw new TipoPosicaoException();
			}
			
		}
		else{
			log.error("Lan�ando DadosLinhaException");
			throw new DadosLinhaException();
		}
		
		return startControl;
	}
	
	/**
	 * Insere uma posi��o do tipo passa a vez no tabuleiro
	 * @param index Posi��o no tabuleiro
	 */
	private void inserePassaVez(Integer index){
		log.debug("Inserindo passa a vez na posi��o [" +String.valueOf(index)+ "]");
		tabuleiro.set(index, new PassaVez());
	}
	
	/**
	 * Insere uma posi��o do tipo start no tabuleiro
	 * @param index Posi��o no tabuleiro
	 * @param startControl Controlador para garantir apenas uma posi��o start no tabuleiro
	 * @return index Posi��o do start no tabuleiro
	 * @throws MyException Exce��o
	 */
	private Integer insereStart(Integer index, int startControl)throws MyException{
		if(startControl == -1){	
			log.debug("Inserindo start na posi��o [" +String.valueOf(index)+ "]");
			tabuleiro.set(index, new Start());
			
			return index;
		}
		
		else{
			log.error("Lan�ando StartException");
			throw new StartException();
		}
	}
	
	/**
	 * Insere uma posi��o do tipo imovel no tabuleiro
	 * @param linha Linha com os dados da posi��o
	 * @param banco Dono incial de todos os imoveis
	 * @throws MyException Exce��o
	 */
	private void insereImovel(ArrayList<Integer> linha, Jogador banco) throws MyException{		
		if(linha.size()<6) {
			log.error("Lan�ando DadosLinhaException");
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
				log.error("Lan�ando TipoImovelException");
				throw new TipoImovelException();
			}
		}
	}
	
	/**
	 * Verifica se a posi��o est� vazia para inser��o
	 * @param pos Posi��o do tabuleiro
	 * @return true Se a posi��o estiver vazia
	 * @throws MyException Exce��o
	 */
	private boolean posicaoVazia(Posicao pos)throws MyException{
		log.debug("Verificando se a posi��o a ser inserida est� vazia...");
		
		if(pos.getId()==0)return true;
		else {
			log.error("Lan�ando PosicaoException");
			throw new PosicaoException();
		}
	}
	
	/**Incializa o tabuleiro com posi��es vazias*/
	private void inicializaTabuleiroDefault(){
		log.debug("Incializando o tabuleiro com posi��es vazias...");
		
		for(int i=0; i<numPosicoes; i++){
		/*iter��o em que, i tem valor incial 0 e � incrementado at� assumir um valor 
		  maior ou igual ao numero de posi�oes do tabuleiro(numPosicoes)
		 */
			
			tabuleiro.add(new Posicao());
			//adicionando uma posi��o vazia ao tabuleiro a cada itera��o
		}
	}

	/**@return numPosicoes N�mero de posi��es do tabuleiro*/
	public int getNumPosicoes() {
		return numPosicoes;
	}

	/**@return tabuleiro Tabuleiro com as posi��es*/
	public ArrayList<Posicao> getTabuleiro() {	
		return tabuleiro;
	}

	/**@return startControl Posi��o do start no tabuleiro*/
	public int getPosicaoStart() {
		return startControl;
	}	
}
