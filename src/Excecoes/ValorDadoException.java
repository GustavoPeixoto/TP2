package Excecoes;

/***
* O valor do dado é invalido
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class ValorDadoException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O valor do dado é invalido";
	}
}
