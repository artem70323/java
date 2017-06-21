package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        Root root = toJavaObject("test.json");
        System.out.println(root.toString());
        toJSON(root);
    }

    public static Root toJavaObject(String path) {
        Root root = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            root = mapper.readValue(new File(path), Root.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return root;
    }
    
    public static void toJSON(Root root) {
        try (FileWriter writer = new FileWriter("test2.json", false)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(root, writer);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}