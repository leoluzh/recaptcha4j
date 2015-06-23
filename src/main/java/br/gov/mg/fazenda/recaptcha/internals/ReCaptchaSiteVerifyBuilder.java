package br.gov.mg.fazenda.recaptcha.internals;

import br.gov.mg.fazenda.recaptcha.ReCaptchaException;

/**
 *
 * @author leonardo luz
 * @version 0.1
 * @since 01/02/2015
 *
 */

public final class ReCaptchaSiteVerifyBuilder {

	public static final String URL = "http://www.google.com/recaptcha/api/siteverify" ;
	public static final String URL_SECURE = "https://www.google.com/recaptcha/api/siteverify" ;

	public static final String PARAM_SECRET = "secret" ;
	public static final String PARAM_RESPONSE = "response" ;
	public static final String PARAM_USER_IP_ADDRESS  = "remoteip";

	public static final String buildURL( String secret , String response ,  String userIpAddress ){
		return URL + "?" + buildParams( secret, response , userIpAddress );
	}

	public static final String buildParams( String secret , String response , String userIpAddress ){

		if( ReCaptchaUtils.isBlank( secret ) ){
			throw new ReCaptchaException("recaptcha.secret.param.required");
		}

		if( ReCaptchaUtils.isBlank( response ) ){
			throw new ReCaptchaException("recaptcha.response.param.required");
		}

		String params =
				PARAM_SECRET + "=" + ReCaptchaUtils.encode(secret) + "&" +
				PARAM_RESPONSE + "=" + ReCaptchaUtils.encode(response) ;

		if( ReCaptchaUtils.isNotBlank( userIpAddress ) ){
			params = params + "&" + PARAM_USER_IP_ADDRESS + "=" + ReCaptchaUtils.encode(userIpAddress);
		}

		return params ;

	}

}
