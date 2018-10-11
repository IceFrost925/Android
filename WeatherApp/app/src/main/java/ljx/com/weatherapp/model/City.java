package ljx.com.weatherapp.model;

public class City {
    private int id;
    private String province;
    private String city;
    private String number;
    private String allpy;
    private String allfirstpy;
    private String firstpy;

    public City() {
    }

    public City(int id, String province, String city, String number, String allpy, String allfirstpy, String firstpy) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.number = number;
        this.allpy = allpy;
        this.allfirstpy = allfirstpy;
        this.firstpy = firstpy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAllpy() {
        return allpy;
    }

    public void setAllpy(String allpy) {
        this.allpy = allpy;
    }

    public String getAllfirstpy() {
        return allfirstpy;
    }

    public void setAllfirstpy(String allfirstpy) {
        this.allfirstpy = allfirstpy;
    }

    public String getFirstpy() {
        return firstpy;
    }

    public void setFirstpy(String firstpy) {
        this.firstpy = firstpy;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", number='" + number + '\'' +
                ", allpy='" + allpy + '\'' +
                ", allfirstpy='" + allfirstpy + '\'' +
                ", firstpy='" + firstpy + '\'' +
                '}';
    }
}
