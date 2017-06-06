package Excecoes;

/***
* O arquivo não pode conter inserções numa mesma posição
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class PosicaoException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O arquivo não pode conter inserções numa mesma posição";
	}
}
