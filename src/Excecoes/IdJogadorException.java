package Excecoes;
/***
* Id de jogador invalido
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class IdJogadorException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "Id de jogador invalido";
	}
}
