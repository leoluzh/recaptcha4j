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

/**
 *
 * @author leonardo luz fernandes
 * @version 0.1
 * @since 01/02/2015
 *
 */

public class ReCaptchaProperties {

	public static final String ID_KEY = "grecaptcha-id" ;
	public static final String THEME_KEY = "grecaptcha-data-theme" ;
	public static final String TYPE_KEY = "grecaptcha-data-type" ;
	public static final String CALLBACK_KEY = "grecaptcha-data-callback" ;
	public static final String CLASSES_KEY = "grecaptcha-extension-classes" ;
	public static final String STYLE_KEY = "grecaptcha-extension-style" ;
	
	public static final String SIZE_KEY = "grecaptcha-data-size" ;
	public static final String TABINDEX_KEY = "grecaptcha-data-tabindex" ;
	public static final String EXPIREDCALLBACK_KEY = "grecaptcha-data-expired-callback" ;
	

	public static final String THEME_VALUE_DARK = "dark" ;
	public static final String THEME_VALUE_LIGHT = "light" ;

	public static final String TYPE_VALUE_AUDIO = "audio" ;
	public static final String TYPE_VALUE_IMAGE = "image" ;

	public static final String RESPONSE_FIELD_NAME = "g-recaptcha-response" ;

}
