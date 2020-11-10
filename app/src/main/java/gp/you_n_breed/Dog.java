package gp.you_n_breed;

public class Dog {

    private int id;
    private String breed_name;
    private String avg_weight;
    private String life_exp;
    private String comBehav;
    private String healthProb;
    private String careTips;
    private String history;

    public Dog(int id, String breed_name, String avg_weight, String life_exp, String comBehav, String healthProb, String careTips, String history) {
        this.id = id;
        this.breed_name = breed_name;
        this.avg_weight = avg_weight;
        this.life_exp = life_exp;
        this.comBehav = comBehav;
        this.healthProb = healthProb;
        this.careTips = careTips;
        this.history = history;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getBreed_name() { return breed_name; }
    public void setBreed_name(String breed_name) { this.breed_name = breed_name; }
    public String getAvg_weight() { return avg_weight; }
    public void setAvg_weight(String avg_weight) { this.avg_weight = avg_weight; }
    public String getLife_exp() { return life_exp; }
    public void setLife_exp(String life_exp) { this.life_exp = life_exp; }
    public String getComBehav() { return comBehav; }
    public void setComBehav(String comBehav) { this.comBehav = comBehav; }
    public String getHealthProb() { return healthProb; }
    public void setHealthProb(String healthProb) { this.healthProb = healthProb; }
    public String getCareTips() { return careTips; }
    public void setCareTips(String careTips) { this.careTips = careTips; }
    public String getHistory() { return history; }
    public void setHistory(String history) { this.history = history; }
}

