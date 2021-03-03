package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Ship {

    private ArrayList<Integer> location;
    private ArrayList<String> hits;

    public Ship() {
        this.location = new ArrayList<>(Arrays.asList(0, 0, 0));
        this.hits = new ArrayList<>(Arrays.asList("", "", ""));
    }

    public ArrayList<Integer> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<Integer> location) {
        this.location = location;
    }

    public ArrayList<String> getHits() {
        return hits;
    }

    public void setHits(ArrayList<String> hits) {
        this.hits = hits;
    }
}
