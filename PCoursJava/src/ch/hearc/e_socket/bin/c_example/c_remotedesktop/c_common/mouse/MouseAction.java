
package ch.hearc.e_socket.bin.c_example.c_remotedesktop.c_common.mouse;

import java.io.Serializable;
import java.util.Objects;

public class MouseAction implements Serializable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public MouseAction(int dx, int dy, ClickType clickType)
		{
		this.dx = dx;
		this.dy = dy;
		this.clickType = clickType;
		}

	public MouseAction(int dx, int dy)
		{
		this(dx, dy, ClickType.NONE);
		}

	public MouseAction(ClickType clickType)
		{
		this(0, 0, clickType);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public String toString()
		{
		StringBuilder builder = new StringBuilder();
		builder.append("MouseAction [dx=");
		builder.append(this.dx);
		builder.append(", dy=");
		builder.append(this.dy);
		builder.append(", clickType=");
		builder.append(this.clickType);
		builder.append("]");
		return builder.toString();
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public int getDx()
		{
		return this.dx;
		}

	public int getDy()
		{
		return this.dy;
		}

	public ClickType getClickType()
		{
		return this.clickType;
		}

	/*------------------------------*\
	|*				equals			*|
	\*------------------------------*/

	public boolean isEquals(MouseAction mouseAction2)
		{
		if (this == mouseAction2)
			{
			return true;
			}
		else
			{
			return this.dx == mouseAction2.dx //
					&& this.dy == mouseAction2.dy //
					&& this.clickType == mouseAction2.clickType;
			}
		}

	@Override
	public boolean equals(Object object2)
		{
		if (object2.getClass().equals(this.getClass()))
			{
			return isEquals((MouseAction)object2);
			}
		else
			{
			return false;
			}
		}

	@Override
	public int hashCode()
		{
		return Objects.hash(dx, dy, clickType);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Inputs
	private int dx;
	private int dy;
	private ClickType clickType;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static final MouseAction CLICK_LEFT = new MouseAction(ClickType.LEFT_CLICKED);
	public static final MouseAction CLICK_RIGHT = new MouseAction(ClickType.RIGHT_CLICKED);
	public static final MouseAction DOUBLE_CLICK_LEFT = new MouseAction(ClickType.DOUBLE_CLICK_LEFT);
	}
