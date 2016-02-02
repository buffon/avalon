/*
 * Copyright (C) lizhuyang, Inc. All Rights Reserved.
 */
package avalon;

/*
 * Java Mysql Proxy
 * Main binary. Just listen for connections and pass them over
 * to the proxy module
 */

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;
import java.io.FileInputStream;

public class Avalon {
    public static Properties config = new Properties();

    public static void main(String[] args) throws IOException {
        FileInputStream config = new FileInputStream("conf/avalon.properties");
        Avalon.config.load(config);
        config.close();

        PropertyConfigurator.configure(Avalon.config.getProperty("logConf").trim());

        String[] ports = Avalon.config.getProperty("ports").split(",");
        for (String port : ports) {
            new AvalonThread(Integer.parseInt(port.trim())).run();
        }
    }
}
