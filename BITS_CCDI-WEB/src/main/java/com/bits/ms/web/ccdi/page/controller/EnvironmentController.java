package com.bits.ms.web.ccdi.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bits.ms.ccdi.core.exception.NoEnvironmentEntryFoundException;
import com.bits.ms.ccdi.entities.cntxt.EnvironmentEntry;
import com.bits.ms.ccdi.entity.cntxt.Contexts;
import com.bits.ms.ccdi.resolvrs.EnvironmentEntryResolver;

@Controller
public class EnvironmentController {


	@Autowired
	private EnvironmentEntryResolver environmentEntryResolver;
	
	@RequestMapping(value="/getEnv",method=RequestMethod.POST)
	@ResponseBody
	public String resolveEnv(@RequestParam("data") String environment) {
		Contexts contexts = new Contexts();
		EnvironmentEntry entry = new EnvironmentEntry();
		try {
			entry = environmentEntryResolver.resolveEnvironmentEntry(contexts,
					environment);
			System.out.println("environment entry value: "+entry.getValue());
		} catch (NoEnvironmentEntryFoundException e) {
			e.printStackTrace();
		}
		return entry.getValue();

	}

}
