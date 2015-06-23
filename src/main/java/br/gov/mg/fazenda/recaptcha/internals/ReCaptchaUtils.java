package br.gov.mg.fazenda.recaptcha.internals;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *
 * @author leonardo luz
 * @version 0.1
 * @since 01/02/2015
 *
 */

public final class ReCaptchaUtils {

	public static String encode( String value ){
		return URLEncoder.encode( value );
	}

	/**
	public static String encode( String value ) throws UnsupportedEncodingException {
		return URLEncoder.encode( value , "UTF-8" );
	}
	**/

	public static String encode( String value , String encoding ) throws UnsupportedEncodingException {
		return URLEncoder.encode( value , encoding );
	}


	public static String decode( String value ){
		return URLDecoder.decode( value );
	}

	public static String decode( String value , String encoding ) throws UnsupportedEncodingException {
		return URLDecoder.decode( value , encoding );
	}

	public static boolean isNotBlank( String value ){
		return !isBlank( value );
	}

	public static boolean isBlank( String value ){
		return value == null || value.trim().isEmpty();
	}

}
