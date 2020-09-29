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
	
	@DisplayName("Testa a soma de dois números positivos")
	@Test
	public void testSomaDoisNumerosPos() {
		int soma = calc.soma(4, 5);		
		Assertions.assertEquals(9, soma);		
	}
	
	@DisplayName("Testa a soma de dois números negativos")
	@Test
	public void testSomaDoisNumerosNeg() {
		int soma = calc.soma(-2, -3);		
		Assertions.assertEquals(-5, soma);		
	}
	
	
	@DisplayName("Testa a subtração de dois números")
	@Test
	public void testSubDoisNumeros() {
		int subtracao = calc.subtracao(2, 5);		
		Assertions.assertEquals(-3, subtracao);		
	}
	
	@DisplayName("Testa a subtração de dois números com negativo")
	@Test
	public void testSubDoisNumerosNeg() {
		int subtracao = calc.subtracao(2, -5);		
		Assertions.assertEquals(7, subtracao);		
	}
	
	@DisplayName("Testa a multiplicação de dois números")
	@Test
	public void testMultDoisNumeros() {
		int mult = calc.multiplicacao(9, 5);		
		Assertions.assertEquals(45, mult);		
	}
	
	@DisplayName("Testa a multiplicação por zero")
	@Test
	public void testMultPorZero() {
		int mult = calc.multiplicacao(9, 0);		
		assertTrue(mult == 0);		
	}
	
	@DisplayName("Testa a multiplicação por negativo")
	@Test
	public void testMultPorNeg() {
		int mult = calc.multiplicacao(9, -2);		
		assertTrue(mult == -18);		
	}
	
	@DisplayName("Testa a multiplicação de zero por negativo")
	@Test
	public void testMultZeroPorNeg() {
		int mult = calc.multiplicacao(0, -2);		
		assertTrue(mult == 0);		
	}
	
	
	@DisplayName("Testa a divisão de dois números")
	@Test
	public void testDivisaoDoisNumeros() {
		int divisao = calc.divisao(8, 4);
		assertTrue(divisao == 2);
	}
	
	@DisplayName("Testa a divisão por zero com fail")
	@Test
	public void testDivisaoPorZero() {
		try {
			int divisao = calc.divisao(8, 0);
			fail("Exceção não lançada");
		}catch (ArithmeticException e) {
			assertEquals("/ by zero", e.getMessage());
		}		
	}
	
	@DisplayName("Testa a divisão por zero com Throws")
	@Test
	public void testDivisaoPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	@DisplayName("Testa a divisão por negativo")
	@Test
	public void testDivisaoPorNeg() {
		int divisao = calc.divisao(8, -2);
		assertTrue(divisao == -4);
	}
	
	@DisplayName("Testa a função somatória")
	@Test
	public void testSomatoria() {
		int somat = calc.somatoria(5);
		assertTrue(somat == 15);
	}
	
	@DisplayName("Testa a função somatória com n < 0")
	@Test
	public void testSomatoriaNeg() {
		int somat = calc.somatoria(-1);
		assertEquals(somat,0);
	}
	
	@DisplayName("Testa a função ehPositivo")
	@Test
	public void testPositivo() {
		assertTrue(calc.ehPositivo(5));
	}
	
	@DisplayName("Testa a função ehPositivo com zero")
	@Test
	public void testPositivoZero() {
		assertTrue(calc.ehPositivo(0));
	}
	
	@DisplayName("Testa a função ehPositivo com negativo")
	@Test
	public void testPositivoNeg() {
		assertFalse(calc.ehPositivo(-5));
	}
	
	@DisplayName("Testa a função compara com numeros iguais")
	@Test
	public void testComparaIguais() {
		int num = calc.compara(1, 1);
		assertEquals(0, num);
	}
	
	@DisplayName("Testa a função compara com numeros a > b")
	@Test
	public void testComparaMaior() {
		int num = calc.compara(5, 2);
		assertEquals(1, num);
	}
	
	@DisplayName("Testa a função compara com numeros a < b")
	@Test
	public void testComparaMenor() {
		int num = calc.compara(2, 3);
		assertEquals(-1, num);
	}

}