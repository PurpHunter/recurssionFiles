// Part 3: Domain Subclass Example (TeacherUser)
import java.util.ArrayList;
import java.util.List;

public class TeacherUser extends UserAccount implements Comparable<TeacherUser> {

    private String type;
    private List<TeacherUser> connections;

    public TeacherUser(String username, String type) {
        super(username);
        this.type = type;
        this.connections = new ArrayList<>();
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void addConnection(TeacherUser user) throws ConnectionException {
        if (connections.contains(user)) {
            throw new ConnectionException("Already connected");
        }
        connections.add(user);
    }

    public void removeConnection(TeacherUser user) throws ConnectionException {
        if (!connections.contains(user)) {
            throw new ConnectionException("Not connected");
        }
        connections.remove(user);
    }

    public List<TeacherUser> getConnections() {
        return new ArrayList<>(connections);
    }

    @Override
    public int compareTo(TeacherUser other) {
        return this.username.compareToIgnoreCase(other.username);
    }
}
