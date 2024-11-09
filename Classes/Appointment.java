package Classes;

import java.sql.*;
import java.util.Date;

public class Appointment {
    private int id;
    private Date date;
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
