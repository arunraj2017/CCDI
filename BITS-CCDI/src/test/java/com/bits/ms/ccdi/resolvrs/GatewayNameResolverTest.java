/**
 * 
 */
package com.bits.ms.ccdi.resolvrs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bits.ms.ccdi.api.constants.CcdiApiConstants;
import com.bits.ms.ccdi.core.exception.NoGatewayFoundException;
import com.bits.ms.ccdi.entities.cntxt.ComponentElement;
import com.bits.ms.ccdi.entities.cntxt.Gateway;
import com.bits.ms.ccdi.entity.cntxt.BusinessContext;
import com.bits.ms.ccdi.entity.cntxt.Contexts;
import com.bits.ms.ccdi.entity.cntxt.UserContext;

/**
 * 
 * Test the functionality of GatewayNameResolver class.
 * 
 * @author AD40439
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/ccdi-root-context-test.xml"})
public class GatewayNameResolverTest
{
	private static final Logger LOG = LogManager.getLogger(GatewayNameResolverTest.class);
	
	@Autowired
	GatewayNameResolver gatewayNameResolver;
	
	
	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.GatewayNameResolver#createComponentType(java.lang.String)}.
	 */
	@Test
	public void testCreateComponentType()
	{
		String action = "SearchUser";
		
		// Create expected result
		Gateway comTypeExpected = new Gateway();
		comTypeExpected.setAction(action);
		
		assertNotNull(gatewayNameResolver);
		
		// Invoke the method to test
		ComponentElement comTypeActual= gatewayNameResolver.createComponentType(action);
		
		// Verify results
		assertNotNull(comTypeActual);
		assertEquals(comTypeExpected.getAction(), ((Gateway) comTypeActual).getAction());
	}
	
	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.GatewayNameResolver#resolveGateway(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public void testResolveGatewayExceptionFlow()
	{
		Boolean testResult = Boolean.FALSE;
		
		// Invoke the method to test
		Contexts contexts = new Contexts();
		try
		{
			gatewayNameResolver.resolveGateway(contexts, "");
		}
		catch (NoGatewayFoundException e)
		{
			testResult = Boolean.TRUE;
		}
		assert(testResult);
	}

	/**
	 * Test method for {@link com.wlp.e3.ccdi.api.rslvrs.cntxt.GatewayNameResolver#resolveGateway(com.wlp.e3.cr.api.dmn.entities.cntxt.Contexts, java.lang.String)}.
	 */
	@Test
	public void testResolveGateway()
	{
		String action = "agentFlow";
		// Build contexts object
		Contexts contexts = new Contexts();
		BusinessContext businessContext = new BusinessContext();
		UserContext userContext = new UserContext();
		businessContext.setName("E3");
		businessContext.setBrand("ABCBS");
		businessContext.setCity("Newbury Park");
		businessContext.setState("CA");
		businessContext.setCounty("Ventura");
		userContext.setUserPreferences("en");
		userContext.setUserRole("IT_ADMIN");
		businessContext.setProductCode("test");
		businessContext.setChannel("ABCBS");
		userContext.setEntitlement("Admin");
		businessContext.setLob("Individual");
		businessContext.setPlanYear("2014");
		businessContext.setProductFamily("ProductFamily");
		businessContext.setProviderPlan("providerPlan");
		businessContext.setPlanType("planType");
		businessContext.setPortFolio("Speciality");
		businessContext.setSiteDomain("batch");
		userContext.setUserType("MEMBER");
		businessContext.setVendor("ABC");
		businessContext.setVisualRole("visualRole");
		contexts.setBusinessContext(businessContext);
		contexts.setUserContext(userContext);
		// Invoke the method to test
		Gateway actual = null;
		try
		{
			actual = gatewayNameResolver.resolveGateway(contexts, action);
		} 
		catch (NoGatewayFoundException e)
		{
			fail("Failed to resolve gateway for action.");
		}
		assertNotNull(actual);
		
		LOG.debug("\n\n{} test (action,name) = ({},{}\n\n)", CcdiApiConstants.COMPONENT_TYPE_GATEWAY, actual.getAction(), actual.getName());
		assertEquals("agentFlow", actual.getText());
		// Create expected result
//		Gateway expected = new Gateway();
//		expected.setAction(action);
//		expected.setName("name");


		// Verify results
//		assertEquals(expected, actual);

	}
}
