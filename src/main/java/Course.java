public class Course {
    private String code;
    private String tittle;
    private String desciption;
    private String startDate;
    private String credit;
    private String lecturerId;

    public Course(String code, String tittle, String desciption, String startDate, String credit, String lecturerId) {
        this.code = code;
        this.tittle = tittle;
        this.desciption = desciption;
        this.startDate = startDate;
        this.credit = credit;
        this.lecturerId = lecturerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }
}
