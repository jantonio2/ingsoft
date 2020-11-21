package bo.ucb.edu.ingsoft.dto;

public class ScoreRequest {
    private Integer vehicleId;
    private Integer userId;
    private Double score;
    public ScoreRequest(){

    }

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
