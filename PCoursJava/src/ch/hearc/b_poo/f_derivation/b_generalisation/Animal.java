
package ch.hearc.b_poo.f_derivation.b_generalisation;

import java.util.Objects;

public abstract class Animal implements Comparable<Animal>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	protected Animal(String name)
		{
		this.name = name;
		}

	protected Animal(Animal source)
		{
		this(source.name); // Si le nom est un StringBuilder : this(new StringBuilder(source.name));
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Abstract						*|
	\*------------------------------------------------------------------*/

	public abstract String eat();

	public abstract Animal cloneOf();

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public String nameHierarchie()
		{
		return Animal.class.getSimpleName();
		}

	@Override
	public String toString()
		{
		return this.nameHierarchie() + SEPARATOR + this.getName() + SEPARATOR + "eats " + this.eat();
		}

	@Override
	public int compareTo(Animal animal2)
		{
		return this.name.compareTo(name);
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	public boolean isEquals(Animal animal2)
		{
		return this.equals(animal2);
		}

	@Override
	public boolean equals(Object object2)
		{
		if (this == object2)
			{
			return true;
			}
		else
			{
			if (!this.getClass().equals(object2.getClass()))
				{
				return false;
				}
			else
				{
				Animal animal2 = (Animal)object2;
				return this.name.equals(animal2.name);
				}
			}
		}

	public int hashcode()
		{
		return Objects.hashCode(this.name);
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// input et output
	private String name;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	protected static final String SEPARATOR = " : ";
	protected static final String CLASS_SEPARATOR = ".";
	}
