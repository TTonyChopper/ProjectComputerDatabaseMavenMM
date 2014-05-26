package com.excilys.formation.webproject.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author excilys
 *
 */
@SuppressWarnings("serial")
@Entity(name="company")
public class Company implements Serializable{

	/*****************************Builder*****************************/
	public static class CpyBuilder {
		private Long id;
		private String	name;

		/**
		 * 
		 * @param id
		 * @return
		 */
		public CpyBuilder id(Long id) {
			this.id = id;
			return this;
		}
		/**
		 * 
		 * @param name
		 * @return
		 */
		public CpyBuilder name(String name) {
			this.name = name;
			return this;
		}		
		/**
		 * 
		 * @return
		 */
		public Company build() {
			return new Company(this);
		}
	}
	/*****************************Builder*****************************/

	/**
	 * 
	 * @return
	 */
	public static CpyBuilder builder() {
		return new CpyBuilder();
	}
	public Company() {    
	}
	/**
	 * 
	 * @param builder
	 */
	private Company(CpyBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;     
	}

	//Attributs
	@Id
	@Column(name="id",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="name")
	private String	name;

	//Accesseurs
	/**
	 * 
	 * @return the id of the Company
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * @param id The id of the Company
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 
	 * @return the name of the Company
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name The name of the Company
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Company))
			return false;
		Company other = (Company) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}