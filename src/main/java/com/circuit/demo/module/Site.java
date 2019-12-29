package com.circuit.demo.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Site implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String description;
	private double x;
	private double y;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public Site( String nom, String description, double x, double y) {
		super();
		this.nom = nom;
		this.description = description;
		this.x = x;
		this.y = y;
		
	}
	public Site() {
		super();
	}
	@Override
	public String toString() {
		return "Site [id=" + id + ", nom=" + nom + ", description=" + description + ", x=" + x + ", y=" + y + "]";
	}
	
	
}
