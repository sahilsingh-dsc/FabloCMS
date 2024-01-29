package com.myfablo.cms.module_digikyc.gst.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GstItems {

    @SerializedName("saveData")
    @Expose
    private SaveGstData saveGstData;

    /**
     * No args constructor for use in serialization
     */
    public GstItems() {
    }

    /**
     * @param saveGstData
     */
    public GstItems(SaveGstData saveGstData) {
        super();
        this.saveGstData = saveGstData;
    }

    public SaveGstData getSaveData() {
        return saveGstData;
    }

    public void setSaveData(SaveGstData saveGstData) {
        this.saveGstData = saveGstData;
    }

}