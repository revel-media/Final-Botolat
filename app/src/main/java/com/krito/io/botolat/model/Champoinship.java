package com.krito.io.botolat.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Goda on 30/06/2018.
 */

public class Champoinship {
    private List<String> name=new ArrayList<>();
    private List<String> player0=new ArrayList<>();
    private List<String> player1=new ArrayList<>();
    private List<String> player2=new ArrayList<>();
    private List<String> teamImage =new ArrayList<>();


    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<String> getPlayer0() {
        return player0;
    }

    public void setPlayer0(List<String> player0) {
        this.player0 = player0;
    }

    public List<String> getPlayer1() {
        return player1;
    }

    public void setPlayer1(List<String> player1) {
        this.player1 = player1;
    }

    public List<String> getPlayer2() {
        return player2;
    }

    public void setPlayer2(List<String> player2) {
        this.player2 = player2;
    }

    public List<String> getTeamImage() {
        return teamImage;
    }

    public void setTeamImage(List<String> teamImage) {
        this.teamImage = teamImage;
    }
}
