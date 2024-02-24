package base;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;

    public ConfigFileReader(){
        properties= new Properties();
        String propertyFilePath="src/test/resources/config.properties";
        try(InputStream input = Files.newInputStream(Path.of(propertyFilePath))){
            properties.load(input);
        }catch (Exception e){
            System.err.println("Error al cargar el archivo properties "+propertyFilePath+ ": "+e.getMessage());
        }
    }

    public String getProp(String keyName){
        return properties.getProperty(keyName);
    }





}
