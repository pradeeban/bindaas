//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.08 at 12:16:10 PM EDT 
//


package edu.emory.cci.bindaas.datasource.provider.aime4.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnnotationRoleEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnnotationRoleEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM}Entity">
 *       &lt;sequence>
 *         &lt;element name="roleCode" type="{uri:iso.org:21090}CD"/>
 *         &lt;element name="questionTypeCode" type="{uri:iso.org:21090}CD" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="roleSequenceNumber" type="{uri:iso.org:21090}INT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnnotationRoleEntity", namespace = "gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM", propOrder = {
    "roleCode",
    "questionTypeCode",
    "roleSequenceNumber"
})
public class AnnotationRoleEntity
    extends Entity
{

    @XmlElement(required = true)
    protected CD roleCode;
    protected List<CD> questionTypeCode;
    protected INT roleSequenceNumber;

    /**
     * Gets the value of the roleCode property.
     * 
     * @return
     *     possible object is
     *     {@link CD }
     *     
     */
    public CD getRoleCode() {
        return roleCode;
    }

    /**
     * Sets the value of the roleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CD }
     *     
     */
    public void setRoleCode(CD value) {
        this.roleCode = value;
    }

    /**
     * Gets the value of the questionTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the questionTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQuestionTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CD }
     * 
     * 
     */
    public List<CD> getQuestionTypeCode() {
        if (questionTypeCode == null) {
            questionTypeCode = new ArrayList<CD>();
        }
        return this.questionTypeCode;
    }

    /**
     * Gets the value of the roleSequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link INT }
     *     
     */
    public INT getRoleSequenceNumber() {
        return roleSequenceNumber;
    }

    /**
     * Sets the value of the roleSequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link INT }
     *     
     */
    public void setRoleSequenceNumber(INT value) {
        this.roleSequenceNumber = value;
    }

}
