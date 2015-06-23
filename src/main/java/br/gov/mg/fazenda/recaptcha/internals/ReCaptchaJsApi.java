package br.gov.mg.fazenda.recaptcha.internals;

import java.util.Map;

import br.gov.mg.fazenda.recaptcha.ReCaptchaException;



/**
 *
 * @author leonardo luz
 * @version 0.1
 * @since 01/02/2015
 *
 */

public final class ReCaptchaJsApi {

	public static final String URL = "http://www.google.com/recaptcha/api.js" ;
	public static final String URL_SECURE = "https://www.google.com/recaptcha/api.js" ;
	public static final String URL_NOSCRIPT = "http://www.google.com/recaptcha/api/fallback" ;
	public static final String URL_NOSCRIPT_SECURE = "https://www.google.com/recaptcha/api/fallback" ;

	public static final String PARAM_ONLOAD = "onload" ;
	public static final String PARAM_RENDER = "render" ;
	public static final String PARAM_LANGUAGE = "hl" ;

	public static final String TAG_ATTR_CLASS_VALUE = "g-recaptcha" ;
	public static final String TAG_ATTR_SITE_KEY = "data-sitekey" ;
	public static final String TAG_ATTR_THEME = "data-theme" ;
	public static final String TAG_ATTR_TYPE = "data-type" ;
	public static final String TAG_ATTR_CALLBACK = "data-callback" ;
	public static final String TAG_ATTR_ID = "id" ;
	public static final String TAG_ATTR_STYLE = "style" ;

	public static final String TAG_ATTR_SIZE = "data-size" ;
	public static final String TAG_ATTR_TABINDEX = "data-tabindex" ;
	public static final String TAG_ATTR_EXPIREDCALLBACK = "data-expired-callback" ;


	public static String buildParams( String onload , String render , String language ){

		String params = "";

		if( ReCaptchaUtils.isNotBlank( onload ) ){
			params = params + PARAM_ONLOAD + "=" + ReCaptchaUtils.encode( onload );
		}

		if( ReCaptchaUtils.isNotBlank( render ) ){
			if( ReCaptchaUtils.isNotBlank( params ) ){
				params = params + "&" ;
			}
			params = params + PARAM_RENDER + "=" + ReCaptchaUtils.encode( render );
		}

		if( ReCaptchaUtils.isNotBlank( language )){
			if( ReCaptchaUtils.isNotBlank( params ) ){
				params = params + "&" ;
			}
			params = params + PARAM_LANGUAGE + "=" + ReCaptchaUtils.encode( language );
		}

		return params;

	}

	public static String buildURL( String onload , String render , String language , boolean secure ){
		String params = buildParams(onload, render, language);
		return ( secure ? URL_SECURE : URL ) + ( ReCaptchaUtils.isBlank( params ) ? "" : ( "?" + params ) ) ;
	}

	public static String div( String siteKey ){
		return div( siteKey , null , null , null , null , null , null );
	}

	public static String div( String siteKey , String divId ){
		return div( siteKey , divId , null , null , null , null , null );
	}

	public static String div( String siteKey , String divId , String theme ){
		return div( siteKey , divId , theme , null , null , null , null );
	}

	public static String div( String siteKey , String divId , String theme , String type ){
		return div( siteKey , divId , theme , type , null , null , null );
	}

	public static String div( String siteKey , String divId , String theme , String type , String callback ){
		return div( siteKey , divId , theme , type , callback , null , null );
	}

	public static String div( String siteKey , String divId , String theme , String type , String callback , String classes ){
		return div( siteKey , divId , theme , type , callback , classes , null , null , null , null );
	}

	public static String div( String siteKey , String divId , String theme , String type , String callback , String classes , String style ){
		return div( siteKey , divId , theme , type , callback , classes , style , null , null , null );
	}

	public static String div( String siteKey , String divId , String theme , String type , String callback , String classes , String style , String size ){
		return div( siteKey , divId , theme , type , callback , classes , style , size , null , null );
	}

	public static String div( String siteKey , String divId , String theme , String type , String callback , String classes , String style , String size , String tabIndex ){
		return div( siteKey , divId , theme , type , callback , classes , style , size , tabIndex , null );
	}


	public static String div( String siteKey , String divId , String theme , String type , String callback , String classes , String style , String size , String tabIndex , String expiredCallback ){

		StringBuilder html = new StringBuilder();

		html.append("<div ");
		html.append(" class=\"" + TAG_ATTR_CLASS_VALUE + ( ReCaptchaUtils.isNotBlank( classes )  ? ( " " + classes ) : "" ) + "\"" );

		html.append( buildTagAttr( TAG_ATTR_SITE_KEY , siteKey ) );
		html.append( buildTagAttr( TAG_ATTR_ID , divId ) );
		html.append( buildTagAttr( TAG_ATTR_THEME , theme ) );
		html.append( buildTagAttr( TAG_ATTR_TYPE, type ) );
		html.append( buildTagAttr( TAG_ATTR_CALLBACK, callback ) );
		html.append( buildTagAttr( TAG_ATTR_STYLE, style ) );

		html.append( buildTagAttr( TAG_ATTR_SIZE , size ) );
		html.append( buildTagAttr( TAG_ATTR_TABINDEX , tabIndex ) );
		html.append( buildTagAttr( TAG_ATTR_EXPIREDCALLBACK , expiredCallback ));


		html.append("></div>");
		return html.toString();
	}

