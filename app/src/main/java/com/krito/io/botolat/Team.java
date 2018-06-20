package com.krito.io.botolat;

import java.util.List;

/**
 * Created by Goda on 20/06/2018.
 */

public class Team {
    private String teamName;
    private List<String> players;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }
}
