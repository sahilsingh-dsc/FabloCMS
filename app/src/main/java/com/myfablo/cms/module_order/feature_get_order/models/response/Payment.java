package com.myfablo.cms.module_order.feature_get_order.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payment {

    @SerializedName("paymentMode")
    @Expose
    private String paymentMode;
    @SerializedName("paymentStatus")
    @Expose
    private String paymentStatus;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("_id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     */
    public Payment() {
    }

    /**
     * @param method
     * @param paymentMode
     * @param id
     * @param paymentStatus
     */
    public Payment(String paymentMode, String paymentStatus, String method, String id) {
        super();
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.method = method;
        this.id = id;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Payment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("paymentMode");
        sb.append('=');
        sb.append(((this.paymentMode == null) ? "<null>" : this.paymentMode));
        sb.append(',');
        sb.append("paymentStatus");
        sb.append('=');
        sb.append(((this.paymentStatus == null) ? "<null>" : this.paymentStatus));
        sb.append(',');
        sb.append("method");
        sb.append('=');
        sb.append(((this.method == null) ? "<null>" : this.method));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}