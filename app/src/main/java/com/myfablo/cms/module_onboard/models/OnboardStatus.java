package com.myfablo.cms.module_onboard.models;

public class OnboardStatus {

    private boolean sellerKyc;
    private boolean sellerPan;
    private boolean sellerDetails;
    private boolean outletMapping;
    private boolean outletFssai;
    private boolean outletGst;
    private boolean outletDetails;
    private boolean outletMenu;
    private boolean outletTraining;
    private boolean outletLive;
    private boolean onboardStatus;

    public OnboardStatus() {
    }

    public OnboardStatus(boolean sellerKyc, boolean sellerPan, boolean sellerDetails, boolean outletMapping, boolean outletFssai, boolean outletGst, boolean outletDetails, boolean outletMenu, boolean outletTraining, boolean outletLive, boolean onboardStatus) {
        this.sellerKyc = sellerKyc;
        this.sellerPan = sellerPan;
        this.sellerDetails = sellerDetails;
        this.outletMapping = outletMapping;
        this.outletFssai = outletFssai;
        this.outletGst = outletGst;
        this.outletDetails = outletDetails;
        this.outletMenu = outletMenu;
        this.outletTraining = outletTraining;
        this.outletLive = outletLive;
        this.onboardStatus = onboardStatus;
    }

    public boolean isSellerKyc() {
        return sellerKyc;
    }

    public void setSellerKyc(boolean sellerKyc) {
        this.sellerKyc = sellerKyc;
    }

    public boolean isSellerPan() {
        return sellerPan;
    }

    public void setSellerPan(boolean sellerPan) {
        this.sellerPan = sellerPan;
    }

    public boolean isSellerDetails() {
        return sellerDetails;
    }

    public void setSellerDetails(boolean sellerDetails) {
        this.sellerDetails = sellerDetails;
    }

    public boolean isOutletMapping() {
        return outletMapping;
    }

    public void setOutletMapping(boolean outletMapping) {
        this.outletMapping = outletMapping;
    }

    public boolean isOutletFssai() {
        return outletFssai;
    }

    public void setOutletFssai(boolean outletFssai) {
        this.outletFssai = outletFssai;
    }

    public boolean isOutletGst() {
        return outletGst;
    }

    public void setOutletGst(boolean outletGst) {
        this.outletGst = outletGst;
    }

    public boolean isOutletDetails() {
        return outletDetails;
    }

    public void setOutletDetails(boolean outletDetails) {
        this.outletDetails = outletDetails;
    }

    public boolean isOutletMenu() {
        return outletMenu;
    }

    public void setOutletMenu(boolean outletMenu) {
        this.outletMenu = outletMenu;
    }

    public boolean isOutletTraining() {
        return outletTraining;
    }

    public void setOutletTraining(boolean outletTraining) {
        this.outletTraining = outletTraining;
    }

    public boolean isOutletLive() {
        return outletLive;
    }

    public void setOutletLive(boolean outletLive) {
        this.outletLive = outletLive;
    }

    public boolean isOnboardStatus() {
        return onboardStatus;
    }

    public void setOnboardStatus(boolean onboardStatus) {
        this.onboardStatus = onboardStatus;
    }
}
