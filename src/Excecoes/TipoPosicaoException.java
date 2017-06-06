package Excecoes;

/***
* Tipo de posicao invalido, somente os valores: 1(Start), 2(Passa Vez), 3(Imovel)
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class TipoPosicaoException extends MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "Tipo de posicao invalido, somente os valores: 1(Start), 2(Passa Vez), 3(Imovel)";
	}
	

}
