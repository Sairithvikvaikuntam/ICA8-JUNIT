import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class urinalsTest {
    private Methods m;

    @BeforeEach
    public void setMethods() {
        
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

    @Test
    void countFreeUrinalsOne() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST ONE EXECUTED =======");
        assertEquals(1, urine.countFreeUrinals("10001"));
    }

    @Test
    void countFreeUrinalsTwo() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST TWO EXECUTED =======");
        assertEquals(0, urine.countFreeUrinals("1001"));
    }

    @Test
    void countFreeUrinalsThree() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST THREE EXECUTED =======");
        assertEquals(3, urine.countFreeUrinals("00000"));
    }

    @Test
    void countFreeUrinalsFour() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST FOUR EXECUTED =======");
        assertEquals(2, urine.countFreeUrinals("0000"));
    }

    @Test
    void countFreeUrinalsFive() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST FIVE EXECUTED =======");
        assertEquals(1, urine.countFreeUrinals("01000"));
    }

    @Test
    void countFreeUrinalsSix() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST SIX EXECUTED =======");
        assertEquals(-1, urine.countFreeUrinals("011"));
    }
}
