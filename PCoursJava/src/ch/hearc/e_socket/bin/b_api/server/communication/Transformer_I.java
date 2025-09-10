
package ch.hearc.e_socket.bin.b_api.server.communication;

import java.io.Serializable;

/**
 * <pre>
 * TMessage  type generic qui doit etre Serializable
 * TResponse type generic qui doit etre Serializable
 * </pre>
 */
@FunctionalInterface
public interface Transformer_I<TMessage extends Serializable, TResponse extends Serializable>
	{

	/**
	 * <pre>
	 * Toute la semantique de ce que dois faire le serveur, est modliser dans cette interface.
	 * Le serveur recoit un message, il fait quoi avec?
	 *
	 *  Notes
	 * 		(N1) Astucieux! prémisse de la programmazion functionelle
	 *
	 * 		(N2) peut renvoyer null
	 * </pre>
	 */
	public TResponse transform(TMessage serializable);

	}
