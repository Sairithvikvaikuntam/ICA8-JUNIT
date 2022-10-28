import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class urinalsTest {
    private Methods m;

    @BeforeEach
    public void setUrine() {
        m = new Methods();
    }

    @Test
    void Test1goodString() {
        System.out.println("== Sai Rithvik Vaikuntam == TEST1 EXECUTED ==");
        assertEquals(true, m.goodString("1010"));
    }

    @Test
    void Test2goodString() {
        System.out.println("== Sai Rithvik Vaikuntam == TEST2 EXECUTED ==");
        assertEquals(false, m.goodString(""));
    }

    @Test
    void Test3goodString() {
        System.out.println("== Sai Rithvik Vaikuntam == TEST3 EXECUTED - NumberFormatException ==");
        assertThrows(NumberFormatException.class, () -> {
            m.goodString("abc");
        });
    }
}
