package mobiledoctor.parvez.com.mobiledoctor.DoctorClass;

public class DoctorPojoclass {

    private String id;
    private String doctorName;
    private String doctorEmail;
    private String doctorPhoneNo;
    private String appointDate;
    private String details;



    public DoctorPojoclass(String id,String doctorName, String doctorEmail, String doctorPhoneNo, String appointDate, String details) {
        this.id = id;
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.doctorPhoneNo = doctorPhoneNo;
        this.appointDate = appointDate;
        this.details = details;
    }


    public DoctorPojoclass(String doctorName, String doctorEmail, String doctorPhoneNo, String appointDate, String details) {
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.doctorPhoneNo = doctorPhoneNo;
        this.appointDate = appointDate;
        this.details = details;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorPhoneNo() {
        return doctorPhoneNo;
    }

    public void setDoctorPhoneNo(String doctorPhoneNo) {
        this.doctorPhoneNo = doctorPhoneNo;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
