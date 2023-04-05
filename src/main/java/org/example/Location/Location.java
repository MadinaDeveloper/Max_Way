package org.example.Location;

import org.example.Location.Address;


import java.util.List;
public class Location{
    private String osmType;
    private long osmId;
    private String licence;
    private List<String> boundingbox;
    private Address address;
    private String lon;
    private String displayName;
    private int placeId;
    private String lat;

    public void setOsmType(String osmType){
        this.osmType = osmType;
    }

    public String getOsmType(){
        return osmType;
    }

    public void setOsmId(long osmId){
        this.osmId = osmId;
    }

    public long getOsmId(){
        return osmId;
    }

    public void setLicence(String licence){
        this.licence = licence;
    }

    public String getLicence(){
        return licence;
    }

    public void setBoundingbox(List<String> boundingbox){
        this.boundingbox = boundingbox;
    }

    public List<String> getBoundingbox(){
        return boundingbox;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public Address getAddress(){
        return address;
    }

    public void setLon(String lon){
        this.lon = lon;
    }

    public String getLon(){
        return lon;
    }

    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public void setPlaceId(int placeId){
        this.placeId = placeId;
    }

    public int getPlaceId(){
        return placeId;
    }

    public void setLat(String lat){
        this.lat = lat;
    }

    public String getLat(){
        return lat;
    }

    @Override
    public String toString(){
        return
                "Location{" +
                        "osm_type = '" + osmType + '\'' +
                        ",osm_id = '" + osmId + '\'' +
                        ",licence = '" + licence + '\'' +
                        ",boundingbox = '" + boundingbox + '\'' +
                        ",address = '" + address + '\'' +
                        ",lon = '" + lon + '\'' +
                        ",display_name = '" + displayName + '\'' +
                        ",place_id = '" + placeId + '\'' +
                        ",lat = '" + lat + '\'' +
                        "}";
    }
}