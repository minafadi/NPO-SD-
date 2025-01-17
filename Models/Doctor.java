package Models;

import java.sql.*;
import java.util.ArrayList;


public class Doctor extends User {
    private String specialization;
    private String degree;
    private int graduationYear;
    private double salary;
    private DBProxy db;

    public Doctor(){
        super();
    }

    public Doctor(int id, DBProxy dbProxy) {
        super(null, null);
        this.id = id;
        this.db = dbProxy;
        initializedoctor(id,dbProxy);
    }

    public Doctor(int id,String name, String phone, String specialization, String degree, int graduationYear, double salary) {
        super(name, phone);
        this.specialization = specialization;
        this.degree = degree;
        this.graduationYear = graduationYear;
        this.salary = salary;
        this.id=id;
    }

    public Doctor(String name, String phone, String specialization, String degree, int graduationYear, double salary, String password, DBProxy dbProxy) {
        super(name, phone);
        this.specialization = specialization;
        this.degree = degree;
        this.graduationYear = graduationYear;
        this.salary = salary;
        this.password = password;
        this.db = dbProxy;
        insertdoctortodb(name,phone,specialization,degree,graduationYear,salary,password,dbProxy);
    }


    public void insertdoctortodb(String name, String phone, String specialization, String degree, int graduationYear, double salary, String password, DBProxy dbProxy){
        String query = "INSERT INTO doctor (name, phone, password, specialization, degree, graduationyear, salary) VALUES ('" + this.name + "', '" + super.phone + "', '" + this.password + "', '" + this.specialization + "', '" + this.degree + "', " + this.graduationYear + ", " + this.salary + ")";
        System.out.println(query);
        dbProxy.executeQuery(query);
        query = "SELECT * FROM doctor WHERE phone = '" + super.phone + "'";
        System.out.println(query);
        ResultSet resultSet = dbProxy.executeQuery(query);
        try {
            resultSet.next();
            super.id = resultSet.getInt("id");
        } catch (SQLException e) {
            System.out.println("Failed to add new doctor");
            System.out.println(e.getMessage());
        }
    }
    public void initializedoctor(int id, DBProxy dbProxy){
        String query = "SELECT name, phone, specialization, degree, graduationYear, salary FROM doctor WHERE Id = " + this.id;
        try(ResultSet resultSet = dbProxy.executeQuery(query)){
            resultSet.next();
            super.name = resultSet.getString("name");
            super.phone = resultSet.getString("phone");
            this.specialization = resultSet.getString("specialization");
            this.degree = resultSet.getString("degree");
            this.graduationYear = resultSet.getInt("graduationYear");
            this.salary = resultSet.getDouble("salary");
        }
        catch(Exception e){

        }
    }

    public int getDRid(){return this.id;}

    public static DoctorsCollection readAllDoctors(DBProxy dbProxy) {
        // Query to get all doctor records from the database
        String query = "SELECT * FROM doctor";
        ResultSet resultSet = dbProxy.executeQuery(query);

        try {
            // Use ArrayList to store doctors first
            ArrayList<Doctor> doctorList = new ArrayList<>();

            // Iterate over the resultSet and add Doctor objects to the list
            while (resultSet.next()) {
                Doctor doctor = new Doctor(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("phone"),
                        resultSet.getString("specialization"),
                        resultSet.getString("degree"),
                        resultSet.getInt("graduationyear"),
                        resultSet.getDouble("salary")
                );
                doctorList.add(doctor);
            }

            // Convert the ArrayList to an array
            Doctor[] doctorsArray = new Doctor[doctorList.size()];
            doctorList.toArray(doctorsArray);

            // Return the DoctorsCollection with the array of doctors
            return new DoctorsCollection(doctorsArray);

        } catch (Exception e) {
            System.out.println("Error occurred while reading doctors: " + e.getMessage());
            return null;
        }
    }



    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
