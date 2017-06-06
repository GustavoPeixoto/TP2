package Excecoes;

/***
* O tabuleiro não possui uma posição start
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class SemStartException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O tabuleiro não possui uma posição start";
	}
}
