package org.example.Location;

public class Address{
    private String country;
    private String countryCode;
    private String road;
    private String city;
    private String amenity;
    private String neighbourhood;
    private String iSO31662Lvl4;
    private String county;
    private String postcode;

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public void setRoad(String road){
        this.road = road;
    }

    public String getRoad(){
        return road;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setAmenity(String amenity){
        this.amenity = amenity;
    }

    public String getAmenity(){
        return amenity;
    }

    public void setNeighbourhood(String neighbourhood){
        this.neighbourhood = neighbourhood;
    }

    public String getNeighbourhood(){
        return neighbourhood;
    }

    public void setISO31662Lvl4(String iSO31662Lvl4){
        this.iSO31662Lvl4 = iSO31662Lvl4;
    }

    public String getISO31662Lvl4(){
        return iSO31662Lvl4;
    }

    public void setCounty(String county){
        this.county = county;
    }

    public String getCounty(){
        return county;
    }

    public void setPostcode(String postcode){
        this.postcode = postcode;
    }

    public String getPostcode(){
        return postcode;
    }

    @Override
    public String toString(){
        return
                "Address{" +
                        "country = '" + country + '\'' +
                        ",country_code = '" + countryCode + '\'' +
                        ",road = '" + road + '\'' +
                        ",city = '" + city + '\'' +
                        ",amenity = '" + amenity + '\'' +
                        ",neighbourhood = '" + neighbourhood + '\'' +
                        ",iSO3166-2-lvl4 = '" + iSO31662Lvl4 + '\'' +
                        ",county = '" + county + '\'' +
                        ",postcode = '" + postcode + '\'' +
                        "}";
    }
}
