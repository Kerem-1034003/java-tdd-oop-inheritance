package com.booleanuk.core;

public class Author {
    private String name;
    private String contactInfo;
    private String website;

    public Author(String name, String contactInfo, String website){
        this.name = name;
        this.contactInfo = contactInfo;
        this.website = website;
    }

    public String getName(){
        return this.name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getWebsite() {
        return website;
    }
}
