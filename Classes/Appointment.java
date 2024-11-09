package Classes;

import java.sql.*;
import java.sql.Connection;
import java.util.Date;
import java.sql.Connection;
import java.sql.*;

public class Appointment {
    private int id;
    private String date;
    private int patientId;
    private int doctorId;
    private String notes;
    static private Connection dbconn;


    // Constructor with patientId set to -1 by default
    public Appointment(Date date, int doctorId, String notes) {
        this.date = date;
        this.patientId = -1;  // Patient ID defaults to -1 when not provided
        this.doctorId = doctorId;
        this.notes = notes;
        if(dbconn==null){
            DB db = new DB();
            this.dbconn = db.ConnectDB();
        }
        try (PreparedStatement stmt = dbconn.prepareStatement("INSERT INTO appointment (date, Pid, Did, Notes) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, this.date.toString());
            stmt.setInt(2, this.patientId);
            //stmt.setString(3, illness.toString());
            stmt.setInt(3, this.doctorId);
            stmt.setString(4, this.notes);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        this.id = generatedKeys.getInt(1); // Get the generated patient ID
                        System.out.println("New Appointment added with ID: " + this.id);
                    }
                }
            } else {
                System.out.println("Failed to add new patient.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Constructor with patientId provided
    public Appointment(int patientId, Date date, int doctorId, String notes) {
        this.patientId = patientId;
        this.date = date;
        this.doctorId = doctorId;
        this.notes = notes;
        if(dbconn==null){
            DB db = new DB();
            this.dbconn = db.ConnectDB();
        }
    }

    // Getters and setters
    static private Connection dbconn;

    public Appointment(String d,int Did){
        if(dbconn==null){
            DB db = new DB();
            this.dbconn = db.ConnectDB();
        }
        this.date=d;
        this.doctorId=Did;
    }
    public Appointment(int Did){
        if(dbconn==null){
            DB db = new DB();
            this.dbconn = db.ConnectDB();
        }
        this.doctorId=Did;
    }
    public Appointment[] ReadDoctorApps(int doctorId) {
        //System.out.println(doctorId);
        // Count how many appointments will be returned
        int appointmentCount = 0;
        // SQL query to fetch appointments for the specified doctor where patient = -1
        String appointmentQuery = "SELECT * FROM appointment WHERE Did = ? AND Pid = -1";

        Appointment[] appointmentsArray;

        try (PreparedStatement appointmentStmt = Appointment.dbconn.prepareStatement(appointmentQuery)) {
            // Set the doctorId in the appointment query
            appointmentStmt.setInt(1, doctorId);

            // Execute the query to count the rows first
            try (ResultSet rs = appointmentStmt.executeQuery()) {
                while (rs.next()) {
                    appointmentCount++;
                }
            }
            //System.out.println(doctorId);
            // If no appointments found, return an empty array
            if (appointmentCount == 0) {
                return new Appointment[0];
            }

            // Create an array to store the appointments
            appointmentsArray = new Appointment[appointmentCount];

            // Now retrieve the appointments and populate the array
            try (ResultSet rs = appointmentStmt.executeQuery()) {
                int index = 0;
                while (rs.next()) {
                    String date = rs.getString("date"); // Assuming date is stored under this column
                    // Create the Appointment object and add it to the array
                    appointmentsArray[index] = new Appointment(date, doctorId);
                    System.out.println("oksh");
                    index++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // In case of an error, return null or handle as needed
        }
        //System.out.println(appointmentsArray[0].id);
        return appointmentsArray;
    }

    public String getDoctorNameById() {
        // SQL query to fetch the doctor name based on doctorId
        String query = "SELECT name FROM doctor WHERE id = ?";
        String doctorName = null;

        //System.out.println(doctorId);
        try (PreparedStatement stmt = Appointment.dbconn.prepareStatement(query)) {
            // Set the doctorId in the query
            stmt.setInt(1, this.doctorId);

            // Execute the query and get the doctor's name
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    doctorName = rs.getString("name"); // Retrieve the doctor's name
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // In case of an error, return null or handle as needed
        }

        return doctorName; // Returns null if the doctor is not found
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
