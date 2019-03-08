package com.detroitlabs.chucknorris.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GifData {

    private String embed_url;

    public String getEmbed_url() {
        return embed_url;
    }

    public void setEmbed_url(String embed_url) {
        this.embed_url = embed_url;
    }
}
