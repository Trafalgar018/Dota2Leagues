package com.example.trafalgar.dota2league.model;

        import java.io.Serializable;

/**
 * Created by trafalgar on 14/12/17.
 */

public class League implements Serializable {
    private String id;
    private String ticket;
    private String banner;
    private String tier;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.id = ticket;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.id = banner;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.id = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.id = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
