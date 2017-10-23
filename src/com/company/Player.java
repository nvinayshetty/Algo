package com.company;

import java.util.Comparator;

class Player implements Comparator {
    String name;
    int score;

    @Override
    public int compare(Object o1, Object o2) {
        Player a = (Player) o1;
        Player b = (Player) o2;
        if (a.score == b.score)
            return a.name.compareTo(b.name);
        else if (a.score > b.score) return 1;
        else return -1;
    }
}
