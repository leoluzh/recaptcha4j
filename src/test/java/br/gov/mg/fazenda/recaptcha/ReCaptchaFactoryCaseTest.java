package br.gov.mg.fazenda.recaptcha;

import static org.junit.Assert.*;

import java.util.Properties;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.gov.mg.fazenda.recaptcha.ReCaptcha;
import br.gov.mg.fazenda.recaptcha.ReCaptchaFactory;
import br.gov.mg.fazenda.recaptcha.ReCaptchaProperties;
import br.gov.mg.fazenda.recaptcha.ReCaptchaResponse;


/**
 *
 * @author leonardo luz ( leonardo.luz at fazenda.mg.gov.br )
 * @version 0.1
 * @since 01/02/2015
 *
 */

public class ReCaptchaFactoryCaseTest {

	private String siteKey;
	private String secretKey;
	private boolean noScript;
	private ReCaptcha reCaptcha;
	private Properties properties;
	private boolean secure;

	@Before
	public void setUp() throws Exception {

		this.siteKey = System.getProperty("siteKey") ;
		this.secretKey = System.getProperty("secretKey");
		this.secure = true ;
		this.noScript = false ;

		if( secure ){
			this.reCaptcha = ReCaptchaFactory.newReCaptchaSecure(this.siteKey,this.secretKey,this.noScript);
		}else{
			this.reCaptcha = ReCaptchaFactory.newReCaptcha(this.siteKey,this.secretKey,this.noScript);
		}

	}


	@Before
	public void setUpProperties(){
		this.properties = new Properties();
		this.properties.put(ReCaptchaProperties.CALLBACK_KEY,"callbackFuction");
		this.properties.put(ReCaptchaProperties.CLASSES_KEY,"recaptcha-custom-css");
		this.properties.put(ReCaptchaProperties.ID_KEY,"RECAPTCHA_DIV_ID");
		this.properties.put(ReCaptchaProperties.STYLE_KEY,"display:inline");
		this.properties.put(ReCaptchaProperties.THEME_KEY,ReCaptchaProperties.THEME_VALUE_LIGHT);
		this.properties.put(ReCaptchaProperties.TYPE_KEY,ReCaptchaProperties.TYPE_VALUE_IMAGE);
	}


	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCreateReCaptcha() {
		ReCaptcha result = ReCaptchaFactory.newReCaptcha(this.siteKey,this.secretKey,this.noScript);
		assertNotNull("Test: create recaptcha can not be null",result);
	}

	@Test
	public void testCreateHtmlWithProperties(){
		System.out.println("Test: Create Html with properties.");
		String result = this.reCaptcha.createRecaptchaHtml(properties);
		System.out.println(result);
		assertNotNull("Test: create html with properties can not be null.",result);
	}

	@Test
	public void testCreckAnswer(){
		System.out.println("Test: Creating chech answer ...");
		ReCaptchaResponse result = this.reCaptcha.checkAnswer("INVALID_ANSWER");
		assertNotNull("Test: check answer can not be null",result);
		assertEquals("Test: check answer result success must be false",false,result.isSuccess());
	}


}
