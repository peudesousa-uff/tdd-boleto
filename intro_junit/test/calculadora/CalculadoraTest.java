package calculadora;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testa a soma de dois n�meros positivos")
	@Test
	public void testSomaDoisNumerosPos() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a soma de dois n�meros negativos")
	@Test
	public void testSomaDoisNumerosNeg() {
		int soma = calc.soma(-2, -3);		
		Assertions.assertEquals(-5, soma);		
	}
	
	
	@DisplayName("Testa a subtra��o de dois n�meros")
	@Test
	public void testSubDoisNumeros() {
		int subtracao = calc.subtracao(2, 5);		
		Assertions.assertEquals(-3, subtracao);		
	}
	
	@DisplayName("Testa a subtra��o de dois n�meros com negativo")
	@Test
	public void testSubDoisNumerosNeg() {
		int subtracao = calc.subtracao(2, -5);		
		Assertions.assertEquals(7, subtracao);		
	}
	
	@DisplayName("Testa a multiplica��o de dois n�meros")
	@Test
	public void testMultDoisNumeros() {
		int mult = calc.multiplicacao(9, 5);		
		Assertions.assertEquals(45, mult);		
	}
	
	@DisplayName("Testa a multiplica��o por zero")
	@Test
	public void testMultPorZero() {
		int mult = calc.multiplicacao(9, 0);		
		assertTrue(mult == 0);		
	}
	
	@DisplayName("Testa a multiplica��o por negativo")
	@Test
	public void testMultPorNeg() {
		int mult = calc.multiplicacao(9, -2);		
		assertTrue(mult == -18);		
	}
	
	@DisplayName("Testa a multiplica��o de zero por negativo")
	@Test
	public void testMultZeroPorNeg() {
		int mult = calc.multiplicacao(0, -2);		
		assertTrue(mult == 0);		
	}
	
	
	@DisplayName("Testa a divis�o de dois n�meros")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa a divis�o por zero com fail")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exce��o n�o lan�ada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa a divis�o por zero com Throws")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a divis�o por negativo")
	@Test
	public void testDivisaoPorNeg() {
		int divisao = calc.divisao(8, -2);
		assertTrue(divisao == -4);
	}
	
	@DisplayName("Testa a fun��o somat�ria")
	@Test
	public void testSomatoria() {
		int somat = calc.somatoria(5);
		assertTrue(somat == 15);
	}
	
	@DisplayName("Testa a fun��o somat�ria com n < 0")
	@Test
	public void testSomatoriaNeg() {
		int somat = calc.somatoria(-1);
		assertEquals(somat,0);
	}
	
	@DisplayName("Testa a fun��o ehPositivo")
	@Test
	public void testPositivo() {
		assertTrue(calc.ehPositivo(5));
	}
	
	@DisplayName("Testa a fun��o ehPositivo com zero")
	@Test
	public void testPositivoZero() {
		assertTrue(calc.ehPositivo(0));
	}
	
	@DisplayName("Testa a fun��o ehPositivo com negativo")
	@Test
	public void testPositivoNeg() {
		assertFalse(calc.ehPositivo(-5));
	}
	
	@DisplayName("Testa a fun��o compara com numeros iguais")
	@Test
	public void testComparaIguais() {
		int num = calc.compara(1, 1);
		assertEquals(0, num);
	}
	
	@DisplayName("Testa a fun��o compara com numeros a > b")
	@Test
	public void testComparaMaior() {
		int num = calc.compara(5, 2);
		assertEquals(1, num);
	}
	
	@DisplayName("Testa a fun��o compara com numeros a < b")
	@Test
	public void testComparaMenor() {
		int num = calc.compara(2, 3);
		assertEquals(-1, num);
	}

}