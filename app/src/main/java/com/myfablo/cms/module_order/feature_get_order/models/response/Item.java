package com.myfablo.cms.module_order.feature_get_order.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {

    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("mpOrderId")
    @Expose
    private String mpOrderId;
    @SerializedName("productList")
    @Expose
    private List<Product> productList;
    @SerializedName("client")
    @Expose
    private Client client;
    @SerializedName("outlet")
    @Expose
    private Outlet outlet;
    @SerializedName("partner")
    @Expose
    private Partner partner;
    @SerializedName("payableAmount")
    @Expose
    private Double payableAmount;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("amount")
    @Expose
    private Amount amount;
    @SerializedName("timing")
    @Expose
    private List<Timing> timing;
    @SerializedName("ratingStatus")
    @Expose
    private String ratingStatus;
    @SerializedName("payment")
    @Expose
    private Payment payment;
    @SerializedName("date")
    @Expose
    private String date;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    /**
     * @param date
     * @param amount
     * @param distance
     * @param orderId
     * @param timing
     * @param mpOrderId
     * @param payableAmount
     * @param partner
     * @param client
     * @param payment
     * @param outlet
     * @param ratingStatus
     * @param productList
     * @param status
     */
    public Item(String orderId, String mpOrderId, List<Product> productList, Client client, Outlet outlet, Partner partner, Double payableAmount, String distance, String status, Amount amount, List<Timing> timing, String ratingStatus, Payment payment, String date) {
        super();
        this.orderId = orderId;
        this.mpOrderId = mpOrderId;
        this.productList = productList;
        this.client = client;
        this.outlet = outlet;
        this.partner = partner;
        this.payableAmount = payableAmount;
        this.distance = distance;
        this.status = status;
        this.amount = amount;
        this.timing = timing;
        this.ratingStatus = ratingStatus;
        this.payment = payment;
        this.date = date;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMpOrderId() {
        return mpOrderId;
    }

    public void setMpOrderId(String mpOrderId) {
        this.mpOrderId = mpOrderId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Outlet getOutlet() {
        return outlet;
    }

    public void setOutlet(Outlet outlet) {
        this.outlet = outlet;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public List<Timing> getTiming() {
        return timing;
    }

    public void setTiming(List<Timing> timing) {
        this.timing = timing;
    }

    public String getRatingStatus() {
        return ratingStatus;
    }

    public void setRatingStatus(String ratingStatus) {
        this.ratingStatus = ratingStatus;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Item.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("orderId");
        sb.append('=');
        sb.append(((this.orderId == null) ? "<null>" : this.orderId));
        sb.append(',');
        sb.append("mpOrderId");
        sb.append('=');
        sb.append(((this.mpOrderId == null) ? "<null>" : this.mpOrderId));
        sb.append(',');
        sb.append("productList");
        sb.append('=');
        sb.append(((this.productList == null) ? "<null>" : this.productList));
        sb.append(',');
        sb.append("client");
        sb.append('=');
        sb.append(((this.client == null) ? "<null>" : this.client));
        sb.append(',');
        sb.append("outlet");
        sb.append('=');
        sb.append(((this.outlet == null) ? "<null>" : this.outlet));
        sb.append(',');
        sb.append("partner");
        sb.append('=');
        sb.append(((this.partner == null) ? "<null>" : this.partner));
        sb.append(',');
        sb.append("payableAmount");
        sb.append('=');
        sb.append(((this.payableAmount == null) ? "<null>" : this.payableAmount));
        sb.append(',');
        sb.append("distance");
        sb.append('=');
        sb.append(((this.distance == null) ? "<null>" : this.distance));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null) ? "<null>" : this.status));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null) ? "<null>" : this.amount));
        sb.append(',');
        sb.append("timing");
        sb.append('=');
        sb.append(((this.timing == null) ? "<null>" : this.timing));
        sb.append(',');
        sb.append("ratingStatus");
        sb.append('=');
        sb.append(((this.ratingStatus == null) ? "<null>" : this.ratingStatus));
        sb.append(',');
        sb.append("payment");
        sb.append('=');
        sb.append(((this.payment == null) ? "<null>" : this.payment));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null) ? "<null>" : this.date));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}