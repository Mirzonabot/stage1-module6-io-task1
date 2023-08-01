package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        FileInputStream fileInputStream = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {

            fileInputStream = new FileInputStream(file);
            while (fileInputStream.available() > 0) {
                stringBuilder.append((char) fileInputStream.read());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        String[] data = stringBuilder.toString().split("\n");

        Profile profile = new Profile();
        profile.setName(data[0].split(" ")[1].trim());
        profile.setAge(Integer.parseInt(data[1].split(" ")[1].trim()));
        profile.setEmail(data[2].split(" ")[1].trim());
        profile.setPhone(Long.parseLong(data[3].split(" ")[1].trim()));

        return profile;
    }

//    public static void main(String[] args) {
//        FileReader fileReader = new FileReader();
//        Profile profile = fileReader.getDataFromFile(new File("src/main/resources/Profile.txt"));
//        System.out.println(profile);
//    }
}
