package TabuleiroTeste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Jogadores.Jogador;
import Posicoes.*;
import Posicoes.TiposPosicao.*;
import Posicoes.TiposPosicao.TiposImoveis.*;
import Tabuleiro.Tabuleiro;

public class TabuleiroTeste {

	@Test
	public void testTabuleiro() {
		try {
			Jogador Banco = new Jogador(0, 0, 0);
			Tabuleiro tabuleiro = new Tabuleiro(Banco, "TabuleiroTeste.txt");
			ArrayList<Posicao> resp = inicializaResp(new ArrayList<Posicao>());

			resp.set(0, new Start());
			resp.set(1, new Comercio(Banco, 150, 20));
			resp.set(2, new Residencia(Banco, 100, 10));
			resp.set(3, new Hotel(Banco, 350, 30));
			resp.set(4, new Residencia(Banco, 100, 10));
			resp.set(5, new Comercio(Banco, 150, 20));
			resp.set(6, new Industria(Banco, 100, 10));
			resp.set(7, new Hospital(Banco, 500, 10));
			resp.set(8, new PassaVez());
			resp.set(9, new Industria(Banco, 100, 10));

			assertTrue(tabuleiro.getTabuleiro().equals(resp));

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private ArrayList<Posicao> inicializaResp(ArrayList<Posicao> resp) {
		for (int i = 0; i < 10; i++) {
			resp.add(new Posicao());
		}
		return resp;
	}
}
