//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.08 at 12:16:10 PM EDT 
//


package edu.emory.cci.bindaas.datasource.provider.aime4.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IVL.Low_MO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IVL.Low_MO">
 *   &lt;complexContent>
 *     &lt;restriction base="{uri:iso.org:21090}IVL_MO">
 *       &lt;sequence>
 *         &lt;element name="originalText" type="{uri:iso.org:21090}ED.Text" minOccurs="0"/>
 *         &lt;element name="low" type="{uri:iso.org:21090}MO" minOccurs="0"/>
 *         &lt;element name="high" type="{uri:iso.org:21090}MO" maxOccurs="0" minOccurs="0"/>
 *         &lt;element name="width" type="{uri:iso.org:21090}QTY" maxOccurs="0" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IVL.Low_MO")
public class IVLLowMO
    extends IVLMO
{


}
