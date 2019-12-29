package com.circuit.demo.controller;



import com.circuit.demo.dao.SiteDao;
import com.circuit.demo.module.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/angular")
public class SiteRESTController {

    @Autowired
    public SiteDao siteDao;


    @GetMapping("/")
    public List<Site> index()
    {
        return siteDao.findAll();
    }



    @GetMapping("/{id}")
    public Optional<Site> getSiteDetail(@PathVariable("id") Long id)
    {
        return siteDao.findById(id);
    }


    @PostMapping("/")
    public Site addSiteform(Site site) {
        siteDao.save(site);
        return site;
    }

    @DeleteMapping("/{id}")
    public void deleteSite(@PathVariable("id") Long id)
    {
        siteDao.deleteById(id);
    }
}
