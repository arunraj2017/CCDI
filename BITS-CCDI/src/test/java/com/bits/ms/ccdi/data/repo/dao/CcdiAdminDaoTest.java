/*package com.bits.ms.ccdi.data.repo.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bits.ms.ccdi.entities.cms.Component;
import com.bits.ms.ccdi.entities.cms.ComponentAttribute;
import com.bits.ms.ccdi.entities.cms.ComponentType;
import com.bits.ms.ccdi.entities.cms.Context;
import com.bits.ms.ccdi.entities.cntxt.ComponentTypes;
import com.bits.ms.ccdi.exception.DataAccessException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ccdi-root-context-test.xml" })
*//**
 * Test the admin functionalities of CCDI Admin
 * @author COGNIZANT
 *//*
public class CcdiAdminDaoTest
{

	@Autowired
	@Qualifier("ccdiAdminDao")
	CcdiAdminDao adminDao;

	@Autowired
	private DataSource ccdiDataSource;

	private JdbcTemplate jdbcTemplate;

	*//**
	 * @return the adminDao
	 *//*
	public CcdiAdminDao getAdminDao()
	{
		return adminDao;
	}

	*//**
	 * @param adminDao
	 *            the adminDao to set
	 *//*
	public void setAdminDao(CcdiAdminDao adminDao)
	{
		this.adminDao = adminDao;
	}

	@Test
	*//**
	 * Test for consturctor.
	 *//*
	public void testCcdiAdminDao() throws Exception
	{
		CcdiAdminDao result = new CcdiAdminDao();
		assertNotNull(result);
	}

	@Test
	*//**
	 * Test for the data source.
	 *//*
	public void testGetCcdiDataSource() throws Exception
	{
		CcdiAdminDao fixture = new CcdiAdminDao();
		fixture.setGlossaryComponentQuery("");
		fixture.setGatewayAndValidatorComponentQuery("");
		fixture.setPropertyComponentQuery("");
		fixture.setUpdateCntxtTableQuery("");
		fixture.setUpdateCmpntTableQuery("");
		fixture.setInsertCmpntTableQuery("");
		fixture.setEditComponentQuery("");
		fixture.setGenericComponentQuery("");
		fixture.setSelectComponentQuery("");
		fixture.setUpdateCmpntAttribTableQuery("");
		fixture.setEnvironmentAndVerbiageComponentQuery("");
		fixture.setCcdiDataSource(new DriverManagerDataSource());

		DataSource result = fixture.getCcdiDataSource();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.getLoginTimeout());
	}

	@Test
	*//**
	 * Test for the data source.
	 *//*
	public void testSetCcdiDataSource() throws Exception
	{
		CcdiAdminDao fixture = new CcdiAdminDao();
		fixture.setGlossaryComponentQuery("");
		fixture.setGatewayAndValidatorComponentQuery("");
		fixture.setPropertyComponentQuery("");
		fixture.setUpdateCntxtTableQuery("");
		fixture.setUpdateCmpntTableQuery("");
		fixture.setInsertCmpntTableQuery("");
		fixture.setEditComponentQuery("");
		fixture.setGenericComponentQuery("");
		fixture.setSelectComponentQuery("");
		fixture.setUpdateCmpntAttribTableQuery("");
		fixture.setEnvironmentAndVerbiageComponentQuery("");
		fixture.setCcdiDataSource(new DriverManagerDataSource());
		DataSource ccdiDataSource = new DriverManagerDataSource();

		fixture.setCcdiDataSource(ccdiDataSource);

		// add additional test code here
	}

	@Test
	*//**
	 * Test search functionality for GENERIC component type.
	 *//*
	public void testGenericComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode(ComponentTypes.Generic_Component.value());
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test search functionality for empty component type.
	 *//*
	public void testComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode("");
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result == null);
	}

	@Test
	*//**
	 * Test search functionality for PROPERTY component type.
	 *//*
	public void testPropertyComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode(ComponentTypes.Property_Component.value());
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test search functionality for GATEWAY component type.
	 *//*
	public void testGatewayComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode(ComponentTypes.Gateway_Component.value());
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test search functionality for VERBIAGE component type
	 *//*
	public void testVergiageComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode(ComponentTypes.Verbiage_Component.value());
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test search functionality for VALIDATOR component type.
	 *//*
	public void testValidatorComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode(ComponentTypes.Validator_Component.value());
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test search functionality for GLOSSARY component type
	 *//*
	public void testGlossaryComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode(ComponentTypes.Glossary_Component.value());
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}
	@Test
	*//**
	 * Test search functionality with exception flow.
	 *//*
	public void testGlossaryComponentSearchNegitive()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result==null);
	}
	
	@Test
	*//**
	 * Test search functionality for all component types.
	 *//*
	public void testGlossaryComponentSearchAll()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode(ComponentTypes.Glossary_Component.value());
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		context.setBrand("junk Brand");
		context.setVisualRole("VisualRole");
		context.setState("TX");
		context.setCounty("US");
		context.setCity("Mason");
		context.setPlanType("PLAN");
		context.setPlanYear("2014");
		context.setProductCode("PC");
		context.setBrand("PC");
		context.setLanguage("ENGLISH");
		context.setVendor("WLP");
		context.setProviderSpeciality("provdsaf");
		context.setChannel("WLP");
		context.setLob("LOB");
		context.setUserType("utype");
		context.setSiteType("stype");
		context.setProductFamily("pfamily");
		context.setUserRole("pfamily");
		context.setEntitlement("entitlement");
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		component.setCreatedUser("E3CCDI");
		component.setUpdatedUser("E3CCDI");
		component.setSource("src");
		component.setPublishDateFrom("11/12/2014");
		component.setPublishDateTo("11/12/2014");
		component.setUpdatedDateFrom("11/12/2014");
		component.setUpdatedDateTo("11/12/2014");
		component.setExpryDateForSearch("11/12/2014");
		component.setPlnEffctvDateForSearch("11/12/2014");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() == 0);
	}
	@Test
	*//**
	 * Test search functionality for ENVIRONMENT component type.
	 *//*
	public void testEnvironmentComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode(ComponentTypes.EnvironmentEntry_Component.value());
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		try
		{
			result = adminDao.searchComponents(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test update functionality 
	 *//*
	public void testUpdateComponentSearch()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);
		component.setId(500);

		try
		{
			result = adminDao.editComponent(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test update functionality for GENERIC component type.
	 *//*
	public void testUpdateGenericComponent()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);
		component.setId(505);

		try
		{
			result = adminDao.editComponent(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test update functionality for GATEWAY component
	 *//*
	public void testUpdateGatewayComponent()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);
		component.setId(593);

		try
		{
			result = adminDao.editComponent(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test update functionality for GLOSSARY component type.
	 *//*
	public void testUpdateGlossaryComponent()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);
		component.setId(532);

		try
		{
			result = adminDao.editComponent(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test update functionality for PROPERTY component type. 
	 *//*
	public void testUpdatePropertyComponent()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);
		component.setId(538);

		try
		{
			result = adminDao.editComponent(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test update functionality for VALIDATOR component type
	 *//*
	public void testUpdateValidatorComponent()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);
		component.setId(582);

		try
		{
			result = adminDao.editComponent(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test update functionality for VERBIAGE component type.
	 *//*
	public void testUpdateVerbiageComponent()
	{
		Component component = new Component();
		List<Component> result = new ArrayList<Component>();
		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		cntxtList.add(context);
		component.setId(579);

		try
		{
			result = adminDao.editComponent(component);
		} catch (DataAccessException e)
		{
			fail("Data Access Exception" + e.getMessage());
		}
		assertTrue(result.size() > 0);
	}

	@Test
	*//**
	 * Test insert functionality for GENERIC component type
	 *//*
	public void testInsertMetaData() throws ParseException
	{
		Component component = new Component();

		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode("GENERIC");

		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		List<ComponentAttribute> attributesList = new ArrayList<ComponentAttribute>();

		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		component.setCreatedUser("E3CCDI");
		component.setUpdatedUser("E3CCDI");
		int result = 0;
		try
		{
			result = adminDao.insertMetaData(component);
		} catch (DataAccessException e)
		{
			fail("Caught SQLException");
		} catch (Exception e)
		{
			fail("Caught Exception");
		}
		assertTrue("Inserted successfully", result > 1);

		// senario 2
		component = new Component();

		componentType = new ComponentType();
		componentType.setComponentTypeCode("GENERIC");

		context = new Context();
		cntxtList = new ArrayList<Context>();
		cntxtList.add(context);
		ComponentAttribute attribute = new ComponentAttribute();
		attribute.setAttributeName("page");
		attribute.setAttributeValue("page1");
		attribute.setAttributeName("category");
		attribute.setAttributeValue("cat1");
		attribute.setAttributeName("block");
		attribute.setAttributeValue("block1");
		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("INPROGRESS");
		component.setCdiStatus("PUBLISHED");
		component.setCreatedUser("E3CCDI");
		component.setUpdatedUser("E3CCDI");
		attributesList = new ArrayList<ComponentAttribute>();
		attributesList.add(attribute);
		component.setAttributes(attributesList);

		cntxtList.add(context);
		try
		{
			result = adminDao.insertMetaData(component);
		} catch (DataAccessException e)
		{
			fail("Caught SQLException");
		} catch (Exception e)
		{
			fail("Caught Exception");
		}
		assertTrue("Inserted successfully", result >= 1);

		// senario 3
		component = new Component();
		java.util.Date dateNew = new SimpleDateFormat("MM/dd/yyyy").parse("11/11/2014");
		componentType = new ComponentType();
		componentType.setComponentTypeCode("GENERIC");

		context = new Context();
		context.setExpiryDate(dateNew);
		context.setPlanEffectiveDate(dateNew);
		attribute = new ComponentAttribute();
		attribute.setAttributeName("page");
		attribute.setAttributeValue("page");
		attribute.setAttributeName("category");
		attribute.setAttributeValue("cat");
		attribute.setAttributeName("block");
		attribute.setAttributeValue("block");
		cntxtList = new ArrayList<Context>();
		cntxtList.add(context);

		attributesList = new ArrayList<ComponentAttribute>();
		attributesList.add(attribute);
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("INPROGRESS");
		component.setCreatedUser("E3CCDI");
		component.setUpdatedUser("E3CCDI");

		component.setPublishedDate(dateNew);
		component.setAttributes(attributesList);
		try
		{
			result = adminDao.insertMetaData(component);
		} catch (DataAccessException e)
		{
			fail("Caught SQLException");
		} catch (Exception e)
		{
			fail("Caught Exception");
		}
		assertTrue("Inserted successfully", result >= 1);
	}

	@Test
	*//**
	 * Test insert functionality for exception flow 
	 *//*
	public void testInsertMetaDataExceptionFlow()
	{
		int result = 0;
		try
		{
			result = adminDao.insertMetaData(null);
		} catch (Exception e)
		{
			assertTrue("Successfully tested excepiton flow.", result == 0);
		}
	}

	@Test
	*//**
	 * Test exception flow for Search functionality.
	 *//*
	public void testSearchExceptionFlow()
	{
		try
		{
			adminDao.searchComponents(null);
		} catch (Exception e)
		{
			assertTrue("Successfully tested excepiton flow.", true);
		}
	}

	@Test
	*//**
	 * Test edit functionality in exception flow
	 *//*
	public void testEditExceptionFlow()
	{
		try
		{
			adminDao.editComponent(null);
		} catch (Exception e)
		{
			assertTrue("Successfully tested excepiton flow.", true);
		}
	}

	*//**
	 * This test method will be used to test delete functionality .
	 * 
	 * @throws ParseException
	 *//*
	@Test
	public void testDeleteComponent() throws ParseException
	{
		Component component = new Component();

		ComponentType componentType = new ComponentType();
		componentType.setComponentTypeCode("GENERIC");

		Context context = new Context();
		List<Context> cntxtList = new ArrayList<Context>();
		context.setBrand("junk Brand");
		context.setVisualRole("VisualRole");
		context.setState("TX");
		context.setCounty("US");
		context.setCity("Mason");
		context.setPlanType("PLAN");
		context.setPlanYear("2014");
		context.setProductCode("PC");
		context.setBrand("PC");
		context.setLanguage("ENGLISH");
		context.setVendor("WLP");
		context.setChannel("WLP");
		context.setLob("LOB");
		context.setUserType("utype");
		context.setSiteType("stype");
		context.setProductFamily("pfamily");
		context.setUserRole("pfamily");
		context.setEntitlement("entitlement");
		cntxtList.add(context);

		component.setContexts(cntxtList);
		component.setComponentType(componentType);
		component.setCmsStatus("PUBLISHED");
		component.setCdiStatus("PUBLISHED");
		component.setCreatedUser("E3CCDI");
		component.setUpdatedUser("E3CCDI");
		component.setSource("src");
		component.setPublishDateFrom("11/12/2014");
		component.setPublishDateTo("11/12/2014");
		component.setUpdatedDateFrom("11/12/2014");
		component.setUpdatedDateTo("11/12/2014");
		component.setExpryDateForSearch("11/12/2014");
		component.setPlnEffctvDateForSearch("11/12/2014");
	
		
		int result = 0;
		try
		{
			result = adminDao.insertMetaData(component);
		} catch (DataAccessException e)
		{
			fail("Caught SQLException");
		} catch (Exception e)
		{
			fail("Caught Exception");
		}
		assertTrue("Inserted successfully", result > 1);
		component = new Component();
		component.setId(result);
		try
		{
			result = adminDao.deleteComponent(component);
		} catch (DataAccessException e)
		{
			fail("Caught SQLException");
		} catch (Exception e)
		{
			fail("Caught Exception");
		}
		assertTrue("Deleted successfully", result == 1);
	}

	@Test
	*//**
	 * Test delete functionality in exception flow.
	 *//*
	public void testDeleteComponentExceptionFlow()
	{
		int result = 0;
		try
		{
			result = adminDao.deleteComponent(null);
		} catch (Exception e)
		{
			assertTrue("Successfully tested excepiton flow.", result == 0);
		}
	}

	@Test
	*//**
	 * Test update functionality for component
	 *//*
	public void testUpdateComponent()
	{
		int result = 0;

		Component component = new Component();
		Context context = new Context();
		List<Context> contexts = new ArrayList<Context>();
		contexts.add(context);
		component.setContexts(contexts);
		component.setId(954);
		component.setTitleText("testingUpdate");

		try
		{
			result = adminDao.updateComponent(component);
		} catch (Exception e)
		{
			fail("Failed to update");
		}
		assertTrue("Successfully updated", result == 1);
	}

	*//**
	 * Test update functionality in exception flow
	 *//*
	@Test
	public void testUpdateComponentExceptionFlow()
	{
		int result = 0;
		try
		{
			result = adminDao.updateComponent(null);
		} catch (Exception e)
		{
			assertTrue("Successfully tested exception flow", result == 0);
		}
	}
	
	@Test
	*//**
	 * Test update functionality for component
	 *//*
	public void testupdateCmpntTxt()
	{
		int result = 0;
		try
		{
			result = adminDao.updateCmpntTxt("default:http://localhost:9083/e3Batch/", "2786");
		} catch (Exception e)
		{
			fail("Failed to update");
		}
		assertTrue("Successfully updated", result == 1);
	}

	*//**
	 * Test update functionality in exception flow
	 *//*
	@Test
	public void testupdateCmpntTxtExceptionFlow()
	{
		int result = 0;
		try
		{
			result = adminDao.updateCmpntTxt(null, null);
		} catch (Exception e)
		{
			assertTrue("Successfully tested exception flow", result == 0);
		}
	}

	@Test
	*//**
	 * Test the GenericComponentQuery in CcdiAdminDao
	 *//*
	public void testGetQuery() throws Exception
	{
		CcdiAdminDao fixture = new CcdiAdminDao();
		fixture.setGlossaryComponentQuery("");
		fixture.setGatewayAndValidatorComponentQuery("");
		fixture.setPropertyComponentQuery("");
		fixture.setUpdateCntxtTableQuery("");
		fixture.setUpdateCmpntTableQuery("");
		fixture.setInsertCmpntTableQuery("");
		fixture.setEditComponentQuery("");
		fixture.setGenericComponentQuery("");
		fixture.setSelectComponentQuery("");
		fixture.setUpdateCmpntAttribTableQuery("");
		fixture.setEnvironmentAndVerbiageComponentQuery("");
		fixture.setCcdiDataSource(new DriverManagerDataSource());

		String result = fixture.getGenericComponentQuery();

		// add additional test code here
		assertEquals("", result);
		assertEquals("", fixture.getGlossaryComponentQuery());
		assertEquals("", fixture.getGatewayAndValidatorComponentQuery());
		assertEquals("", fixture.getPropertyComponentQuery());
		assertEquals("", fixture.getUpdateCmpntAttribTableQuery());
		assertEquals("", fixture.getUpdateCmpntTableQuery());
		assertEquals("", fixture.getUpdateCntxtTableQuery());
		assertEquals("", fixture.getInsertCmpntTableQuery());
		assertEquals("", fixture.getEditComponentQuery());
		assertEquals("", fixture.getGenericComponentQuery());
		assertEquals("", fixture.getSelectComponentQuery());
		assertEquals("", fixture.getEnvironmentAndVerbiageComponentQuery());

	}
}
*/