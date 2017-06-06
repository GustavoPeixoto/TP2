package Excecoes;

/***
* O tabuleiro pode ter somente uma posicao Start
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class StartException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O tabuleiro pode ter somente uma posicao Start";
	}
}
