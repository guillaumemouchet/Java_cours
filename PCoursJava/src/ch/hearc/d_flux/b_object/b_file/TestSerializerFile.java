
package ch.hearc.d_flux.b_object.b_file;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.d_flux.b_object.a_materiel.Equipe;

public class TestSerializerFile
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testClone() throws ClassNotFoundException, IOException
		{
		Equipe equipe = Equipe.createEquipe();
		Equipe equipeClone = (Equipe)SerializerFile.clone(equipe);

		System.out.println(equipe);
		System.out.println(equipeClone);

		Assertions.assertTrue(equipe.isEquals(equipeClone));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/


	}
