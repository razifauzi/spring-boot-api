package masjidmuar.project.bms.dto;

public class RunningNumberDTO {
    
    private String prefix;
    private int currentNumber;

    public RunningNumberDTO(int currentNumber, String prefix) {
        this.currentNumber = currentNumber;
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

}
