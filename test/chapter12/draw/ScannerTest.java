package chapter12.draw;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {
    @Test
    void testReadLine() {
        Scanner in = new Scanner("N 2");
        assertEquals("N 2", in.nextLine());
    }
}
