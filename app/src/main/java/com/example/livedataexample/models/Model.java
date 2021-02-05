package com.example.livedataexample.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Model {
/*
    @SerializedName("geonames")
    private List<Source> gopi;

    public List<Source> getGopi() {
        return gopi;
    }

    public  class Source{

        @SerializedName("summary")
        private  String summary;
        @SerializedName("elevation")
        private String elevation;
        @SerializedName("countryCode")
        private String countryCode;

        public String getSummary() {
            return summary;
        }

        public String getElevation() {
            return elevation;
        }

        public String getCountryCode() {
            return countryCode;
        }

    }

 */

    @SerializedName("status")
   private String status;
    @SerializedName("sources")
    private List<Sourcedata>  gopi;

    public String getStatus() {
        return status;
    }

    public List<Sourcedata> getGopi() {
        return gopi;
    }

    public class Sourcedata{
        @SerializedName("name")
        private String name;
        @SerializedName("description")
        private  String description;
        @SerializedName("category")
        private String category;
        @SerializedName("language")
        private String language;


        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }


        public String getCategory() {
            return category;
        }

        public String getLanguage() {
            return language;
        }
    }

}
