package file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class LineByLineFileReader {
    private final String fileName;

    public LineByLineFileReader(String fileName) {
        this.fileName = fileName;
    }

    public String readFile() {
        try {
            URI uri = requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI();
            Path Path = Paths.get(uri);
            return Files.lines(Path).collect(Collectors.joining("\n"));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}