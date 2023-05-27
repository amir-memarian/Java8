package enterprise;

public class SARL implements Company {
    @Override
    public double getTaxPercentage() {
        return DEFULT_TAX_PERCENTAGE;
    }
}
