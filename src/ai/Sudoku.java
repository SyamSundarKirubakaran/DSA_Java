package ai;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sudoku {

    private static String rows = "ABCDEFGHI";
    private static String columns = "123456789";
    private static String allDigits = "123456789";

    private static Map<String, String> sudokuMapper = new LinkedHashMap<>();

    private static String sudokuFiller = "..3.2.6..9..3.5..1..18.64....81.29..7.......8..67.82....26.95..8..2.3..9..5.1.3..";

    private static String[][] resultantGrid = new String[rows.length()][columns.length()];

    public static void main(String[] args) {
        inflateGrid();
        replaceDots();
//        while (shouldContinue()) {
//            reductionAndElimination();
//            onlyChoiceReduction();
//        }
        reductionAndElimination();
        onlyChoiceReduction();
        reductionAndElimination();
        onlyChoiceReduction();
        reductionAndElimination();
        onlyChoiceReduction();
        reductionAndElimination();
        onlyChoiceReduction();
        reductionAndElimination();
        onlyChoiceReduction();
    }

//    private static boolean shouldContinue() {
//        boolean shouldContinue = false;
//        for (int i = 0; i < rows.length(); i++) {
//            for (int j = 0; j < columns.length(); j++) {
//                if (resultantGrid[i][j].length() == allDigits.length()) {
//                    shouldContinue = true;
//                    break;
//                }
//            }
//        }
//        return shouldContinue;
//    }

    private static void onlyChoiceReduction() {
        // peer reduction
        int startRow = 0;
        int startColumn = 0;

        while (startRow < rows.length()) {
            HashSet<String> tempSet = new HashSet<>();
            Map<Character, Integer> countMap = new LinkedHashMap<>();
            HashSet<String> uniqueCharSet = new HashSet<>();

            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startColumn; j < startColumn + 3; j++) {
                    if (resultantGrid[i][j].trim().length() == allDigits.length()) {
                        tempSet.add(resultantGrid[i][j].trim());
                    }
                }
            }

            for (String s : tempSet) {
                for (char ch : s.toCharArray()) {
                    countMap.merge(ch, 1, Integer::sum);
                }
            }

            System.out.println(countMap);

            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == 1) {
                    uniqueCharSet.add(String.valueOf(entry.getKey()));
                }
            }

            System.out.println("Unique Char Set: " + uniqueCharSet);

            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startColumn; j < startColumn + 3; j++) {
                    if (resultantGrid[i][j].trim().length() == allDigits.length()) {
                        for (String uniqueChar : uniqueCharSet) {
                            if (resultantGrid[i][j].contains(uniqueChar)) {
                                resultantGrid[i][j] = "    " + uniqueChar + "    ";
                            }
                        }
                    }
                }
            }

            startColumn += 3;
            if (startColumn >= columns.length()) {
                startColumn = 0;
                startRow += 3;
            }
        }

        printSudokuGrid();
    }

    private static void reductionAndElimination() {
        // pre calculation
        Map<Integer, HashSet<String>> rowMap = new LinkedHashMap<>();
        Map<Integer, HashSet<String>> columnMap = new LinkedHashMap<>();
        Map<String, HashSet<String>> peerMap = new LinkedHashMap<>();

        // row and column reduction
        for (int i = 0; i < rows.length(); i++) {
            HashSet<String> rowTempSet = new HashSet<>();
            HashSet<String> columnTempSet = new HashSet<>();
            for (int j = 0; j < columns.length(); j++) {
                if (resultantGrid[i][j].trim().length() != allDigits.length()) {
                    rowTempSet.add(resultantGrid[i][j].trim());
                }
                if (resultantGrid[j][i].trim().length() != allDigits.length()) {
                    columnTempSet.add(resultantGrid[j][i].trim());
                }
            }
            rowMap.put(i, rowTempSet);
            columnMap.put(i, columnTempSet);
        }
        System.out.println(rowMap);
        System.out.println(columnMap);

        // peer reduction
        int startRow = 0;
        int startColumn = 0;

        while (startRow < rows.length()) {
            HashSet<String> tempSet = new HashSet<>();
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startColumn; j < startColumn + 3; j++) {
                    if (resultantGrid[i][j].trim().length() != allDigits.length()) {
                        tempSet.add(resultantGrid[i][j].trim());
                    }
                }
            }
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startColumn; j < startColumn + 3; j++) {
                    peerMap.put(i + "_" + j, tempSet);
                }
            }
            startColumn += 3;
            if (startColumn >= columns.length()) {
                startColumn = 0;
                startRow += 3;
            }
        }
        System.out.println(peerMap);
        printSudokuGrid();

        // actual elimination
        HashSet<String> selectedRow;
        HashSet<String> selectedColumn;
        HashSet<String> selectedPeer;
        String tempString;
        for (int i = 0; i < rows.length(); i++) {
            for (int j = 0; j < columns.length(); j++) {
                selectedRow = rowMap.get(i);
                selectedColumn = columnMap.get(j);
                selectedPeer = peerMap.get(i + "_" + j);
                if (resultantGrid[i][j].trim().length() == allDigits.length()) {
                    tempString = resultantGrid[i][j];
                    for (String a : selectedRow) {
                        tempString = tempString.replaceAll(a.trim(), "_");
                    }
                    for (String b : selectedColumn) {
                        tempString = tempString.replaceAll(b.trim(), "_");
                    }
                    for (String c : selectedPeer) {
                        tempString = tempString.replaceAll(c.trim(), "_");
                    }
                    resultantGrid[i][j] = tempString;
                }
            }
        }
        printSudokuGrid();
    }

    private static void replaceDots() {
        for (int i = 0; i < rows.length(); i++) {
            for (int j = 0; j < columns.length(); j++) {
                if (!resultantGrid[i][j].equals(".")) {
                    resultantGrid[i][j] = "    " + resultantGrid[i][j] + "    ";
                } else {
                    resultantGrid[i][j] = allDigits;
                }
            }
        }
        printSudokuGrid();
    }

    private static void inflateGrid() {
        int count = 0;
        char[] sudokuFillerCharArray = sudokuFiller.toCharArray();

        char[] rowCharArray = rows.toCharArray();
        char[] columnCharArray = columns.toCharArray();

        for (int i = 0; i < rows.length(); i++) {
            for (int j = 0; j < columns.length(); j++) {
                resultantGrid[i][j] = String.valueOf(sudokuFillerCharArray[count]);
                sudokuMapper.put(rowCharArray[i] + "" + columnCharArray[j], resultantGrid[i][j]);
                count += 1;
            }
        }
        printSudokuGrid();
    }


    private static void printSudokuGrid() {
        System.out.print("-------------------------------");
        System.out.println();
        for (int i = 0; i < rows.length(); i++) {
            for (int j = 0; j < columns.length(); j++) {
                if (j % 3 == 0) {
                    System.out.print("|");
                }
                System.out.print(" " + resultantGrid[i][j] + " ");
                if (j == rows.length() - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0) {
                System.out.print("-------------------------------");
                System.out.println();
            }
        }
    }

}
