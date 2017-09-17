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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.bits.ms.ccdi.api.constants.CcdiApiConstants;
import com.bits.ms.ccdi.entities.cms.Component;
import com.bits.ms.ccdi.entities.cms.ComponentAttribute;
import com.bits.ms.ccdi.entities.cms.ComponentType;
import com.bits.ms.ccdi.entities.cms.Context;
import com.bits.ms.ccdi.exception.DataAccessException;

/**
 * DAO class for getting the content from repository based on the component type
 * 
 * @author AB69987
 * @author Cognizant - Modified for E3
 * @version 1.0
 */
public class ComponentSelectorDao {
	private static final Logger LOG = LogManager
			.getLogger(ComponentSelectorDao.class);

	/**
	 * The DataSource to obtain connections from
	 */
	// Not Autowired, Manually set as property in DAO-Config because this DAO is
	// used by property place holder configurer and it executes before
	// autowiring.
	private DataSource ccdiDataSource;

	/**
	 * Query to retrieve Property component from CCDI Repository
	 */
	private String propertyComponentQuery;
	/**
	 * Query to retrieve Gateway component from CCDI Repository
	 */
	private String gatewayComponentQuery;
	/**
	 * Query to retrieve Environment component from CCDI Repository
	 */
	private String environmentComponentQuery;
	/**
	 * Query to retrieve Verbiage component from CCDI Repository
	 */
	private String verbiageComponentQuery;
	/**
	 * Query to retrieve Validator component from CCDI Repository
	 */
	private String validatorComponentQuery;

	/**
	 * Query to retrieve the placeholder properties
	 */
	private String ccdiPropertyPlaceHolderQuery;

	/**
	 * Component Type - Column name
	 */
	private static final String COMPONENT_TYPE = "ComponentType";

