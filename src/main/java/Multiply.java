public class Multiply extends Thread{

    Matrix firstMatrix, secondMatrix, resultMatrix;
    int start, finish;

    public Multiply(Matrix firstMatrix, Matrix secondMatrix) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
    }

    public Multiply(Matrix firstMatrix, Matrix secondMatrix, Matrix resultMatrix, int start, int finish) {
        this.firstMatrix = firstMatrix;
        this.secondMatrix = secondMatrix;
        this.resultMatrix = resultMatrix;
        this.start = start;
        this.finish = finish;
    }

    @Override
    public void run() {
        int column = secondMatrix.getData()[0].length;
        for (int i = start; i < finish; i++) {
            calculate(i / column, i % column);
        }
        System.out.println(getName() + " processed.");
    }

    private void calculate(int row, int column) {
        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += this.firstMatrix.getCell(row, i) * this.secondMatrix.getCell(i, column);
        }
        resultMatrix.setCell(row,column, result);
    }

    public Matrix multiply (Matrix firstMatrix, Matrix secondMatrix, int threads) throws InterruptedException {
        int row = firstMatrix.getRow();
        int column = secondMatrix.getColumn();
        Matrix resMatrix = new Matrix(row,column);

        int threadingMultiply = (row * column) / threads;
        int startIndex = 0;
        Multiply[] multiplies = new Multiply[threads];

        for (int i = threads-1; i >= 0; --i) {
            int lastIndex = startIndex + threadingMultiply;
            if (i == 0) {
                lastIndex = row * column;
            }
            multiplies[i] =  new Multiply(firstMatrix, secondMatrix, resMatrix, startIndex, lastIndex);
            multiplies[i].start();
            startIndex = lastIndex;

        }
        for (Multiply multiply:multiplies) {
            multiply.join();
        }
        return resMatrix;
    }

}
