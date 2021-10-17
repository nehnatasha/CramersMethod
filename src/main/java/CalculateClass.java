import java.util.ArrayList;

public class CalculateClass {

//Вычисление дискриминанта матрицы
    public double determinantBigMatrix(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer startIndex){
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

//Вычисление произведения элементов главной диагонали матрицы
    private double calculateMainDiagonal(int[][] newArray){
        double result = 1;

        for (int i = 0; i < newArray.length; i++){
            result *= newArray[i][i];
        }
        return result;
    }

//Вычисление произведения элементов побочной диагонали матрицы
    private double calculateCollateralDiagonal(int[][] newArray){
        double result = 1;

        for (int i = 0; i < newArray.length; i++){
            result *= newArray[i][newArray.length - i -1];
        }
        return result;
    }
}
