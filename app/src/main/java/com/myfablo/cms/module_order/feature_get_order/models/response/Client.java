package com.myfablo.cms.module_order.feature_get_order.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Client {

    @SerializedName("clientId")
    @Expose
    private String clientId;
    @SerializedName("clientName")
    @Expose
    private String clientName;
    @SerializedName("clientPhone")
    @Expose
    private String clientPhone;
    @SerializedName("clientAddress")
    @Expose
    private String clientAddress;
    @SerializedName("clientLongitude")
    @Expose
    private Double clientLongitude;
    @SerializedName("clientLatitude")
    @Expose
    private Double clientLatitude;
    @SerializedName("isCODEnable")
    @Expose
    private Boolean isCODEnable;

    /**
     * No args constructor for use in serialization
     */
    public Client() {
    }

    /**
     * @param clientId
     * @param isCODEnable
     * @param clientName
     * @param clientLongitude
     * @param clientAddress
     * @param clientLatitude
     * @param clientPhone
     */
    public Client(String clientId, String clientName, String clientPhone, String clientAddress, Double clientLongitude, Double clientLatitude, Boolean isCODEnable) {
        super();
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientAddress = clientAddress;
        this.clientLongitude = clientLongitude;
        this.clientLatitude = clientLatitude;
        this.isCODEnable = isCODEnable;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Double getClientLongitude() {
        return clientLongitude;
    }

    public void setClientLongitude(Double clientLongitude) {
        this.clientLongitude = clientLongitude;
    }

    public Double getClientLatitude() {
        return clientLatitude;
    }

    public void setClientLatitude(Double clientLatitude) {
        this.clientLatitude = clientLatitude;
    }

    public Boolean getIsCODEnable() {
        return isCODEnable;
    }

    public void setIsCODEnable(Boolean isCODEnable) {
        this.isCODEnable = isCODEnable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Client.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("clientId");
        sb.append('=');
        sb.append(((this.clientId == null) ? "<null>" : this.clientId));
        sb.append(',');
        sb.append("clientName");
        sb.append('=');
        sb.append(((this.clientName == null) ? "<null>" : this.clientName));
        sb.append(',');
        sb.append("clientPhone");
        sb.append('=');
        sb.append(((this.clientPhone == null) ? "<null>" : this.clientPhone));
        sb.append(',');
        sb.append("clientAddress");
        sb.append('=');
        sb.append(((this.clientAddress == null) ? "<null>" : this.clientAddress));
        sb.append(',');
        sb.append("clientLongitude");
        sb.append('=');
        sb.append(((this.clientLongitude == null) ? "<null>" : this.clientLongitude));
        sb.append(',');
        sb.append("clientLatitude");
        sb.append('=');
        sb.append(((this.clientLatitude == null) ? "<null>" : this.clientLatitude));
        sb.append(',');
        sb.append("isCODEnable");
        sb.append('=');
        sb.append(((this.isCODEnable == null) ? "<null>" : this.isCODEnable));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}