package Excecoes;

/***
* Exce��o abstrata, pai das demais exce��es
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public abstract class MyException extends Exception{
	/*** @return Mensagem de erro*/
	public abstract String getMensagem();
}
