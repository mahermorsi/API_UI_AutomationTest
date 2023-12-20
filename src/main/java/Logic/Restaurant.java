package Logic;

public class Restaurant {
    private String id;
    private String name;
    private String score;
    private String address;

    public Restaurant(String id, String name, String score, String address) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"score\":" + score + ",\"address\":\"" + address + "\"}";
    }
}
