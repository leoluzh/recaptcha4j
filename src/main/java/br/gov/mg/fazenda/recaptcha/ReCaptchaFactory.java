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

import br.gov.mg.fazenda.recaptcha.ReCaptcha;
import br.gov.mg.fazenda.recaptcha.internals.ReCaptchaImpl;



/**
 *
 * @author leonardo luz fernandes
 * @version 0.1
 * @since 01/02/2015
 *
 */

public class ReCaptchaFactory {

	public static ReCaptcha newReCaptcha(String siteKey, String secretKey) {
		return newReCaptcha(siteKey, secretKey, false, false);
	}

	public static ReCaptcha newReCaptcha(String siteKey, String secretKey, boolean includeNoScript) {
		return newReCaptcha(siteKey, secretKey, includeNoScript, false);
	}

	public static ReCaptcha newReCaptchaSecure(String siteKey, String secretKey, boolean includeNoScript){
		return newReCaptcha(siteKey, secretKey, includeNoScript,true);
	}

	public static ReCaptcha newReCaptcha(String siteKey, String secretKey, boolean includeNoScript , boolean secure ) {
		ReCaptchaImpl recaptcha = new ReCaptchaImpl();
		recaptcha.setSiteKey(siteKey);
		recaptcha.setSecretKey(secretKey);
		recaptcha.setIncludeNoScript(includeNoScript);
		recaptcha.setSecure(secure);
		return recaptcha;
	}

	public static ReCaptcha newReCaptcha(String siteKey, String secretKey, boolean includeNoScript , boolean secure , Proxy proxy ) {
		ReCaptchaImpl recaptcha = new ReCaptchaImpl();
		recaptcha.setSiteKey(siteKey);
		recaptcha.setSecretKey(secretKey);
		recaptcha.setIncludeNoScript(includeNoScript);
		recaptcha.setSecure(secure);
		recaptcha.setProxy(proxy);
		return recaptcha;
	}


}
