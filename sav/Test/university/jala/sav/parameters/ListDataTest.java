package university.jala.sav.parameters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListDataTest {

    private ListData listData;

    @BeforeEach
    void setUp() {
        String[] args = {"a=q", "t=c", "o=az", "in=m", "v=a,e,c,z,b,l,f,q,z,m", "s=100"};
        listData = ListData.getInstance(args);
    }
    @Test
    void testGetArrayCharacter() {
        Character[] expected = {'a', 'e', 'c', 'z', 'b', 'l', 'f', 'q', 'z', 'm'};
        Character[] result = listData.getArrayCharacter();
        assertArrayEquals(expected, result);
    }
    @Test
    void testGetArrayIntegerRandom() {
        Integer[] result = listData.getArrayIntegerRandom();
        assertNotNull(result);
        assertEquals(listData.getParameters().getNumberValuesRandom(), result.length);
    }
    @Test
    void testGetArrayCharacterRandom() {
        Character[] result = listData.getArrayCharacterRandom();
        assertNotNull(result);
        assertEquals(listData.getParameters().getNumberValuesRandom(), result.length);
    }
}