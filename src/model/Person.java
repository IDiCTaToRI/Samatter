package model;

import java.io.Serializable;

public class Person implements Serializable {

    private String id;
    private String firstname;
    private String secondname;
    private String patronymic;
    private boolean sex;
    private short age;
    private String birthday;
    private String email;
    private String address;
    private String phone;

    public Person() {
    }

    public Person(String id, String firstname, String secondname, String patronymic, boolean sex, short age, String birthday, String email, String address, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }
    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public boolean isSex() {
        return sex;
    }
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public short getAge() {
        return age;
    }
    public void setAge(short age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}