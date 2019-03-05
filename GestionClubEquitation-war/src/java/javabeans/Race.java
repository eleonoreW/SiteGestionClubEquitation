package javabeans;

public class Race {
    
    private int race_id;
    private String name;
    
    public Race(int race_id, String name) {
        this.race_id = race_id;
        this.name = name;
    }
    
    public Race(String name) {
        this.race_id = -1;
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

    public int getRace_id() {
        return race_id;
    }
    
}
