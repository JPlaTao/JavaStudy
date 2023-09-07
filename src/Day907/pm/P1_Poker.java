package Day907.pm;

import Day818_Sys_Methods.Vehicle.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Card implements Comparable {
    private int point;
    private String number;
    private String suit;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Card() {
    }

    public Card(int point, String number, String suit) {
        this.point = point;
        this.number = number;
        this.suit = suit;
    }

    @Override
    public int compareTo(Object o) {
        Card anotherCard = (Card) o;
        return this.point - anotherCard.point;
    }

    @Override
    public String toString() {
        return  suit + number + " ";
    }
}


class GameLobby {
    private ArrayList player1 = new ArrayList();
    private ArrayList player2= new ArrayList();
    private ArrayList player3 = new ArrayList();
    private ArrayList poker = new ArrayList();


    {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                poker.add(new Card(j, number[j], suits[i]));
            }
        }
        poker.add(new Card(13, "", "🤡"));
        poker.add(new Card(14, "", "🃏"));
        Collections.shuffle(poker);
    }


    public GameLobby() {
    }

    public GameLobby(ArrayList player1, ArrayList player2, ArrayList player3, ArrayList poker) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.poker = poker;
    }

    public void cardDeal(ArrayList player) {
        for (int i = 0; i < 17; i++) {
            player.add(poker.get(0));
            poker.remove(0);
        }
    }

    public void cardSort(ArrayList player){
        player.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Card c1 = (Card) o1;
                Card c2 = (Card) o2;
                return c1.getPoint() - c2.getPoint();
            }
        });
    }


    public ArrayList getPlayer1() {
        return player1;
    }

    public void setPlayer1(ArrayList player1) {
        this.player1 = player1;
    }

    public ArrayList getPlayer2() {
        return player2;
    }

    public void setPlayer2(ArrayList player2) {
        this.player2 = player2;
    }

    public ArrayList getPlayer3() {
        return player3;
    }

    public void setPlayer3(ArrayList player3) {
        this.player3 = player3;
    }

    public ArrayList getPoker() {
        return poker;
    }

    public void setPoker(ArrayList poker) {
        this.poker = poker;
    }


}

class TestOfPoker {
    public static void main(String[] args) {
        GameLobby gl = new GameLobby();

        System.out.println("发牌！");
        System.out.println("玩家1：");
        gl.cardDeal(gl.getPlayer1());
        gl.getPlayer1().forEach(o -> System.out.print(o + ""));
        System.out.println();

        System.out.println("玩家2：");
        gl.cardDeal(gl.getPlayer2());
        gl.getPlayer2().forEach(o -> System.out.print(o + ""));
        System.out.println();

        System.out.println("玩家3：");
        gl.cardDeal(gl.getPlayer3());
        gl.getPlayer3().forEach(o -> System.out.print(o + ""));
        System.out.println();
        System.out.println("底牌:");
        gl.getPoker().forEach(o -> System.out.print(o + " "));
        System.out.println();

        System.out.println("捋牌！");
        System.out.println("玩家1：");
        gl.cardSort(gl.getPlayer1());
        gl.getPlayer1().forEach(o -> System.out.print(o + ""));
        System.out.println();

        System.out.println("玩家2：");
        gl.cardSort(gl.getPlayer2());
        gl.getPlayer2().forEach(o -> System.out.print(o + ""));
        System.out.println();

        System.out.println("玩家3：");
        gl.cardSort(gl.getPlayer3());
        gl.getPlayer3().forEach(o -> System.out.print(o + ""));
        System.out.println();
    }
}