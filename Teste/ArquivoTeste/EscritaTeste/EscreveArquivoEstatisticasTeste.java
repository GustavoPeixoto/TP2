package ArquivoTeste.EscritaTeste;

import org.junit.Test;

import Arquivo.Escrita.EscreveArquivoEstatisticas;
import Estatisticas.EstatisticasJogador;

public class EscreveArquivoEstatisticasTeste {
	@Test
	public void testEscreverEstatisticas() {
		EstatisticasJogador e = new EstatisticasJogador();
		EscreveArquivoEstatisticas escreve = new EscreveArquivoEstatisticas();
		
		int i, j;
		for(i = 0; i<5; i++){
			e.setAluguelPago(50);
			e.setAluguelRecebido(40);
			e.setCompraImoveis(60.5);
			e.setDinheiro(700.6);
			for(j =0; j<2; j++) e.incrementarPassaVez();
			for(j =0; j<10; j++) e.incrementarRodadas();
			for(j =0; j<4; j++) e.incrementarVoltas();
			escreve.setEstatisticas(e);
		}
		System.out.println(e.getRodadas());
		escreve.escreverEstatisticas("EstatisticasTeste.txt");
	}

}
