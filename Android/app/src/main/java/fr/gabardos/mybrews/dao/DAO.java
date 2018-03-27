package fr.gabardos.mybrews.dao;

/**
 * Abstract to access object in database
 *
 * Created by Laurent on 26/03/2018.
 */

import android.content.Context;

import java.util.List;

import fr.gabardos.mybrews.core.BrewException;

/**
 * Classe de DAO permettant de récupérer en base
 *
 * @author laurent
 *
 * @param <T>
 *            Le type de données à manipuler
 */
public abstract class DAO<T> {

	/** Adapter sur la base de données */
	protected Context context;
	protected DbHelper sqlHelper;
	protected String table;

	/**
	 * Constructor
	 */
	public DAO() {
	}

	/**
	 * Creation method
	 *
	 * @param obj Object to create
	 * @return id of the created object
	 */
	public abstract long create(T obj) throws BrewException;

	/**
	 * Delete the object
	 *
	 * @param obj Object to delete
	 * @return true if succeed, false otherwise
	 */
	public abstract boolean delete(T obj) throws BrewException;

	/**
	 * Update this object
	 *
	 * @param obj Object to upadte
	 * @return true if update succeed
	 * @throws BrewException if id not find
	 */
	public abstract boolean update(T obj) throws BrewException;

	/**
	 * Retrieve an object by its id
	 *
	 * @param id Object's id
	 * @return The wanted object or null
	 * @throws BrewException if there is too many result
	 */
	public abstract T find(int id) throws BrewException;

	/**
	 * Retrieve all objects
	 *
	 * @return A list with all item present in database
	 */
	public abstract List<T> findAll();

}
