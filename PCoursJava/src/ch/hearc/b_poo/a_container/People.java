
package ch.hearc.b_poo.a_container;

public class People //extends Object //pas obligatoire, le fait automatiquement
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public People(String name, int age)
		{
		this.name = name;
		this.age = age;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append(TITLE);
		builder.append(this.name);
		builder.append(MIDDLE);
		builder.append(this.age);
		builder.append(END);
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getName()
		{
		return this.name;
		}

	public int getAge()
		{
		return this.age;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//input et output
	private String name;

	private int age;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/
	//une instance par classe

	//a faire pour ne pas créer plusieurs strings
	private static final String TITLE = "People [name=";

	private static final String MIDDLE = ", age=";

	private static final String END = "]";

	}
