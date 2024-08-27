package proxy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

public class InputOutputImpl implements InputOutput {

    private final String fileName;

    public InputOutputImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void output(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(text);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String input() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
