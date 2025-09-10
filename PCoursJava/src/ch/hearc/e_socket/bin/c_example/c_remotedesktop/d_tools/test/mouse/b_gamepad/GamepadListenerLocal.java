
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.test.mouse.b_gamepad;

import ch.hearc.device.usb.api.generic.listener.ComponentEvent;
import ch.hearc.device.usb.api.generic.listener.GamepadListener;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.MouseService;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.xeox.ComponentXeox;

public class GamepadListenerLocal implements GamepadListener
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public GamepadListenerLocal()
		{
		this.mouseService = MouseService.getInstance();
		this.move = new Move();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void connected(Object object) // aie pas d'adapter dans cette version
		{
		// rien
		}

	@Override
	public void componentPerformed(ComponentEvent event)
		{
		xeoxPerformed(event);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/**
	 * GamepadXEOX
	 */
	private void xeoxPerformed(ComponentEvent event)
		{
		ComponentXeox componentXeox = (ComponentXeox)event.getSource();

		double value = event.getValue();
		//System.out.println("[XeoxListener] : " + value);

		switch(componentXeox)
			{
			case BUTTON_X:
				{
				mouseService.clickLeft();
				break;
				}
			case BUTTON_B:
				{
				mouseService.clickRight();
				break;
				}
			case BUTTON_A:
				{
				mouseService.doubleClickLeft();
				break;
				}
			case JOYSTICK_RIGHT_LEFT_RIGHT:
				{
				move.updateDX(value);
				break;
				}
			case JOYSTICK_RIGHT_UP_DOWN:
				{
				move.updateDY(value);
				break;
				}
			default:
				{
				// rien
				break;
				}
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Input
	private MouseService mouseService;

	// Tools
	private Move move;
	}
