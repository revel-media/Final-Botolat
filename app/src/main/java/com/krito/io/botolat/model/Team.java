package com.krito.io.botolat.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Goda on 20/06/2018.
 */

public class Team implements Serializable {
    private String teamName;
    private String[] players;
    private String teamImage;

    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String[] getPlayers() {
        return players;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }

    public String getTeamImage() {
        return teamImage;
    }

    public void setTeamImage(String teamImage) {
        this.teamImage = teamImage;
    }
}
