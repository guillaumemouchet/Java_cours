package ch.hearc.b_poo.e_interface.factory.b_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.b_poo.e_interface.factory.a_specification.Calculatrice_I;
import ch.hearc.b_poo.e_interface.factory.d_implementation.FactoryCalculatrice;

public class TestCalculatrice
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testAddition()
		{
		Calculatrice_I calculatrice = FactoryCalculatrice.create();

		double x = 5.9;
		double y = 1.1;

		double resultatTheorique = 7;
		double resultatEmpirique = calculatrice.add(x, y);

		Assertions.assertEquals(resultatTheorique, resultatEmpirique);
		}

	@Test
	public void testMultiplication()
		{
		Calculatrice_I calculatrice = FactoryCalculatrice.create();

		double x = 5.9;
		double y = 1.1;

		double resultatTheorique = x * y;
		double resultatEmpirique = calculatrice.multiply(x, y);

		Assertions.assertEquals(resultatTheorique, resultatEmpirique);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}