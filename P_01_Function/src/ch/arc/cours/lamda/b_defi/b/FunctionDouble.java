
package ch.arc.cours.lamda.b_defi.b;

import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

/**
 * idem version precedente, mais en mieux!
 * On s'aide pour l'implemention de nos 3 methodes par defaut d'une methode generic op (cf prototype ci-dessous)
 */
@FunctionalInterface
public interface FunctionDouble extends Function<Double, Double>
	{
	/*------------------------------*\
	|*			  Default			*|
	\*------------------------------*/

	/**
	 * add this avec g
	 */
	public default FunctionDouble add(FunctionDouble g)
		{
		// lambda sans variable

		// TODO Contrainte : utiliser op ci-dessous
		return op(g, (f1, f2) -> f1 + f2);
		}

	/**
	 * multiply this avec g
	 */
	public default FunctionDouble mult(FunctionDouble g)
		{
		// lambda sans variable

		// TODO  Contrainte : utiliser op ci-dessous
		return op(g, (f1, f2) -> f1 * f2);
		}

	/**
	 * Eleve quoi au carrer? this!
	 */
	public default FunctionDouble carrer()
		{
		// lambda sans variable

		// TODO Contrainte : utiliser mult-ci dessus
		return this.mult(this);
		}

	/*------------------------------*\
	|*			  Version 1			*|
	\*------------------------------*/

	/**
	 * g= f1 op f2
	 * g(x) = f1(x) op f2(x)
	 *
	 * examples:
	 * 		op = +
	 * 		op = *
	 *
	 * Typage de op:
	 *	 op recoit:
	 * 		- f1(x) qui est un double
	 *  	- f2(x) qui est un double
	 *   op renvoie f1(x) + f2(x) qui est lui aussi un double
	 *
	 *   op est donc de type BiFunctionDouble=BiFunction<Double, Double, Double>
	 */
//	public default FunctionDouble op(FunctionDouble f2, BiFunctionDouble op)
//		{
//		return x -> op.apply(this.apply(x), f2.apply(x)); // TODO
//
//		}

	/*------------------------------*\
	|*			  Version 2			*|
	\*------------------------------*/

	// TODO
	//
	// Une fois useDefiB Fonctionel et ce fichier coder,  mettez en commentaire la methode op ci-dessus
	// Inventez une methode op qui fait la meme chose mais avec une signature differente
	// Tester là
	//
	// Indication : utiliser autre chose pour BiFunctionDouble !

	public default FunctionDouble op(FunctionDouble f2, DoubleBinaryOperator op)
		{
		return x -> op.applyAsDouble(this.apply(x), f2.apply(x)); // TODO
		}

	}
