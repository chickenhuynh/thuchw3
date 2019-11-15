package com.example.thuchw3.APIClasses;

import com.google.gson.annotations.SerializedName;

public class Cat {
    String id;
    String name;

    String imageUrl;
    String description;
    Weight weight;
    String temp;
    String origin;
    @SerializedName("life_span")
    String lifeSpan;
    @SerializedName("dog_friendly")
    String dogfriendliness;
    @SerializedName("wikipedia_url")
    String wikipediaUrl;

    public boolean favourite;

    public Cat(String id, String name, String description, Weight weight, String temp, String origin, String lifeSpan, String dogfriendliness, String wikiUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.temp = temp;
        this.origin = origin;
        this.lifeSpan = lifeSpan;
        this.dogfriendliness = dogfriendliness;
        this.wikipediaUrl = wikipediaUrl;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getTemp() {
        return temp;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public String getDogfriendliness() {
        return dogfriendliness;
    }

    public String getWikipediaUrl() {
        return wikipediaUrl;
    }

    public Weight getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + '}';
    }

    public class Weight{
        String metric;

        public Weight(String metric) {
            this.metric = metric;
        }

        public String getMetric() {
            return metric;
        }
    }
}
