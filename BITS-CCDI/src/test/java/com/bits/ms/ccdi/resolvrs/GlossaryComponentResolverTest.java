/**
 * 
 */
package com.bits.ms.ccdi.resolvrs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.GlossaryComponent;
import com.bits.ms.ccdi.entity.cntxt.BusinessContext;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * Test the functionality of GlossaryComponentResolver class.
 *  
 * @author AB69987
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test/ccdi-root-context-test.xml"})
public class GlossaryComponentResolverTest
{
	private static final Logger LOG = LogManager.getLogger(GlossaryComponentResolverTest.class);
	
	@Autowired
	GlossaryComponentResolver glossaryComponentResolver;

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
		assertNotNull("GlossaryComponentResolver initialized successfully",glossaryComponentResolver);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.GlossaryComponentResolver#resolveGlossaryComponent(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public final void testResolveGlossaryComponent()
	{
		String term = "agentFlowValidator";
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("E3");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		GlossaryComponent actual = null;
		try
		{
			actual = glossaryComponentResolver.resolveGlossaryComponent(contexts, term);
		} 
		catch (Exception e)
		{
			fail("Failed to resolve Glossary for given term");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (term, text) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_GLOSSARY,term, actual.getText());
		
		// Create expected result

		// Verify results
		assertEquals("agentFlow", actual.getText());
	}
	
	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.GlossaryComponentResolver#resolveWildCardGlossaryComponent(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public final void testResolveWildCardGlossaryComponent()
	{
		String term = "agentFlow%";
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("E3");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		List<ComponentElement> actuals = null;
		try
		{
			actuals = glossaryComponentResolver.resolveWildCardGlossaryComponent(contexts, term);
		} 
		catch (Exception e)
		{
			fail("Failed to resolve Glossary for given term");
		}
		assertNotNull(actuals);
		
		LOG.debug("\n\n{} test (term, Glossary) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_GLOSSARY,term,actuals);
		
	}


}