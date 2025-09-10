
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.test.mouse.a_simple;

import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.MouseService;

/**
 * test du service independamment du remoteDesktop
 */
public class UseMouseService
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static void main(String[] args)
		{
		main();
		}

	public static void main()
		{
		//Threads.sleep(Integer.MAX_VALUE);

		//testLocation();
		//testMove();
		testClickLeft();
		testClickRight();
		//testTranslate();

		//final int N=10;
		//for(int i = 0; i < N; i++)
			{
//			while(true)
//				{
//				//System.out.println(MouseService.getInstance().location());
//				//MouseService.getInstance().translate(1, 0);
//				}
			}

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/




	private static void testLocation()
		{
		while(true)
			{
			System.out.println(MouseService.getInstance().location());
			}
		}

	private static void testMove()
		{
		MouseService.getInstance().move(1327, 713);
		}

	private static void testClickLeft()
		{
		MouseService.getInstance().clickLeft();
		}

	private static void testClickRight()
		{
		MouseService.getInstance().clickRight();
		}


	private static void testTranslate()
		{
		//MouseService.getInstance().translate(100, 0);
		//MouseService.getInstance().translate(0, 100);

		//MouseService.getInstance().translate(0, Integer.MAX_VALUE);
		//MouseService.getInstance().translate(0, -Integer.MAX_VALUE);

		//MouseService.getInstance().translate(Integer.MAX_VALUE, 0); // bizaRRE
		//MouseService.getInstance().translate(-Integer.MAX_VALUE, 0);
		}
	}
