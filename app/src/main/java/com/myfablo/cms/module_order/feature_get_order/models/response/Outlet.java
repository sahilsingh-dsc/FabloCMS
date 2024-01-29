package com.myfablo.cms.module_order.feature_get_order.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Outlet {

    @SerializedName("outletId")
    @Expose
    private String outletId;
    @SerializedName("sellerId")
    @Expose
    private String sellerId;
    @SerializedName("outletName")
    @Expose
    private String outletName;
    @SerializedName("outletPhone")
    @Expose
    private String outletPhone;
    @SerializedName("outletArea")
    @Expose
    private String outletArea;
    @SerializedName("outletAddress")
    @Expose
    private String outletAddress;
    @SerializedName("outletLongitude")
    @Expose
    private Double outletLongitude;
    @SerializedName("outletLatitude")
    @Expose
    private Double outletLatitude;

    /**
     * No args constructor for use in serialization
     */
    public Outlet() {
    }

    /**
     * @param outletName
     * @param outletLatitude
     * @param outletAddress
     * @param sellerId
     * @param outletLongitude
     * @param outletId
     * @param outletArea
     * @param outletPhone
     */
    public Outlet(String outletId, String sellerId, String outletName, String outletPhone, String outletArea, String outletAddress, Double outletLongitude, Double outletLatitude) {
        super();
        this.outletId = outletId;
        this.sellerId = sellerId;
        this.outletName = outletName;
        this.outletPhone = outletPhone;
        this.outletArea = outletArea;
        this.outletAddress = outletAddress;
        this.outletLongitude = outletLongitude;
        this.outletLatitude = outletLatitude;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletPhone() {
        return outletPhone;
    }

    public void setOutletPhone(String outletPhone) {
        this.outletPhone = outletPhone;
    }

    public String getOutletArea() {
        return outletArea;
    }

    public void setOutletArea(String outletArea) {
        this.outletArea = outletArea;
    }

    public String getOutletAddress() {
        return outletAddress;
    }

    public void setOutletAddress(String outletAddress) {
        this.outletAddress = outletAddress;
    }

    public Double getOutletLongitude() {
        return outletLongitude;
    }

    public void setOutletLongitude(Double outletLongitude) {
        this.outletLongitude = outletLongitude;
    }

    public Double getOutletLatitude() {
        return outletLatitude;
    }

    public void setOutletLatitude(Double outletLatitude) {
        this.outletLatitude = outletLatitude;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Outlet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("outletId");
        sb.append('=');
        sb.append(((this.outletId == null) ? "<null>" : this.outletId));
        sb.append(',');
        sb.append("sellerId");
        sb.append('=');
        sb.append(((this.sellerId == null) ? "<null>" : this.sellerId));
        sb.append(',');
        sb.append("outletName");
        sb.append('=');
        sb.append(((this.outletName == null) ? "<null>" : this.outletName));
        sb.append(',');
        sb.append("outletPhone");
        sb.append('=');
        sb.append(((this.outletPhone == null) ? "<null>" : this.outletPhone));
        sb.append(',');
        sb.append("outletArea");
        sb.append('=');
        sb.append(((this.outletArea == null) ? "<null>" : this.outletArea));
        sb.append(',');
        sb.append("outletAddress");
        sb.append('=');
        sb.append(((this.outletAddress == null) ? "<null>" : this.outletAddress));
        sb.append(',');
        sb.append("outletLongitude");
        sb.append('=');
        sb.append(((this.outletLongitude == null) ? "<null>" : this.outletLongitude));
        sb.append(',');
        sb.append("outletLatitude");
        sb.append('=');
        sb.append(((this.outletLatitude == null) ? "<null>" : this.outletLatitude));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}