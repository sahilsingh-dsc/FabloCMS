package com.myfablo.cms.module_digikyc.fssai.models;

import com.myfablo.cms.module_digikyc.fssai.models.response.FssaiItems;
import com.myfablo.cms.module_digikyc.fssai.models.response.SaveFssaiData;

public class FssaiDetails {

    private String licenceId;
    private String licenceNo;
    private String ticketId;
    private SaveFssaiData saveFssaiData;


    public FssaiDetails() {
    }

    public FssaiDetails(String licenceId, String licenceNo, String ticketId, SaveFssaiData saveFssaiData) {
        this.licenceId = licenceId;
        this.licenceNo = licenceNo;
        this.ticketId = ticketId;
        this.saveFssaiData = saveFssaiData;
    }

    public String getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public SaveFssaiData getSaveFssaiData() {
        return saveFssaiData;
    }

    public void setSaveFssaiData(SaveFssaiData saveFssaiData) {
        this.saveFssaiData = saveFssaiData;
    }
}
