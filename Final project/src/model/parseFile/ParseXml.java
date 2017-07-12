package model.parseFile;

import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import model.baseOfEmployees.BaseOfEmployees;
import model.baseOfEmployees.Employee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//используем DOM-парсер
//System.out.println оставил для тестов
public class ParseXml extends ParserThread {
    
    @Override
    public void parse() {
        
        synchronized (this) {
            //спим
            view.View.print("ParserThread - спим");
            try {
                wait();
            } catch (InterruptedException ex) {
                view.View.print(ex.getMessage());
            }
        }

        //парсим
        view.View.print("ParserThread - парсим XML");
        BaseOfEmployees baseOfEmployees = BaseOfEmployees.getInstance();
        Document dom = null;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("Employee.xml");
        } catch (Exception e) {
            view.View.print(e.getMessage());
            return;
        }
        
        //root
        Element root = dom.getDocumentElement();
//        System.out.println("tag = " + root.getTagName());
        //name
        baseOfEmployees.setName(getElement(root, "name"));
        //location
        baseOfEmployees.setLocation(getElement(root, "location"));
        //baseSalary
        baseOfEmployees.setBaseSalary(Integer.parseInt(getElement(root, "baseSalary")));
        //employees
        NodeList employeesNodeList = root.getElementsByTagName("employees");
        
        TreeSet<Employee> set = new TreeSet<>();

        for (int i = 0; i < employeesNodeList.getLength(); i++) {
            Node employeesNode = employeesNodeList.item(i);

            if (employeesNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Employee employee = new Employee();

//            System.out.println("======================================");

            Element element = (Element) employeesNode;

            //id
            employee.setId(Integer.parseInt(getElement(element, "id")));

            //name
            employee.setName(getElement(element, "name"));

            //degree
            employee.setDegree(getElement(element, "degree"));

            //dateOfBirth
            employee.setDateOfBirth(getElement(element, "dateOfBirth"));

            //yearExperience
            employee.setYearExperience(Integer.parseInt(getElement(element, "yearEperience")));

            //emails
            NodeList nodeList = element.getElementsByTagName("emails");
            for (int j = 0; j < nodeList.getLength(); j++) {
                Node node = nodeList.item(j);
//                System.out.print(node.getNodeName());
                String text = node.getTextContent();
//                System.out.println(" = " + text);
                employee.addEmails(text);
            }

            //visible
            employee.setVisible(Boolean.parseBoolean(getElement(element, "visible")));

            set.add(employee);
        }
        baseOfEmployees.setEmployees(set);
    }
    
    //получаем элемент по имени
    private static String getElement(Element element, String str) {
        Node node = element.getElementsByTagName(str).item(0);
//        System.out.print(node.getNodeName());
        String text = node.getTextContent();
//        System.out.println(" = " + text);
        return text;
    }
    
}