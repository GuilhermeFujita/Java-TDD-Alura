package br.com.caelum.leilao.teste;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;
import junit.framework.Assert;

public class AvaliadorTest {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
		//Scenario
		Usuario joao  = new Usuario("Joao");
		Usuario jose  = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 3 novo");
		
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		
		//Actions
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//Comparing expected vs exit
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
		
		
	}
}
