package Arquivo.Leitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * Leitor de arquivos de acordo com o padrão especificado nas regras do jogo
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 * */
public class Leitor {
	
	/**Objeto para log*/
	private Logger log;
	
	/**Lista de linhas com os dados coletados do arquivo*/
	private ArrayList<ArrayList<Integer>> dadosArquivo;
	
	/**
	 * Le um arquivo de acordo com o padrão especificado nas regras do jogo
	 * @param nomeArquivo Nome do arquivo para leitura
	 * @return dadosArquivo Dados coletados do arquivo
	 * */
	public ArrayList<ArrayList<Integer>> lerArquivo(String nomeArquivo) {
		log = Logger.getLogger(Leitor.class);
		
		dadosArquivo = new ArrayList<ArrayList<Integer>>();
		
		try {
			log.debug("Abrindo arquivo " + nomeArquivo + " para leitura...");
			BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));

			boolean DUMP = false;
			//booleano para indicar se o DUMP foi encontrado
			
			log.debug("Lendo arquivo");
			for (int i = 0; br.ready() && DUMP == false; i++) {
				//iteração que termina ao chegar no fim do arquivo ou encontrar o DUMP
				
				log.debug("Lendo linha [" + String.valueOf(i) +"]");
				dadosArquivo.add(getLinhaInt(br.readLine()));
				
				if(dadosArquivo.get(i).isEmpty()){ 
					log.debug("A linha não contem numeros, DUMP encontrado");

					dadosArquivo.remove(i);
					// removendo a linha vazia
					
					DUMP = true;
					//marcando o DUMP como encontrado para encerrar a leitura do arquivo
				}
			}
			
			log.debug("Fechando o arquivo " + nomeArquivo);
			br.close();			
		} catch (IOException e) {
			log.error("Erro na abertura do arquivo" + e.getMessage());
		}
		return dadosArquivo;
	}
	
	
	/***
	 * Converte os dados da linha recebida para inteiros, 
	 * desconsiderando todos os caracteres que não são números
	 * @param linha Linha lida do arquivo, com os dados para serem convertidos
	 * @return Lista de inteiros com os dados da linha
	 */
	private ArrayList<Integer> getLinhaInt(String linha) {
		ArrayList<Integer> resp = new ArrayList<Integer>();
		
		int index = 0;		
		String aux = "";
		
		log.debug("Inciando conversão dos dados da linha para inteiro");
		while(index < linha.length()) {			
			if (isNumber(linha.charAt(index)) == true) {
				aux += linha.charAt(index);
			}  
			else {
				if(aux != ""){
					log.debug("Convertendo o numero " +aux+" para inteiro");
					resp.add(Integer.parseInt(aux));
					aux = "";
				}
			}
			index++;
		}
		if(aux != ""){
			log.debug("Convertendo o numero " +aux+" para inteiro");
			resp.add(Integer.parseInt(aux));
		}
		
		return resp;
	}

	/***
	 * Verifica se o caractere recebido é um número
	 * @param num Caractere a ser verificado
	 * @return true Se o caractere for um número
	 * @return false Se o caractere não for um número
	 */
	private boolean isNumber(char num) {
		log.debug("Verificando se " +num+ "é um número");
		if (num == '0' || num == '1' || num == '2' || num == '3' || num == '4' || num == '5' || num == '6' || num == '7' || num == '8'|| num == '9'){
			log.debug(num +" é um numero");
			return true;
		}
		else{
			log.debug(num +" não é um numero");
			return false;
		}
	}
}
