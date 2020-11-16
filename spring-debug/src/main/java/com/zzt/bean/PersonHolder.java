package com.zzt.bean;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/9 21:26
 **/
public class PersonHolder {

    private Person person;
    private String username;
    private String password;

    public PersonHolder() {
    }

    public PersonHolder(Person person, String username, String password) {
        this.person = person;
        this.username = username;
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
