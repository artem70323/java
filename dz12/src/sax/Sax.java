package sax;

import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Sax extends DefaultHandler {

    String thisElement = "";
    ArrayList<People> list = new ArrayList<>();
    People peop;
    boolean skipName = false;   //проверка, чтобы первое "name" не занесло в People

    public static void main(String[] args) {
        Sax saxp = new Sax();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse("test.xml", saxp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Root r = new Root();

        for (People e : saxp.list) {
            System.out.println(e.toString());
        }
    }
    
    @Override
    public void startDocument() {
        System.out.println("Start document\n");
    }

    @Override
    public void endDocument() {
        System.out.println("\nEnd document\n");
    }

    @Override
    public void startElement(String uri, String name, String qName, Attributes atts) {
        if (qName.equals("element")) {
            peop = new People();
        }
        thisElement = qName;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String name, String qName) {
        if (qName.equals("element")) {
            list.add(peop);
        }
        thisElement = "";
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char ch[], int start, int length) {
        //не выводим ненужную информацию
        if (ch[start] == '\n') {
            System.out.println("");
        } else {
            System.out.print("Characters:    \"");
            for (int i = start; i < start + length; i++) {
                switch (ch[i]) {
                    case ' ':
                        System.out.print("");
                        break;
                    case '\n':
                        System.out.print("\\n");
                        break;
                    default:
                        System.out.print(ch[i]);
                        break;
                }
            }
            System.out.print("\"\n");
        }

        switch (thisElement) {
            case "age":
                peop.setAge(Integer.parseInt(new String(ch, start, length)));
                break;
            case "id":
                peop.setId(Integer.parseInt(new String(ch, start, length)));
                break;
            case "isDegree":
                peop.setIsDegree(Boolean.parseBoolean(new String(ch, start, length)));
                break;
            case "name":
                //проверка, чтобы первое "name" не занесло в People
                if (skipName) {
                    peop.setName(new String(ch, start, length));
                } else {
                    skipName = true;
                }
                break;
            case "surname":
                peop.setSurname(new String(ch, start, length));
                break;
        }
    }

}
