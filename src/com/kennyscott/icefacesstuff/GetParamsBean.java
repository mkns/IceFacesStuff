
package com.kennyscott.icefacesstuff;

import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class GetParamsBean {

	private String text = "starting value";
	private String param = "n/a";

	public GetParamsBean() {
		readParams();
	}

	private void readParams() {
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		Set<String> keys = params.keySet();
		if ( keys.size() > 0 ) {
			if ( keys.contains( "param" ) )
			  this.setParam( params.get( "param" ) );
			if ( keys.contains( "text" ) )
			  this.setText( params.get( "text" ) );
		}
	}

	public String getParam() {
		return param;
	}

	public void setParam( String param ) {
		this.param = param;
	}

	public String getText() {
		return text;
	}

	public void setText( String text ) {
		this.text = text;
	}

	public void setSecondTextValue() {
		this.setText( "This is the 2nd value" );
	}

}
