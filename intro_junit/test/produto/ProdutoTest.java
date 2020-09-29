package produto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdução ao Teste de Software", 100.00);
	}
	
	@DisplayName("Testa a criação de um produto e seus parametros")
	@Test
	public void testCriaProduto() {
		Assertions.assertAll("livro",
				() -> assertEquals("Introdução ao Teste de Software", livro.getNome()),
				() -> assertTrue(100.00 == livro.getPreco())						
				);
	}
	
	@DisplayName("Testa a diferença entre 2 produtos")
	@Test
	public void testProdutosIguais() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		
		assertNotSame(livro, livro2);
		
	}
	
	@DisplayName("Testa a função setNome")
	@Test
	public void testSetNome() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		livro2.setNome("Teste Nome");
	    assertEquals("Teste Nome", livro2.getNome());
		
	}
	
	@DisplayName("Testa a função getPreco")
	@Test
	public void testGetPreco() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
	    assertNotEquals(100.00, livro2.getPreco());
		
	}
	
	@DisplayName("Testa a função setPreco")
	@Test
	public void testSetPreco() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		livro2.setPreco(150.30);
	    assertEquals(150.30, livro2.getPreco());
		
	}
	

	@DisplayName("Testes com Hamcrest")
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(livro.getPreco(), equalTo(100.00));
		assertThat(livro.getNome(), notNullValue());
		assertThat(livro.getNome(), containsString("Teste"));
		assertThat(livro, instanceOf(Produto.class));
	}
	
	

}