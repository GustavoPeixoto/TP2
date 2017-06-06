package Excecoes;

/***
* O número de jogadas indicado na primeira linha não corresponde 
* ao número de jogadas a serem feitas antes do DUMP
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class NumJogadasException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O número de jogadas indicado na primeira linha não corresponde ao número de jogadas a serem feitas antes do DUMP";
	}
}
