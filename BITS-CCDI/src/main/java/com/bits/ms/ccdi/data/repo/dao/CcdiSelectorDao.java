/*
 * Application: Wellpoint Enrollment System
 * 
 * -------------------------------
 * Copyright (c) WellPoint, Inc
 * -------------------------------
 * This software is the confidential and proprietary information of WellPoint, Inc. ("Confidential Information").
 * You shall not disclose such confidential information, and shall use it only in accordance with the terms of the 
 * license agreement you entered into with WellPoint.
 */
package com.bits.ms.ccdi.data.repo.dao;


import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.support.lob.LobHandler;

import com.bits.ms.ccdi.api.constants.CcdiApiConstants;
import com.bits.ms.ccdi.entities.cms.Component;
import com.bits.ms.ccdi.entities.cms.ComponentAttribute;
import com.bits.ms.ccdi.entities.cms.ComponentType;
import com.bits.ms.ccdi.entities.cms.Context;
import com.bits.ms.ccdi.exception.DataAccessException;


/**
 * DAO class for getting the Generic or Glossary content from content repository
 * 
 * @author AB69987
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
public class CcdiSelectorDao
{
	private static final Logger LOG = LogManager.getLogger(CcdiSelectorDao.class);
	/**
	 * The DataSource to obtain connections from
	 */
	@Autowired
	private DataSource ccdiDataSource;

	//private LobHandler lobHandler;
	/**
	 * Query to retrieve Generic component from CCDI Repository
	 */
	private String genericComponentQuery;
	/**
	 * Query to retrieve Gloassary component from CCDI Repository
	 */
	private String glossaryComponentQuery;

	/**
	 * Component Type - Column name
	 */
	private static final String COMPONENT_TYPE = "ComponentType";

	/**
	 * Fetches the list of components from database for Generic or Glossary content
	 * 
	 * @param component
	 *            The CCDI request component
	 * 
	 * @return List of response component objects for the given component request
	 * @throws SQLException
	 */
	public List<Component> getComponentData(Component component)
			throws DataAccessException
	{

		try
		{
			String sqlQuery = validateComponent(component);

			if (sqlQuery != null)
			{
				LOG.debug("SQL Query :\n{}", sqlQuery);
				FetchContentRepository fetchContentRepository = new FetchContentRepository(ccdiDataSource, sqlQuery, component
						.getComponentType().getComponentTypeCode());

				Object[] params = formQueryParameters(component);
				LOG.debug("Params= {}", params);

				@SuppressWarnings("unchecked")
				List<Component> componentDataList = fetchContentRepository.execute(params);
				Map<Integer,Component> components = new HashMap<Integer, Component>();
				for (Component componentFrmList : componentDataList)
				{
					Component componentData = components.get(componentFrmList.getId());
					if (componentData == null)
					{
						components.put(componentFrmList.getId(), componentFrmList);
					}
					else
					{
						componentData.getAttributes().addAll(componentFrmList.getAttributes());
						componentData.getContexts().addAll(componentFrmList.getContexts());
					}
				}
				return new ArrayList<Component>(components.values());

			}
		} catch (Exception ex)
		{
			throw new DataAccessException(ex.getMessage(), ex);
		}

		return null;
	}

	/**
	 * Used to validate the Glossary and Generic components.
	 * 
	 * @param component
	 * @return sqlQuery
	 */
	private String validateComponent(Component component)
	{
		String sqlQuery = null;
		if (component != null && component.getComponentType() != null
				&& StringUtils.isNotBlank(component.getComponentType().getComponentTypeCode()))
		{
			if (CcdiApiConstants.COMPONENT_TYPE_GLOSSARY.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				sqlQuery = glossaryComponentQuery;
			}
			else if (CcdiApiConstants.COMPONENT_TYPE_GENERIC.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				sqlQuery = genericComponentQuery;
			}
		}
		return sqlQuery;
	}

	/**
	 * Inner class which compiles the query and maps the resultset to component object
	 * 
	 * @author AB69987
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private class FetchContentRepository extends MappingSqlQuery
	{
		// Constructor which gets used from our public class
		FetchContentRepository(DataSource dataSource, String sqlQuery, String compnentType)
		{
			super(dataSource, sqlQuery);
			if (CcdiApiConstants.COMPONENT_TYPE_GLOSSARY.equalsIgnoreCase(compnentType))
			{
				super.declareParameter(new SqlParameter("term", Types.VARCHAR));
				super.declareParameter(new SqlParameter("ComponentType", Types.VARCHAR));
			}
			else if (CcdiApiConstants.COMPONENT_TYPE_GENERIC.equalsIgnoreCase(compnentType))
			{
				super.declareParameter(new SqlParameter("category", Types.VARCHAR));
				super.declareParameter(new SqlParameter("page", Types.VARCHAR));
				super.declareParameter(new SqlParameter("block", Types.VARCHAR));

				super.declareParameter(new SqlParameter("ComponentType", Types.VARCHAR));
			}
			super.declareParameter(new SqlParameter("VisualRole", Types.VARCHAR));
			super.declareParameter(new SqlParameter("state", Types.VARCHAR));
			super.declareParameter(new SqlParameter("county", Types.VARCHAR));
			super.declareParameter(new SqlParameter("city", Types.VARCHAR));
			super.declareParameter(new SqlParameter("PlanType", Types.VARCHAR));
			super.declareParameter(new SqlParameter("year", Types.VARCHAR));
			super.declareParameter(new SqlParameter("product", Types.VARCHAR));
			super.declareParameter(new SqlParameter("brand", Types.VARCHAR));
			super.declareParameter(new SqlParameter("WebSite", Types.VARCHAR));
			super.declareParameter(new SqlParameter("language", Types.VARCHAR));
			super.declareParameter(new SqlParameter("Vendor", Types.VARCHAR));
			super.declareParameter(new SqlParameter("providerSpeciality", Types.VARCHAR));
			super.declareParameter(new SqlParameter("channel", Types.VARCHAR));
			super.declareParameter(new SqlParameter("Lob", Types.VARCHAR));
			super.declareParameter(new SqlParameter("userType", Types.VARCHAR));
			super.declareParameter(new SqlParameter("SiteType", Types.VARCHAR));
			super.declareParameter(new SqlParameter("ProductFamily", Types.VARCHAR));
			super.declareParameter(new SqlParameter("userRole", Types.VARCHAR));
			super.declareParameter(new SqlParameter("entitlementCode", Types.VARCHAR));
			super.declareParameter(new SqlParameter("ProviderPlan", Types.VARCHAR));

			compile();
		}

		/**
		 * Maps the resultset to component object
		 * 
		 * @param resultSet
		 *            Resultset which contains the result set, which is usually generated by executing a statement that queries the database
		 */
		@Override
		protected Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException
		{
			Component component = new Component();
			Context context = new Context();
			context.setVisualRole(resultSet.getString("VisualRole"));
			context.setSite(resultSet.getString("Website"));
			context.setLanguage(resultSet.getString("Language"));
			context.setCounty(resultSet.getString("County"));
			context.setCity(resultSet.getString("City"));
			context.setState(resultSet.getString("State"));
			context.setPlanType(resultSet.getString("PlanType"));
			context.setPlanYear(resultSet.getString("Year"));
			context.setProductCode(resultSet.getString("Product"));
			context.setBrand(resultSet.getString("Brand"));
			context.setId(resultSet.getInt("InstanceId"));

			context.setLob(resultSet.getString("LOB"));
			context.setChannel(resultSet.getString("Channel"));
			context.setVendor(resultSet.getString("Vendor"));
			context.setUserType(resultSet.getString("UserType"));
			context.setSiteType(resultSet.getString("SiteType"));
			context.setProductFamily(resultSet.getString("ProductFamily"));
			context.setProviderPlan(resultSet.getString("ProviderPlan"));
			context.setProviderSpeciality(resultSet.getString("ProviderSpeciality"));
			List<Context> contexts = new ArrayList<Context>();
			contexts.add(context);
			component.setContexts(contexts);

			component.setId(resultSet.getInt("ComponentId"));
			String cmptType = resultSet.getString(COMPONENT_TYPE);
			component.setComponentType(new ComponentType(cmptType));
			Clob clob = resultSet.getClob("ContentText");
			if (clob != null)
			{
				component.setComponentText(clob.getSubString(1, (int) clob.length()));
			}

			List<ComponentAttribute> componentAttributes = new ArrayList<ComponentAttribute>();
			component.setAttributes(componentAttributes);

			return component;
		}
	}

	/**
	 * Private method to create the in parameters for the query
	 * 
	 * @param component
	 *            The CCDI request component
	 * 
	 * @return An object array which containing the input parameters for the query
	 */
	private Object[] formQueryParameters(Component component)
	{
		String attrCategory = null;
		String attrPage = null;
		String attrBlock = null;
		String attrTerm = null;
		Context context = null;
		Object[] params = null;

		try
		{
			List<ComponentAttribute> componentAttributes = component.getAttributes();
			LOG.debug("ComponentAttributes={}", componentAttributes);
			for (ComponentAttribute componentAttribute : componentAttributes)
			{
				if (attrCategory == null)
				{
					attrCategory = CcdiApiConstants.COMPONENT_ATTRIBUTE_CATEGORY.equalsIgnoreCase(componentAttribute.getAttributeName()) ? componentAttribute
							.getAttributeValue() : null;
				}
				if (attrPage == null)
				{
					attrPage = CcdiApiConstants.COMPONENT_ATTRIBUTE_PAGE.equalsIgnoreCase(componentAttribute.getAttributeName()) ? componentAttribute
							.getAttributeValue() : null;
				}
				if (attrBlock == null)
				{
					attrBlock = CcdiApiConstants.COMPONENT_ATTRIBUTE_BLOCK.equalsIgnoreCase(componentAttribute.getAttributeName()) ? componentAttribute
							.getAttributeValue() : null;
				}

				if (attrTerm == null)
				{
					attrTerm = CcdiApiConstants.COMPONENT_ATTRIBUTE_TERM.equalsIgnoreCase(componentAttribute.getAttributeName()) ? componentAttribute
							.getAttributeValue() : null;
				}
			}

			if (component.getContexts() != null && component.getContexts().size() > 0)
			{
				context = component.getContexts().get(0);
			}
			if (context == null)
			{
				context = new Context();
			}

			if (CcdiApiConstants.COMPONENT_TYPE_GLOSSARY.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				params = new Object[] { attrTerm, context.getVisualRole(), context.getState(), context.getCounty(), context.getCity(),
						context.getPlanType(), context.getPlanYear(), context.getProductCode(), context.getBrand(), context.getSite(),
						context.getLanguage(), context.getVendor(), context.getProviderSpeciality(), context.getChannel(),
						context.getLob(), context.getUserType(), context.getSiteType(), context.getProductFamily(), context.getUserRole(),
						context.getEntitlement(), context.getProviderPlan(), component.getComponentType().getComponentTypeCode() };
			}
			else if (CcdiApiConstants.COMPONENT_TYPE_GENERIC.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				params = new Object[] { attrCategory, attrPage, attrBlock, context.getVisualRole(), context.getState(),
						context.getCounty(), context.getCity(), context.getPlanType(), context.getPlanYear(), context.getProductCode(),
						context.getBrand(), context.getSite(), context.getLanguage(), context.getVendor(), context.getProviderSpeciality(),
						context.getChannel(), context.getLob(), context.getUserType(), context.getSiteType(), context.getProductFamily(),
						context.getUserRole(), context.getEntitlement(), context.getProviderPlan(),
						component.getComponentType().getComponentTypeCode() };
			}
		} catch (Exception ex)
		{
			LOG.error("Error in ccdiSelectorDao-formQueryParameters() :: " + ex);
		}

		return params;
	}

	/**
	 * @return the ccdiDataSource
	 */
	public DataSource getCcdiDataSource()
	{
		return ccdiDataSource;
	}

	/**
	 * @param ccdiDataSource
	 *            the ccdiDataSource to set
	 */
	public void setCcdiDataSource(DataSource ccdiDataSource)
	{
		this.ccdiDataSource = ccdiDataSource;
	}

	/**
	 * @param lobHandler
	 *            the lobHandler to set
	 */
	/*public void setLobHandler(LobHandler lobHandler)
	{
		this.lobHandler = lobHandler;
	}*/

	/**
	 * @return the lobHandler
	 */
/*	public LobHandler getLobHandler()
	{
		return lobHandler;
	}*/

	/**
	 * @return the genericComponentQuery
	 */
	public String getGenericComponentQuery()
	{
		return genericComponentQuery;
	}

	/**
	 * @param genericComponentQuery
	 *            the genericComponentQuery to set
	 */
	public void setGenericComponentQuery(String genericComponentQuery)
	{
		this.genericComponentQuery = genericComponentQuery;
	}

	/**
	 * @return the glossaryComponentQuery
	 */
	public String getGlossaryComponentQuery()
	{
		return glossaryComponentQuery;
	}

	/**
	 * @param glossaryComponentQuery
	 *            the glossaryComponentQuery to set
	 */
	public void setGlossaryComponentQuery(String glossaryComponentQuery)
	{
		this.glossaryComponentQuery = glossaryComponentQuery;
	}

}
