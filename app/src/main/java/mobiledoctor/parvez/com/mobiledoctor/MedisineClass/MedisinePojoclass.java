package mobiledoctor.parvez.com.mobiledoctor.MedisineClass;

public class MedisinePojoclass  {

    private int id;
   // private int image;
    private String doctorName;
    private String visitDate;
    private String details;

    public MedisinePojoclass(int id,String doctorName, String visitDate, String details) {
        this.id = id;

        this.doctorName = doctorName;
        this.visitDate = visitDate;
        this.details = details;
    }



    public MedisinePojoclass( String doctorName, String visitDate, String details) {

        this.doctorName = doctorName;
        this.visitDate = visitDate;
        this.details = details;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
