package dz8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private String name;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");  //задаю формат даты       
        Date date = sdf.parse(birthday);
        this.birthday = date;
    }

}
