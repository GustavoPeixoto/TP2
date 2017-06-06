package Excecoes;

/***
 * A linha não contem dados suficientes
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class DadosLinhaException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "A linha não contem dados suficientes";
	}
}
