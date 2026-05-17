public class ConversorUnidades {

    private static final double CM_POR_METRO = 100;
    private static final double MM_POR_METRO = 1000;
    private static final double MM_POR_CM = 10;

    public double metrosACentimetros(double metros) {
        return metros * CM_POR_METRO;
    }

    public double metrosAMilimetros(double metros) {
        return metros * MM_POR_METRO;
    }

    public double centimetrosAMilimetros(double centimetros) {
        return centimetros * MM_POR_CM;
    }

    public double milimetrosAMetros(double milimetros) {
        return milimetros / MM_POR_METRO;
    }
}
