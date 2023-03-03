
package ch.arc.cours.lamda.b_defi.a;

import java.util.function.Function;

//TODO
public interface FunctionDouble extends Function<Double, Double>
	{
	/*------------------------------*\
	|*			  Default			*|
	\*------------------------------*/

	// TODO
	//
	// Ajouter des default methode pour:
	//		- additioner deux fonctions	g et h :	g(x)+h(x)
	//		- multiplier deux fonctions	g et h :	g(x)*h(x)
	//		- elever au carrer une fonction g  :	g(x)*g(x)
	//
	// Indication : attention au prototype et a  this!

	public default FunctionDouble add(FunctionDouble h)
		{
		return x -> this.apply(x) + h.apply(x);
		}

	public default FunctionDouble mult(FunctionDouble h)
		{
		return x -> this.apply(x) * h.apply(x);
		}

	public default FunctionDouble square()
		{
		return x -> this.apply(x) * this.apply(x);
		}

	}
