
package ch.arc.cours.z_annexe.material;

public class TeamTools
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static Team create(int n)
		{
		Team team = new Team();

		for(int i = 0; i < n; i++)
			{
			Homme homme = new Homme(i, i * 10);
			team.add(homme);
			}

		return team;
		}

	public static Homme[] createTab(int n)
		{
		Homme[] tab= new Homme[n];

		for(int i = 1; i <= n; i++)
			{
			Homme homme = new Homme(-i, -i * 10);
			tab[i-1]=homme;
			}

		return tab;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
