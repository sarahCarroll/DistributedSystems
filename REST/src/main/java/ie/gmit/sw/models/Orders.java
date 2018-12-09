//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.12.09 at 12:38:46 PM GMT 
//


package ie.gmit.sw.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookingId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="rentalDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="returnDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="account" type="{http://sw.gmit.ie/models/}account"/&gt;
 *         &lt;element name="car" type="{http://sw.gmit.ie/models/}car" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bookingId",
    "rentalDate",
    "returnDate",
    "account",
    "car"
})
@XmlRootElement(name = "orders", namespace = "http://sw.gmit.ie/models/")
public class Orders {

    @XmlElement(namespace = "http://sw.gmit.ie/models/")
    protected int bookingId;
    @XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
    protected String rentalDate;
    @XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
    protected String returnDate;
    @XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
    protected Account account;
    @XmlElement(namespace = "http://sw.gmit.ie/models/", required = true)
    protected List<Car> car;

    /**
     * Gets the value of the bookingId property.
     * 
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Sets the value of the bookingId property.
     * 
     */
    public void setBookingId(int value) {
        this.bookingId = value;
    }

    /**
     * Gets the value of the rentalDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRentalDate() {
        return rentalDate;
    }

    /**
     * Sets the value of the rentalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRentalDate(String value) {
        this.rentalDate = value;
    }

    /**
     * Gets the value of the returnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the value of the returnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnDate(String value) {
        this.returnDate = value;
    }

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link Account }
     *     
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link Account }
     *     
     */
    public void setAccount(Account value) {
        this.account = value;
    }

    /**
     * Gets the value of the car property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the car property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Car }
     * 
     * 
     */
    public List<Car> getCar() {
        if (car == null) {
            car = new ArrayList<Car>();
        }
        return this.car;
    }

}
