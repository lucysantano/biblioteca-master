package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by eleones on 9/23/15.
 */
public class OurBufferedReader {

    private BufferedReader bufferedReader;

    public OurBufferedReader(Reader in) {
        this.bufferedReader = new BufferedReader(in);
    }

    public String readLine() {
        try {
            String line = bufferedReader.readLine();
            return line;
        } catch (IOException runtimeIOException) {
            throw new RuntimeIOException();
        }

    }
}
