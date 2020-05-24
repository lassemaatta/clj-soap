package cljsoap.api.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Measurement {
    @XmlElement(required = true)
    private Double waterTemperature;
    @XmlElement(required = true)
    private String location;
    @XmlElement(required = true)
    private String beach;

    public Measurement(final Double waterTemperature,
                       final String location,
                       final String beach) {
        this.waterTemperature = waterTemperature;
        this.location = location;
        this.beach = beach;
    }

    // JAXB requires a no-args constructor
    public Measurement() {
    }
}
