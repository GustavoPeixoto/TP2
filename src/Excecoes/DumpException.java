package Excecoes;

/***
* N�o foi encrontrado a linha DUMP para encerramento das jogadas
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class DumpException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "N�o foi encrontrado a linha DUMP para encerramento das jogadas";
	}
}
