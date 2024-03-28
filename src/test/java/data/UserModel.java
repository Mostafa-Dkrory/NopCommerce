package data;

import com.github.javafaker.Faker;

public class UserModel{
    final private String fName;
    final private String lName ;
    final private String email ;
    final private String password;
    final private String company;
    final private String country;
    final private String city;
    final private String zipCode;
    final private String address;
    final private String phoneNumber;
    public UserModel(){
        fName = new Faker().name().firstName();
        lName = new Faker().name().lastName();
        email =  new Faker().internet().emailAddress();
        password  = new Faker().internet().password();
        company  = new Faker().company().name();
        country  = new Faker().address().country();
        city  = new Faker().address().city();
        zipCode = new Faker().address().zipCode();
        phoneNumber = new Faker().phoneNumber().phoneNumber();
        address = new Faker().address().fullAddress();
        System.out.println(email);
        System.out.println(password);}
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getCompany() {
        return company;
    }
}

