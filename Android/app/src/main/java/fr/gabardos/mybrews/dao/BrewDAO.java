package fr.gabardos.mybrews.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.gabardos.mybrews.bean.Brew;
import fr.gabardos.mybrews.core.BrewException;
import fr.gabardos.mybrews.core.ErrorCodes;
import fr.gabardos.mybrews.util.AppUtil;

/**
 * DAO to access Brew objects in database
 * Created by Laurent on 26/03/2018.
 */

public class BrewDAO extends DAO<Brew> {

	private static List<String> fields = new ArrayList<>();
	static {
		fields.add("id");
		fields.add("dateCreate");
		fields.add("title");
		fields.add("description");
		fields.add("image");
	}

	public BrewDAO(Context context) {
		this.context = context;
		sqlHelper = new DbHelper(context);
		table = "brew";
	}

	@Override
	public long create(Brew obj) throws BrewException {
		SQLiteDatabase db = sqlHelper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put("id", obj.getId());
		cv.put("dateCreate", AppUtil.formatDateYMDHMS(obj.getDateCreate()));
		cv.put("title", obj.getTitle());
		cv.put("description", obj.getDescription());
		cv.put("image", obj.getImage());

		long toReturn = db.insert(table, "", cv);

		db.close();

		if (toReturn == -1) {
			throw new BrewException(context, ErrorCodes.OBJECT_NOT_FOUND, new Object[] {Brew.class.getSimpleName(), obj.getId()});
		}

		return toReturn;
	}

	@Override
	public boolean delete(Brew obj) throws BrewException {

		if (obj == null || obj.getId() == 0) return false;

		SQLiteDatabase db = sqlHelper.getReadableDatabase();

		int nbDelete = db.delete(table, "id=?", new String[] { Integer.toString(obj.getId()) });

		db.close();

		if (nbDelete == 0) {
			throw new BrewException(context, ErrorCodes.OBJECT_NOT_FOUND, new Object[] {Brew.class.getSimpleName(), obj.getId()});
		}

		return nbDelete == 1;
	}

	@Override
	public boolean update(Brew obj) throws BrewException {
		// update brew from database
		SQLiteDatabase db = sqlHelper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put("id", obj.getId());
		cv.put("dateCreate", AppUtil.formatDateYMDHMS(obj.getDateCreate()));
		cv.put("title", obj.getTitle());
		cv.put("description", obj.getDescription());
		cv.put("image", obj.getImage());

		int updated = db.update(table, cv, "id=?", new String[] { Integer.toString(obj.getId()) });

		db.close();

		if (updated == 0) {
			throw new BrewException(context, ErrorCodes.OBJECT_NOT_FOUND, new Object[] {Brew.class.getSimpleName(), obj.getId()});
		}

		return true;
	}

	@Override
	public Brew find(int id) throws BrewException {
		List<Brew> toReturn = new ArrayList<>();

		SQLiteDatabase db = sqlHelper.getReadableDatabase();
		Cursor cursor = db.query(table, fields.toArray(new String[0]), "id",
				new String[] {Integer.toString(id)}, null, null,
				null, null);
		if (cursor.moveToFirst()) {
			do {

				Brew b = new Brew();

				b.setId(cursor.getInt(0));
				b.setDateCreate(AppUtil.parseDateYMDHMS(cursor.getString(1)));
				b.setTitle(cursor.getString(2));
				b.setDescription(cursor.getString(3));
				b.setImage(cursor.getString(4));

				toReturn.add(b);

			} while (cursor.moveToNext());
		}
		if (!cursor.isClosed()) {
			cursor.close();
		}
		db.close();

		if (toReturn.size() > 1) {
			throw new BrewException(context, ErrorCodes.TOO_MANY_RESULT, new Object[] {Brew.class.getSimpleName(), id});
		} else if (toReturn.size() == 0) {
			return null;
		}
		return toReturn.get(0);
	}

	@Override
	public List<Brew> findAll() {
		List<Brew> toReturn = new ArrayList<>();

		SQLiteDatabase db = sqlHelper.getReadableDatabase();
		Cursor cursor = db.query(table, fields.toArray(new String[0]), "", null, null, null,
				null, null);
		if (cursor.moveToFirst()) {
			do {

				Brew b = new Brew();

				b.setId(cursor.getInt(0));
				b.setDateCreate(AppUtil.parseDateYMDHMS(cursor.getString(1)));
				b.setTitle(cursor.getString(2));
				b.setDescription(cursor.getString(3));
				b.setImage(cursor.getString(4));

				toReturn.add(b);

			} while (cursor.moveToNext());
		}
		if (!cursor.isClosed()) {
			cursor.close();
		}
		db.close();

		return toReturn;
	}
}
