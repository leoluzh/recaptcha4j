package br.gov.mg.fazenda.recaptcha.internals;


/*
 * Copyright 2007 Soren Davidsen, Tanesha Networks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import br.gov.mg.fazenda.recaptcha.ReCaptcha;
import br.gov.mg.fazenda.recaptcha.ReCaptchaProperties;
import br.gov.mg.fazenda.recaptcha.ReCaptchaResponse;
import br.gov.mg.fazenda.recaptcha.http.HttpLoader;
import br.gov.mg.fazenda.recaptcha.http.SimpleHttpLoader;



/**
 *
 * @author leonardo luz
 * @version 0.1
 * @since 01/02/2015
 *
 */

public class ReCaptchaImpl implements ReCaptcha {

	private String siteKey;
	private String secretKey;
	private boolean includeNoScript = false ;
	private boolean secure = false ;
	private HttpLoader httpLoader = new SimpleHttpLoader();

	public void setSiteKey( String siteKey ){
		this.siteKey = siteKey ;
	}

	public void setSecretKey( String secretKey ){
		this.secretKey = secretKey ;
	}

	public void setIncludeNoScript( boolean includeNoScript ){
		this.includeNoScript = includeNoScript ;
	}

	public void setSecure( boolean secure ){
		this.secure = secure ;
	}

	public ReCaptchaResponse checkAnswer( String response ) {
		return checkAnswer( response , null );
	}

	public ReCaptchaResponse checkAnswer( String response , String remoteAddr ) {

		String params = ReCaptchaSiteVerifyBuilder.buildParams( this.secretKey , response , remoteAddr );
		String url = secure ? ReCaptchaSiteVerifyBuilder.URL_SECURE : ReCaptchaSiteVerifyBuilder.URL  ;
		String result = httpLoader.httpGet( url + "?"+ params );
		//String result = httpLoader.httpPost(url, params);

		if( ReCaptchaUtils.isNotBlank( result ) ){
			return ReCaptchaResponseBuilder.fromJSON( result );
		}else{
			List<String> errors = new ArrayList<String>();
			errors.add("Nullable result from server.");
			return new ReCaptchaResponse(false,errors);
		}

	}


	public String createRecaptchaHtml(){
		return createRecaptchaHtml( null , null , null , null , null , null );
	}

	public String createRecaptchaHtml( String divId ){
		return createRecaptchaHtml( divId , null , null , null , null , null );
	}

	public String createRecaptchaHtml( Properties properties ){
		return createRecaptchaHtml(
				properties.getProperty(ReCaptchaProperties.ID_KEY,null), properties );
	}


	public String createRecaptchaHtml( String divId , Properties properties ){
		return createRecaptchaHtml(divId,
				properties.getProperty(ReCaptchaProperties.THEME_KEY,null),
				properties.getProperty(ReCaptchaProperties.TYPE_KEY,null) ,
				properties.getProperty(ReCaptchaProperties.CALLBACK_KEY,null) ,
				properties.getProperty(ReCaptchaProperties.CLASSES_KEY,null),
				properties.getProperty(ReCaptchaProperties.STYLE_KEY,null),
				properties.getProperty(ReCaptchaProperties.SIZE_KEY,null), 
				properties.getProperty(ReCaptchaProperties.TABINDEX_KEY,null),
				properties.getProperty(ReCaptchaProperties.EXPIREDCALLBACK_KEY,null));
		
	}

	public String createRecaptchaHtml( String divId , String theme ){
		return createRecaptchaHtml( divId , theme , null , null , null , null , null , null , null );
	}

	public String createRecaptchaHtml( String divId , String theme , String type){
		return createRecaptchaHtml( divId , theme , type , null , null , null , null , null , null );
	}

	public String createRecaptchaHtml( String divId , String theme , String type , String callback ){
		return createRecaptchaHtml( divId , theme , type , callback , null , null , null , null , null );
	}

	public String createRecaptchaHtml( String divId , String theme , String type , String callback , String classes ){
		return createRecaptchaHtml( divId , theme , type , callback , classes , null , null , null , null );
	}
	
	public String createRecaptchaHtml( String divId , String theme , String type , String callback , String classes , String style ){
		return createRecaptchaHtml( divId , theme , type , callback , classes , style , null , null , null );
	}

	public String createRecaptchaHtml( String divId , String theme , String type , String callback , String classes , String style , String size ){
		return createRecaptchaHtml( divId , theme , type , callback , classes , style , size , null , null );
	}
	
	public String createRecaptchaHtml( String divId , String theme , String type , String callback , String classes , String style , String size , String tabIndex ){
		return createRecaptchaHtml( divId , theme , type , callback , classes , style , size , tabIndex , null );
	}
	
	public String createRecaptchaHtml( String divId , String theme , String type , String callback , String classes , String style , String size , String tabIndex , String expiredCallback ){

		StringBuilder html = new StringBuilder();
		html.append( ReCaptchaJsApi.div( this.siteKey , divId , theme , type , callback , classes , style , size , tabIndex , expiredCallback ) );

		if( includeNoScript ){
			html.append( ReCaptchaJsApi.noScript( this.siteKey , this.secure ) );
		}

		return html.toString();
		
	}

	public void setProxy( Proxy proxy ){
		this.httpLoader.setProxy(proxy);
	}

}
