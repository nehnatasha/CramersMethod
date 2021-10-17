import java.util.ArrayList;

public class CalculateClass {

    /**
     *Метод для вызова вычисления дискриминанта матрицы
     *
     * @param matrix,size
     * @return
     */
    public static double calculateDeterminant(ArrayList<ArrayList<Integer>> matrix, int size) {
        double determinant = 0.0;

        for (int i = 0; i < size; i++) {
            determinant += determinantBigMatrix(matrix, size, i);
        }

        return determinant;
    }

    /**
     *Метод для вычисления дискриминанта дельта-матриц
     *
     * @param deltaMatrix,mainMatrixSize
     * @return
     */
    public static double calculateDeltaMatrixDeterminant(ArrayList<ArrayList<Integer>> deltaMatrix, int mainMatrixSize) {
        double determinant = 0.0;
        ArrayList<Double> answers = new ArrayList<>();

        for (int i = 0; i < mainMatrixSize; i++) {
            answers.add(CalculateClass.determinantBigMatrix(deltaMatrix, deltaMatrix.size(), i));// тут будут храниться все решения для матриц
        }

        for (int i = 0; i < answers.size(); i++){
            determinant += answers.get(i);
        }

        return determinant;
    }

    /**
     *Метод для вычисления дискриминанта матрицы
     *
     * @param matrix,n,startIndex
     * @return
     */
    public static double determinantBigMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer startIndex){
        int[][] newArray = new int[n][n];
        ArrayList<Double> elemOfMainDiag = new ArrayList<>();
        ArrayList<Double> elemOfCollDiag = new ArrayList<>();
        double firstResult = 0.0;
        double secondResult = 0.0;
        double mainResult = 0.0;

        //Если строк-столбцов в матрице не равно 2
        if (n != 2) {
            for (int i = 0; i < n; i++) {
                for (int j = startIndex; j < startIndex + n; j++) {
                    newArray[i][j - startIndex] = matrix.get(i).get(j);
                }
            }

            firstResult = calculateMainDiagonal(newArray);
            secondResult = calculateCollateralDiagonal(newArray);
            mainResult = firstResult - secondResult;

        //Если строк-столбцов в матрице равно 2
        } else {
            mainResult = (matrix.get(0).get(0) * matrix.get(1).get(1)) - (matrix.get(1).get(0) * matrix.get(0).get(1));
        }
        return mainResult;
    }

    /**
     *Метод для вычисления произведения элементов главной диагонали матрицы
     *
     * @param newArray
     * @return
     */
    private static double calculateMainDiagonal(int[][] newArray){
        double result = 1;

        for (int i = 0; i < newArray.length; i++){
            result *= newArray[i][i];
        }
        return result;
    }

    /**
     *Метод для вычисления произведения элементов побочной диагонали матрицы
     *
     * @param newArray
     * @return
     */
    private static double calculateCollateralDiagonal(int[][] newArray){
        double result = 1;

        for (int i = 0; i < newArray.length; i++){
            result *= newArray[i][newArray.length - i -1];
        }
        return result;
    }
}
