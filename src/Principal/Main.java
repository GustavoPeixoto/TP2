package Principal;

import org.apache.log4j.Logger;

import Excecoes.MyException;
import Jogo.Jogo;

/**
 * Classe principal
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class Main {
	/**
	 * Metodo principal, instancia um novo jogo, joga e solicita as estatisticas
	 * @param args String[]
	 * */
	public static void main(String[] args) {
		Logger log = Logger.getLogger(Main.class);
		
		try{
			Jogo bancoImobiliario = new Jogo("Jogadas.txt", "Tabuleiro.txt");
			bancoImobiliario.Jogar();
			bancoImobiliario.mostrarEstatisticas();
		}catch(MyException e){
			log.error(e.getMensagem());
		}
	}

}
