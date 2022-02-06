package it.unimol.quiztime.handler;

import it.unimol.quiztime.entities.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HandlerPlayer {

    private List<Player> playerList;


    public HandlerPlayer(){
        this.playerList = new ArrayList<>();
        this.caricaDaFilePlayer();
        this.rankingPlayers();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void aggiungiPlayer(Player player) throws IOException {
        assert player != null;

        this.playerList.add(player);
        try {
            this.saveOnFile();
        } catch (IOException exception) {
            this.playerList.remove(this.playerList.size() -1);
            throw exception;
        }
    }

    private void saveOnFile() throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("PlayerPoint.serr");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this.playerList);
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        }
    }

    private void caricaDaFilePlayer() {
        File file = new File("PlayerPoint.serr");
        if (file.exists()) {
            List<Player> players = null;
            FileInputStream fileInputStream = null;
            ObjectInputStream objectInputStream = null;

            try {
                fileInputStream = new FileInputStream("PlayerPoint.serr");
                objectInputStream = new ObjectInputStream(fileInputStream);

                players = (List<Player>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException ignore) {
            } finally {
                try {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (IOException ignore) {
                }
            }
            if (players != null) {
                this.playerList = new ArrayList<>(players);
            }
        }
    }

    /*public void printPlayer(){
        for(Player player : playerList){
            System.out.println(player.getAlias()+" ->"+player.getPoint());
        }
    }*/


    public List<Player> rankingPlayers(){
        List<Player> bestPlayers = new ArrayList<>();
        Collections.sort(playerList,
                Comparator.comparingInt(
                        Player::getPoint));
        Collections.reverse(playerList);
        for(Player player : playerList){
           System.out.println(player.getAlias()+" ->"+player.getPoint());
            bestPlayers.add(player);
        }
        return bestPlayers;
    }

    public Player firstPlayer(){
        Player first;
        Collections.sort(playerList,
                Comparator.comparingInt(
                        Player::getPoint));
        Collections.reverse(playerList);
        first = playerList.get(0);
        return first;
    }

    public Player secondPlayer(){
        Player second;
        Collections.sort(playerList,
                Comparator.comparingInt(
                        Player::getPoint));
        Collections.reverse(playerList);
        second = playerList.get(1);
        return second;
    }

    public Player thirdPlayer(){
        Player third;
        Collections.sort(playerList,
                Comparator.comparingInt(
                        Player::getPoint));
        Collections.reverse(playerList);
        third = playerList.get(2);
        return third;
    }

    public void checkListIsNotEmpty() throws EmptyListException {
        if (this.playerList.size() == 0)
            throw new EmptyListException("Non è presente alcuna cplayer nella lista.");
    }


}