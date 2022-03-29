package hw4_20001976.bai7;

public class Client {
    private String name;
    private String phoneNumber;
    private String info;

    public Client(String name, String phoneNumber, String info) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.info = info;
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

    @Override
    public String toString() {
        return "Client:\n" +
                "name='" + name + '\'' +
                "\nphoneNumber='" + phoneNumber + '\'' +
                "\ninfo='" + info + '\'' +
                ':';
    }
}
