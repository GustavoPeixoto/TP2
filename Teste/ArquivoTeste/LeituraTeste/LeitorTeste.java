package ArquivoTeste.LeituraTeste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Arquivo.Leitura.Leitor;

public class LeitorTeste {

	@Test
	public void testLerArquivo() {
		Leitor leitura = new Leitor();
				
		assertTrue(ComparaMatriz(leitura.lerArquivo("TabuleiroTeste.txt"), incializaTabuleirto()) == true);
		assertTrue(ComparaMatriz(leitura.lerArquivo("JogadasTeste.txt"), incializaJogadas()) == true);
	}
	

	private ArrayList<ArrayList<Integer>> incializaTabuleirto(){
		ArrayList<ArrayList<Integer>> dadosArquivo = new ArrayList<ArrayList<Integer>>();

		dadosArquivo.add(SetStringSize1(new ArrayList<Integer>(), 10));
		dadosArquivo.add(SetStringSize3(new ArrayList<Integer>(), 1, 1, 1));
		dadosArquivo.add(SetStringSize6(new ArrayList<Integer>(), 2, 2, 3, 2, 150, 20));
		dadosArquivo.add(SetStringSize6(new ArrayList<Integer>(), 3, 3, 3, 1, 100, 10));
		dadosArquivo.add(SetStringSize6(new ArrayList<Integer>(), 4, 4, 3, 4, 350, 30));
		dadosArquivo.add(SetStringSize6(new ArrayList<Integer>(), 5, 5, 3, 1, 100, 10));
		dadosArquivo.add(SetStringSize6(new ArrayList<Integer>(), 6, 6, 3, 2, 150, 20));
		dadosArquivo.add(SetStringSize6(new ArrayList<Integer>(), 7, 7, 3, 3, 100, 10));		
		dadosArquivo.add(SetStringSize6(new ArrayList<Integer>(), 8, 8, 3, 5, 500, 10));
		dadosArquivo.add(SetStringSize3(new ArrayList<Integer>(), 9, 9, 2));
		dadosArquivo.add(SetStringSize6(new ArrayList<Integer>(), 10, 10, 3, 1, 100, 10));

		return dadosArquivo;
	}
	
	private ArrayList<ArrayList<Integer>> incializaJogadas(){
		ArrayList<ArrayList<Integer>> teste2 = new ArrayList<ArrayList<Integer>>();
		
		teste2.add(SetStringSize3(new ArrayList<Integer>(), 13, 3, 3000));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),	 1, 1, 3));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),  2, 2, 4));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),  3, 3, 6));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),  4, 1, 3));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),  5, 2, 2));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),  6, 3, 1));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),  7, 1, 1));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),  8, 2, 4));
		teste2.add(SetStringSize3(new ArrayList<Integer>(),  9, 3, 4));
		teste2.add(SetStringSize3(new ArrayList<Integer>(), 10, 1, 6));
		teste2.add(SetStringSize3(new ArrayList<Integer>(), 11, 2, 3));
		teste2.add(SetStringSize3(new ArrayList<Integer>(), 12, 3, 4));
		
		return teste2;
	}
	

	protected ArrayList<Integer> SetStringSize1(ArrayList<Integer> aux, int a){
		aux.add(a);
		return aux;
	}
	
	protected ArrayList<Integer> SetStringSize6(ArrayList<Integer> aux, int a, int b, int c, int d, int e, int f){
		aux.add(a);
		aux.add(b);
		aux.add(c);
		aux.add(d);
		aux.add(e);
		aux.add(f);
		return aux;
	}
	
	protected ArrayList<Integer> SetStringSize3(ArrayList<Integer> aux, int a, int b, int c){
		aux.add(a);
		aux.add(b);
		aux.add(c);
		return aux;
	}
	
	protected boolean ComparaLinha(ArrayList<Integer> linha, ArrayList<Integer> resp) {
		for (int i=0; i < linha.size(); i++) {
			if (resp.get(i).equals(linha.get(i)) == false){
				System.out.println(linha.get(i));
				System.out.println(resp.get(i));
				return false;
			}
		}
		return true;
	}
	
	
	protected boolean ComparaMatriz(ArrayList<ArrayList<Integer>> resp, ArrayList<ArrayList<Integer>> dadosArquivo) {
		int size = resp.size();
		if (size == dadosArquivo.size()) {
			for(int i=0; i<size; i++) {
				if(ComparaLinha(resp.get(i), dadosArquivo.get(i)) == false){
					return false;
				}
			}
			return true;
		}
		else return false;
	}


}
