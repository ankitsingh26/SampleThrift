package com.oyo.acp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Theatre")
public class Theatre {

    @Id
    private String id;
    private String name;
    private String city;

    public Theatre(){
    }

    public Theatre(String name,String city){
        super();
        //this.setId(id);
        this.setName(name);
        this.setCity(city);
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

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
