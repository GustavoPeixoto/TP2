package Excecoes;

/***
 * A linha n�o contem dados suficientes
 * 
 * @author Gustavo Peixoto
 * @author Carlaile Felipe
 */
public class DadosLinhaException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "A linha n�o contem dados suficientes";
	}
}
