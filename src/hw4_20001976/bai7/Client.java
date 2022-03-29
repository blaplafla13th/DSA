package hw4_20001976.bai7;

public class Client {
    private String name;
    private String phoneNumber;
    private String info;

    public Client(String name, String phoneNumber, String idNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.info = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
