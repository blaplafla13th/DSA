package hw4_20001976.bai7;

public class Employee {
    private String username;
    private int clientCount;
    private long time;

    public Employee(String username) {
        this.username = username;
        this.clientCount = 0;
        this.time = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTime() {
        return time;
    }

    public int getClientCount() {
        return clientCount;
    }

    public void addClientCount() {
        this.clientCount++;
    }

    public void addTime(long time) {
        this.time += time;
        this.time /= 60000.0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "username='" + username + '\'' +
                ", clientCount=" + clientCount +
                ", time=" + time + "mins" +
                '}';
    }
}
