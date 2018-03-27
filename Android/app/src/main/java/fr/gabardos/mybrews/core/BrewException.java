package fr.gabardos.mybrews.core;

import android.content.Context;
import android.util.Log;

import fr.gabardos.mybrews.R;
import fr.gabardos.mybrews.util.AppUtil;

/**
 *
 * Created by Laurent on 26/03/2018.
 */

public class BrewException extends Exception {

	private Context context;
	private ErrorCodes code;
	private String message;

	public BrewException(Context context, ErrorCodes code) {
		this(context, code, null, null);
	}
	public BrewException(Context context, ErrorCodes code, Object[] params) {
		initFields(context, code, null, params);
	}
	public BrewException(Context context, String message, Object[] params) {
		initFields(context, ErrorCodes.ERROR_UNKNOWN, message, params);
	}

	public BrewException(Context context, ErrorCodes code, String message, Object[] params) {
		initFields(context, code, message, params);
	}

	private final void initFields(Context context, ErrorCodes code, String message, Object[] params) {

		if (AppUtil.isEmpty(message)) {
			int resourceId = context.getResources().getIdentifier("error.code." + code.getValue(), "string", "fr.gabardos.mybrews");
			if (resourceId == 0) {
				// invalid resource
				Log.e(context.getString(R.string.app_name), "Can't find error code n°" + code.getValue());
			} else {
				message = context.getResources().getString(resourceId, params);
			}
		}
		this.message = message;
		this.code = code;
		this.context = context;
	}

	public String getMessage() {
		return message;
	}

	public ErrorCodes getErrorCodes() {
		return code;
	}
}
