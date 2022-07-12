package com.ttopacademy.remotedatasources.entities;

/** TopicResponse entity class. */
public class TopicResponse {

    private final int topicID;
    private final int number;
    private final String name;

    /** Constructs a new instance. */
    public TopicResponse(int topicID, int number, String name) {
        this.topicID = topicID;
        this.number = number;
        this.name = name;
    }

    /** Returns topicID. */
    public int getTopicID() {
        return topicID;
    }

    /** Returns topic number. */
    public int getNumber() {
        return number;
    }

    /** Returns topic name. */
    public String getName() {
        return name;
    }

}
