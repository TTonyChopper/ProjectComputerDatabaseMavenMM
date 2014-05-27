package com.excilys.formation.webproject.persistence;

import java.util.List;

import com.excilys.formation.webproject.core.Company;



/**
 * 
 * @author excilys
 *
 */
public interface CompanyDAO{

	/**
	 * @return The Company in the table company matching the id
	 */
	public Company findById(Long id);
	/**
	 * @return The Company in the table company matching the name
	 */
	public Company findByName(String name);
	/**
	 * 
	 * @return A List<Company> of Company in the table company
	 */
	public List<Company> getList();
	/**
	 * 
	 * @param comp A Company to be added in the table company
	 */
	public void create(Company comp);
}