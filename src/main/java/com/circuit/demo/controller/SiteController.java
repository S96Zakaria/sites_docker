package com.circuit.demo.controller;


import com.circuit.demo.dao.SiteDao;
import com.circuit.demo.module.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Controller
public class SiteController {
	public String fileLocation = System.getProperty("user.dir")+"/uploadingDir/";

	@Autowired
	public SiteDao siteDao;
	
	




	@RequestMapping(value = "/site/addsite" ,method = RequestMethod.GET)
	public String addSite(Model model) {
		Site site=new Site();
		File file = new File(fileLocation);
        model.addAttribute("files", file.listFiles());
		model.addAttribute("site",site);
		return "NewFile";
	}
	
	@GetMapping("/")
	public String index(Model model)
	{
		List<Site> sites = siteDao.findAll();
		model.addAttribute("sites",sites);
		return "index";
	}
	
	
	
	@GetMapping("/site/detail")
	public String getSiteDetail(Model model, @RequestParam(name = "id")Long id)
	{
		
		Optional<Site> sitee=siteDao.findById(id);

		if(sitee.isPresent()) {
			Site site=sitee.get();
			model.addAttribute("site",site);
		}
		
		return "siteDetail";
	}
	
	
	@RequestMapping(value = "/site/addsite" ,method = RequestMethod.POST)
	public String addSiteform(Model model, @RequestParam("uploadingFiles") MultipartFile[] uploadingFiles, Site site) {
		System.out.println("salaam");

		
		siteDao.save(site);
	


		return "redirect:/";
		
	}
	@GetMapping("/site/circuit")
	public String getCircuit(Model model)
	{
		return "circuit";
	}
	
}
