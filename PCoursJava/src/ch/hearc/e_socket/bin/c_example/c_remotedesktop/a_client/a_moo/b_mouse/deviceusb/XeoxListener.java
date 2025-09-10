
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.b_mouse.deviceusb;

import ch.hearc.device.usb.api.generic.listener.ComponentEvent;
import ch.hearc.device.usb.api.generic.listener.GamepadListener;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.a_client.a_moo.b_mouse.SocketClientMouse;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.mouse.MouseAction;
import ch.hearc.e_socket.bin.c_example.c_remotedesktop.d_tools.xeox.ComponentXeox;

public class XeoxListener implements GamepadListener
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public XeoxListener(SocketClientMouse socketClientMouse)
		{
		// Input
			{
			this.socketClientMouse = socketClientMouse;
			}

		// Tools
			{
			this.move = new Move(socketClientMouse);
			}
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
		ComponentXeox componentXeox = (ComponentXeox)event.getSource();

		double value = event.getValue();
		//System.out.println("[XeoxListener] : " + value);
		//System.out.println("[XeoxListener] : " + componentXeox);

		switch(componentXeox)
			{
			case BUTTON_X:
				{
				socketClientMouse.sendMouseAction(MouseAction.CLICK_LEFT);
				break;
				}
			case BUTTON_B:
				{
				socketClientMouse.sendMouseAction(MouseAction.CLICK_RIGHT);
				break;
				}
			case BUTTON_A:
				{
				socketClientMouse.sendMouseAction(MouseAction.DOUBLE_CLICK_LEFT);
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
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private SocketClientMouse socketClientMouse;

	// Tools
	private Move move;

	}
