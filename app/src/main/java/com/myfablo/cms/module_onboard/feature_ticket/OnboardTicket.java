package com.myfablo.cms.module_onboard.feature_ticket;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class OnboardTicket implements Parcelable {

    private String ticketId;
    private String employeeId;
    private String outletName;
    private String phone;
    private boolean sellerPan;
    private boolean sellerDetails;
    private boolean taxPolicy;
    private boolean outletFssai;
    private boolean outletMapping;
    private boolean outletMenu;
    private boolean sellerTraining;
    private boolean outletLive;
    private boolean onboardStatus;

    public OnboardTicket() {
    }

    public OnboardTicket(String ticketId, String employeeId, String outletName, String phone, boolean sellerPan, boolean sellerDetails, boolean taxPolicy, boolean outletFssai, boolean outletMapping, boolean outletMenu, boolean sellerTraining, boolean outletLive, boolean onboardStatus) {
        this.ticketId = ticketId;
        this.employeeId = employeeId;
        this.outletName = outletName;
        this.phone = phone;
        this.sellerPan = sellerPan;
        this.sellerDetails = sellerDetails;
        this.taxPolicy = taxPolicy;
        this.outletFssai = outletFssai;
        this.outletMapping = outletMapping;
        this.outletMenu = outletMenu;
        this.sellerTraining = sellerTraining;
        this.outletLive = outletLive;
        this.onboardStatus = onboardStatus;
    }

    protected OnboardTicket(Parcel in) {
        ticketId = in.readString();
        employeeId = in.readString();
        outletName = in.readString();
        phone = in.readString();
        sellerPan = in.readByte() != 0;
        sellerDetails = in.readByte() != 0;
        taxPolicy = in.readByte() != 0;
        outletFssai = in.readByte() != 0;
        outletMapping = in.readByte() != 0;
        outletMenu = in.readByte() != 0;
        sellerTraining = in.readByte() != 0;
        outletLive = in.readByte() != 0;
        onboardStatus = in.readByte() != 0;
    }

    public static final Creator<OnboardTicket> CREATOR = new Creator<OnboardTicket>() {
        @Override
        public OnboardTicket createFromParcel(Parcel in) {
            return new OnboardTicket(in);
        }

        @Override
        public OnboardTicket[] newArray(int size) {
            return new OnboardTicket[size];
        }
    };

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public boolean isTaxPolicy() {
        return taxPolicy;
    }

    public void setTaxPolicy(boolean taxPolicy) {
        this.taxPolicy = taxPolicy;
    }

    public boolean isOutletFssai() {
        return outletFssai;
    }

    public void setOutletFssai(boolean outletFssai) {
        this.outletFssai = outletFssai;
    }

    public boolean isOutletMapping() {
        return outletMapping;
    }

    public void setOutletMapping(boolean outletMapping) {
        this.outletMapping = outletMapping;
    }

    public boolean isOutletMenu() {
        return outletMenu;
    }

    public void setOutletMenu(boolean outletMenu) {
        this.outletMenu = outletMenu;
    }

    public boolean isSellerTraining() {
        return sellerTraining;
    }

    public void setSellerTraining(boolean sellerTraining) {
        this.sellerTraining = sellerTraining;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(ticketId);
        dest.writeString(employeeId);
        dest.writeString(outletName);
        dest.writeString(phone);
        dest.writeByte((byte) (sellerPan ? 1 : 0));
        dest.writeByte((byte) (sellerDetails ? 1 : 0));
        dest.writeByte((byte) (taxPolicy ? 1 : 0));
        dest.writeByte((byte) (outletFssai ? 1 : 0));
        dest.writeByte((byte) (outletMapping ? 1 : 0));
        dest.writeByte((byte) (outletMenu ? 1 : 0));
        dest.writeByte((byte) (sellerTraining ? 1 : 0));
        dest.writeByte((byte) (outletLive ? 1 : 0));
        dest.writeByte((byte) (onboardStatus ? 1 : 0));
    }
}
