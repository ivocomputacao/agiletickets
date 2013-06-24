package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SessaoTest {
	private Sessao sessao;
	
	/**
	 * O before faz o junit rodar sempre antes de cada teste, para cada teste ele roda esse metodo.
	 */
	@Before
	public void inicializa() {
		this.sessao = new Sessao();
	}

	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = this.sessao;
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}
	/**
	 * Não é legar colocar esse nome, tinha que ficar um texto mais generico, tipo nao posso vender mais que tenho
	 * @throws Exception
	 */
	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = this.sessao;
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = this.sessao;
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void podeReservarTodosIngressosDisponiveis() throws Exception {
		Sessao sessao = this.sessao;
		sessao.setTotalIngressos(10);
		Assert.assertEquals(true,sessao.podeReservar(10));
	}
}
