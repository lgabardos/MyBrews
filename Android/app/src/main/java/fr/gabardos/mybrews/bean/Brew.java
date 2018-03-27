package fr.gabardos.mybrews.bean;

import java.util.Date;
import java.util.List;

/**
 * Main class of Brew.
 * This class represent a Brew where we'll have the full recipe with steps and also notes on it
 * Created by Laurent on 26/03/2018.
 */

public class Brew {

	private int id;

	private Date dateCreate;

	private String title;

	private String description;

	private String image;

	private List<Step> steps;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
}
