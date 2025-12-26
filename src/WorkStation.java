import java.util.Objects;

public class WorkStation {
    private String name;
    private String ip;

    public WorkStation(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public String getName() { return name; }
    public String getIp() { return ip; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkStation)) return false;
        WorkStation ws = (WorkStation) o;
        return Objects.equals(ip, ws.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }

    @Override
    public String toString() {
        return name + " (" + ip + ")";
    }
}