package com.ttopacademy.remotedatasources.entities;

/** VideoResponse entity class. */
public class VideoResponse {

    private final int videoID;
    private final int number;
    private final String title;
    private final String youtubeID;
    private final String size;
    private final String solutionVideoYoutubeID;
    private final String solutionVideoSize;

    /** Constructs a new instance. */
    public VideoResponse(int videoID, int number, String title, String youtubeID, String size,
                         String solutionVideoYoutubeID, String solutionVideoSize) {
        this.videoID = videoID;
        this.number = number;
        this.title = title;
        this.youtubeID = youtubeID;
        this.size = size;
        this.solutionVideoYoutubeID = solutionVideoYoutubeID;
        this.solutionVideoSize = solutionVideoSize;
    }

    /** Returns videoID. */
    public int getVideoID() {
        return videoID;
    }

    /** Returns video number. */
    public int getNumber() {
        return number;
    }

    /** Returns video title. */
    public String getTitle() {
        return title;
    }

    /** Returns video youtubeID. */
    public String getYoutubeID() {
        return youtubeID;
    }

    /** Returns video size in MB. */
    public String getSize() {
        return size;
    }

    /** Returns solution video youtubeID. */
    public String getSolutionVideoYoutubeID() {
        return solutionVideoYoutubeID;
    }

    /** Returns solution video size in MB. */
    public String getSolutionVideoSize() {
        return solutionVideoSize;
    }
}
