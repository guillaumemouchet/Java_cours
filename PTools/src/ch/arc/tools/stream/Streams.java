
package ch.arc.tools.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static <T> Stream<T> stream(final Iterable<T> iterable)
		{
		return toStream(iterable, false);
		}

	public static <T> Stream<T> parallelStream(final Iterable<T> iterable)
		{
		return toStream(iterable, true);
		}

	/*------------------------------*\
	|*	catch Exception in foreach	*|
	\*------------------------------*/

	public static <T> Consumer<T> throwing(ThrowingConsumer<T, Exception> throwingConsumer)
		{
		return i -> {
		try
			{
			throwingConsumer.accept(i);
			}
		catch (Exception ex)
			{
			throw new RuntimeException(ex);
			}
		};
		}

	public static <T> IntConsumer throwingInt(ThrowingConsumerInt throwingConsumer)
		{
		return i -> {
		try
			{
			throwingConsumer.accept(i);
			}
		catch (Exception ex)
			{
			throw new RuntimeException(ex);
			}
		};
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static <T> Stream<T> toStream(final Iterable<T> iterable, final boolean isParallel)
		{
		return StreamSupport.stream(iterable.spliterator(), isParallel);
		}
	}
