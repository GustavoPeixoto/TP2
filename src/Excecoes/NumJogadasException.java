package Excecoes;

/***
* O n�mero de jogadas indicado na primeira linha n�o corresponde 
* ao n�mero de jogadas a serem feitas antes do DUMP
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class NumJogadasException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O n�mero de jogadas indicado na primeira linha n�o corresponde ao n�mero de jogadas a serem feitas antes do DUMP";
	}
}
