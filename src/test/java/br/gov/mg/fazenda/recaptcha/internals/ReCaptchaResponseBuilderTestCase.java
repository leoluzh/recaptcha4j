package br.gov.mg.fazenda.recaptcha.internals;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.gov.mg.fazenda.recaptcha.ReCaptchaResponse;
import br.gov.mg.fazenda.recaptcha.internals.ReCaptchaResponseBuilder;


/**
 *
 * @author leonardo luz ( leonardo.luz at fazenda.mg.gov.br )
 * @version 0.1
 * @since 01/02/2015
 *
 */

public class ReCaptchaResponseBuilderTestCase {

	private static final String RESPONSE_JSON_OK = "{ \"success\" : true , \"error-codes\" : [] }";
	private static final String RESPONSE_JSON_FAIL = "{ \"success\" : false , \"error-codes\" : [ \"missing-input-secret\" , \"invalid-input-secret\" , \"missing-input-response\" , \"invalid-input-response\" ] }" ;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testResponseOk() {
		ReCaptchaResponse result = ReCaptchaResponseBuilder.fromJSON(RESPONSE_JSON_OK);
		assertNotNull("Test: ReCaptchaResponseBuilder can not be null.",result);
		assertEquals("Test: ReCaptchaReponse field success must be true.",true,result.isSuccess());
		assertNotNull("Test: RecaptchaResponse errorCodes can not be null.",result.getErrorCodes());
		assertEquals("Test: RecaptchaResponse errorCodes size must be equals 0.",0,result.getErrorCodes().size());
	}

	@Test
	public void testResponseFail(){
		ReCaptchaResponse result = ReCaptchaResponseBuilder.fromJSON(RESPONSE_JSON_FAIL);
		assertNotNull("Test: ReCaptchaResponseBuilder can not be null.",result);
		assertEquals("Test: ReCaptchaReponse field success must be false.",false,result.isSuccess());
		assertNotNull("Test: RecaptchaResponse errorCodes can not be null.",result.getErrorCodes());
		assertEquals("Test: RecaptchaResponse errorCodes size must be equals 4.",4,result.getErrorCodes().size());
	}

}
