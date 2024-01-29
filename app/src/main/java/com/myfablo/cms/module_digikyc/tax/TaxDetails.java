package com.myfablo.cms.module_digikyc.tax;

import com.myfablo.cms.module_digikyc.gst.models.response.Address;
import com.myfablo.cms.module_digikyc.gst.models.response.SaveGstData;

public class TaxDetails {

    private String taxId;
    private String ticketId;
    private boolean gstStatus;
    private String gstNumber;
    private Integer gstCategory;
    private SaveGstData gstData;


    public TaxDetails() {
    }

    public TaxDetails(String taxId, String ticketId, boolean gstStatus, String gstNumber, Integer gstCategory, SaveGstData gstData) {
        this.taxId = taxId;
        this.ticketId = ticketId;
        this.gstStatus = gstStatus;
        this.gstNumber = gstNumber;
        this.gstCategory = gstCategory;
        this.gstData = gstData;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public boolean isGstStatus() {
        return gstStatus;
    }

    public void setGstStatus(boolean gstStatus) {
        this.gstStatus = gstStatus;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public Integer getGstCategory() {
        return gstCategory;
    }

    public void setGstCategory(Integer gstCategory) {
        this.gstCategory = gstCategory;
    }

    public SaveGstData getGstData() {
        return gstData;
    }

    public void setGstData(SaveGstData gstData) {
        this.gstData = gstData;
    }
}
