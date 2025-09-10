
package ch.hearc.c_gui.a_listener.a_hello;

public class UseJFrameHello
	{
	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		System.out.println("fin:" + Thread.currentThread().getName());
		}

	public static void main()
		{
		new JFrameHello();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	}
