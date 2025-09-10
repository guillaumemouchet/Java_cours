package ch.hearc.d_flux.b_object.c_memoire;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ch.hearc.d_flux.b_object.a_materiel.Equipe;

public class TestSerializer
	{

	/*------------------------------------------------------------------*\
	 |*							Methodes Public							*|
	 \*-----------------------------------------------------------------*/

	@Test
	public void testClone() throws ClassNotFoundException, IOException
		{
		Equipe equipe = Equipe.createEquipe();
		Equipe equipeClone = (Equipe)Serializer.clone(equipe);

//		System.out.println(equipe);
//		System.out.println(equipeClone);

		Assertions.assertTrue(equipe.isEquals(equipeClone));
		}

	@Test
	public void testCloneGZip() throws ClassNotFoundException, IOException
		{
		Equipe equipe = Equipe.createEquipe();
		Equipe equipeClone = (Equipe)SerializerGZIP.clone(equipe);

//		System.out.println(equipe);
//		System.out.println(equipeClone);

		Assertions.assertTrue(equipe.isEquals(equipeClone));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}