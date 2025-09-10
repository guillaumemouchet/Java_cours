
package ch.hearc.b_poo.d_template;

import java.util.LinkedList;
import java.util.List;

public class Pile<T>
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Pile()
		{
		this.list = new LinkedList<T>();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public synchronized int size()
		{
		return this.list.size();
		}

	public synchronized void push(T element)
		{
		this.list.add(element);
		}

	/**
	 * Warning : Non protégé si taille vide
	 */
	public synchronized T pop()
		{
		// Problème de concurrence, il peut y avoir 2 pop en même temps
		// dans 2 thread différents
		// -> Système de jeton => synchronized (désavantage : lent)

		int index = this.size() - 1;
		return this.list.remove(index);
		}

	@Override
	public synchronized String toString()
		{
		return this.list.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// tools
	private List<T> list;
	}
