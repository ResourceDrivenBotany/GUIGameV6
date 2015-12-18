
package game.v5;

/**
 *
 * @author Amanuel
 */
public class Data {
    private String playerName;
    private String plantType;
    private String plantName;

    public Data(String playerName, String plantType, String plantName) {
        this.playerName = playerName;
        this.plantType = plantType;
        this.plantName = plantName;
    }

    public Data() {
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
    
}
