package enterprise;

public class SASU implements Company {
    @Override
    public double getTaxPercentage() {
        return DEFULT_TAX_PERCENTAGE;
    }
}
