package fr.gabardos.mybrews.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Util class
 * Created by Laurent on 23/03/2018.
 */

public class AppUtil {

	/**
	 * Format date in sql pattern yyyy-MM-dd hh:mm:ss
	 * @param d The date to format
	 * @return The date in SQL format
	 */
	public static String formatDateYMDHMS(Date d) {
		SimpleDateFormat formatter =  new SimpleDateFormat(Constants.DATE_FORMAT_YMDHMS);
		return formatter.format(d);
	}

	/**
	 * Parse date from sql pattern yyyy-MM-dd hh:mm:ss
	 * @param date The date to parse
	 * @return The date
	 */
	public static Date parseDateYMDHMS(String date) {
		SimpleDateFormat formatter =  new SimpleDateFormat(Constants.DATE_FORMAT_YMDHMS);
		try {
			return formatter.parse(date);
		} catch (ParseException ex) {
			return null;
		}
	}

	/**
	 * Check if string is null or empty
	 * @param s The string to test
	 * @return true if string is null or empty, false otherwise
	 */
	public static boolean isEmpty(String s) {
		return s == null || "".equals(s);
	}
	/**
	 * Check if List is null or empty
	 * @param l The list to test
	 * @return true if list is null or empty, false otherwise
	 */
	public static boolean isEmpty(List<?> l) {
		return l == null || l.size() == 0;
	}
}
