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
    void Test1countFreeUrinals() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST ONE EXECUTED =======");
        assertEquals(1, m.countFreeUrinals("10001"));
    }

    @Test
    void Test2countFreeUrinals() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST TWO EXECUTED =======");
        assertEquals(0, m.countFreeUrinals("1001"));
    }

    @Test
    void Test3countFreeUrinals() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST THREE EXECUTED =======");
        assertEquals(3, m.countFreeUrinals("00000"));
    }

    @Test
    void Test4countFreeUrinals() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST FOUR EXECUTED =======");
        assertEquals(2, m.countFreeUrinals("0000"));
    }

    @Test
    void Test5countFreeUrinals() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST FIVE EXECUTED =======");
        assertEquals(1, m.countFreeUrinals("01000"));
    }

    @Test
    void Test6countFreeUrinals() {
        System.out.println("====== Sai Rithvik Vaikuntam == TEST SIX EXECUTED =======");
        assertEquals(-1, m.countFreeUrinals("011"));
    }

    @Test
    void Test1readFromFile() throws IOException {
        System.out.println("====== Sai Rithvik Vaikuntam == readFromFileOne == TEST ONE EXECUTED - Valid Case =======");
        String filePath = "src/urinal.dat";
        assertArrayEquals(new String[]{"10001", "1001", "00000", "0000", "01000", "011"}, m.readFromFile(filePath));
    }

    @Test
    void Test2FromFile() {
        System.out.println("====== Sai Rithvik Vaikuntam == readFromFileTwo == TEST TWO EXECUTED - File doesn't exist =======");
        String filePath = "urinal.dat1";
        assertThrows(FileNotFoundException.class, () -> {
            m.readFromFile(filePath);
        });
    }

    @Test
    void Test3FromFile() throws IOException {
        System.out.println("====== Sai Rithvik Vaikuntam == readFromFileThree == TEST THREE EXECUTED - Empty file =======");
        String filePath = "src/urinal.dat";
        String [] inputs = m.readFromFile(filePath);
        assertArrayEquals(inputs, m.readFromFile(filePath));
    }

    @Test
    void Test4readFromFile() {
        System.out.println("====== Sai Rithvik Vaikuntam == readFromFileFour == TEST FOUR EXECUTED - IOException =======");
        String filePath = "urinal";
        assertThrows(IOException.class, () -> {
            m.readFromFile(filePath);
        });
    }
}
