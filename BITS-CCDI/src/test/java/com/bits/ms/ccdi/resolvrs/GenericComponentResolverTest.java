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
import com.bits.ms.ccdi.entities.cntxt.GenericComponent;
import com.bits.ms.ccdi.entity.cntxt.BusinessContext;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * 
 * Test the functionality of GenericComponentResolver class.
 * 
 * @author AB69987
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/ccdi-root-context-test.xml"})
public class GenericComponentResolverTest
{
	private static final Logger LOG = LogManager.getLogger(GenericComponentResolverTest.class);
	
	@Autowired
	GenericComponentResolver genericComponentResolver;

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
		assertNotNull("GenericComponentResolver initialized successfully",genericComponentResolver);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.GenericComponentResolver#resolveGenericComponent(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testResolveGenericComponent()
	{
		String page = "ccdiadmin";
		String category ="search";
		String block="results";
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("E3");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		GenericComponent actual = null;
		try
		{
			actual = genericComponentResolver.resolveGenericComponent(contexts, page, category, block);
		} 
		catch (Exception e)
		{
			fail("Failed to resolve Generic Component");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (page, category, block, text) = ({},{},{},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_GENERIC,page,category,block, actual.getText());
		
		// Create expected result

		// Verify results
		assertEquals("agentFlow", actual.getText());
	}

}