import java.util.Random;

public class Matrix {

    private int column;
    private int row;

    private int [][] data;

    public Matrix() {
    }

    public Matrix(int column, int row) {
        this.column = column;
        this.row = row;
        this.data =  new int [row][column];
    }

    public Matrix(int[][] data) {
        this.data = data;
    }

    public Matrix(int column, int row, int[][] data) {
        this.column = column;
        this.row = row;
        this.data = data;
    }

    public Matrix generateCells() {
        Random random = new Random();
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.column ; j++) {
                data[i][j] = random.nextInt(100);
            }
        }
        return this;
    }

    public int getCell (int row, int column) {
        return this.data[row][column];
    }

    public void setCell (int row, int column, int data) {
        this.data[row][column] = data;
    }


    public boolean possibleMultiply (Matrix secondMatrix) {
        if (this.column == secondMatrix.getRow())
            return true;
        else
            return false;
    }
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public void printData () {
        for (int i = 0; i < this.getRow(); i++) {
            for (int j = 0; j < this.getColumn(); j++) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println("\n");
        }
    }

}
