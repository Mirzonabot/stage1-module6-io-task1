package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        FileInputStream fileInputStream = null;

        try (InputStream inputStream = new FileInputStream(file)) {
            int i;
            while ((i = inputStream.read()) != -1) {
                stringBuilder.append((char) i);
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

}
