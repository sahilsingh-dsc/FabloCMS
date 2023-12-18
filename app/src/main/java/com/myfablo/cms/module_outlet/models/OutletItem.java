package com.myfablo.cms.module_outlet.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OutletItem {

    @SerializedName("outletId")
    @Expose
    private String outletId;
    @SerializedName("outletName")
    @Expose
    private String outletName;
    @SerializedName("outletImage")
    @Expose
    private List<String> outletImage;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("sellerId")
    @Expose
    private String sellerId;
    @SerializedName("isClosed")
    @Expose
    private Boolean isClosed;

    /**
     * No args constructor for use in serialization
     */
    public OutletItem() {
    }

    public OutletItem(String outletId, String outletName, List<String> outletImage, String type, String area, String sellerId, Boolean isClosed) {
        this.outletId = outletId;
        this.outletName = outletName;
        this.outletImage = outletImage;
        this.type = type;
        this.area = area;
        this.sellerId = sellerId;
        this.isClosed = isClosed;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public List<String> getOutletImage() {
        return outletImage;
    }

    public void setOutletImage(List<String> outletImage) {
        this.outletImage = outletImage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public Boolean getClosed() {
        return isClosed;
    }

    public void setClosed(Boolean closed) {
        isClosed = closed;
    }
}