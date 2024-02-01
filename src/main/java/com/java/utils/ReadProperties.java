package com.java.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ReadProperties {




        public ReadProperties() {

        }

        private static Properties properties = new Properties();

        static {
            try {
                FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
                properties.load(fileInputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getValue(String key) throws Exception {


            String value = "";
            if (Objects.isNull(value) || Objects.isNull(key)) {
                throw new Exception("Property name" + key + "not found");
            }
            value = properties.getProperty(key);
            return value;

        }
    }
