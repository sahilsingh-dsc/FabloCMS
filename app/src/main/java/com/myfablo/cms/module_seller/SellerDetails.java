package com.myfablo.cms.module_seller;

public class SellerDetails {

    private String sellerId;
    private String ticketId;
    private String sellerName;
    private String sellerEmail;
    private String sellerPhone;
    private String sellerWhatsapp;

    public SellerDetails() {
    }

    public SellerDetails(String sellerId, String ticketId, String sellerName, String sellerEmail, String sellerPhone, String sellerWhatsapp) {
        this.sellerId = sellerId;
        this.ticketId = ticketId;
        this.sellerName = sellerName;
        this.sellerEmail = sellerEmail;
        this.sellerPhone = sellerPhone;
        this.sellerWhatsapp = sellerWhatsapp;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(String sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public String getSellerWhatsapp() {
        return sellerWhatsapp;
    }

    public void setSellerWhatsapp(String sellerWhatsapp) {
        this.sellerWhatsapp = sellerWhatsapp;
    }
}
