import java.util.logging.Logger;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void main() throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        Logger logger = Logger.getLogger(Main.class.getName());

        int [][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int [][] matrix2 = {{9,8,0},{2,1,3},{4,5,6}};
        int [][] result =  {{25,25,24}, {70,67,51}, {115,109,78}};

        Matrix m1 = new Matrix(3, 3, matrix1);
        Matrix m2 = new Matrix(3, 3, matrix2);


        if (m1.possibleMultiply(m2)) {
            Multiply multiply = new Multiply(m1, m2);
            Matrix res =  multiply.multiply(m1, m2, cores);
            res.getData();
            assertArrayEquals(res.getData(),result);
        } else
            logger.info("Impossible process matrix");
    }
}