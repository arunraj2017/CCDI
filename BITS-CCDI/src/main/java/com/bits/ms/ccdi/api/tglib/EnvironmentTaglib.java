package com.bits.ms.ccdi.api.tglib;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bits.ms.ccdi.core.exception.NoEnvironmentEntryFoundException;
import com.bits.ms.ccdi.entities.cntxt.EnvironmentEntry;
import com.bits.ms.ccdi.entity.cntxt.Contexts;
import com.bits.ms.ccdi.resolvrs.EnvironmentEntryResolver;

public class EnvironmentTaglib extends SimpleTagSupport  {

	public String message;
	EnvironmentEntryResolver environmentEntryResolver = (EnvironmentEntryResolver) SpringContext.getApplicationContext().getBean("environmentEntryResolver");

	private StringWriter sw = new StringWriter();
	Contexts contexts = new Contexts();

	@Override
	public void doTag() throws JspException, IOException {
		if (message != null) {
			System.out.println("MESSAGE " + message);
			System.out.println("EER :" + environmentEntryResolver);
			JspWriter out = getJspContext().getOut();
			EnvironmentEntry entry = new EnvironmentEntry();
			try {
				entry = environmentEntryResolver.resolveEnvironmentEntry(
						contexts, message);
				System.out.println("environment entry value: "
						+ entry.getValue());
			} catch (NoEnvironmentEntryFoundException e) {
				e.printStackTrace();
			}
			out.println(entry.getValue());

		} else {
			System.out.println("MESSAGE " + message);
			getJspBody().invoke(sw);
			getJspContext().getOut().println(sw.toString());
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
