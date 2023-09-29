package io.recepkara.project.library.menu.generic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {
    private static BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
    public  static  String readerConsole(){

        try {
            return  bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error when reading from System.in",e);
        }
    }

}
