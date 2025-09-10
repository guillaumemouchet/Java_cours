
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.test.mouse.b_gamepad;

import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.xeox.GamepadXeox;

public class UseGamePad
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
		useXeoxGamePad();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private static void useXeoxGamePad()
		{
		GamepadXeox.getInstance().addGamepadListener(new GamepadListenerLocal());
		}

	}
