package Excecoes;

/***
* Exceção abstrata, pai das demais exceções
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public abstract class MyException extends Exception{
	/*** @return Mensagem de erro*/
	public abstract String getMensagem();
}
