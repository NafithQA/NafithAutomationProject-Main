package org.nafeth.helpers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataLoader {

    public String urlsData(String key) throws IOException {

        FileReader reader =
                new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testData" + File.separator + "links");
        Properties p = new Properties();
        p.load(reader);

        return p.getProperty(key);
    }

    public String configsData(String key) throws IOException {

        FileReader reader =
                new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testData" + File.separator + "runConfigs");
        Properties p = new Properties();
        p.load(reader);

        return p.getProperty(key);
    }

    public String credentialsData(String key) throws IOException {

        FileReader reader =
                new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testData" + File.separator + "credentials");
        Properties p = new Properties();
        p.load(reader);

        return p.getProperty(key);
    }

    public String testData(String key) throws IOException {

        FileReader reader =
                new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testData" + File.separator + "testData");
        Properties p = new Properties();
        p.load(reader);

        return p.getProperty(key);
    }

    public String dbQueriesData(String key) throws IOException {

        FileReader reader =
                new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testData" + File.separator + "dbQueries");
        Properties p = new Properties();
        p.load(reader);

        return p.getProperty(key);
    }

    public String dbConnection(String key) throws IOException {

        FileReader reader =
                new FileReader(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "testData" + File.separator + "dbConnection");
        Properties p = new Properties();
        p.load(reader);

        return p.getProperty(key);
    }
}
