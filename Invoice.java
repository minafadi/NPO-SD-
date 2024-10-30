public class Invoice {
    private int appointmentId;
    private String patientName;
    private String doctorName;
    private String[] drugList;
    private Payment payment;
    private double totalPrice;

    public Boolean isDrugAvailable(Drug drug) {
        return false;
    }

    public double getDrugPrice(Drug drug) {
        return 0.0;
    }

    public Boolean addDrug(Drug drug) {
        return false;
    }

    public Boolean removeDrug(Drug drug) {
        return false;
    }

    public Boolean pay() {
        return false;
    }

    public double getTax() {
        return payment.getTax();
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String[] getDrugList() {
        return drugList;
    }

    public void setDrugList(String[] drugList) {
        this.drugList = drugList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