	/**
	 * Fetches the list of components from database for the given request
	 * component
	 * 
	 * @param component
	 *            The CCDI request component
	 * 
	 * @return List of response component objects for the given component
	 *         request
	 * @throws SQLException
	 */
	public List<Component> getComponentData(Component component)
			throws DataAccessException
	{
		String sqlQuery = null;

		try
		{
			if (CcdiApiConstants.COMPONENT_TYPE_PROPERTY.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				sqlQuery = propertyComponentQuery;
			}
			else if (CcdiApiConstants.COMPONENT_TYPE_GATEWAY.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				sqlQuery = gatewayComponentQuery;
			}
			else if (CcdiApiConstants.COMPONENT_TYPE_VERBIAGE.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				sqlQuery = verbiageComponentQuery;
			}
			else if (CcdiApiConstants.COMPONENT_TYPE_ENV.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				sqlQuery = environmentComponentQuery;
			}
			else if (CcdiApiConstants.COMPONENT_TYPE_VALIDATOR.equalsIgnoreCase(component.getComponentType().getComponentTypeCode()))
			{
				sqlQuery = validatorComponentQuery;
			}

			if (sqlQuery != null)
			{

				LOG.debug("SQL Query :\n{}", sqlQuery);

				FetchContentRepository fetchContentRepository = new FetchContentRepository(ccdiDataSource, sqlQuery, component
						.getComponentType().getComponentTypeCode());

				Object[] params = formQueryParameters(component);
				if (params != null)
				{
					LOG.debug("Params= {}", params);
					@SuppressWarnings("unchecked")
					List<Component> componentDataList = fetchContentRepository.execute(params);
					Map<Integer, Component> components = new HashMap<Integer,Component>();
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
			}
		} catch (Exception ex)
		{
			throw new DataAccessException(ex.getMessage(), ex);
		}
		return null;
	}

	/**
	 * Inner class which compiles the query and maps the resultset to component
	 * object
	 * 
	 * @author AB69987
	 * 
	 */
	@SuppressWarnings("rawtypes")
	private class FetchContentRepository extends MappingSqlQuery {
		// Constructor which gets used from our public class
		FetchContentRepository(DataSource dataSource, String sqlQuery,
				String componentType) {
			super(dataSource, sqlQuery);

			if (CcdiApiConstants.COMPONENT_TYPE_PROPERTY
					.equalsIgnoreCase(componentType)) {
				super.declareParameter(new SqlParameter("name", Types.VARCHAR));
			} else if (CcdiApiConstants.COMPONENT_TYPE_GATEWAY
					.equalsIgnoreCase(componentType)) {
				super.declareParameter(new SqlParameter("action", Types.VARCHAR));
			} else if (CcdiApiConstants.COMPONENT_TYPE_VERBIAGE
					.equalsIgnoreCase(componentType)) {
				super.declareParameter(new SqlParameter("key", Types.VARCHAR));
			} else if (CcdiApiConstants.COMPONENT_TYPE_ENV
					.equalsIgnoreCase(componentType)) {
				super.declareParameter(new SqlParameter("key", Types.VARCHAR));

			} else if (CcdiApiConstants.COMPONENT_TYPE_VALIDATOR
					.equalsIgnoreCase(componentType)) {
				super.declareParameter(new SqlParameter("action", Types.VARCHAR));
			}
			super.declareParameter(new SqlParameter("VisualRole", Types.VARCHAR));
			super.declareParameter(new SqlParameter("state", Types.VARCHAR));
			super.declareParameter(new SqlParameter("county", Types.VARCHAR));
			super.declareParameter(new SqlParameter("City", Types.VARCHAR));
			super.declareParameter(new SqlParameter("PlanType", Types.VARCHAR));
			super.declareParameter(new SqlParameter("Year", Types.VARCHAR));
			super.declareParameter(new SqlParameter("Product", Types.VARCHAR));
			super.declareParameter(new SqlParameter("brand ", Types.VARCHAR));
			super.declareParameter(new SqlParameter("WebSite ", Types.VARCHAR));
			super.declareParameter(new SqlParameter("language ", Types.VARCHAR));
			super.declareParameter(new SqlParameter("Lob", Types.VARCHAR));
			super.declareParameter(new SqlParameter("Channel", Types.VARCHAR));
			super.declareParameter(new SqlParameter("Vendor", Types.VARCHAR));
			super.declareParameter(new SqlParameter("userType", Types.VARCHAR));
			super.declareParameter(new SqlParameter("providerSpeciality",
					Types.VARCHAR));
			super.declareParameter(new SqlParameter("SiteType", Types.VARCHAR));
			super.declareParameter(new SqlParameter("ProductFamily",
					Types.VARCHAR));
			super.declareParameter(new SqlParameter("userRole", Types.VARCHAR));
			super.declareParameter(new SqlParameter("entitlementCode",
					Types.VARCHAR));
			super.declareParameter(new SqlParameter("ProviderPlan",
					Types.VARCHAR));
			compile();

		}

		/**
		 * Maps the resultset to component object
		 * 
		 * @param resultSet
		 *            Resultset which contains the result set, which is usually
		 *            generated by executing a statement that queries the
		 *            database
		 */
		@Override
		protected Object mapRow(ResultSet resultSet, int rowNumber)
				throws SQLException {
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
			context.setProviderSpeciality(resultSet
					.getString("ProviderSpeciality"));
			List<Context> contexts = new ArrayList<Context>();
			contexts.add(context);
			component.setContexts(contexts);

			ComponentAttribute componentAttribute = new ComponentAttribute();
			componentAttribute.setAttributeName(resultSet
					.getString("AttributeName"));
			componentAttribute.setAttributeValue(resultSet
					.getString("AttributeValue"));
			// componentAttribute.setAttributeId(resultSet.getInt("AttributeId"));
			List<ComponentAttribute> componentAttributes = new ArrayList<ComponentAttribute>();
			componentAttributes.add(componentAttribute);

			component.setId(resultSet.getInt("ComponentId"));
			component.setComponentType(new ComponentType(resultSet
					.getString(COMPONENT_TYPE)));
			Clob clob = resultSet.getClob("ContextText");
			if (clob != null) {
				component.setComponentText(clob.getSubString(1,
						(int) clob.length()));
			}
			Clob clobTitle = resultSet.getClob("TitleText");
			if (clobTitle != null) {
				component.setTitleText(clobTitle.getSubString(1,
						(int) clobTitle.length()));
			}
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
	 * @return An object array which containing the input parameters for the
	 *         query
	 */
	private Object[] formQueryParameters(Component component) {

		String attributeValue = null;
		Context context = null;
		Object[] params = null;

		try {
			List<ComponentAttribute> componentAttributes = component
					.getAttributes();
			LOG.debug("ComponentAttributes={}", componentAttributes);
			if (componentAttributes != null && !componentAttributes.isEmpty()) {
				ComponentAttribute componentAttribute = componentAttributes
						.get(0);
				if (componentAttribute != null) {
					attributeValue = componentAttribute.getAttributeValue();
				}
			}

			if (component.getContexts() != null
					&& component.getContexts().size() > 0) {
				context = component.getContexts().get(0);
			}
			if (context == null) {
				context = new Context();
			}
			params = new Object[] {
					attributeValue,
					StringUtils.isEmpty(context.getVisualRole()) ? "" : context
							.getVisualRole(),
					StringUtils.isEmpty(context.getState()) ? "" : context
							.getState(),
					StringUtils.isEmpty(context.getCounty()) ? "" : context
							.getCounty(),
					StringUtils.isEmpty(context.getCity()) ? "" : context
							.getCity(),
					StringUtils.isEmpty(context.getPlanType()) ? "" : context
							.getPlanType(),
					StringUtils.isEmpty(context.getPlanYear()) ? "" : context
							.getPlanYear(),
					StringUtils.isEmpty(context.getProductCode()) ? ""
							: context.getProductCode(),
					StringUtils.isEmpty(context.getBrand()) ? "" : context
							.getBrand(),
					StringUtils.isEmpty(context.getSite()) ? "" : context
							.getSite(),
					StringUtils.isEmpty(context.getLanguage()) ? "" : context
							.getLanguage(),
					StringUtils.isEmpty(context.getLob()) ? "" : context
							.getLob(),
					StringUtils.isEmpty(context.getChannel()) ? "" : context
							.getChannel(),
					StringUtils.isEmpty(context.getVendor()) ? "" : context
							.getVendor(),
					StringUtils.isEmpty(context.getUserType()) ? "" : context
							.getUserType(),
					StringUtils.isEmpty(context.getProviderSpeciality()) ? ""
							: context.getProviderSpeciality(),
					StringUtils.isEmpty(context.getSiteType()) ? "" : context
							.getSiteType(),
					StringUtils.isEmpty(context.getProductFamily()) ? ""
							: context.getProductFamily(),
					StringUtils.isEmpty(context.getUserRole()) ? "" : context
							.getUserRole(),
					StringUtils.isEmpty(context.getEntitlement()) ? ""
							: context.getEntitlement(),
					StringUtils.isEmpty(context.getProviderPlan()) ? ""
							: context.getProviderPlan() };
		} catch (Exception ex) {
			LOG.error("Error in componentSelectorDao-formQueryParameters() :: "
					+ ex);
		}
		return params;
	}

	/**
	 * Retrieves the list of placeholder properties from the CCDI repository
	 * 
	 * @return list of config properties
	 * @throws DataAccessException
	 */
	public List<Map<String, Object>> getPlaceHolderProperties()
			throws DataAccessException {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ccdiDataSource);
		List<Map<String, Object>> configProperties = jdbcTemplate
				.queryForList(ccdiPropertyPlaceHolderQuery);
		LOG.debug("config properties size=" + configProperties.size());
		return configProperties;

	}

	/**
	 * @return the ccdiDataSource
	 */
	public DataSource getCcdiDataSource() {
		return ccdiDataSource;
	}

	/**
	 * @param ccdiDataSource
	 *            the ccdiDataSource to set
	 */
	public void setCcdiDataSource(DataSource ccdiDataSource) {
		this.ccdiDataSource = ccdiDataSource;
	}

	/**
	 * @return the propertyComponentQuery
	 */
	public String getPropertyComponentQuery() {
		return propertyComponentQuery;
	}

	/**
	 * @param propertyComponentQuery
	 *            the propertyComponentQuery to set
	 */
	public void setPropertyComponentQuery(String propertyComponentQuery) {
		this.propertyComponentQuery = propertyComponentQuery;
	}

	/**
	 * @return the gatewayComponentQuery
	 */
	public String getGatewayComponentQuery() {
		return gatewayComponentQuery;
	}

	/**
	 * @param gatewayComponentQuery
	 *            the gatewayComponentQuery to set
	 */
	public void setGatewayComponentQuery(String gatewayComponentQuery) {
		this.gatewayComponentQuery = gatewayComponentQuery;
	}

	/**
	 * @return the environmentComponentQuery
	 */
	public String getEnvironmentComponentQuery() {
		return environmentComponentQuery;
	}

	/**
	 * @param environmentComponentQuery
	 *            the environmentComponentQuery to set
	 */
	public void setEnvironmentComponentQuery(String environmentComponentQuery) {
		this.environmentComponentQuery = environmentComponentQuery;
	}

	/**
	 * @return the verbiageComponentQuery
	 */
	public String getVerbiageComponentQuery() {
		return verbiageComponentQuery;
	}

	/**
	 * @param verbiageComponentQuery
	 *            the verbiageComponentQuery to set
	 */
	public void setVerbiageComponentQuery(String verbiageComponentQuery) {
		this.verbiageComponentQuery = verbiageComponentQuery;
	}

	/**
	 * @return the validatorComponentQuery
	 */
	public String getValidatorComponentQuery() {
		return validatorComponentQuery;
	}

	/**
	 * @param validatorComponentQuery
	 *            the validatorComponentQuery to set
	 */
	public void setValidatorComponentQuery(String validatorComponentQuery) {
		this.validatorComponentQuery = validatorComponentQuery;
	}

	public String getCcdiPropertyPlaceHolderQuery() {
		return ccdiPropertyPlaceHolderQuery;
	}

	public void setCcdiPropertyPlaceHolderQuery(
			String ccdiPropertyPlaceHolderQuery) {
		this.ccdiPropertyPlaceHolderQuery = ccdiPropertyPlaceHolderQuery;
	}
}
