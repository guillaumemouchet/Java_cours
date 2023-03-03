
package ch.arc.cours.z_annexe.material;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class DataBase
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static DoubleStream dataProvider()
		{
		return IntStream.range(0, 11).mapToDouble(i -> i * i);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
