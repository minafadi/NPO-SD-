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

        // SQL query to retrieve doctor details from the database
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

//        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(query)) {
//            stmt.setInt(1, id);
//
//            // Execute the query and fetch results
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    // Populate the Doctor object's attributes from the database
//                    String name = rs.getString("name");
//                    String phone = rs.getString("phone");
//                    this.specialization = rs.getString("specialization");
//                    this.degree = rs.getString("degree");
//                    this.graduationYear = rs.getInt("graduationYear");
//                    this.salary = rs.getDouble("salary");
//
//                    // Use `super` to set name and phone in the superclass
//                    super.name = name;
//                    super.phone = phone;
//                } else {
//                    throw new SQLException("Doctor with ID " + id + " not found in the database.");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle exception appropriately (e.g., logging or rethrowing)
//        }
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

//        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement("INSERT INTO doctor (name, phone, password, specialization, degree, graduationyear, salary) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
//            stmt.setString(1, this.name);
//            stmt.setString(2, super.phone);
//            stmt.setString(3, this.password);
//            stmt.setString(4, this.specialization);
//            stmt.setString(5, this.degree);
//            stmt.setInt(6, this.graduationYear);
//            stmt.setDouble(7, this.salary);
//
//            int affectedRows = stmt.executeUpdate();
//
//            if (affectedRows > 0) {
//                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        this.id = generatedKeys.getInt(1); // Get the generated patient ID
//                        System.out.println("New Doctor added with ID: " + this.id);
//                    }
//                }
//            } else {
//                System.out.println("Failed to add new patient.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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
