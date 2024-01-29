package com.myfablo.cms.module_digikyc.pan.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PanItems {

    @SerializedName("saveData")
    @Expose
    private SavePanData savePanData;

    /**
     * No args constructor for use in serialization
     */
    public PanItems() {
    }

    /**
     * @param savePanData
     */
    public PanItems(SavePanData savePanData) {
        super();
        this.savePanData = savePanData;
    }

    public SavePanData getSaveData() {
        return savePanData;
    }

    public void setSaveData(SavePanData savePanData) {
        this.savePanData = savePanData;
    }

}