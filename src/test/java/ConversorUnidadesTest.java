import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConversorUnidadesTest {

    private final ConversorUnidades conversor = new ConversorUnidades();

    @Test
    void unMetroEquivaleACienCentimetros() {
        assertEquals(100.0, conversor.metrosACentimetros(1.0), 0.0001);
    }

    @Test
    void unMetroEquivaleAMilMilimetros() {
        assertEquals(1000.0, conversor.metrosAMilimetros(1.0), 0.0001);
    }

    @Test
    void diezCentimetrosEquivalenACienMilimetros() {
        assertEquals(100.0, conversor.centimetrosAMilimetros(10.0), 0.0001);
    }

    @Test
    void milMilimetrosEquivalenAUnMetro() {
        assertEquals(1.0, conversor.milimetrosAMetros(1000.0), 0.0001);
    }
}
