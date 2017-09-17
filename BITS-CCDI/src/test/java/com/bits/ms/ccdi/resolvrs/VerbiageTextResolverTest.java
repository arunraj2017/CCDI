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
import com.bits.ms.ccdi.core.exception.NoVerbiageTextFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.Verbiage;
import com.bits.ms.ccdi.entity.cntxt.BusinessContext;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

/**
 * Test the functionality of VerbiageTextResolver class.
 *  
 * @author AD40439
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/ccdi-root-context-test.xml"})
public class VerbiageTextResolverTest
{
	private static final Logger LOG = LogManager.getLogger(VerbiageTextResolverTest.class);
	
	@Autowired
	VerbiageTextResolver verTxtResolver;

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
		assertNotNull("VerbiageTextResolver initialized successfully",verTxtResolver);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.VerbiageTextResolver#createComponentType(java.lang.String)}.
	 */
	@Test
	public final void testCreateComponentType()
	{
		String key = "Key";
		
		// Create expected result
		Verbiage comTypeExpected = new Verbiage();
		comTypeExpected.setKey(key);

		// Invoke the method to test
		ComponentElement comTypeActual= verTxtResolver.createComponentType(key);
			
		// Verify results
		assertNotNull(comTypeActual);
		assertEquals(comTypeExpected.getKey(), ((Verbiage) comTypeActual).getKey());
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.VerbiageTextResolver#resolveText(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public final void testResolveText()
	{
		String key = "label/ccdi/admin/language/OPTIONS";
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("E3");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		Verbiage actual = null;
		try
		{
			actual = verTxtResolver.resolveText(contexts, key);
		} 
		catch (Exception e)
		{
			fail("Failed to resolve verbiage text for key");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (key,text) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_VERBIAGE, actual.getKey(), actual.getText());
		
		// Create expected result

		// Verify results
//		assertEquals(expected, actual);
	}

	@Test
	/**
	 * 
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.VerbiageTextResolver#resolveText(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 * Exception Flow
	 */
	public void testResolveTextExceptionFlow()
	{
		Boolean testResult = Boolean.FALSE;
		
		// Invoke the method to test
		Contexts contexts = new Contexts();
		try
		{
			verTxtResolver.resolveText(contexts, "");
		}
		catch (NoVerbiageTextFoundException e)
		{
			testResult = Boolean.TRUE;
		}
		assert(testResult);
	}
	
}