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
 * <p>Java class for AnnotationOfAnnotation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AnnotationOfAnnotation">
 *   &lt;complexContent>
 *     &lt;extension base="{gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM}AnnotationEntity">
 *       &lt;sequence>
 *         &lt;element name="adjudicationObservation" type="{gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM}AdjudicationObservation" minOccurs="0"/>
 *         &lt;element name="annotationOfAnnotationStatementCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AnnotationOfAnnotationStatement" type="{gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM}AnnotationStatement" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AnnotationOfAnnotation", namespace = "gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM", propOrder = {
    "adjudicationObservation",
    "annotationOfAnnotationStatementCollection"
})
public class AnnotationOfAnnotation
    extends AnnotationEntity
{

    protected AdjudicationObservation adjudicationObservation;
    protected AnnotationOfAnnotation.AnnotationOfAnnotationStatementCollection annotationOfAnnotationStatementCollection;

    /**
     * Gets the value of the adjudicationObservation property.
     * 
     * @return
     *     possible object is
     *     {@link AdjudicationObservation }
     *     
     */
    public AdjudicationObservation getAdjudicationObservation() {
        return adjudicationObservation;
    }

    /**
     * Sets the value of the adjudicationObservation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdjudicationObservation }
     *     
     */
    public void setAdjudicationObservation(AdjudicationObservation value) {
        this.adjudicationObservation = value;
    }

    /**
     * Gets the value of the annotationOfAnnotationStatementCollection property.
     * 
     * @return
     *     possible object is
     *     {@link AnnotationOfAnnotation.AnnotationOfAnnotationStatementCollection }
     *     
     */
    public AnnotationOfAnnotation.AnnotationOfAnnotationStatementCollection getAnnotationOfAnnotationStatementCollection() {
        return annotationOfAnnotationStatementCollection;
    }

    /**
     * Sets the value of the annotationOfAnnotationStatementCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnnotationOfAnnotation.AnnotationOfAnnotationStatementCollection }
     *     
     */
    public void setAnnotationOfAnnotationStatementCollection(AnnotationOfAnnotation.AnnotationOfAnnotationStatementCollection value) {
        this.annotationOfAnnotationStatementCollection = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="AnnotationOfAnnotationStatement" type="{gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM}AnnotationStatement" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "annotationOfAnnotationStatement"
    })
    public static class AnnotationOfAnnotationStatementCollection {

        @XmlElement(name = "AnnotationOfAnnotationStatement", namespace = "gme://caCORE.caCORE/4.4/edu.northwestern.radiology.AIM", required = true)
        protected List<AnnotationStatement> annotationOfAnnotationStatement;

        /**
         * Gets the value of the annotationOfAnnotationStatement property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the annotationOfAnnotationStatement property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAnnotationOfAnnotationStatement().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AnnotationStatement }
         * 
         * 
         */
        public List<AnnotationStatement> getAnnotationOfAnnotationStatement() {
            if (annotationOfAnnotationStatement == null) {
                annotationOfAnnotationStatement = new ArrayList<AnnotationStatement>();
            }
            return this.annotationOfAnnotationStatement;
        }

    }

}
