package Models;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Appointment {
    private int id;
    private String date;
    private int patientId;
    private int doctorId;
    private String doctorName;
    private String notes;

    public Appointment(String date, int doctorId, String notes, DBProxy dbProxy){
        this.notes = notes;
        this.date = date;
        this.doctorId = doctorId;
        this.doctorName = this.getDoctorName(dbProxy);
        insertappointment(date,doctorId,notes,dbProxy);
    }

    // Constructor with patientId provided
    public Appointment(int patientId, String  date, int doctorId, String notes, DBProxy dbProxy) {
        this.patientId = patientId;
        this.date = date;
        this.doctorId = doctorId;
        this.notes = notes;
        insertappointmentpatientprovided(patientId,date,doctorId,notes,dbProxy);

    }

    public Appointment(int patientId, String  date, int doctorId, String notes, int id) {
        this.patientId = patientId;
        this.date = date;
        this.doctorId = doctorId;
        this.notes = notes;
        this.id = id;
    }


    public Appointment(String d,int Did){
        this.date=d;
        this.doctorId=Did;
    }
    public Appointment(int Did){
        this.doctorId=Did;
    }
    public void insertappointmentpatientprovided(int patientId, String  date, int doctorId, String notes, DBProxy dbProxy){
        String query = "INSERT INTO appointment (date, Pid, Did, Notes) VALUES ('" + LocalDate.parse(this.date, DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + this.patientId + ", " + this.doctorId + ", '" + this.notes +"')";
        try {
            dbProxy.executeQuery(query);
            ResultSet result = dbProxy.executeQuery("SELECT * FROM appointment WHERE Pid = " + this.patientId + " AND Did = " + this.doctorId);
            if (result != null) {
                try {
                    result.next();
                    this.id = result.getInt("id");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Failed to add new patient!");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertappointment(String date, int doctorId, String notes, DBProxy dbProxy){

        String query = "INSERT INTO appointment (date, Pid, Did, Notes) VALUES ('" + LocalDate.parse(this.date, DateTimeFormatter.ofPattern("yyyy-MM-dd")) + "', " + this.patientId + ", " + this.doctorId + ", '" + this.notes +"')";
        try {
            dbProxy.executeQuery(query);
            ResultSet result = dbProxy.executeQuery("SELECT * FROM appointment WHERE Pid = " + this.patientId + " AND Did = " + this.doctorId);
            if (result!=null){
                try {
                    result.next();
                    this.id = result.getInt("id");
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Failed to add new patient!");
                }
            } else {
                System.out.println("Failed to add new patient.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Appointment[] ReadDoctorApps(int doctorId, DBProxy dbProxy) {
        // SQL query to fetch appointments for the specified doctor where patient = -1
        String appointmentQuery = "SELECT * FROM appointment WHERE Did = " + doctorId + " AND Pid = 0";

        try (ResultSet resultSet = dbProxy.executeQuery(appointmentQuery)) {
            // Use ArrayList to store appointments first
            ArrayList<Appointment> appointmentList = new ArrayList<>();

            // Iterate through the ResultSet and add Appointment objects to the list
            while (resultSet.next()) {
                Appointment appointment = new Appointment(
                        resultSet.getInt("Pid"),
                        resultSet.getString("date"),
                        resultSet.getInt("Did"),
                        resultSet.getString("Notes"),
                        resultSet.getInt("id")
                );
                appointmentList.add(appointment);
            }

            // Convert the ArrayList to an array
            Appointment[] appointmentsArray = new Appointment[appointmentList.size()];
            appointmentList.toArray(appointmentsArray);

            // Return the array of appointments
            return appointmentsArray;

        } catch (SQLException e) {
            e.printStackTrace();
            return new Appointment[0]; // Return an empty array in case of an error
        }
    }

    public String getDoctorName() {
        return this.doctorName;
    }

    public String getDoctorName(DBProxy dbProxy) {
        // SQL query to fetch the doctor name based on doctorId
        String query = "SELECT name FROM doctor WHERE id = " + this.doctorId;
        String doctorName = null;

        try(ResultSet result = dbProxy.executeQuery(query)){
            result.next();
            doctorName = result.getString("name");
            System.out.println(doctorName);
        }
        catch (Exception e){
            System.out.println("YALAHWYYYYY");
            System.out.println(e.getMessage());
        }
        //System.out.println(doctorId);
//        try (PreparedStatement stmt = DB.getInstance().getConnection().prepareStatement(query)) {
//            // Set the doctorId in the query
//            stmt.setInt(1, this.doctorId);
//
//            // Execute the query and get the doctor's name
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    doctorName = rs.getString("name"); // Retrieve the doctor's name
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null; // In case of an error, return null or handle as needed
//        }

        return doctorName; // Returns null if the doctor is not found
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
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

    public void reserve(DBProxy dbProxy,Patient p){
        String query = "UPDATE appointment SET Pid = " + p.id + " WHERE id = " + this.getId();
        dbProxy.executeQuery(query);
    }
}
