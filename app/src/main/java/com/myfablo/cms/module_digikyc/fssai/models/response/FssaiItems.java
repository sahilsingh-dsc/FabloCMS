package com.myfablo.cms.module_digikyc.fssai.models.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FssaiItems {

    @SerializedName("saveData")
    @Expose
    private SaveFssaiData saveFssaiData;

    /**
     * No args constructor for use in serialization
     */
    public FssaiItems() {
    }

    /**
     * @param saveFssaiData
     */
    public FssaiItems(SaveFssaiData saveFssaiData) {
        super();
        this.saveFssaiData = saveFssaiData;
    }

    public SaveFssaiData getSaveData() {
        return saveFssaiData;
    }

    public void setSaveData(SaveFssaiData saveFssaiData) {
        this.saveFssaiData = saveFssaiData;
    }

}