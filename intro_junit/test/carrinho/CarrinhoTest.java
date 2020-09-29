package carrinho;



import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste da calculadora")
public class CarrinhoTest {
	
	Carrinho car;
	
	@BeforeEach
	public void inicializa() {
		car = new Carrinho();
	}
	
	@DisplayName("Testa a criação de um carrinho com 1 livro")
	@Test
	public void testCriaCarrinho() {
		Produto livro = new Produto("Livro Teste", 90.00);
		car.addItem(livro);
		assertAll("carrinho",
				() -> assertEquals(car.getQtdeItems(),1),
				() -> assertTrue(car.getValorTotal() == 90.00)
				);
	}
	
	@DisplayName("Testa a criação de um carrinho com + de 1 livro")
	@Test
	public void testCriaCarrinhoItens() {
		Produto livro = new Produto("Livro Teste 1", 90.00);
		car.addItem(livro);
		Produto livro2 = new Produto("Livro Teste 2", 90.00);
		car.addItem(livro2);
		Produto livro3 = new Produto("Livro Teste 3", 90.00);
		car.addItem(livro3);
		assertAll("carrinho",
				() -> assertEquals(car.getQtdeItems(),3),
				() -> assertTrue(car.getValorTotal() == 270.00)
				);
	}
	
	@DisplayName("Testa a criação de um carrinho e vazio")
	@Test
	public void testCriaCarrinhoVazio() {
		Produto livro = new Produto("Livro Teste 1", 90.00);
		car.addItem(livro);
		Produto livro2 = new Produto("Livro Teste 2", 90.00);
		car.addItem(livro2);
		Produto livro3 = new Produto("Livro Teste 3", 90.00);
		car.addItem(livro3);
		car.esvazia();
		assertEquals(car.getQtdeItems(),0);
	}
	
	@DisplayName("Testa a remoção de um item do carrinho")
	@Test
	public void testRemocaoCarrinho() throws ProdutoNaoEncontradoException {
		Produto livro = new Produto("Livro Teste 1", 90.00);
		car.addItem(livro);
		car.removeItem(livro);
		assertEquals(car.getQtdeItems(),0);
	}
	
	@DisplayName("Testa a remoção de um item do carrinho com exceção")
	@Test
	public void testRemocaoCarrinhoExc() throws ProdutoNaoEncontradoException {
		Produto livro = new Produto("Livro Teste 1", 90.00);
		Produto livro2 = new Produto("Livro Teste 2", 100.00);
		car.addItem(livro);
		assertThrows(ProdutoNaoEncontradoException.class,
				() -> car.removeItem(livro2));
	}
	
	
	
}