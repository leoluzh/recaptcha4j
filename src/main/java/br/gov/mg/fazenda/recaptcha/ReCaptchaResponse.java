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

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author leonardo luz fernandes
 * @version 0.1
 * @since 01/02/2015
 *
 */

@SuppressWarnings("serial")
public class ReCaptchaResponse implements Serializable {

	private boolean success;
	private List<String> errorCodes;

	public ReCaptchaResponse(){

	}

	public ReCaptchaResponse( boolean success , List<String> errorCodes ){
		this.success = success ;
		this.errorCodes = errorCodes ;
	}


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


	public boolean isValid(){
		return this.success;
	}

	public List<String> getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(List<String> errorCodes) {
		this.errorCodes = errorCodes;
	}

}
