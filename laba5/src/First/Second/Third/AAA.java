package First.Second.Third;

import First.Second.Student;

import java.util.Date;

public class AAA implements Student {

    private String Surname;
    private String Name;
    private String Fathername;
    private String University;
    private java.util.Date Birthday;
    private java.util.Date FirstDate;

    public void setSurname(String surname) {
        this.Surname=surname;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setFatherName(String fathername) {
        this.Fathername= fathername;
    }

    public void setBirthday(int yyyy, int mm, int dd) {
        if(this.Limityyyy > yyyy) this.Birthday = new Date(yyyy, mm, dd);
    }

    public String getSurname() {
        return this.Surname;
    }

    public String getName() {
        return this.Name;
    }

    public String getFatherName() {
        return this.Fathername;
    }

    @Override
    public Date getBirhtday() {
        return this.Birthday;
    }

    public void setFirstDate(Date d) {
        FirstDate = d;
    }

    public Date getFirstDate() {
        return FirstDate;
    }

    public void setUniversity(String u) {
      this.University = u;
    }

    public String getUniversity() {
        return this.University;
    }
}
