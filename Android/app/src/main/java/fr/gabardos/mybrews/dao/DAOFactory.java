package fr.gabardos.mybrews.dao;

import android.content.Context;

import fr.gabardos.mybrews.bean.Brew;
import fr.gabardos.mybrews.core.BrewException;
import fr.gabardos.mybrews.core.ErrorCodes;

/**
 * Factory in order to create the correct DAO by object we want
 *
 * Created by Laurent on 26/03/2018.
 */

public class DAOFactory {
	/**
	 * @return A dao object in order to access database for Deals
	 */
	public static <T> DAO getDAO(Context context, Class<T> clazz) throws BrewException {

		if (clazz.equals(Brew.class)) {
			return new BrewDAO(context);
		}

		throw new BrewException(context, ErrorCodes.CLASS_NOT_MAPPED, new Object[] {clazz.getSimpleName()});
	}
}
