import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        CalculateClass calculateClass = new CalculateClass();
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(); //главный массив.
        ArrayList<ArrayList<Integer>> matrixMain = new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        int matrixSize = 0;
        int mainMatrixSize = 0;
        double termite = 0.0;
        ArrayList<Double> deltaAnswers = new ArrayList<>();


        //Первоначальный массив
        String matrixStr = "3 -2 4\n3 4 -2\n2 -1 -1";
        String[] matrixRowsStr = matrixStr.split("\n");
        matrixSize = matrixRowsStr.length;

        //Результаты равенст
        String resultStr = "21 9 10";
        String[] resultRowsStr = resultStr.split(" ");
        //Заполнение массива данными равенств
        for (String resultRowStr : resultRowsStr) {
            result.add(Integer.parseInt(resultRowStr));
        }

        //Инициализация дополненной матрицы для определения ее дискрименанта
        for (String matrixRowStr : matrixRowsStr) {
            String[] matrixRowArr = matrixRowStr.split(" ");
            ArrayList<Integer> matrixRow = new ArrayList<>();
            for (String elStr : matrixRowArr) {
                matrixRow.add(Integer.parseInt(elStr));
            }
            for (int i = 0; i < matrixRowArr.length - 1; i++) {
                matrixRow.add(Integer.parseInt(matrixRowArr[i]));
            }
            matrix.add(matrixRow);
        }

        //Инициализация главной матрицы
        for (String matrixRowStr : matrixRowsStr) {
            String[] matrixRowArr = matrixRowStr.split(" ");
            ArrayList<Integer> matrixRow = new ArrayList<>();
            for (String elStr : matrixRowArr) {
                matrixRow.add(Integer.parseInt(elStr));
            }
            matrixMain.add(matrixRow);
        }

        //Вычисление дискрименанта главной матрицы (используя дополненную матрицу)
        for (int i = 0; i < matrixSize; i++) {
            termite += calculateClass.determinantBigMatrix(matrix, matrixSize, i);
        }

//Проверка, что система имеет решение
        if (termite != 0) {
            System.out.println("Система имеет единственное решение");
        } else {
            System.out.println("Система не имеет единственного решения");
        }

        ArrayList<Double> answers = new ArrayList<>();
        ArrayList<Double> answer = new ArrayList<>();
        //Составление дельта-матриц
        //Вычисление дискрименанта дельта-матриц
        for (int n = 0; n < matrixSize; n++) {
            ArrayList<ArrayList<Integer>> deltaMatrix = cloneArray(matrixMain);
            for (int i = 0; i < matrixMain.size(); i++) {
                deltaMatrix.get(i).set(n, result.get(i));
            }
            for (int i = 0; i < matrixMain.size(); i++) {
                for (int j = 0; j < matrixMain.size()-1; j++) {
                    deltaMatrix.get(i).add(deltaMatrix.get(i).get(j));
                }
            }

            double resultDeltaMatrix = 0.0;
            answers.clear();
            for (int i = 0; i < matrixSize; i++) {
                answers.add(calculateClass.determinantBigMatrix(deltaMatrix, deltaMatrix.size(), i));// тут будут храниться все решения для матриц
            }

            for (int i = 0; i < answers.size(); i++){
                resultDeltaMatrix += answers.get(i);
            }
            answer.add(resultDeltaMatrix);
        }

        for (int i = 0; i < answer.size(); i ++){
            deltaAnswers.add(answer.get(i) / termite);
        }
        System.out.println(deltaAnswers);
    }

    //глубокое копирование массива
    public static ArrayList<ArrayList<Integer>> cloneArray(ArrayList<ArrayList<Integer>> array){
        ArrayList<ArrayList<Integer>> deltaMatrix = new ArrayList<>();
        for (int i = 0; i < array.size(); i++){
            deltaMatrix.add((ArrayList<Integer>) array.get(i).clone());
        }
        return deltaMatrix;
    }
}


