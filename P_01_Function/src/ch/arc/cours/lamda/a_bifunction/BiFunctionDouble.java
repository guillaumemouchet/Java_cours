
package ch.arc.cours.lamda.a_bifunction;

import java.util.function.BiFunction;

/**
 * <pre>
 * Represente les fonctions a deux variables:
 *
 * 		f : R x R --->R
 *
 * exemple : f(x1,x2)=x1+x2
 * </pre>
 */
@FunctionalInterface
public interface BiFunctionDouble extends BiFunction<Double, Double, Double>
	{
	/*------------------------------*\
	|*			  Default			*|
	\*------------------------------*/

	/**
	 * h(x1,x2)= f1(x1,x2)+f2(x1,x2)
	 * f1 est this
	 */
	// TODO write default methode add
	// a faire en dernier apres le use !!
	// attention au prototype!
	// this c'est quoi?

	public default BiFunctionDouble add(BiFunctionDouble f)
		{
		return (x, y) -> apply(x, y) + f.apply(x, y);
		}
	}
