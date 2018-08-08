package com.lovemanager.app.models.basic;

public class ActiveItem {

    private String VehicleUrl;
    private String OutfitUrl;
    private String AccessorieUrl;

    public ActiveItem(){

    }

    public ActiveItem(String vehicleUrl, String outfitUrl, String accessorieUrl) {
        VehicleUrl = vehicleUrl;
        OutfitUrl = outfitUrl;
        AccessorieUrl = accessorieUrl;
    }

    public String getVehicleUrl() {
        return VehicleUrl;
    }

    public void setVehicleUrl(String vehicleUrl) {
        VehicleUrl = vehicleUrl;
    }

    public String getOutfitUrl() {
        return OutfitUrl;
    }

    public void setOutfitUrl(String outfitUrl) {
        OutfitUrl = outfitUrl;
    }

    public String getAccessorieUrl() {
        return AccessorieUrl;
    }

    public void setAccessorieUrl(String accessorieUrl) {
        AccessorieUrl = accessorieUrl;
    }
}
