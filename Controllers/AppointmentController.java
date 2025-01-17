package Controllers;

import Models.Appointment;
import Models.DBProxy;
import Models.ICommandAdmin;
import Views.AppointmentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Date;

public class AppointmentController implements ICommandAdmin {
    private AppointmentView view;
    DBProxy dbProxy;

    @Override
    public void executecommand() {
        this.view = new AppointmentView();
        this.view.setVisible(true);
        this.view.getAddAppointmentButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddAppointment();
            }
        });
    }

    @Override
    public void undocommand() {
        this.view.setVisible(false);

    }

    public AppointmentController(DBProxy dbProxy) {
        this.dbProxy = dbProxy;
    }

    private void handleAddAppointment() {
        int day = (int) view.getSpinner1().getValue();
        int month = (int) view.getSpinner2().getValue();
        int year = (int) view.getSpinner3().getValue();

//        LocalDate localDate = LocalDate.of(year, month, day);
        String months, days;
        if (month >= 10) months = Integer.toString(month);
        else months = "0" + month;
        if (day >= 10) days = Integer.toString(day);
        else days = "0" + day;
        String appDate = year + "-" + months + "-" + days;
//        Date appointmentDate = java.sql.Date.valueOf(localDate);

        try {
            int patientId = Integer.parseInt(view.getTextField1().getText());
            int doctorId = Integer.parseInt(view.getTextField2().getText());
            String description = view.getTextField3().getText();

            if (view.getReserveForPatientCheckBox().isSelected()) {
                Appointment appointment = new Appointment(patientId, appDate, doctorId, description, dbProxy);
                System.out.println("Reserved for patient: " + appointment);
            } else {
                Appointment appointment = new Appointment(appDate, doctorId, description, dbProxy);
                System.out.println("Appointment created: " + appointment);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Invalid input. Please ensure all fields are filled correctly.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
