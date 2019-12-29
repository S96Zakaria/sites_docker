package com.circuit.demo.dao;

import com.circuit.demo.module.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteDao extends JpaRepository<Site, Long> {
	
}
