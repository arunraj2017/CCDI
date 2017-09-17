package com.bits.ms.ccdi.entity.cntxt;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.builder.ToStringBuilder;
import com.bits.ms.ccdi.entity.cntxt.BaseContext;


public class BusinessContext extends BaseContext {

	private static final long serialVersionUID = 758495220843183122L;

	// The following fields correspond to columns in CNTXT table -START
	private String visualRole;
	private String state;
	private String county;
	private String city;
	private String planType;
	private String planYear;
	private String productCode;
	private String brand;
	private String name;
	private String vendor;
	private String channel;
	private Date planEffectiveDate;
	private String lob;
	private String siteDomain;
	private String productFamily;
	private Date expiryDate;
	private String providerPlan;
	// The following fields correspond to columns in CNTXT table - END
	
	private String localTimeZone;
	private String serverTimeZone;
	private String resolvedUrlContext;
	private Locale defaultLocale;

	// The following fiels are for Utility START
	private String campaignId;
	private String portFolio;
	private String zipCode;
	private static final String ONEXCHANGE = "On-Exchange";
	private static final String OFFEXCHANGE = "Off-Exchange";	
	// The following fields are for Utility END
	
	/**
	 * Create Business context.
	 */
	public BusinessContext() {
	}

	/**
	 * @param businessContext
	 */
	public BusinessContext(BusinessContext businessContext) {
		if (null != businessContext) 
		{
			this.visualRole = businessContext.getVisualRole();
			this.state = businessContext.getState();
			this.county = businessContext.getCounty();
			this.city = businessContext.getCity();
			this.planType = businessContext.getPlanType();
			this.planYear = businessContext.getPlanYear();
			this.productCode = businessContext.getProductCode();
			this.brand = businessContext.getBrand();
			this.name = businessContext.getName();
			this.vendor = businessContext.getVendor();
			this.channel = businessContext.getChannel();
			this.planEffectiveDate = businessContext.getPlanEffectiveDate();
			this.lob = businessContext.getLob();
			this.siteDomain = businessContext.getSiteDomain();
			this.productFamily = businessContext.getProductFamily();
			this.expiryDate = businessContext.getExpiryDate();
			this.providerPlan = businessContext.getProviderPlan();
			this.localTimeZone = businessContext.getLocalTimeZone();
			this.serverTimeZone = businessContext.getServerTimeZone();
			this.resolvedUrlContext = businessContext.getResolvedUrlContext();
			this.defaultLocale = businessContext.getDefaultLocale();
			this.campaignId = businessContext.getCampaignId();
			this.portFolio = businessContext.getPortFolio();
			this.zipCode = businessContext.getZipCode();
		}
	}


	/**
	 * @return the visualRole
	 */
	public String getVisualRole()
	{
		return visualRole;
	}

	/**
	 * @param visualRole the visualRole to set
	 */
	public void setVisualRole(String visualRole)
	{
		this.visualRole = visualRole;
	}

	/**
	 * @return the state
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state)
	{
		this.state = state;
	}

	/**
	 * @return the county
	 */
	public String getCounty()
	{
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county)
	{
		this.county = county;
	}

	/**
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * @return the planType
	 */
	public String getPlanType()
	{
		return planType;
	}

	/**
	 * @param planType the planType to set
	 */
	public void setPlanType(String planType)
	{
		this.planType = planType;
	}

	/**
	 * @return the planYear
	 */
	public String getPlanYear()
	{
		return planYear;
	}

	/**
	 * @param planYear the planYear to set
	 */
	public void setPlanYear(String planYear)
	{
		this.planYear = planYear;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode()
	{
		return productCode;
	}

	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode)
	{
		this.productCode = productCode;
	}

