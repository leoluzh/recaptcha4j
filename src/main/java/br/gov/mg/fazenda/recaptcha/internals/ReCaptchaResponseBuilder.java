package br.gov.mg.fazenda.recaptcha.internals;

import java.util.ArrayList;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;

import br.gov.mg.fazenda.recaptcha.ReCaptchaResponse;


/**
 *
 * @author leonardo luz
 * @version 0.1
 * @since 01/02/2015
 *
 */

public final class ReCaptchaResponseBuilder {

	private static final String JSON_FIELD_SUCESS = "success" ;
	private static final String JSON_FIELD_ERROR_CODES = "error-codes" ;

	public static ReCaptchaResponse fromJSON( String json ){

		ReCaptchaResponse result = new ReCaptchaResponse();

		JSONObject jsonObject = new JSONObject( json );

		result.setSuccess((Boolean)jsonObject.get(JSON_FIELD_SUCESS));

		if( !result.isSuccess() ){

			JSONArray jsonCodes = (JSONArray)jsonObject.get(JSON_FIELD_ERROR_CODES);
			List<String> errorCodes = new ArrayList<String>();

			for( int index = 0 ; index < jsonCodes.length() ; index++ ){
				errorCodes.add( (String) jsonCodes.get(index) );
			}

			result.setErrorCodes(errorCodes);

		}

		return result;

	}

}
