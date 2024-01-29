package com.myfablo.cms.module_onboard.models.seller;

public class SellerPan {

    private String pan;
    private String panName;
    private String panCategory;
    private boolean panAadhaarLink;
    private boolean panStatus;

    public SellerPan() {
    }

    public SellerPan(String pan, String panName, String panCategory, boolean panAadhaarLink, boolean panStatus) {
        this.pan = pan;
        this.panName = panName;
        this.panCategory = panCategory;
        this.panAadhaarLink = panAadhaarLink;
        this.panStatus = panStatus;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getPanName() {
        return panName;
    }

    public void setPanName(String panName) {
        this.panName = panName;
    }

    public String getPanCategory() {
        return panCategory;
    }

    public void setPanCategory(String panCategory) {
        this.panCategory = panCategory;
    }

    public boolean isPanAadhaarLink() {
        return panAadhaarLink;
    }

    public void setPanAadhaarLink(boolean panAadhaarLink) {
        this.panAadhaarLink = panAadhaarLink;
    }

    public boolean isPanStatus() {
        return panStatus;
    }

    public void setPanStatus(boolean panStatus) {
        this.panStatus = panStatus;
    }
}
