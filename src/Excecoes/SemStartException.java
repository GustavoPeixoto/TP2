package Excecoes;

/***
* O tabuleiro n�o possui uma posi��o start
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class SemStartException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O tabuleiro n�o possui uma posi��o start";
	}
}
