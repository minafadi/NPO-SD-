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
    public Patient(int id) {
        super(null, null);
        this.id = id;

        // SQL query to retrieve patient details from the database
        String query = "SELECT name, phone, age, gender, password FROM patient WHERE Id = ?";

        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);

            // Execute the query and fetch results
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Populate the Patient object's attributes from the database
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    this.age = rs.getInt("age");
                    this.gender = rs.getBoolean("gender");
                    this.password = rs.getString("password");

                    // Set name and phone in the superclass (Person)
                    super.name = name;
                    super.phone = phone;
                } else {
                    throw new SQLException("Patient with ID " + id + " not found in the database.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception appropriately (e.g., logging or rethrowing)
        }
    }

    //to create new patient in database
    public Patient(String name, String phone, int age, boolean gender, String password) {
        super(name, phone);
        this.age = age;
        this.gender = gender;
        this.password = password;
        // Insert the new patient into the database
        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement("INSERT INTO patient (name, phone,age, gender, password) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, this.name);
            stmt.setString(2, this.phone);
            //stmt.setString(3, illness.toString());
            stmt.setInt(3, this.age);
            stmt.setBoolean(4, this.gender);
            stmt.setString(5, this.password);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.id = generatedKeys.getInt(1); // Get the generated patient ID
                        System.out.println("New patient added with ID: " + this.id);
                    }
                }
            } else {
                System.out.println("Failed to add new patient.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //get existing object from db
    public Patient(String name, String password) {
        super(name, password);
        // Use the static dbconn attribute to retrieve patient from the database
        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement("SELECT * FROM patient WHERE name = ? AND password = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.id = rs.getInt("id");
                this.age = rs.getInt("age");
                this.gender = rs.getBoolean("gender");
                //this.illness = new MentalIllness(); // Replace with actual column name
                System.out.println("Patient found: " + name);
                System.out.println("Patient found: " + this.getId());
            } else {
                System.out.println("No patient found with the given name and password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //public int getid(){return this.id;}
    public Boolean updatePatient(Patient patient) {
        // Update patient information in the database (example)
        String query = "UPDATE patients SET name = ?, phone = ?, age = ?, gender = ? WHERE id = ?";
        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getPhone());
            //stmt.setString(3, patient.getIllness().toString()); // Adjust for Illness type
            stmt.setInt(4, patient.getAge());
            stmt.setBoolean(5, patient.getGender());
            stmt.setInt(6, patient.getId());

            int result = stmt.executeUpdate();
            return result > 0;  // Returns true if update was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Patient readPatient(Patient patient) {
        // You could add logic here to read patient from db or return the patient itself
        return patient;
    }

    public Boolean removePatient(Patient patient) {
        String query = "DELETE FROM patients WHERE id = ?";
        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1, patient.getId());
            int result = stmt.executeUpdate();
            return result > 0;  // Returns true if removal was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean AuthenticatePatient(String name, String password) {
        String query = "SELECT COUNT(*) FROM patient WHERE name = ? AND password = ?";

        try (PreparedStatement statement = DB.getInstance().getConnection().prepareStatement(query)) {
            // Set query parameters
            statement.setString(1, name);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Getter and Setter methods
    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    // Static method to close the database connection when done
    public static void closeConnection() {
        try {
            if (DB.getInstance().getConnection() != null && !DB.getInstance().getConnection().isClosed()) {
                DB.getInstance().getConnection().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