	public static String div( String siteKey , String divId , Map<String,String> data ){

		StringBuilder html = new StringBuilder();

		html.append("<div ");
		html.append(" class=\"" + TAG_ATTR_CLASS_VALUE + ( ReCaptchaUtils.isNotBlank( data.get("classes") )  ? ( " " + data.get("classes") ) : "" ) + "\"" );

		html.append( buildTagAttr( TAG_ATTR_SITE_KEY , siteKey ) );
		html.append( buildTagAttr( TAG_ATTR_ID , divId ) );

		html.append( buildTagAttr( TAG_ATTR_THEME , data.get(TAG_ATTR_THEME) ) );
		html.append( buildTagAttr( TAG_ATTR_TYPE, data.get(TAG_ATTR_TYPE) ) );
		html.append( buildTagAttr( TAG_ATTR_CALLBACK, data.get(TAG_ATTR_CALLBACK) ) );
		html.append( buildTagAttr( TAG_ATTR_STYLE, data.get(TAG_ATTR_STYLE) ) );

		html.append( buildTagAttr( TAG_ATTR_SIZE , data.get(TAG_ATTR_SIZE) ) );
		html.append( buildTagAttr( TAG_ATTR_TABINDEX , data.get(TAG_ATTR_TABINDEX) ) );
		html.append( buildTagAttr( TAG_ATTR_EXPIREDCALLBACK , data.get(TAG_ATTR_EXPIREDCALLBACK) ));

		html.append("></div>");
		return html.toString();

	}

	public static String buildTagAttr( String attr , String value ){
		return ReCaptchaUtils.isNotBlank( value ) ? ( " " + attr + "=\""+ value +"\" " ) : "" ;
	}

	public static String script( boolean secure ){
		return "<script type=\"text/javascript\" src=\""+ ( secure ? URL_SECURE : URL ) +"\" async defer></script>" ;
	}

	public static String script( String onload , String render , String language , boolean secure ){
		String url = buildURL(onload, render, language, secure);
		return "<script type=\"text/javascript\" src=\""+ ( url ) +"\" async defer></script>" ;
	}

	public static String explicityJS( String divId , String onLoadCallbackId , String siteKey , String theme , String callbackAfterRender ){

		String params = "" ;

		//TODO: Exception message
		if( ReCaptchaUtils.isBlank( divId ) ){
			throw new ReCaptchaException("Parameter 'id' on 'Explicity' mode is required.");
		}

		//TODO: Exception message
		if( ReCaptchaUtils.isBlank( onLoadCallbackId ) ){
			throw new ReCaptchaException("Parameter 'onloadCallback' on 'Explicity' mode is required.");
		}

		//TODO: Exception message
		if( ReCaptchaUtils.isNotBlank( siteKey ) ){
			params += "'sitekey' : '" + siteKey + "' , " ;
		}else{
			throw new ReCaptchaException("Parameter 'siteKey' on 'Explicity' mode is required.");
		}

		if( ReCaptchaUtils.isNotBlank( theme ) ){
			params += "'theme' : '" + theme + "' , " ;
		}

		if( ReCaptchaUtils.isNotBlank( callbackAfterRender ) ){
			params += "'callback' : '" + callbackAfterRender + "' , " ;
		}

		StringBuilder js = new StringBuilder();
		js.append( "<script type=\"text/javascript\">" );
		js.append( "\n\t" );
		js.append( " var " + onLoadCallbackId + " = function(){ " );
		js.append( "\n\t\t" );
		js.append( " grecatcha.render( \"" + divId + "\" , { " );
		js.append( "\n\t\t\t" );
		js.append( params );
		js.append( "\n\t\t" );
		js.append( "}); " );
		js.append( "\n\t" );
		js.append( " };" );
		js.append( "\n" );
		js.append( "</script>" );

		return js.toString();

	}

	public static String noScript( String siteKey , boolean secure ){

		StringBuilder noJs = new StringBuilder() ;

		noJs.append( "<noscript>" );
		noJs.append( "\n\t" );
		noJs.append( "<div style=\"width: 302px; height: 352px;\">" );
		noJs.append( "\n\t\t" ) ;
		noJs.append( "<div style=\"width: 302px; height: 352px; position: relative;\">" ) ;
		noJs.append( "\n\t\t\t" ) ;
		noJs.append( "<div style=\"width: 302px; height: 352px; position: absolute;\">" ) ;
		noJs.append( "\n\t\t\t\t" ) ;
		noJs.append( "<iframe src=\"" + ( secure ? URL_NOSCRIPT_SECURE : URL_NOSCRIPT ) + "?k=" + siteKey + "\" " );
	    noJs.append( " frameborder=\"0\" scrolling=\"no\"" );
		noJs.append( " style=\"width: 302px; height:352px; border-style: none;\">" );
		noJs.append( "</iframe>" );
		noJs.append( "\n\t\t\t" ) ;
		noJs.append( "</div>" );
		noJs.append( "\n\t\t\t" ) ;
		noJs.append( "<div style=\"width: 250px; height: 80px; position: absolute; border-style: none;" ) ;
		noJs.append( " bottom: 21px; left: 25px; margin: 0px; padding: 0px; right: 25px;\">" );
		noJs.append( "\n\t\t\t\t" ) ;
		noJs.append( "<textarea id=\"g-recaptcha-response\" name=\"g-recaptcha-response\"" );
		noJs.append( " class=\"g-recaptcha-response\"" );
		noJs.append( " style=\"width: 250px; height: 80px; border: 1px solid #c1c1c1" );
		noJs.append( " margin: 0px; padding: 0px; resize: none;\" value=\"\">" );
		noJs.append( "</textarea>" );
		noJs.append( "\n\t\t\t" ) ;
		noJs.append( "</div>" );
		noJs.append( "\n\t\t" ) ;
		noJs.append( "</div>" );
		noJs.append( "\n\t" ) ;
		noJs.append( "</div>" );
		noJs.append( "\n" );
		noJs.append( "</noscript>" );

		return noJs.toString();
	}

}
