package com.myfablo.cms.module_order.feature_get_order.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Partner {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("partnerId")
    @Expose
    private String partnerId;
    @SerializedName("partnerName")
    @Expose
    private String partnerName;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("taskId")
    @Expose
    private String taskId;

    /**
     * No args constructor for use in serialization
     */
    public Partner() {
    }

    /**
     * @param image
     * @param partnerName
     * @param phone
     * @param id
     * @param partnerId
     * @param taskId
     */
    public Partner(String id, String image, String partnerId, String partnerName, String phone, String taskId) {
        super();
        this.id = id;
        this.image = image;
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.phone = phone;
        this.taskId = taskId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Partner.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("image");
        sb.append('=');
        sb.append(((this.image == null) ? "<null>" : this.image));
        sb.append(',');
        sb.append("partnerId");
        sb.append('=');
        sb.append(((this.partnerId == null) ? "<null>" : this.partnerId));
        sb.append(',');
        sb.append("partnerName");
        sb.append('=');
        sb.append(((this.partnerName == null) ? "<null>" : this.partnerName));
        sb.append(',');
        sb.append("phone");
        sb.append('=');
        sb.append(((this.phone == null) ? "<null>" : this.phone));
        sb.append(',');
        sb.append("taskId");
        sb.append('=');
        sb.append(((this.taskId == null) ? "<null>" : this.taskId));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}