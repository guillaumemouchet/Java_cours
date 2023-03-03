
package ch.arc.tools.stream;

@FunctionalInterface
public interface ThrowingConsumerInt<E extends Exception>
	{

	void accept(int i) throws E;
	}
