package homework1.models.entities;

/**
 * Created by Peyman RM
 */
public class EmployeeEnti {
    private String name, fatherName, nationalCode, degree, phoneNumber, Telephone, Address;
    private int age;

    public String getName() {
        return name;
    }

    public EmployeeEnti setName(String name) {
        this.name = name;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public EmployeeEnti setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public EmployeeEnti setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
        return this;
    }

    public String getDegree() {
        return degree;
    }

    public EmployeeEnti setDegree(String degree) {
        this.degree = degree;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public EmployeeEnti setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getTelephone() {
        return Telephone;
    }

    public EmployeeEnti setTelephone(String telephone) {
        Telephone = telephone;
        return this;
    }

    public String getAddress() {
        return Address;
    }

    public EmployeeEnti setAddress(String address) {
        Address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public EmployeeEnti setAge(int age) {
        this.age = age;
        return this;
    }
}
