package Excecoes;

/***
* O arquivo n�o pode conter inser��es numa mesma posi��o
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class PosicaoException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O arquivo n�o pode conter inser��es numa mesma posi��o";
	}
}
