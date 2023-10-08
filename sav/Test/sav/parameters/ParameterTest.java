package university.jala.sav.parameters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterTest {
    private Parameter parameter;

    @BeforeEach
    void setUp() {
        String[] args = {"a=b", "t=n", "o=az", "in=r", "r=30", "s=140"};
        parameter = Parameter.getInstance(args);
    }

    @Test
    void testGetAlgorithm() {
        assertEquals("b", parameter.getAlgorithm());
    }

    @Test
    void testIsAscendant() {
        assertTrue(parameter.isAscendant());
    }

    @Test
    void testGetDataMode() {
        assertEquals("r", parameter.getDataMode());
    }

    @Test
    void testGetPauseTime() {
        assertEquals(140, parameter.getPauseTime());
    }

    @Test
    void testIsRandom() {
        assertTrue(parameter.isRandom());
    }
    @Test
    void testNumbersRandom() {
        assertEquals(30, parameter.getNumberValuesRandom());
    }
    @Test
    void testGetTypeData() {
        assertEquals("n", parameter.getTypeData());
    }


}
