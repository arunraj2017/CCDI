/**
 * 
 */
package com.bits.ms.ccdi.resolvrs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
import com.bits.ms.ccdi.core.exception.NoEnvironmentEntryFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.EnvironmentEntry;
import com.bits.ms.ccdi.entity.cntxt.BusinessContext;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * Test the functionality of EnvironmentEntryResolver class.
 * 
 * @author AD40439
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test/ccdi-root-context-test.xml"})
public class EnvironmentEntryResolverTest
{
	private static final Logger LOG = LogManager.getLogger(EnvironmentEntryResolverTest.class);
	
	@Autowired
	EnvironmentEntryResolver envEntryResolver;
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
		assertNotNull("EnvironmentEntryResolver initialized successfully",envEntryResolver);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.EnvironmentEntryResolver#createComponentType(java.lang.String)}.
	 */
	@Test
	public void testCreateComponentType()
	{
		String key = "Key";
		
		// Create expected result
		EnvironmentEntry comTypeExpected = new EnvironmentEntry();
		comTypeExpected.setKey(key);

		// Invoke the method to test
		ComponentElement comTypeActual= envEntryResolver.createComponentType(key);
			
		// Verify results
		assertNotNull(comTypeActual);
		assertEquals(comTypeExpected.getKey(),((EnvironmentEntry) comTypeActual).getKey());
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.EnvironmentEntryResolver#resolveEnvironmentEntry(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public void testResolveEnvironmentEntryExceptionFlow()
	{
		Boolean testResult = Boolean.FALSE;
		
		// Invoke the method to test
		Contexts contexts = new Contexts();
		try
		{
			envEntryResolver.resolveEnvironmentEntry(contexts, "");
		}
		catch (NoEnvironmentEntryFoundException e)
		{
			testResult = Boolean.TRUE;
		}
		assertTrue(testResult);		
	}
	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.EnvironmentEntryResolver#resolveEnvironmentEntry(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public void testResolveEnvironmentEntry()
	{
		String key = "envkey";
		
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("BITSMS");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		EnvironmentEntry actual = null;
		try
		{
			actual=envEntryResolver.resolveEnvironmentEntry(contexts, key);
		} 
		catch (NoEnvironmentEntryFoundException e)
		{
			fail("Failed to resolve environment entry for key");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (key,value) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_ENV, actual.getKey(), actual.getValue());
		
		// Verify results
		assertEquals("PLACEHOLDER_CONFIG", actual.getTitle());
		
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.EnvironmentEntryResolver#resolveEnvironmentEntry(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public void testResolveEnvironmentEntry1()
	{
		String key = "envkey";
		
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("BITSMS");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		EnvironmentEntry actual = null;
		try
		{
			actual=envEntryResolver.resolveEnvironmentEntry(contexts, key);
		} 
		catch (NoEnvironmentEntryFoundException e)
		{
			fail("Failed to resolve environment entry for key");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (key,value) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_ENV, actual.getKey(), actual.getValue());
		
		// Verify results
		assertEquals("<a href=\"http://localhost:9080/e3AdminConsole/service/logger/refreshContext\" target=\"_blank\" style=\"font-size: 12px;color:blue;\">Local</a>", actual.getValue());
		
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.EnvironmentEntryResolver#resolveEnvironmentEntry(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public void testResolveEnvironmentEntry2()
	{
		String key = "envkey";
		
		System.setProperty("bits.environment", "sit");
		
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("BITSMS");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		EnvironmentEntry actual = null;
		try
		{
			actual=envEntryResolver.resolveEnvironmentEntry(contexts, key);
		} 
		catch (NoEnvironmentEntryFoundException e)
		{
			fail("Failed to resolve environment entry for key");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (key,value) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_ENV, actual.getKey(), actual.getValue());
		
		// Verify results
		assertEquals("<a href=\"http://va10n40020.wellpoint.com:9080/cachemonitor\" target=\"_blank\" style=\"font-size: 12px;color:blue;\">SBX</a>", actual.getValue());
		
	}

}
