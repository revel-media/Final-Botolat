package com.krito.io.botolat.model;

import java.security.KeyStore;

/**
 * Created by Goda on 23/06/2018.
 */

public class ChampTeam  {
    private int pos;
    private int deff;
    private int wins;
    private int lose;
    private int play;
    private int points;
    private int draw;
    private String teamName;

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getDeff() {
        return deff;
    }

    public void setDeff(int deff) {
        this.deff = deff;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
