
package com.sdk.wms.iml.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paramsJson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appToken" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="appKey" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="service" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "paramsJson",
    "appToken",
    "appKey",
    "service"
})
@XmlRootElement(name = "callService")
public class CallService {

    protected String paramsJson;
    @XmlElement(required = true)
    protected String appToken;
    @XmlElement(required = true)
    protected String appKey;
    @XmlElement(required = true)
    protected String service;

    /**
     * ��ȡparamsJson���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParamsJson() {
        return paramsJson;
    }

    /**
     * ����paramsJson���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParamsJson(String value) {
        this.paramsJson = value;
    }

    /**
     * ��ȡappToken���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppToken() {
        return appToken;
    }

    /**
     * ����appToken���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppToken(String value) {
        this.appToken = value;
    }

    /**
     * ��ȡappKey���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * ����appKey���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppKey(String value) {
        this.appKey = value;
    }

    /**
     * ��ȡservice���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getService() {
        return service;
    }

    /**
     * ����service���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setService(String value) {
        this.service = value;
    }

}
