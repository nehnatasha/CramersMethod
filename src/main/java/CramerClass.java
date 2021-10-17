import java.util.ArrayList;

public class CramerClass {
    /**
     * Инициализация дополненной матрицы для определения ее дискрименанта
     *
     * @param matrix
     * @return
     */
    public static ArrayList<ArrayList<Integer>> createAdditionalMatrix(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<ArrayList<Integer>> additionalMatrix = new ArrayList<>(); //главный массив.

        for (ArrayList<Integer> matrixRow : matrix) {
            ArrayList<Integer> additionalMatrixRow = (ArrayList<Integer>) matrixRow.clone();

            for (int i = 0; i < matrixRow.size() - 1; i++) {
                additionalMatrixRow.add(matrixRow.get(i));
            }

            additionalMatrix.add(additionalMatrixRow);
        }

        return additionalMatrix;
    }

    /**
     * Cоздание дельта-матриц для нахождения их дискриминанта
     *
     * @param matrix, n, result
     * @return
     */
    public static ArrayList<ArrayList<Integer>> createDeltaMatrix(ArrayList<ArrayList<Integer>> matrix, int n, ArrayList<Integer> result) {
        ArrayList<ArrayList<Integer>> deltaMatrix = cloneArray(matrix);
        for (int i = 0; i < matrix.size(); i++) {
            deltaMatrix.get(i).set(n, result.get(i));
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.size()-1; j++) {
                deltaMatrix.get(i).add(deltaMatrix.get(i).get(j));
            }
        }

        return deltaMatrix;
    }

    /**
     * Метод для глубокого копирования массива
     *
     * @param array
     * @return
     */
    //глубокое копирование массива
    private static ArrayList<ArrayList<Integer>> cloneArray(ArrayList<ArrayList<Integer>> array){
        ArrayList<ArrayList<Integer>> deltaMatrix = new ArrayList<>();
        for (int i = 0; i < array.size(); i++){
            deltaMatrix.add((ArrayList<Integer>) array.get(i).clone());
        }
        return deltaMatrix;
    }
}
