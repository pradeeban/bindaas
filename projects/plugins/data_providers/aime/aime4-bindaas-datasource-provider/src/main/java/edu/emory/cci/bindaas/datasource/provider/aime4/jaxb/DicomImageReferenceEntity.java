//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.08 at 12:16:10 PM EDT 
//


package edu.emory.cci.bindaas.datasource.provider.aime4.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DicomImageReferenceEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DicomImageReferenceEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM}ImageReferenceEntity">
 *       &lt;sequence>
 *         &lt;element name="imageStudy" type="{gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM}ImageStudy"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DicomImageReferenceEntity", namespace = "gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM", propOrder = {
    "imageStudy"
})
public class DicomImageReferenceEntity
    extends ImageReferenceEntity
{

    @XmlElement(required = true)
    protected ImageStudy imageStudy;

    /**
     * Gets the value of the imageStudy property.
     * 
     * @return
     *     possible object is
     *     {@link ImageStudy }
     *     
     */
    public ImageStudy getImageStudy() {
        return imageStudy;
    }

    /**
     * Sets the value of the imageStudy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageStudy }
     *     
     */
    public void setImageStudy(ImageStudy value) {
        this.imageStudy = value;
    }

}