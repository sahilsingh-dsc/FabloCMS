package com.myfablo.cms.module_digikyc.gst.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SaveGstData {

    @SerializedName("valid")
    @Expose
    private Boolean valid;
    @SerializedName("active")
    @Expose
    private Boolean active;
    @SerializedName("legalName")
    @Expose
    private String legalName;
    @SerializedName("tradeName")
    @Expose
    private String tradeName;
    @SerializedName("pan")
    @Expose
    private String pan;
    @SerializedName("constitution")
    @Expose
    private String constitution;
    @SerializedName("nature")
    @Expose
    private List<String> nature;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("registered")
    @Expose
    private String registered;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("expiry")
    @Expose
    private Object expiry;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("stateCode")
    @Expose
    private String stateCode;
    @SerializedName("center")
    @Expose
    private String center;
    @SerializedName("centerCode")
    @Expose
    private String centerCode;
    @SerializedName("addresses")
    @Expose
    private List<Address> addresses;
    @SerializedName("filings")
    @Expose
    private Object filings;
    @SerializedName("einvoiceEnabled")
    @Expose
    private Boolean einvoiceEnabled;

    /**
     * No args constructor for use in serialization
     */
    public SaveGstData() {
    }

    /**
     * @param addresses
     * @param constitution
     * @param nature
     * @param center
     * @param active
     * @param registered
     * @param type
     * @param einvoiceEnabled
     * @param valid
     * @param legalName
     * @param filings
     * @param tradeName
     * @param centerCode
     * @param stateCode
     * @param expiry
     * @param state
     * @param pan
     * @param updated
     */
    public SaveGstData(Boolean valid, Boolean active, String legalName, String tradeName, String pan, String constitution, List<String> nature, String type, String registered, String updated, Object expiry, String state, String stateCode, String center, String centerCode, List<Address> addresses, Object filings, Boolean einvoiceEnabled) {
        super();
        this.valid = valid;
        this.active = active;
        this.legalName = legalName;
        this.tradeName = tradeName;
        this.pan = pan;
        this.constitution = constitution;
        this.nature = nature;
        this.type = type;
        this.registered = registered;
        this.updated = updated;
        this.expiry = expiry;
        this.state = state;
        this.stateCode = stateCode;
        this.center = center;
        this.centerCode = centerCode;
        this.addresses = addresses;
        this.filings = filings;
        this.einvoiceEnabled = einvoiceEnabled;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public List<String> getNature() {
        return nature;
    }

    public void setNature(List<String> nature) {
        this.nature = nature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Object getExpiry() {
        return expiry;
    }

    public void setExpiry(Object expiry) {
        this.expiry = expiry;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Object getFilings() {
        return filings;
    }

    public void setFilings(Object filings) {
        this.filings = filings;
    }

    public Boolean getEinvoiceEnabled() {
        return einvoiceEnabled;
    }

    public void setEinvoiceEnabled(Boolean einvoiceEnabled) {
        this.einvoiceEnabled = einvoiceEnabled;
    }

}