package videos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {
    private List<Channel> channels = new ArrayList<>();

    public void readDataFromFile(Path path) {
        try {
            List<String> input = Files.readAllLines(path);
            for (int i = 1; i < input.size(); i++) {
                String[] data = input.get(i).split(";");

                String name = data[0];
                int subs = Integer.parseInt(data[1]);
                int videos = Integer.parseInt(data[2]);

                channels.add(new Channel(name, subs, videos));
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot open file for read!", ioe);
        }
    }

    public int calculateSumOfVideos() {
        return channels.stream()
                .mapToInt(Channel::getCountOfVideos)
                .sum();
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
