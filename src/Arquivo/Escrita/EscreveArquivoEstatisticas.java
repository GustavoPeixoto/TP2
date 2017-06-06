package Arquivo.Escrita;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import Estatisticas.EstatisticasJogador;


/**
 * Escreve as estatisticas do jogo em um arquivo
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 * */
public class EscreveArquivoEstatisticas {
	/**Lista de das estatisticas dos jogadores*/
	private ArrayList<EstatisticasJogador> estatisticas;
	
	/**Objeto para escrita em arquivo*/
	private BufferedWriter bw;
	
	/**Objeto para log*/
	private Logger log;
	
	/**
	 * Escreveas estatisticas  do jogo em um arquivo
	 * */
	public EscreveArquivoEstatisticas(){
		estatisticas = new ArrayList<EstatisticasJogador>();
		log = Logger.getLogger(EscreveArquivoEstatisticas.class);
	}
	
	
	/**
	 * Recebe as estatiticas de um jogador que precisam ser escritas no arquivo
	 * @param e Estatisticas do jogador que precisam ser escritas
	 * */
	public void setEstatisticas(EstatisticasJogador e){
		estatisticas.add(e);
	}

	/**
	 * Escreveas estatisticas  do jogo em um arquivo
	 * @param nomeArquivo  Nome do arquivo para escrita
	 * */	
	public void escreverEstatisticas(String nomeArquivo){
		try{
			log.debug("Abrindo arquivo " +nomeArquivo+ "para escrita");
			bw = new BufferedWriter(new FileWriter(nomeArquivo));
			
			escreveRodadas();
			escreveVoltas();
			escreveDinheiro();
			escreveAluguelRecebido();
			escreveAluguelPago();
			escreveValorCompra();
			escrevePassaVez();			
			
			log.debug("Estatisticas escritas em " +nomeArquivo);
			log.debug("Fechando arquivo" +nomeArquivo);
			bw.close();
		}catch(IOException e){
			log.error("Erro na abertura do arquivo" + e.getMessage());
		}
	}
	
	
	/**
	 * Escreve a quantidade de rodadas jogadas no jogo
	 * @throws IOException Erro ao escrever no arquivo
	 */
	private void escreveRodadas() throws IOException{
		log.debug("Escrevendo quantidade de rodadas...");
		bw.write("1:");
		
		int quantidadeRodadas = 0;

		for(int i =0; i<estatisticas.size(); i++){
			if(estatisticas.get(i).getRodadas() > quantidadeRodadas){
				quantidadeRodadas = estatisticas.get(i).getRodadas();
			}
		}
		
		bw.write(String.valueOf(quantidadeRodadas));
	}
	
	/**
	 * Escreve a quantidade de voltas dadas no tabuleiro por cada jogador
	 * @throws IOException Erro ao escrever no arquivo
	 */
	private void escreveVoltas()throws IOException{
		log.debug("Escrevendo quantidade de voltas...");
		
		bw.newLine();
		bw.write("2:");
		
		int i;
		for(i=1; i<estatisticas.size(); i++){
			bw.write(String.valueOf(i) + "-" + String.valueOf(estatisticas.get(i-1).getVoltas()) + ";");
		}
		bw.write(String.valueOf(i) + "-" + String.valueOf(estatisticas.get(i-1).getVoltas()));
	}
	
	/**
	 * Escreve a quantidade de dinheiro de cada jogador
	 * @throws IOException Erro ao escrever no arquivo
	 */
	private void escreveDinheiro()throws IOException{
		log.debug("Escrevendo quantidade de dinheiro...");
		
		bw.newLine();
		bw.write("3:");
		
		int i;
		for(i=1; i<estatisticas.size(); i++){
			bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getDinheiro()) + ";");
		}
		
		bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getDinheiro()));	
	}
	
	/**
	 * Escreve a quantidade de aluguel recebido por cada jogador
	 * @throws IOException Erro ao escrever no arquivo
	 */
	private void escreveAluguelRecebido()throws IOException{
		log.debug("Escrevendo quantidade de aluguel recebido...");
		
		bw.newLine();
		bw.write("4:");
	

		int i;
		for(i=1; i<estatisticas.size(); i++){
			bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getAluguelRecebido()) + ";");
		}
		
		bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getAluguelRecebido()));	

	}
	
	/**
	 * Escreve a quantidade de aluguel pago por cada jogador
	 * @throws IOException Erro ao escrever no arquivo
	 */
	private void escreveAluguelPago()throws IOException{
		log.debug("Escrevendo quantidade de aluguel pago...");
		
		bw.newLine();
		bw.write("5:");		

		int i;
		for(i=1; i<estatisticas.size(); i++){
			bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getAluguelPago()) + ";");
		}
		
		bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getAluguelPago()));	

	}
	
	/**
	 * Escreve a quantidade de dinheito gasta em compras de imoveis por cada jogador
	 * @throws IOException Erro ao escrever no arquivo
	 */
	private void escreveValorCompra()throws IOException{
		log.debug("Escrevendo valor gasto em compras...");
		
		bw.newLine();
		bw.write("6:");
		

		int i;
		for(i=1; i<estatisticas.size(); i++){
			bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getCompraImoveis()) + ";");
		}
		
		bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getCompraImoveis()));	

	}
	
	/**
	 * Escreve a quantidade de vezes que cada jogador 
	 * caiu numa posição do tipo passa a vez no tabuleiro
	 * @throws IOException Erro ao escrever no arquivo
	 */
	private void escrevePassaVez()throws IOException{
		log.debug("Escrevendo quantidade de passa a vez...");
		
		bw.newLine();
		bw.write("7:");		

		int i;
		for(i=1; i<estatisticas.size(); i++){
			bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getPassaVez()) + ";");
		}
		
		bw.write(String.valueOf(i)+ "-" + String.valueOf(estatisticas.get(i-1).getPassaVez()));	

	}
}
