package fr.gabardos.mybrews.core;

/**
 *
 * Created by Laurent on 26/03/2018.
 */

public enum ErrorCodes {

	ERROR_UNKNOWN(-1),

	// SQL ERROR CODES
	CLASS_NOT_MAPPED(1), TOO_MANY_RESULT(2), OBJECT_NOT_FOUND(3)
	;

	private int code;
	ErrorCodes(int code) {
		this.code = code;
	}

	public int getValue() {
		return code;
	}

//	public final static int ERROR_UNKNOWN = -1;
//
//	/* ***************************************************************************************** */
//	/* ** SQL ERROR CODES ********************************************************************** */
//	/* ***************************************************************************************** */
//	public static int CLASS_NOT_MAPPED = 1;

}
