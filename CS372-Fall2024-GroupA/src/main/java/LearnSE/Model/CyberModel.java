package LearnSE.Model;

public class CyberModel {
    private String srcCountry;
    private int srcNoAttack;
    private String targetCountry;
    private int targetNoAttack;
    private String month;
    private String year;

    public CyberModel(String srcCountry, int srcNoAttack, String targetCountry, int targetNoAttack, String month, String year) {
        this.srcCountry = srcCountry;
        this.srcNoAttack = srcNoAttack;
        this.targetCountry = targetCountry;
        this.targetNoAttack = targetNoAttack;
        this.month = month;
        this.year = year;
    }

    public String getSrcCountry() {
        return srcCountry;
    }

    public void setSrcCountry(String srcCountry) {
        this.srcCountry = srcCountry;
    }

    public int getSrcNoAttack() {
        return srcNoAttack;
    }

    public void setSrcNoAttack(int srcNoAttack) {
        this.srcNoAttack = srcNoAttack;
    }

    public String getTargetCountry() {
        return targetCountry;
    }

    public void setTargetCountry(String targetCountry) {
        this.targetCountry = targetCountry;
    }

    public int getTargetNoAttack() {
        return targetNoAttack;
    }

    public void setTargetNoAttack(int targetNoAttack) {
        this.targetNoAttack = targetNoAttack;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "CyberModel{" +
               "srcCountry='" + srcCountry + '\'' +
               ", srcNoAttack=" + srcNoAttack +
               ", targetCountry='" + targetCountry + '\'' +
               ", targetNoAttack=" + targetNoAttack +
               ", month='" + month + '\'' +
               ", year='" + year + '\'' +
               '}';
    }

}