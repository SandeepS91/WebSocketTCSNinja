package com.tcs.ninja;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class RequestBean {

	public String Temperature;
	public String Humidity;
	public String getTemperatur() {
		return Temperature;
	}
	public void setTemperatur(String temperatur) {
		Temperature = temperatur;
	}
	public String getHumidity() {
		return Humidity;
	}
	public void setHumidity(String humidity) {
		Humidity = humidity;
	}
	
}