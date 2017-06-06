package Excecoes;

/***
* Tipo de imovel invalido, os tipos de imoveis permitidos sao: 
* 1(residencia), 2(comercio), 3(industria), 4(hotel), 5(hospital)
* 
* @author Gustavo Peixoto
* @author Carlaile Felipe
*/
public class TipoImovelException extends 	MyException{
	/*** @return Mensagem de erro*/
	public String getMensagem(){
		return "Tipo de imovel invalido, os tipos de imoveis permitidos sao: 1(residencia), 2(comercio), 3(industria), 4(hotel), 5(hospital)";
	}
}
