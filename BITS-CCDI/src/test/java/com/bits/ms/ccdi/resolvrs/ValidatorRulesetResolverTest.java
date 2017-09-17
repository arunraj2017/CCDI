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
import com.bits.ms.ccdi.core.exception.NoValidatorRulesetFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.Validator;
import com.bits.ms.ccdi.entity.cntxt.BusinessContext;
import com.bits.ms.ccdi.entity.cntxt.Contexts;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/ccdi-root-context-test.xml"})
/**
 *  Test the functionality of ValidatorRulesetResolver class.
 *  
 *  @author COGNIZANT
 *  
 */
public class ValidatorRulesetResolverTest
{
	private static final Logger LOG = LogManager.getLogger(ValidatorRulesetResolverTest.class);
	
	@Autowired
	ValidatorRulesetResolver valRulResolver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
		assertNotNull("ValidatorRulesetResolver initialized successfully",valRulResolver);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	/**
	 * Construct input (Contexts, "action")
	 * Test method - ValidatorRulesetResolver.resolveRuleset(contexts, action)
	 * Verify results
	 * 
	 */
	public final void testCreateComponentType()
	{
		String action = "action";
		
		// Create expected result
		Validator comTypeExpected = new Validator();
		comTypeExpected.setAction(action);

		// Invoke the method to test
		ComponentElement comTypeActual= valRulResolver.createComponentType(action);
			
		// Verify results
		assertNotNull(comTypeActual);
		assertEquals(comTypeExpected.getAction(), ((Validator) comTypeActual).getAction());
	}

	@Test
	/**
	 * Construct input (Contexts, "agentFlowValidator")
	 * Test method - ValidatorRulesetResolver.resolveRuleset(contexts, action)
	 * Verify results
	 * 
	 */
	public final void testResolveRuleset()
	{
		String action = "agentFlowValidator";

		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		businessContext.setName("E3");
		contexts.setBusinessContext(businessContext);
		
		// Invoke the method to test
		Validator actual = null;
		try
		{
			actual = valRulResolver.resolveRuleset(contexts, action);
		} 
		catch (Exception e)
		{
			fail("Failed to resolve validator text for key");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (action,name) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_VALIDATOR, actual.getAction(), actual.getValue());
		
		// Verify results
		assertEquals("agentFlow", actual.getValue());

	}

	@Test
	/**
	 * Construct input (Contexts, "")
	 * Test method - ValidatorRulesetResolver.resolveRuleset(contexts, action)
	 * Verify results
	 */
	public void testResolveRuleSetExceptionFlow()
	{
		Boolean testResult = Boolean.FALSE;
		
		// Invoke the method to test
		Contexts contexts = new Contexts();
		try
		{
			valRulResolver.resolveRuleset(contexts, "");
		}
		catch (NoValidatorRulesetFoundException e)
		{
			testResult = Boolean.TRUE;
		}
		assert(testResult);
	}

}
