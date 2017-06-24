package dz14;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {

    public static void main(String[] args) {

        String regex = "(?<=(\\w))\\1+";
        String text = "hellowoooorld";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        StringBuffer str = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(str, Integer.toString(m.group().length() + 1));
        }
        m.appendTail(str);
        text = str.toString();
        System.out.println("text = " + text);
    }

}
