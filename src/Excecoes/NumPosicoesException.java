package Excecoes;

/***
* O número de posiçôes indicado na primeira linha do arquivo 
* não corresponde a quantidade de posiçôes setadas no mesmo
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class NumPosicoesException extends MyException {
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "O número de posiçôes indicado na primeira linha do arquivo não corresponde a quantidade de posiçôes setadas no mesmo";
	}
}
