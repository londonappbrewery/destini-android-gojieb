package com.londonappbrewery.destini;

public class StoryPath {

    private int pathID;
    private int pathA;
    private int pathB;


    public StoryPath(int pathID, int pathA, int pathB) {
        this.pathID = pathID;
        this.pathA = pathA;
        this.pathB = pathB;
    }

    public int getPathID() {
        return pathID;
    }
    public int getPathA() {
        return pathA;
    }
    public int getPathB() {
        return pathB;
    }
}