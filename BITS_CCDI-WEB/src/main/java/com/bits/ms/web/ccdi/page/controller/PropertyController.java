package com.bits.ms.web.ccdi.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bits.ms.ccdi.core.exception.NoPropertyFoundException;
import com.bits.ms.ccdi.entities.cntxt.Property;
import com.bits.ms.ccdi.entity.cntxt.Contexts;
import com.bits.ms.ccdi.resolvrs.PropertyValueResolver;

@Controller
public class PropertyController {
	private static final String HOME_PAGE = "home";
	@Autowired
	private PropertyValueResolver propertyresolver;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePageController() {
		return HOME_PAGE;
	}

	@RequestMapping(value = "/getData", method = RequestMethod.POST)
	@ResponseBody
	public String responseData(@RequestParam("data") String data) {

		Property property = null;
		Contexts contexts = new Contexts();
		try {
			property = propertyresolver.resolveProperty(contexts, data);
		} catch (NoPropertyFoundException e) {
			e.printStackTrace();
			data = "No data received. see error logs";
		}

		return property.getValue();

	}

}
