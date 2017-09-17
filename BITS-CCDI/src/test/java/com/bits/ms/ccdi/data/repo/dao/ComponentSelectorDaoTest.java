/**
 * 
 */
package com.bits.ms.ccdi.data.repo.dao;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

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
 * Test class for ComponentSelectorDao
 * 
 * @author AD40439
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test/ccdi-root-context-test.xml" })
public class ComponentSelectorDaoTest {
	private static final Logger LOG = LogManager
			.getLogger(ComponentSelectorDaoTest.class);

	@Autowired
	ComponentSelectorDao componentSelectorDao;

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
	 * {@link com.wlp.e3.ccdi.data.repo.dao.ComponentSelectorDao#getComponentData(Component)}
	 * .
	 */
	@Test
	public final void testGetComponentDataForProperty() {
		// Invoke the method to test
		try {
			LOG.debug("Retrieved {} component result {}",
					CcdiApiConstants.COMPONENT_TYPE_PROPERTY,
					componentSelectorDao.getComponentData(createTestComponent(
							CcdiApiConstants.COMPONENT_TYPE_PROPERTY, "name",
							"audit_com.wlp.e3.epc.data.tx.Enrollment_enroll")));

		} catch (DataAccessException e) {
			fail("Caught SQLException.");
		}

	}

	/**
	 * Test method for
	 * {@link com.wlp.e3.ccdi.data.repo.dao.ComponentSelectorDao#getComponentData(Component)}
	 * .
	 */
	@Test
	public final void testGetComponentDataForEnvEntry() {
		// Invoke the method to test
		try {
			LOG.debug("Retrieved {} component result {}",
					CcdiApiConstants.COMPONENT_TYPE_ENV, componentSelectorDao
							.getComponentData(createTestComponent(
									CcdiApiConstants.COMPONENT_TYPE_ENV, "key",
									"E3.ENV.SERVER")));

		} catch (DataAccessException e) {
			LOG.error("Exception caught {}", e);
			fail("Caught SQLException.");
		}

	}

	/**
	 * Test method for
	 * {@link com.wlp.e3.ccdi.data.repo.dao.ComponentSelectorDao#getComponentData(Component)}
	 * .
	 */
	@Test
	public final void testGetComponentDataForGateway() {
		// Invoke the method to test
		try {

			LOG.debug("Retrieved {} component result {}",
					CcdiApiConstants.COMPONENT_TYPE_GATEWAY,
					componentSelectorDao
							.getComponentData(createTestGatewayComponent(
									CcdiApiConstants.COMPONENT_TYPE_GATEWAY,
									"action", "agentFlow")));

		} catch (DataAccessException e) {
			fail("Caught SQLException.");
		}

	}

	/**
	 * Test method for
	 * {@link com.wlp.e3.ccdi.data.repo.dao.ComponentSelectorDao#getComponentData(Component)}
	 * .
	 */
	@Test
	public final void testGetComponentDataForVerbiage() {
		try {
			LOG.debug("Retrieved {} component result {}",
					CcdiApiConstants.COMPONENT_TYPE_VERBIAGE,
					componentSelectorDao.getComponentData(createTestComponent(
							CcdiApiConstants.COMPONENT_TYPE_VERBIAGE, "key",
							"label/ccdi/admin/language/options")));

		} catch (DataAccessException e) {
			fail("Caught SQLException.");
		}

	}

	/**
	 * Test method for
	 * {@link com.wlp.e3.ccdi.data.repo.dao.ComponentSelectorDao#getComponentData(Component)}
	 * .
	 */
	@Test
	public final void testGetComponentDataForValidator() {
		// Invoke the method to test
		try {
			LOG.debug("Retrieved {} component result {}",
					CcdiApiConstants.COMPONENT_TYPE_VALIDATOR,
					componentSelectorDao.getComponentData(createTestComponent(
							CcdiApiConstants.COMPONENT_TYPE_VALIDATOR,
							"action", "agentFlowValidator")));

		} catch (DataAccessException e) {
			fail("Caught SQLException.");
		}

	}

	/**
	 * Test method for
	 * {@link com.wlp.e3.ccdi.data.repo.dao.ComponentSelectorDao#getPlaceHolderProperties()}
	 * .
	 */
	@Test
	public final void testGetPlaceHolderProperties() {
		// Invoke the method to test
		try {
			LOG.debug("Retrieved {} component result {}",
					"PlaceHolderProperties",
					componentSelectorDao.getPlaceHolderProperties());

		} catch (DataAccessException e) {
			fail("Caught SQLException.");
		}

	}

	/**
	 * 
	 * Helper method to create test data. Creates Component based on the
	 * component type passes as input.
	 * 
	 * @param componentType
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 */
	public Component createTestComponent(String componentType,
			String attributeName, String attributeValue) {

		Component component = new Component();
		component.setComponentType(new ComponentType(componentType));

		List<ComponentAttribute> componentAttributes = new ArrayList<ComponentAttribute>();
		ComponentAttribute componentAttribute = new ComponentAttribute();
		componentAttribute.setAttributeName(attributeName);
		componentAttribute.setAttributeValue(attributeValue);
		componentAttributes.add(componentAttribute);

		component.setAttributes(componentAttributes);

		List<Context> contexts = new ArrayList<Context>();
		Context context = new Context();
		context.setSite("E3");
		contexts.add(context);
		component.setContexts(contexts);

		return component;

	}

	/**
	 * Helper method to create test data. Creates Component based on the
	 * component type passes as input.
	 * 
	 * @param componentType
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 */
	public Component createTestGatewayComponent(String componentType,
			String attributeName, String attributeValue) {

		Component component = new Component();
		component.setComponentType(new ComponentType(componentType));

		List<ComponentAttribute> componentAttributes = new ArrayList<ComponentAttribute>();
		ComponentAttribute componentAttribute = new ComponentAttribute();
		componentAttribute.setAttributeName(attributeName);
		componentAttribute.setAttributeValue(attributeValue);
		componentAttributes.add(componentAttribute);

		component.setAttributes(componentAttributes);

		List<Context> contexts = new ArrayList<Context>();
		Context context = new Context();
		context.setSite("E3");
		context.setBrand("ABCBS");
		context.setCity("Newbury Park");
		context.setState("CA");
		context.setCounty("Ventura");
		context.setLanguage("en");
		context.setUserRole("IT_ADMIN");
		context.setProductCode("test");
		context.setChannel("ABCBS");
		context.setEntitlement("Admin");
		context.setLob("Individual");
		context.setPlanYear("2014");
		context.setProductFamily("ProductFamily");
		context.setProviderPlan("providerPlan");
		context.setPlanType("planType");
		context.setProviderSpeciality("Speciality");
		context.setSiteType("batch");
		context.setUserType("MEMBER");
		context.setVendor("ABC");
		context.setVisualRole("visualRole");

		contexts.add(context);
		component.setContexts(contexts);

		return component;

	}

}
