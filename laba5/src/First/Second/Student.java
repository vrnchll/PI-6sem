package First.Second;

import First.Person;

import java.util.Date;

public interface Student extends Person {
    int LimitUniversityLength = 60;
    void setFirstDate(Date d);
    Date getFirstDate();
    void setUniversity(String u);
    String getUniversity();
}
