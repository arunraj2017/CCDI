/**
 * 
 */
package com.bits.ms.ccdi.data.repo.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bits.ms.ccdi.api.constants.CcdiApiConstants;
import com.bits.ms.ccdi.entities.cms.Component;
import com.bits.ms.ccdi.entities.cms.ComponentAttribute;
import com.bits.ms.ccdi.entities.cms.ComponentType;
import com.bits.ms.ccdi.entities.cms.Context;
import com.bits.ms.ccdi.entities.cntxt.WildcardTypeEnum;
import com.bits.ms.ccdi.exception.DataAccessException;

/**
 * Test the CcdiWildcardSelectorDao class
 * 
 * @author AD40439
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test/ccdi-root-context-test.xml"})
public class CcdiWildcardSelectorDaoTest
{
	private static final Logger LOG = LogManager.getLogger(CcdiWildcardSelectorDaoTest.class);

	@Autowired
	CcdiWildcardSelectorDao ccdiWildCardSelectorDao;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	/**
	 * Test method for {@link com.wlp.e3.ccdi.data.repo.dao.CcdiWildcardSelectorDao#getComponentData(Component, com.wlp.e3.ccdi.api.dmn.entities.WildcardTypeEnum)}.
	 */
	@Test
	public final void testGetComponentDataComponentIsNull()
	{
		// Invoke the method to test
		List<Component> actual = null;
		try
		{
			Map<String, String> attributes = new HashMap<String, String>();
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_TERM,"agen%");
			actual = ccdiWildCardSelectorDao.getComponentData(null, WildcardTypeEnum.TERM_START_WITH);
		} catch (DataAccessException e)
		{
			fail("Caught SQLException");
		}
		LOG.debug("Retrieved {} {} result : {}", CcdiApiConstants.COMPONENT_TYPE_GLOSSARY, WildcardTypeEnum.TERM_START_WITH,actual);
		assertNull(actual);
	}
	
	@Test
	/**
	 * Test method for {@link com.wlp.e3.ccdi.data.repo.dao.CcdiWildcardSelectorDao#getComponentData(Component, com.wlp.e3.ccdi.api.dmn.entities.WildcardTypeEnum)}.
	 */
	public final void testGetComponentDataAtrbIsNull()
	{
		// Invoke the method to test
		List<Component> actual = null;
		try
		{
			Map<String, String> attributes = new HashMap<String, String>();
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_TERM,"agen%");
			actual = ccdiWildCardSelectorDao.getComponentData(createTestComponentWithNull(CcdiApiConstants.COMPONENT_TYPE_GLOSSARY, attributes), WildcardTypeEnum.TERM_START_WITH);
		} catch (DataAccessException e)
		{
			fail("Caught SQLException");
		}
		LOG.debug("Retrieved {} {} result : {}", CcdiApiConstants.COMPONENT_TYPE_GLOSSARY, WildcardTypeEnum.TERM_START_WITH,actual);
		assertNull(actual);
	}
	
	/**
	 * Test method for {@link com.wlp.e3.ccdi.data.repo.dao.CcdiWildcardSelectorDao#getComponentData(Component, com.wlp.e3.ccdi.api.dmn.entities.WildcardTypeEnum)}.
	 */
	@Test
	public final void testGetComponentData()
	{
		// Invoke the method to test
		List<Component> actual = null;
		try
		{
			Map<String, String> attributes = new HashMap<String, String>();
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_TERM,"agen%");
			actual = ccdiWildCardSelectorDao.getComponentData(createTestComponent(CcdiApiConstants.COMPONENT_TYPE_GLOSSARY, attributes), WildcardTypeEnum.TERM_START_WITH);
		} catch (DataAccessException e)
		{
			fail("Caught SQLException");
		}
		LOG.debug("Retrieved {} {} result : {}", CcdiApiConstants.COMPONENT_TYPE_GLOSSARY, WildcardTypeEnum.TERM_START_WITH,actual);

	}

	/**
	 * Helper method to create test data.
	 * Creates Component based on the component type passes as input.
	 * 
	 * @param componentType
	 * @param attributes
	 * @return
	 */	
	public Component createTestComponent(String componentType, Map<String, String> attributes)
	{
		Component component = new Component();
		component.setComponentType(new ComponentType(componentType));

		List<ComponentAttribute> componentAttributes = new ArrayList<ComponentAttribute>();
		ComponentAttribute componentAttribute = null;
		
		for (Map.Entry<String,String> attribute : attributes.entrySet())
		{
		    componentAttribute = new ComponentAttribute();
			componentAttribute.setAttributeName(attribute.getKey());
			componentAttribute.setAttributeValue(attribute.getValue());
			componentAttributes.add(componentAttribute);
		}
		component.setAttributes(componentAttributes);
		
		List<Context> contexts = new ArrayList<Context>();
		Context context = new Context();
		context.setSite("E3");
		contexts.add(context);
		component.setContexts(contexts);
		

		return component;
	}
	
	/**
	 * Helper method to create test data.
	 * 
	 * @param componentType
	 * @param attributes
	 * @return
	 */
	public Component createTestComponentWithNull(String componentType, Map<String, String> attributes)
	{
		Component component = new Component();
		component.setComponentType(new ComponentType(componentType));
		return component;
	}
}
