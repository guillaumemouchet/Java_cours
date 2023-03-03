
package ch.arc.cours.z_annexe.tools;

import java.io.Serializable;

/**
 * Wrapper Alterable
 */
public class Int implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Int(int i)
		{
		this.i = i;
		}

	public Int(Int source)
		{
		this(source.intvalue());
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		return EMPTY + i;
		}

	public Int cloneOf()
		{
		return new Int(this);
		}

	@Override
	protected Int clone() throws CloneNotSupportedException
		{
		return this.cloneOf();
		}

	public int inc()
		{
		i++;
		return i;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int intvalue()
		{
		return this.i;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setValue(int i)
		{
		this.i = i;
		}

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static int sum(int a, int b)
		{
		return a + b;
		}

	public static int prod(int a, int b)
		{
		return a * b;
		}

	public static int inc(int a)
		{
		return a + 1;
		}

	public static boolean isPaire(int x)
		{
		return x % 2 == 0;
		}

	public static boolean isImpaire(int x)
		{
		return x % 2 != 0;
		}

	public static int compare(Int i1, Int i2)
		{
		return Integer.compare(i1.i, i2.i);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private int i;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final String EMPTY = "";

	}
