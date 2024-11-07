package Classes;

import java.sql.Connection;
import java.sql.*;


public class Doctor extends User {
    private String specialization;
    private String degree;
    private int graduationYear;
    private double salary;
    static private Connection dbconn;

    public Doctor(String name, String phone, String specialization, String degree, int graduationYear, double salary) {
        super(name, phone);
        if(dbconn==null){
            DB db = new DB();
            this.dbconn = db.ConnectDB();
        }
        this.specialization = specialization;
        this.degree = degree;
        this.graduationYear = graduationYear;
        this.salary = salary;
    }

    public Boolean updateDoctor(Doctor doctor) {
        return true;
    }

    static public Doctor[] readAllDoctors() {
        // Query to get all doctor records from the database
        String query = "SELECT * FROM Doctors";
        Statement stmt = null;
        ResultSet rs = null;
        Doctor[] doctors = null;

        try {
            stmt = dbconn.createStatement();
            rs = stmt.executeQuery(query);

            // Count how many doctors are there to initialize the array
            rs.last();
            int rowCount = rs.getRow();
            rs.beforeFirst();

            // Initialize the array of doctors with the row count
            doctors = new Doctor[rowCount];

            int i = 0;
            while (rs.next()) {
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String specialization = rs.getString("specialization");
                String degree = rs.getString("degree");
                int graduationYear = rs.getInt("graduationYear");
                double salary = rs.getDouble("salary");

                // Create a new Doctor object and add it to the array
                doctors[i++] = new Doctor(name, phone, specialization, degree, graduationYear, salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return doctors;
    }

    public Boolean removeDoctor(Doctor doctor) {
        return true;
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
