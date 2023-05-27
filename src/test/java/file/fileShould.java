package file;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class fileShould {
    @Test
    void resd_a_file_line_by_line() {
        LineByLineFileReader reader = new LineByLineFileReader("test.txt");

        String Content = reader.readFile();

        Assertions.assertThat(Content).isEqualTo("line 1\nline 2\nline 3\nline 4\nline 5");
    }
}
