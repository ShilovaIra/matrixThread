import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        Logger logger = Logger.getLogger(Main.class.getName());

        Matrix m1 = new Matrix(100, 200);
        m1.generateCells();
        m1.printData();

        Matrix m2 = new Matrix(200, 100);
        m2.generateCells();
        m2.printData();

        if (m1.possibleMultiply(m2)) {
            Multiply multiply = new Multiply(m1, m2);
            Matrix res =  multiply.multiply(m1, m2, cores);
            res.printData();
        } else
            logger.info("Impossible process matrix");

    }

}
