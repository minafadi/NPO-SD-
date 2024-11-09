package Classes;

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
    private Doctor d;
    static private Connection dbconn;
    public Appointment(Doctor d){
        if(dbconn==null){
            DB db = new DB();
            this.dbconn = db.ConnectDB();
        }
        this.d=d;
    }
    public Appointment(String d,Doctor doc){
        this.date=d;
        this.d=doc;
    }
    public static Appointment[] ReadDoctorApps(Doctor d) {
        // Count how many appointments will be returned
        int appointmentCount = 0;

        // SQL query to fetch the doctor ID by name
        String doctorQuery = "SELECT Id FROM doctor WHERE name = ?";
        // SQL query to fetch appointments for the specified doctor where patient = -1
        String appointmentQuery = "SELECT * FROM appointment WHERE Did = ? AND Pid = -1";

        Appointment[] appointmentsArray;
        try (PreparedStatement doctorStmt = Appointment.dbconn.prepareStatement(doctorQuery)) {
            // Set the doctor's name in the doctor query
            doctorStmt.setString(1, d.getName());

            // Execute the doctor query to retrieve the doctorId
            int doctorId = -1; // Default value if doctor not found
            try (ResultSet rs = doctorStmt.executeQuery()) {
                if (rs.next()) {
                    doctorId = rs.getInt("id"); // Retrieve doctorId
                } else {
                    return new Appointment[0]; // If no doctor is found, return an empty array
                }
            }

            // Now, use the doctorId to fetch the appointments for this doctor
            try (PreparedStatement appointmentStmt = Appointment.dbconn.prepareStatement(appointmentQuery)) {
                // Set the doctorId in the appointment query
                appointmentStmt.setInt(1, doctorId);

                // Execute the query to count the rows first
                try (ResultSet rs = appointmentStmt.executeQuery()) {
                    while (rs.next()) {
                        appointmentCount++;
                    }
                }

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
                        appointmentsArray[index] = new Appointment(date, d);
                        index++;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // In case of an error, return null or handle as needed
        }

        return appointmentsArray;
    }

    public Doctor getDoctor(){return this.d;}
    public String getDoctorName(){return d.getName();}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
