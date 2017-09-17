/**
 * 
 */
package com.bits.ms.ccdi.data.repo.dao;

import static org.junit.Assert.assertTrue;
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
import com.bits.ms.ccdi.exception.DataAccessException;

/**
 * Test the CccdiSelectorDAO class
 * 
 * @author AD40439
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/ccdi-root-context-test.xml" })
public class CcdiSelectorDaoTest {
	private static final Logger LOG = LogManager
			.getLogger(CcdiSelectorDaoTest.class);

	@Autowired
	CcdiSelectorDao ccdiSelectorDao;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.wlp.e3.ccdi.data.repo.dao.CcdiSelectorDao#getComponentData(com.wlp.e3.ccdi.api.dmn.entities.cms.Component)}
	 * .
	 */
	@Test
	public final void testGetComponentData() {
		// Invoke the method to test
		List<Component> actual = null;
		try {
			Map<String, String> attributes = new HashMap<String, String>();
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_TERM,
					"agentFlowValidator");
			actual = ccdiSelectorDao.getComponentData(createTestComponent(
					CcdiApiConstants.COMPONENT_TYPE_GLOSSARY, attributes));
			assertTrue(actual.size() == 1);
		} catch (DataAccessException e) {
			fail("Caught SQLException");
		}
		LOG.debug("Retrieved {} result : {}",
				CcdiApiConstants.COMPONENT_TYPE_GLOSSARY, actual);
	}

	/**
	 * Test method for
	 * {@link com.wlp.e3.ccdi.data.repo.dao.CcdiSelectorDao#getComponentData(com.wlp.e3.ccdi.api.dmn.entities.cms.Component)}
	 * .
	 */
	@Test
	public final void testGetComponentDataGenericQuery() {
		// Invoke the method to test
		List<Component> actual = null;
		try {
			Map<String, String> attributes = new HashMap<String, String>();
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_PAGE,
					"ccdiadmin");
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_CATEGORY,
					"search");
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_BLOCK,
					"results");
			actual = ccdiSelectorDao.getComponentData(createTestComponent(
					CcdiApiConstants.COMPONENT_TYPE_GENERIC, attributes));
			attributes = new HashMap<String, String>();
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_PAGE,
					"ccdiadmin1");
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_CATEGORY,
					"search1");
			attributes.put(CcdiApiConstants.COMPONENT_ATTRIBUTE_BLOCK,
					"results1");
			actual = ccdiSelectorDao.getComponentData(createTestComponent(
					CcdiApiConstants.COMPONENT_TYPE_GENERIC, attributes));
			assertTrue(actual.size() == 0);

			actual = ccdiSelectorDao.getComponentData(createTestComponent(
					CcdiApiConstants.COMPONENT_ATTRIBUTE_VALUE, attributes));
			assertTrue(actual == null);

			actual = ccdiSelectorDao.getComponentData(null);
			assertTrue(actual == null);
		} catch (DataAccessException e) {
			fail("Caught SQLException");
		}
		LOG.debug("Retrieved {} result : {}",
				CcdiApiConstants.COMPONENT_TYPE_GENERIC, actual);
		// Verify results
	}

	/**
	 * Helper method to create test data. Creates Component based on the
	 * component type passes as input.
	 * 
	 * @param componentType
	 * @param attributes
	 * @return
	 */
	public Component createTestComponent(String componentType,
			Map<String, String> attributes) {
		Component component = new Component();
		component.setComponentType(new ComponentType(componentType));

		List<ComponentAttribute> componentAttributes = new ArrayList<ComponentAttribute>();
		ComponentAttribute componentAttribute = null;

		for (Map.Entry<String, String> attribute : attributes.entrySet()) {
			componentAttribute = new ComponentAttribute();
			componentAttribute.setAttributeName(attribute.getKey());
			componentAttribute.setAttributeValue(attribute.getValue());
			componentAttributes.add(componentAttribute);
		}
		component.setAttributes(componentAttributes);

		List<Context> contexts = new ArrayList<Context>();
		Context context = new Context();
		context.setSite("E3");
		if (componentType.equals("GLOSSARY")) {
			context.setLanguage("ES");
		}
		contexts.add(context);
		component.setContexts(contexts);

		return component;
	}
}
