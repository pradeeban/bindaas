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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QSI_CO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QSI_CO">
 *   &lt;complexContent>
 *     &lt;extension base="{uri:iso.org:21090}QSET_CO">
 *       &lt;sequence>
 *         &lt;element name="term" type="{uri:iso.org:21090}QSET_CO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QSI_CO", propOrder = {
    "term"
})
public class QSICO
    extends QSETCO
{

    protected List<QSETCO> term;

    /**
     * Gets the value of the term property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the term property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTerm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QSETCO }
     * 
     * 
     */
    public List<QSETCO> getTerm() {
        if (term == null) {
            term = new ArrayList<QSETCO>();
        }
        return this.term;
    }

}
