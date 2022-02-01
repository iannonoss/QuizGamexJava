package it.unimol.quiztime.entities;

import java.io.Serializable;

public class Player implements Serializable{
    private String alias;
    private int point;
    private static final long serialVersionUID =1L;

    public int compareTo(Player u1)
    {
        return alias.compareTo(u1.alias);
    }
    public Player(String alias, int point){
        this.alias = alias;
        this.point = point;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

}
