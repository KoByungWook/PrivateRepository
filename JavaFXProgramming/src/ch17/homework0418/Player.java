package ch17.homework0418;

public class Player {
    private String name;
    private String avg;
    
    public Player() {
        
    }

    public Player(String name, String avg) {
        this.name = name;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }
    
    
}
