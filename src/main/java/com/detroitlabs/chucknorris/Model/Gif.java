package com.detroitlabs.chucknorris.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Gif{

    private GifData gifData;

    @JsonProperty("data")
    public GifData getGifData() {
        return gifData;
    }

    @JsonProperty("data")
    public void setGifData(GifData gifData) {
        this.gifData = gifData;
    }
}
