package com.myfablo.cms.module_digikyc.gst.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("building")
    @Expose
    private String building;
    @SerializedName("buildingName")
    @Expose
    private String buildingName;
    @SerializedName("floor")
    @Expose
    private String floor;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("district")
    @Expose
    private String district;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("zip")
    @Expose
    private String zip;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("nature")
    @Expose
    private String nature;

    /**
     * No args constructor for use in serialization
     */
    public Address() {
    }

    /**
     * @param zip
     * @param buildingName
     * @param nature
     * @param street
     * @param district
     * @param latitude
     * @param locality
     * @param state
     * @param type
     * @param floor
     * @param building
     * @param longitude
     */
    public Address(String type, String building, String buildingName, String floor, String street, String locality, String district, String state, String zip, String latitude, String longitude, String nature) {
        super();
        this.type = type;
        this.building = building;
        this.buildingName = buildingName;
        this.floor = floor;
        this.street = street;
        this.locality = locality;
        this.district = district;
        this.state = state;
        this.zip = zip;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nature = nature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

}