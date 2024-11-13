package Classes;

import java.sql.Connection;
import java.sql.*;


public class Doctor extends User {
    private int id;
    private String specialization;
    private String degree;
    private int graduationYear;
    private double salary;

    public Doctor(){
        super();
    }
    public Doctor(int id) {
        super(null, null);
        this.id = id;

        // SQL query to retrieve doctor details from the database
        String query = "SELECT name, phone, specialization, degree, graduationYear, salary FROM doctor WHERE Id = ?";

        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);

            // Execute the query and fetch results
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Populate the Doctor object's attributes from the database
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    this.specialization = rs.getString("specialization");
                    this.degree = rs.getString("degree");
                    this.graduationYear = rs.getInt("graduationYear");
                    this.salary = rs.getDouble("salary");

                    // Use `super` to set name and phone in the superclass
                    super.name = name;
                    super.phone = phone;
                } else {
                    throw new SQLException("Doctor with ID " + id + " not found in the database.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately (e.g., logging or rethrowing)
        }
    }

    public Doctor(int id,String name, String phone, String specialization, String degree, int graduationYear, double salary) {
        super(name, phone);
        this.specialization = specialization;
        this.degree = degree;
        this.graduationYear = graduationYear;
        this.salary = salary;
        this.id=id;
    }

    public Doctor(String name, String phone, String specialization, String degree, int graduationYear, double salary, String password) {
        super(name, phone);
        this.specialization = specialization;
        this.degree = degree;
        this.graduationYear = graduationYear;
        this.salary = salary;
        this.password = password;
        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement("INSERT INTO doctor (name, phone, password, specialization, degree, graduationyear, salary) VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, this.name);
            stmt.setString(2, super.phone);
            stmt.setString(3, this.password);
            stmt.setString(4, this.specialization);
            stmt.setString(5, this.degree);
            stmt.setInt(6, this.graduationYear);
            stmt.setDouble(7, this.salary);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.id = generatedKeys.getInt(1); // Get the generated patient ID
                        System.out.println("New Doctor added with ID: " + this.id);
                    }
                }
            } else {
                System.out.println("Failed to add new patient.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean updateDoctor(Doctor doctor) {
        return true;
    }
    public int getDRid(){return this.id;}
    public static Doctor[] readAllDoctors() {
        // Query to get all doctor records from the database
        String query = "SELECT * FROM Doctor";
        Statement stmt = null;
        ResultSet rs = null;
        Doctor[] doctors = new Doctor[0]; // Default to an empty array

        try {
            // Create a scrollable statement
            stmt = DB.getInstance().getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query);

            // Check if there are results and get the count
            if (rs.last()) { // Moves to the last row to get the row count
                int rowCount = rs.getRow();
                rs.beforeFirst(); // Move back to the start for iteration

                // Initialize the array of doctors with the row count
                doctors = new Doctor[rowCount];

                int i = 0;
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String specialization = rs.getString("specialization");
                    String degree = rs.getString("degree");
                    int graduationYear = rs.getInt("graduationYear");
                    double salary = rs.getDouble("salary");

                    // Create a new Doctor object and add it to the array
                    doctors[i++] = new Doctor(id,name, phone, specialization, degree, graduationYear, salary);
                }
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
