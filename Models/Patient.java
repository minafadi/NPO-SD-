package Models;

import java.sql.*;

public class Patient extends User {
    private Illness illness;
    private int age;
    private boolean gender;

    public Patient(int id, String name, String phone, Illness illness, int age, boolean gender, String password) {
        super(name, phone);
        this.id = id;
        this.illness = illness;
        this.age = age;
        this.gender = gender;
        this.password = password;
    }

    public Patient(int id, DBProxy dbProxy) {
        super(null, null);
        this.id = id;
        initializepatient(id,dbProxy);
    }

    //to create new patient in database
    public Patient(String name, String phone, int age, boolean gender, String password, DBProxy dbProxy) {
        super(name, phone);
        this.age = age;
        this.gender = gender;
        this.password = password;
        insertpatient(name,phone,age,gender,password,dbProxy);;
    }

    //get existing object from db
    public Patient(String name, String password, DBProxy dbProxy) {
        super(name, password);
        initpatient(name,password,dbProxy);
    }


    public void initpatient(String name, String password, DBProxy dbProxy){
        String query = "SELECT * FROM patient WHERE name = '" + name + "' AND password = '" + password + "'";
        ResultSet resultSet = dbProxy.executeQuery(query);
        try {
            if (resultSet.next()) {
                this.id = resultSet.getInt("id");
                this.age = resultSet.getInt("age");
                this.gender = resultSet.getBoolean("gender");
            }
        } catch (Exception e) {

        }
    }
    public void insertpatient(String name, String phone, int age, boolean gender, String password, DBProxy dbProxy){
        String query = "INSERT INTO patient (name, phone,age, gender, password) VALUES ('" + name + "', " + phone + ", " + age + ", '" + gender + "', '" + password + "')";
        dbProxy.executeQuery(query);
    }
    public void initializepatient(int id, DBProxy dbProxy){
        String query = "SELECT name, phone, age, gender, password FROM patient WHERE Id = " + id;
        ResultSet resultSet = dbProxy.executeQuery(query);

        try {
            super.name = resultSet.getString("name");
            super.phone = resultSet.getString("phone");
            this.age = resultSet.getInt("age");
            this.gender = resultSet.getBoolean("gender");
            this.password = resultSet.getString("password");
        } catch (Exception e) {

        }
    }

    //public int getid(){return this.id;}
    public Boolean updatePatient(Patient patient, DBProxy dbProxy) {
        // Update patient information in the database (example)
        String query = "UPDATE patients SET name = '" + patient.getName() + "', phone = '" + patient.getPhone() + "', age = " + patient.getAge() + ", gender = '" + patient.getGender() + "' WHERE id = " + patient.getId();
        ResultSet resultSet = dbProxy.executeQuery(query);
        try {
            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }

        public static Boolean AuthenticatePatient (String name, String password, DBProxy dbProxy){
            String query = "SELECT COUNT(*) FROM patient WHERE name = '" + name + "' AND password = '" + password + "'";
            ResultSet resultSet = dbProxy.executeQuery(query);
            try {
                return (resultSet.next() && (resultSet.getInt(1) > 0));
            } catch (Exception e) {
                return false;
            }
        }


        // Getter and Setter methods
        public Illness getIllness () {
            return illness;
        }

        public void setIllness (Illness illness){
            this.illness = illness;
        }

        public int getAge () {
            return age;
        }

        public void setAge ( int age){
            this.age = age;
        }

        public boolean getGender () {
            return gender;
        }

        public void setGender ( boolean gender){
            this.gender = gender;
        }

        // Static method to close the database connection when done
        public static void closeConnection () {
            try {
                if (DB.getInstance().getConnection() != null && !DB.getInstance().getConnection().isClosed()) {
                    DB.getInstance().getConnection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

