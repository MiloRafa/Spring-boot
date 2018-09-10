package com.qa.accountmanagement.domain;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;

@Entity
public class AccountDatabase {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long iD;

    private String firstName;

    private String surname;

    private int accountNumber;

    public AccountDatabase() {}

    public AccountDatabase(String firstName, String surname, int accountNumber) {
        this.firstName = firstName;
        this.surname = surname;
        this.accountNumber = accountNumber;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "AccountDatabase{" +
                "iD=" + iD +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
