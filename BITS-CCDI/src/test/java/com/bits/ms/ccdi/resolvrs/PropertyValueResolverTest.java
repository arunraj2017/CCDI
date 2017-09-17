/**
 * 
 */
package com.bits.ms.ccdi.resolvrs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import com.bits.ms.ccdi.core.exception.NoPropertyFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.Property;
import com.bits.ms.ccdi.entity.cntxt.BusinessContext;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * Test the functionality of PropertyValueResolver class.
 * 
 * @author AD40439
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test/ccdi-root-context-test.xml"})
public class PropertyValueResolverTest
{
	private static final Logger LOG = LogManager.getLogger(PropertyValueResolverTest.class);
	
	@Autowired
	PropertyValueResolver proValResolver;

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
		assertNotNull("PropertyValueResolver initialized successfully",proValResolver);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.PropertyValueResolver#createComponentType(java.lang.String)}.
	 */
	@Test
	public void testCreateComponentType()
	{
		String name = "name";
		
		// Create expected result
		Property comTypeExpected = new Property();
		comTypeExpected.setName(name);

		// Invoke the method to test
		ComponentElement comTypeActual= proValResolver.createComponentType(name);
			
		// Verify results
		assertNotNull(comTypeActual);
		assertEquals(comTypeExpected.getName(), ((Property) comTypeActual).getName());

	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.PropertyValueResolver#resolveProperty(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public void testResolvePropertyExceptionFlow()
	{
		Boolean testResult = Boolean.FALSE;
		
		// Invoke the method to test
		Contexts contexts = new Contexts();
		try
		{
			proValResolver.resolveProperty(contexts, "");
		}
		catch (NoPropertyFoundException e)
		{
			testResult = Boolean.TRUE;
		}
		assert(testResult);				
	}
	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.PropertyValueResolver#resolveProperty(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 * Construct input (Contexts, name)
	 * Test method - PropertyValueResolver.resolveProperty(contexts, name)
	 * Verify results
	 */
	@Test
	public void testResolveProperty()
	{
		String name = "key1";
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("BITSMS");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		Property actual = null;
		try
		{
			actual = proValResolver.resolveProperty(contexts, name);
		} 
		catch (NoPropertyFoundException e)
		{
			fail("Failed to resolve value for key");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (name,value) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_PROPERTY, actual.getName(), actual.getValue());
		
		// Verify results
		assertEquals("Value1", actual.getValue());

	}

	
	/**
	 * Construct input (Contexts, name)
	 * Test method - PropertyValueResolver.resolveProperty(contexts, name)
	 * Verify results
	 */
	@Test
	public final void testRegisteredJobs() {
		
		
		String name = "e3_jobs";
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("E3");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		Property actual = null;
		try
		{
			actual = proValResolver.resolveProperty(contexts, name);
		} 
		catch (NoPropertyFoundException e)
		{
			fail("Failed to resolve value for key");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (name,value) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_PROPERTY, actual.getName(), actual.getValue());
		
		LOG.debug("After splitting = {}",(Object[]) actual.getValue().split(","));
		
		// Verify results
//		assertEquals("sampleFileProcessingJob,ExampleJob,jobWithDependentOutcomeFailedTasks,JobWithSeqTasks,jobWithSeqFailedTasks,jobWithParallelTasks,jobWithANDPreconditionFailedTasks,jobWithDependentOutcomeTasks,JobWithFailedNotifiers,exampleJob,jobWithORPreconditionTasks,jobFailedinStartup,jobWithPreconditionTasks,jobWithNotifiers,jobWithParallelFailedTasks,jobWithTaskFailed", actual.getValue());

	}	
	
	/**
	 * Construct input (Contexts, name)
	 * Test method - PropertyValueResolver.resolveProperty(contexts, name)
	 * Verify results
	 */
	@Test
	public final void testCacheIndicator() {
		
		
		String name = "key1";
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("BITSMS");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		Property cache = null;
		Property db = null;
		try
		{
			cache = proValResolver.resolveProperty(contexts, name);
			db = proValResolver.resolvePropertyFromDB(contexts, name);
		} 
		catch (NoPropertyFoundException e)
		{
			fail("Failed to resolve value for key");
		}
		assertNotNull(cache);
		
		
		LOG.debug("\n\n{} cache (name,value) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_PROPERTY, cache.getName(), cache.getValue());
		LOG.debug("\n\n{} DB (name,value) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_PROPERTY, db.getName(), db.getValue());
		
	}	
}