	/**
	 * @return the brand
	 */
	public String getBrand()
	{
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor()
	{
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor)
	{
		this.vendor = vendor;
	}

	/**
	 * @return the channel
	 */
	public String getChannel()
	{
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel)
	{
		this.channel = channel;
	}

	/**
	 * @return the planEffectiveDate
	 */
	public Date getPlanEffectiveDate()
	{
		return planEffectiveDate;
	}

	/**
	 * @param planEffectiveDate the planEffectiveDate to set
	 */
	public void setPlanEffectiveDate(Date planEffectiveDate)
	{
		this.planEffectiveDate = planEffectiveDate;
	}

	/**
	 * @return the lob
	 */
	public String getLob()
	{
		return lob;
	}

	/**
	 * @param lob the lob to set
	 */
	public void setLob(String lob)
	{
		this.lob = lob;
	}

	/**
	 * @return the siteDomain
	 */
	public String getSiteDomain()
	{
		return siteDomain;
	}

	/**
	 * @param siteDomain the siteDomain to set
	 */
	public void setSiteDomain(String siteDomain)
	{
		this.siteDomain = siteDomain;
	}

	/**
	 * @return the productFamily
	 */
	public String getProductFamily()
	{
		return productFamily;
	}

	/**
	 * @param productFamily the productFamily to set
	 */
	public void setProductFamily(String productFamily)
	{
		this.productFamily = productFamily;
	}

	/**
	 * @return the expiryDate
	 */
	public Date getExpiryDate()
	{
		return expiryDate;
	}

	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(Date expiryDate)
	{
		this.expiryDate = expiryDate;
	}

	/**
	 * @return the providerPlan
	 */
	public String getProviderPlan()
	{
		return providerPlan;
	}

	/**
	 * @param providerPlan the providerPlan to set
	 */
	public void setProviderPlan(String providerPlan)
	{
		this.providerPlan = providerPlan;
	}

	/**
	 * @return the localTimeZone
	 */
	public String getLocalTimeZone()
	{
		return localTimeZone;
	}

	/**
	 * @param localTimeZone the localTimeZone to set
	 */
	public void setLocalTimeZone(String localTimeZone)
	{
		this.localTimeZone = localTimeZone;
	}

	/**
	 * @return the serverTimeZone
	 */
	public String getServerTimeZone()
	{
		return serverTimeZone;
	}

	/**
	 * @param serverTimeZone the serverTimeZone to set
	 */
	public void setServerTimeZone(String serverTimeZone)
	{
		this.serverTimeZone = serverTimeZone;
	}

	/**
	 * @return the resolvedUrlContext
	 */
	public String getResolvedUrlContext()
	{
		return resolvedUrlContext;
	}

	/**
	 * @param resolvedUrlContext the resolvedUrlContext to set
	 */
	public void setResolvedUrlContext(String resolvedUrlContext)
	{
		this.resolvedUrlContext = resolvedUrlContext;
	}

	/**
	 * @return the defaultLocale
	 */
	public Locale getDefaultLocale()
	{
		return defaultLocale;
	}

	/**
	 * @param defaultLocale the defaultLocale to set
	 */
	public void setDefaultLocale(Locale defaultLocale)
	{
		this.defaultLocale = defaultLocale;
	}
	/**
	 * @return the campaignId
	 */
	public String getCampaignId() {
		return campaignId;
	}


	/**
	 * @param campaignId the campaignId to set
	 */
	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}


	/**
	 * @return the portFolio
	 */
	public String getPortFolio() {
		return portFolio;
	}


	/**
	 * @param portFolio the portFolio to set
	 */
	public void setPortFolio(String portFolio) {
		this.portFolio = portFolio;
	}


	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}


	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	/**
	 * 
	 * @param portFolioValue
	 */
	public void setPortFolio(boolean portFolioValue){
		String portFolio="" ;
		if (portFolioValue) {
			portFolio = ONEXCHANGE;
		} else {
			 portFolio = OFFEXCHANGE;
		}
		this.portFolio = portFolio;
		
		
	}

	@Override
	public String toString()
	{
		return new ToStringBuilder(this).append("visualRole", visualRole)
				.append("state", state)
				.append("state", state)
				.append("city", city)
				.append("planType", planType)
				.append("planYear", planYear)
				.append("productCode", productCode)
				.append("brand", brand)
				.append("name", name)
				.append("vendor", vendor)
				.append("channel", channel)
				.append("planEffectiveDate", planEffectiveDate)
				.append("lob", lob)
				.append("siteDomain", siteDomain)
				.append("productFamily", productFamily)
				.append("expiryDate", expiryDate)
				.append("providerPlan", providerPlan)
				.append("localTimeZone", localTimeZone)
				.append("serverTimeZone", serverTimeZone)
				.append("resolvedUrlContext", resolvedUrlContext)
				.append("defaultLocale", defaultLocale)
				.append("campaignId", campaignId)
				.append("portFolio", portFolio)
				.append("zipCode", zipCode)
				.toString();
	}

}
