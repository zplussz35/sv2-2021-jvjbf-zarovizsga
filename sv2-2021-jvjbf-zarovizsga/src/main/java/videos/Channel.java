package videos;

public class Channel {
    private String channelName;
    private int countOfSubs;
    private int countOfVideos;

    public Channel(String channelName, int countOfSubs, int countOfVideos) {
        this.channelName = channelName;
        this.countOfSubs = countOfSubs;
        this.countOfVideos = countOfVideos;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getCountOfSubs() {
        return countOfSubs;
    }

    public int getCountOfVideos() {
        return countOfVideos;
    }
}
