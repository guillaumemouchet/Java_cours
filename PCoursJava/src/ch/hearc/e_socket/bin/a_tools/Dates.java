
package ch.hearc.e_socket.bin.a_tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Dates
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public static String dateString()
		{
		return DATE_FORMAT.format(date());
		}

	public static Date date()
		{
		return new Date(System.currentTimeMillis());
		}
	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final String PATTERN_DATE = "dd.MM.yyyy HH:mm:ss";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(PATTERN_DATE, new Locale("da", "DK"));

	}

