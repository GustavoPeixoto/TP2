package Excecoes;

/***
* O ID da linha está incorreto
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class IdLinhaArquivoException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O ID da linha está incorreto";
	}
}
