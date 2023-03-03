
package ch.arc.cours.g_application.b_junit_parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ch.arc.cours.z_annexe.material.Calculatrice;

@TestMethodOrder(OrderAnnotation.class)
public class TestTuto1_parametrized
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	/**
	 * Derouler le test dans le plugin de votre IDE!
	 */
	@ParameterizedTest
	@CsvSource({ "1,2", "10, 11" })
	@Order(1)
	public void test1_hello(int x, int y)
		{
		int resultatEmpirique = Calculatrice.add(x, y);
		int resultatTheorique = x + y;

		Assertions.assertEquals(resultatEmpirique, resultatTheorique);
		}

	@ParameterizedTest
	@CsvSource({ //
			"1, 2, 3", //
			"10, 20, 30", //
			"100, 200, 300" })
	@Order(2)
	public void test2_hello(int x, int y, int expected)
		{
		assertEquals(Calculatrice.add(x, y), expected);// Import static, pas de Assetions ici
		}

	/**
	 * idem ci-dessus mais avec plus de verbositer!
	 */
	@ParameterizedTest(name = "{index}: add x={0}, y={1}, expected= {2}")
	@CsvSource({ //
			"1, 2, 3", //
			"10, 20, 30", //
			"100, 200, 300" })
	@Order(3)
	public void test3_verbosity_float(int x, int y, int expected)
		{
		assertEquals(Calculatrice.add(x, y), expected);
		}

	/**
	 * idem ci-dessus maisen double
	 */
	@ParameterizedTest(name = "{index}: multiply x={0}, y={1}, expected= {2}")
	@CsvSource({ //
			"1.2, 2, 2.4", //
			"1.23, 10, 12.3", //
			"1.234, 100, 123.4" })
	@Order(4)
	public void test4_verbosity_double(double x, double y, double expected)
		{
		assertEquals(Calculatrice.multiply(x, y), expected);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
