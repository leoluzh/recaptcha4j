package br.gov.mg.fazenda.recaptcha.internals;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.gov.mg.fazenda.recaptcha.internals.ReCaptchaJsApi;


/**
 *
 * @author leonardo luz ( leonardo.luz at fazenda.mg.gov.br )
 * @version 0.1
 * @since 01/02/2015
 *
 */

public class ReCaptchaJsApiTestCase {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testDivWithSiteKey() {
		System.out.println("Test: Creating with site key.");
		String result = ReCaptchaJsApi.div("SITE_KEY_VALUE");
		System.out.println(result);
		assertNotNull("Test: Create a div with site key. Result can not be null.", result);
	}

	@Test
	public void testDivWithIdAndSiteKey() {
		System.out.println("Test: Creating div with id and with site key.");
		String result = ReCaptchaJsApi.div("SITE_KEY_VALUE","IDENTIFIER");
		System.out.println(result);
		assertNotNull("Test: Create div with id and with site key. Result can not be null.", result);
	}

	@Test
	public void testDivWithIdAndSiteKeyAndTheme() {
		System.out.println("Test: Creating div with id , site key and theme.");
		String result = ReCaptchaJsApi.div("SITE_KEY_VALUE","IDENTIFIER","THEME_VALUE");
		System.out.println(result);
		assertNotNull("Test: Create div with id , site key and theme. Result can not be null.", result);
	}

	@Test
	public void testDivWithIdAndSiteKeyAndThemeAndType() {
		System.out.println("Test: Creating div with id, site key, ");
		String result = ReCaptchaJsApi.div("SITE_KEY_VALUE","IDENTIFIER","THEME_VALUE","TYPE_VALUE");
		System.out.println(result);
		assertNotNull("Test: Create a div without id and with site key. Result can not be null.", result);
	}

	@Test
	public void testDivWithIdAndSiteKeyAndThemeAndTypeAndCallback() {
		System.out.println("Test: Creating div with id and with site key");
		String result = ReCaptchaJsApi.div("SITE_KEY_VALUE","IDENTIFIER","THEME_VALUE","TYPE_VALUE","CALLBACK_VALUE");
		System.out.println(result);
		assertNotNull("Test: Create a div without id and with site key. Result can not be null.", result);
	}

	@Test
	public void testDivWithIdAndSiteKeyAndThemeAndTypeAndCallbackAndClasses() {
		System.out.println("Test: Creating div with id and with site key");
		String result = ReCaptchaJsApi.div("SITE_KEY_VALUE","IDENTIFIER","THEME_VALUE","TYPE_VALUE","CALLBACK_VALUE","CLASSES_VALUE");
		System.out.println(result);
		assertNotNull("Test: Create a div without id and with site key. Result can not be null.", result);
	}

	@Test
	public void testDivWithIdAndSiteKeyAndThemeAndTypeAndCallbackAndClassesAndStyle() {
		System.out.println("Test: Creating div with id and with site key");
		String result = ReCaptchaJsApi.div("SITE_KEY_VALUE","IDENTIFIER","THEME_VALUE","TYPE_VALUE","CALLBACK_VALUE","CLASSES_VALUE","STYLE_VALUE");
		System.out.println(result);
		assertNotNull("Test: Create a div without id and with site key. Result can not be null.", result);
	}


	@Test
	public void testNoScript(){
		System.out.println("Test: Creating noscript with site key.");
		String result = ReCaptchaJsApi.noScript("SITE_KEY_VALUE",false);
		System.out.println(result);
		assertNotNull("Test: Create a noscript with site key. Result can not be null.", result);
	}


	@Test
	public void testExplicityJs(){
		System.out.println("Test: Creating explicityjs.");
		String result = ReCaptchaJsApi.explicityJS("DIV_ID","ONLOAD_CALLBACK_ID","SITE_KEY","THEME","CALLBACK");
		System.out.println(result);
		assertNotNull("Test: Create a explicityjs. Result can not be null.", result);
	}


	@Test
	public void testScript(){
		System.out.println("Test: Creating script.");
		String result = ReCaptchaJsApi.script(false);
		System.out.println(result);
		assertNotNull("Test: Create a script. Result can not be null.", result);
	}

	@Test
	public void testBuildParams(){
		System.out.println("Test: Creating buildParams.");
		String result = ReCaptchaJsApi.buildParams("ONLOAD_VALUE","RENDER_VALUE","LANGUAGE_VALUE");
		System.out.println(result);
		assertNotNull("Test: Create a script. Result can not be null.", result);
	}

}
