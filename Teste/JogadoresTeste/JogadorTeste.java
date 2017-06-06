package JogadoresTeste;

import static org.junit.Assert.*;

import org.junit.Test;

import Jogadores.Jogador;

public class JogadorTeste {

	@Test
	public void testJogarDados() {
		Jogador x = new Jogador(0, 0, 0);
		
		x.jogarDados(5, 10);
		assertTrue(x.getPosicaoAtual() == 5);
		
		x.jogarDados(6, 8);
		assertTrue(x.getPosicaoAtual() == 3);
	}

	@Test
	public void testComprarImovel() {
		Jogador x = new Jogador(200, 0, 0);
		
		assertTrue(x.comprarImovel(199, 3) && x.getSaldo() == 1);
		assertTrue(!x.comprarImovel(200, 3));

	}

	@Test
	public void testReceberAluguel() {
		Jogador x = new Jogador(7, 0, 0);
		x.receberAluguel(10);
		assertTrue(x.getSaldo() == 17);
	}

	@Test
	public void testPagarAluguel() {
		Jogador x = new Jogador(27, 0, 0);
		assertTrue(x.pagarAluguel(10) && x.getSaldo() == 17);
		
		x.pagarAluguel(20);
		assertTrue(!x.pagarAluguel(20));
	}

}
