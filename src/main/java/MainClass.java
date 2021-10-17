import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        //Первоначальный массив
        String matrixStr = "3 -2 4\n3 4 -2\n2 -1 -1";
        ArrayList<ArrayList<Integer>> matrixMain = parseMatrixFromString(matrixStr);
        int mainMatrixSize = matrixMain.size();

        ArrayList<ArrayList<Integer>> additionalMatrix = CramerClass.createAdditionalMatrix(matrixMain);

        //Результаты равенств
        String resultStr = "21 9 10";
        ArrayList<Integer> result = parseArrayFromString(resultStr);

        double determinant = CalculateClass.calculateDeterminant(additionalMatrix, mainMatrixSize);

        //Проверка, что система имеет решение
        if (determinant != 0) {
            System.out.println("Система имеет единственное решение");
        } else {
            System.out.println("Система не имеет единственного решения");
            return;
        }

        ArrayList<Double> answer = new ArrayList<>();
        //Составление дельта-матриц
        //Вычисление дискрименанта дельта-матриц
        for (int n = 0; n < mainMatrixSize; n++) {
            ArrayList<ArrayList<Integer>> deltaMatrix = CramerClass.createDeltaMatrix(matrixMain, n, result);
            answer.add(CalculateClass.calculateDeltaMatrixDeterminant(deltaMatrix, mainMatrixSize));
        }

        ArrayList<Double> deltaAnswers = new ArrayList<>();
        for (int i = 0; i < answer.size(); i ++){
            deltaAnswers.add(answer.get(i) / determinant);
        }
        System.out.println(deltaAnswers);
    }

    /**
     *
     *
     * @param matrixStr
     * @return
     */
    private static ArrayList<ArrayList<Integer>> parseMatrixFromString(String matrixStr) {
        String[] matrixRowsStr = matrixStr.split("\n");
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (String matrixRowStr : matrixRowsStr) {
            matrix.add(parseArrayFromString(matrixRowStr));
        }

        return matrix;
    }

    /**
     *
     *
     * @param arrayStr
     * @return
     */
    private static ArrayList<Integer> parseArrayFromString(String arrayStr) {
        ArrayList<Integer> array = new ArrayList<>();
        String[] arrayElementsStr = arrayStr.split(" ");

        for (String elementStr : arrayElementsStr) {
            array.add(Integer.parseInt(elementStr));
        }

        return array;
    }
}


