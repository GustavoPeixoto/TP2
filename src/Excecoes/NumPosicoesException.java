package Excecoes;

/***
* O n�mero de posi��es indicado na primeira linha do arquivo 
* n�o corresponde a quantidade de posi��es setadas no mesmo
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class NumPosicoesException extends MyException {
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O n�mero de posi��es indicado na primeira linha do arquivo n�o corresponde a quantidade de posi��es setadas no mesmo";
	}
}
