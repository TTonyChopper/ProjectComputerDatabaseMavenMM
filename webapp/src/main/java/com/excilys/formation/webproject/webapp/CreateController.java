package com.excilys.formation.webproject.webapp;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.excilys.formation.webproject.binding.ComputerDTO;
import com.excilys.formation.webproject.binding.Mapper;
import com.excilys.formation.webproject.binding.Validator;
import com.excilys.formation.webproject.core.Company;
import com.excilys.formation.webproject.core.Computer;
import com.excilys.formation.webproject.service.MainService;

/**
 * 
 * @author excilys
 *
 */
@Controller
@RequestMapping(value="/addComputer")
public class CreateController {

	@Autowired
	private MainService mainService;

	@Autowired
	private Mapper mapper;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ComputerDTO getAdd(Model model) {		

		List<Company> companylist = (ArrayList<Company>)mainService.getListCompany();
		model.addAttribute("companylist", companylist);
		model.addAttribute("companylistsize", companylist.size());

		return new ComputerDTO();
	}
	/**
	 * 
	 * @param computerDTO
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String postAdd(@ModelAttribute @Valid ComputerDTO computerDTO,BindingResult result,
			Model model) {		
		
		Company company = mainService.findCompanyById(computerDTO.getCompany());
		Computer computer = mapper.fromDTO(computerDTO, company);
		List<String> errorlist = null; 
		if (company == null) errorlist = Validator.check(computerDTO,"");
		else errorlist = Validator.check(computerDTO,computer.getCompany().getName());
		List<Company> companylist = (ArrayList<Company>)mainService.getListCompany();
		model.addAttribute("companylist", companylist);
		model.addAttribute("companylistsize", companylist.size());
		model.addAttribute("errorlist", errorlist);

		if( (result.hasErrors()) || (!(Validator.validate(errorlist))) ) {			

			return "addComputer";
		}
		else { 
			mainService.createComputer(computer);

			return "redirect:dashboard";
		}
	}
}