package org.example.Location;

import javassist.compiler.ast.StringL;
import org.example.dto.LocationBr;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LocationMap {
    public  static LocationBr getloc(double lat, double lon) {
        LocationBr locationBr = new LocationBr();
        locationBr.setLat(lat);
        locationBr.setLon(lon);
        return locationBr;
    }

    public static Map<String, LocationBr> locationMap() {
        Map<String, LocationBr> locationBrH = new HashMap<>();
        LocationBr risovy = getloc(41.274899, 69.309423);
        LocationBr parus = getloc(41.293496, 69.212972);
        LocationBr magic = getloc(41.304277, 69.244847);
        LocationBr samarqand = getloc(41.31683, 69.231262);
        LocationBr parkent = getloc(41.314775, 69.325162);
        LocationBr universam = getloc(41.363468, 69.288586);
        LocationBr royson = getloc(41.322643, 69.241973);
        LocationBr next = getloc(41.297983, 69.249571);
        LocationBr muqumiy = getloc(41.287939, 69.229206);
        LocationBr grant = getloc(41.295095, 69.26797);
        LocationBr sergeli = getloc(41.226369, 69.219899);
        LocationBr minor = getloc(41.326548, 69.292786);


        locationBrH.put("MAX WAY RISOVIY", risovy);
        locationBrH.put("MAX WAY PARUS", parus);
        locationBrH.put("MAX WAY MAGIC CITY", magic);
        locationBrH.put("MAX WAY SAMARQAND DARVOZA", samarqand);
        locationBrH.put("MAX WAY PARKENT", parkent);
        locationBrH.put("MAX WAY UNIVERSAM", universam);
        locationBrH.put("MAX WAY ROYSON", royson);
        locationBrH.put("MAX WAY NEXT", next);
        locationBrH.put("MAX WAY MUQUMIY", muqumiy);
        locationBrH.put("MAX WAY GRAND MIR", grant);
        locationBrH.put("MAX WAY SERGELI", sergeli);
        locationBrH.put("MAX WAY MINOR", minor);
        return locationBrH;
    }
    public static List<String> getbranches(){
        List<String> branch=new LinkedList<>();
        branch.add("MAX WAY RISOVIY");
        branch.add("MAX WAY PARUS");
        branch.add("MAX WAY MAGIC CITY");
        branch.add("MAX WAY SAMARQAND DARVOZA");
        branch.add("MAX WAY PARKENT");
        branch.add("MAX WAY UNIVERSAM");
        branch.add("MAX WAY ROYSON");
        branch.add("MAX WAY NEXT");
        branch.add("MAX WAY MUQUMIY");
        branch.add("MAX WAY GRAND MIR");
        branch.add("MAX WAY SERGELI");
        branch.add("MAX WAY MINOR");
        return branch;
    }

    public static String getNear(double lat, double lon) {
        double distans=0d;
        List<String>  branch=getbranches();
        Map<String,Double>  result=new HashMap<>();
        Map<String, LocationBr> locationBr = locationMap();
       for (String br:branch){
          LocationBr location= locationBr.get(br);
          double latB=location.getLat();
          double lonB=location.getLon();
           double dist = org.apache.lucene.util.SloppyMath.haversinMeters(lat, lon, latB, lonB);
           result.put(br,dist);
       }
        int i=1;
       for ( String r:branch){

           if (i==1){
               distans=result.get(r);
               i++;
           }

           if (result.get(r)<distans){
               distans=result.get(r);
           }
       }
       ;
        for ( String r:branch){
            if (result.get(r)==distans){
               return r;
            }
        }

            return null;
    }
    public static  LocationBr locationMap(String name) {
       Map<String,LocationBr> result=locationMap();
       LocationBr l=result.get(name);
        return l;
    }


 /* public LocationBr getResult(String name){

  }*/

}
