package br.gov.mg.fazenda.recaptcha.http;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.gov.mg.fazenda.recaptcha.http.HttpLoader;
import br.gov.mg.fazenda.recaptcha.http.SimpleHttpLoader;
import br.gov.mg.fazenda.recaptcha.internals.ReCaptchaJsApi;
import br.gov.mg.fazenda.recaptcha.internals.ReCaptchaSiteVerifyBuilder;


import junit.framework.TestCase;

/**
 *
 * @author leonardo luz ( leonardo.luz at fazenda.mg.gov.br )
 * @version 0.1
 * @since 01/02/2015
 *
 */

public class SimpleHttpLoadTestCase extends TestCase {

	private HttpLoader httpLoader = null ;

	private static final String GOOGLE_URL = "http://www.google.com" ;

	public SimpleHttpLoadTestCase(String name) {
		super(name);
	}

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		this.httpLoader = new SimpleHttpLoader();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		this.httpLoader = null;
	}


	@Test
	public void testGoogleConnection(){
		System.out.println("Starting test google connection ...");
		String response = this.httpLoader.httpGet(GOOGLE_URL);
		System.out.println(response);
		assertNotNull("Test: Google response can not be a null value",response);
	}


	@Test
	public void testVerifySiteConnection(){
		System.out.println("Starting test Recaptcha Verifify Site connection ...");
		String response = this.httpLoader.httpGet(ReCaptchaSiteVerifyBuilder.URL);
		System.out.println(response);
		assertNotNull("Test: ReCaptcha Verify Site response can not be a null value",response);
	}

	@Test
	public void testVerifySiteSecureConnection(){
		System.out.println("Starting test Recaptcha Verifify Site secure connection ...");
		String response = this.httpLoader.httpGet(ReCaptchaSiteVerifyBuilder.URL_SECURE);
		System.out.println(response);
		assertNotNull("Test: ReCaptcha Verify Site secure response can not be a null value",response);
	}

	@Test
	public void testJsApiConnection(){
		System.out.println("Starting test Recaptcha JS API connection ...");
		String response = this.httpLoader.httpGet(ReCaptchaJsApi.URL);
		System.out.println(response);
		assertNotNull("Test: ReCaptcha JS API response can not be a null value",response);
	}


	@Test
	public void testJsApiSecureConnection(){
		System.out.println("Starting test Recaptcha JS API secure connection ...");
		String response = this.httpLoader.httpGet(ReCaptchaJsApi.URL_SECURE);
		System.out.println(response);
		assertNotNull("Test: ReCaptcha JS API secure response can not be a null value",response);
	}

}
