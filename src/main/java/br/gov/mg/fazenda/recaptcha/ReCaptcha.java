package br.gov.mg.fazenda.recaptcha;

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
import java.util.Properties;

import br.gov.mg.fazenda.recaptcha.ReCaptchaResponse;


/**
 *
 * @author leonardo luz fernandes
 * @version 0.1
 * @since 01/02/2015
 *
 */

public interface ReCaptcha {

	public String createRecaptchaHtml();

	public String createRecaptchaHtml( Properties properties );

	public String createRecaptchaHtml( String id , Properties properties );

	public String createRecaptchaHtml( String id , String theme );

	public String createRecaptchaHtml( String id , String theme , String type );

	public String createRecaptchaHtml( String id , String theme , String type , String callback );

	public String createRecaptchaHtml( String id , String theme , String type , String callback , String classes );

	public String createRecaptchaHtml( String id , String theme , String type , String callback , String classes , String style );

	public String createRecaptchaHtml( String id , String theme , String type , String callback , String classes , String style , String size );

	public String createRecaptchaHtml( String id , String theme , String type , String callback , String classes , String style , String size , String tabIndex );
	
	/**
	 * Validates a reCaptcha response.
	 *
	 * @param response The response from the reCaptcha form, this is usually request.getParameter("g-recaptcha-response") in your code.
	 * @return
	 */
	public ReCaptchaResponse checkAnswer(String response );

	/**
	 * Validates a reCaptcha response.
	 *
	 * @param response The response from the reCaptcha form, this is usually request.getParameter("g-recaptcha-response") in your code.
	 * @param remoteAddr The address of the user, eg. request.getRemoteAddr() - Optional
	 * @return
	 */
	public ReCaptchaResponse checkAnswer(String response, String remoteAddr );


	public void setProxy( Proxy proxy );


}
