import java.util.ArrayList;

public class CramerClass {

    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(); //дополненная матрица.
    ArrayList<ArrayList<Integer>> matrixMain = new ArrayList<>(); //главная матрица - входные данные

    public ArrayList<ArrayList<Integer>> initAdditionalArray(String[] matrixRowsStr){
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
        return matrix;
    }

    public ArrayList<ArrayList<Integer>> initMainArray(String[] matrixRowsStr) {
        for (String matrixRowStr : matrixRowsStr) {
            String[] matrixRowArr = matrixRowStr.split(" ");
            ArrayList<Integer> matrixRow = new ArrayList<>();
            for (String elStr : matrixRowArr) {
                matrixRow.add(Integer.parseInt(elStr));
            }
            matrixMain.add(matrixRow);
        }
        return matrixMain;
    }
}
