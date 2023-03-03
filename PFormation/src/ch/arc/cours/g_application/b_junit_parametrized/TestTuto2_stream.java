
package ch.arc.cours.g_application.b_junit_parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ch.arc.cours.z_annexe.material.Calculatrice;

/**
 * Stream comme methode source d'un test @ParameterizedTest
 */
@TestMethodOrder(OrderAnnotation.class)
public class TestTuto2_stream
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	/**
	 * Derouler le test dans le plugin de votre IDE!
	 */
	@ParameterizedTest
	@MethodSource("dataProvider1")
	@Order(1)
	void test1_hello(double x)
		{
		assertEquals(Calculatrice.sqrt(x), Math.sqrt(x));
		}

	@ParameterizedTest
	@MethodSource("dataProvider2")
	@Order(2)
	void test2_hello(double x)
		{
		assertEquals(Calculatrice.sqrt(x), Math.sqrt(x));
		}

	/**
	 * un tableau
	 */
	@ParameterizedTest(name = "{index}: {0}, x and sqrt(x) expected")
	@MethodSource("dataProvider3")
	@Order(3)
	void test3_tab(double[] tab)
		{
		assertEquals(Calculatrice.sqrt(tab[1]), tab[0]);
		}

	/**
	 * idem ci-dessus, mais le tableau est remplacer par la technique de l'argument
	 */
	@ParameterizedTest(name = "{index}: x = {0}, sqrt({0})= {1} expected")
	@MethodSource("dataProviderArguments")
	@Order(4)
	void test4_arguments(int x, int sqrtxExpected)
		{
		assertEquals(Calculatrice.sqrt(x), sqrtxExpected);
		}

	/**
	 * depuis un "provider" extern
	 */
	@ParameterizedTest
	@MethodSource("ch.arc.cours.g_annexe.material.DataBase#dataProvider") // nomPackage#nomMethodStatic
	@Order(5)
	void test5_externe(double x)
		{
		assertEquals(Calculatrice.sqrt(x), Math.sqrt(x));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static Stream<Double> dataProvider1()
		{
		return Stream.of(4d, 9d, 16d);
		}

	private static DoubleStream dataProvider2()
		{
		return IntStream.range(0, 11).mapToDouble(i -> i * i);
		}

	/*------------------------------*\
	|*			  sqrt				*|
	\*------------------------------*/

	private static Stream<double[]> dataProvider3()
		{
		return IntStream.range(0, 11).mapToObj(i -> new double[] { i, i * i });
		}

	/**
	 * Input
	 */
	private static Stream<Arguments> dataProviderArguments()
		{
		return IntStream.range(0, 11).mapToObj(i -> Arguments.of(i * i, i));
		}

	}
