package br.gov.mg.fazenda.recaptcha;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.gov.mg.fazenda.recaptcha.internals.ReCaptchaUtils;


import junit.framework.TestCase;

/**
 *
 * @author leonardo luz ( leonardo.luz at fazenda.mg.gov.br )
 * @version 0.1
 * @since 01/02/2015
 *
 */

public class ReCaptchaUtilsTestCase extends TestCase {

	private String decodeSimbols; ;
	private String encodeSimbols;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		this.decodeSimbols = "áéíóúâêôãõçà" ;
		this.encodeSimbols = "%E1%E9%ED%F3%FA%E2%EA%F4%E3%F5%E7%E0" ;
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testIsBlankWithEmptyValue(){
		boolean result = ReCaptchaUtils.isBlank("");
		assertEquals("Test: isBlank with an empty value must be true.",true,result);
	}

	@Test
	public void testIsBlankWithBlankValue(){
		boolean result = ReCaptchaUtils.isBlank("   ");
		assertEquals("Test: isBlank with a blank string value must be true.",true,result);
	}

	@Test
	public void testIsBlankWithNullValue(){
		boolean result = ReCaptchaUtils.isBlank(null);
		assertEquals("Test: isBlank with a null value must be true.",true,result);
	}

	@Test
	public void testIsBlankWithNonBlankValue(){
		boolean result = ReCaptchaUtils.isBlank(" TEST ");
		assertEquals("Test: isBlank with a non blank string must be false.",false,result);
	}

	@Test
	public void testIsNotBlankWithEmptyValue(){
		boolean result = ReCaptchaUtils.isNotBlank("");
		assertEquals("Test: isNotBlank with an empty value must be false.",false,result);
	}

	@Test
	public void testIsNonBlankWithBlankValue(){
		boolean result = ReCaptchaUtils.isNotBlank("   ");
		assertEquals("Test: isNotBlank with a blank string value must be false.",false,result);
	}

	@Test
	public void testIsNonBlankWithNullValue(){
		boolean result = ReCaptchaUtils.isNotBlank(null);
		assertEquals("Test: isNotBlank with a null value must be false.",false,result);
	}

	@Test
	public void testIsNonBlankWithNonBlankValue(){
		boolean result = ReCaptchaUtils.isNotBlank(" TEST ");
		assertEquals("Test: isNotBlank with a non blank string value must be true.",true,result);
	}

	@Test
	public void testEncode(){
		String result = ReCaptchaUtils.encode(decodeSimbols);
		assertEquals("Test: encode value '" + decodeSimbols + "' must be '" + encodeSimbols + "'" , encodeSimbols ,result);
	}

	@Test
	public void testDecode(){
		String result = ReCaptchaUtils.decode(encodeSimbols);
		assertEquals("Test: decode value '" + decodeSimbols + "' must be '" + encodeSimbols + "'" , decodeSimbols ,result);
	}

}
