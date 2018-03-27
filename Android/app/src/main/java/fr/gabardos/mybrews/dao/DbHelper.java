package fr.gabardos.mybrews.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper for database construction
 *
 * Created by Laurent on 26/03/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

	/* CONSTANTS */
	private final static String DATABASE_NAME = "MyBrews";
	private final static int DATABASE_VERSION = 1;

	private final static String CREATE_BREWS = "CREATE TABLE brews (id INTEGER PRIMARY KEY AUTOINCREMENT, ...);";

	/**
	 * Default constructor
	 *
	 * @param context Context to access database
	 */
	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Creation of all tables
		db.execSQL(CREATE_BREWS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS brews");
		db.execSQL(CREATE_BREWS);
	}
}
