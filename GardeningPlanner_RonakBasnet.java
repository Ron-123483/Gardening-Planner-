
/**
 * File: [GardeningPlanner_RonakBasnet].
 * By: [Ronak Basnet]
 * Date: [3/9/2024]
 * Description: [This program prints gardening planner]
 */



import java.util.Scanner;

public class GardeningPlanner_RonakBasnet {

    public static void userInput() {
        char myDash = '-';
        int n = 89;
        String repeatDash = String.valueOf(myDash).repeat(n);
        System.out.println("\n" + repeatDash);

        System.out.print("Welcome to the CSC 215 Gardening Planner!");

        System.out.println("\n" + repeatDash);

        Scanner input = new Scanner(System.in);
        System.out.print("- Enter minimum temperature for plant: ");
        int minTemp = input.nextInt();

        System.out.print("- Enter maximum temperature for plant: ");
        int maxTemp = input.nextInt();

        System.out.print("- Enter maximum rainfall for plant: ");
        int minRain = input.nextInt();

        System.out.println(repeatDash + "\n");

        plantGrowth(minTemp, maxTemp, minRain);
    }

    public static void plantGrowth(int minTemp, int maxTemp, int minRain) {
        int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
        int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] plantGrowth = new int[12];
        int[] plantHeight = new int[12];
        String[] maxHeightArray = new String[12];

        for (int i = 0; i < avgTemp.length; i++) {
            if (avgTemp[i] < minTemp || avgTemp[i] > maxTemp) {
                plantGrowth[i] = -1;
            } else {
                plantGrowth[i] = avgRain[i] - minRain;
            }
        }
        plantHeight(plantHeight, plantGrowth);
        maxHeight(plantHeight, plantGrowth, maxHeightArray, months, avgRain, avgTemp);
    }

    public static void plantHeight(int[] plantHeight, int[] plantGrowth) {
        plantHeight[0] = plantGrowth[0];
        for (int i = 1; i < 12; i++) {
            plantHeight[i] = plantHeight[i - 1] + plantGrowth[i];
        }
    }

    public static void maxHeight(int[] plantHeight, int[] plantGrowth, String[] maxHeightArray, String[] months, int[] avgTemp, int[] avgRain) {
        final String textColor = "\u001B[30m" + "\u001B[43m";
        final String cancelColor = "\u001B[0m";


        int maxIndex = getIndexOfMaxHeight(plantHeight);
        maxHeightArray[maxIndex] = textColor + "MAX" + cancelColor;

        System.out.print("INDEX          MONTH          TEMPERATURE    RAINFALL       PLANT GROWTH   PLANT HEIGHT\n");
        for (int i = 0; i < 12; i++) {
            System.out.printf(" %-10s  %5s  %12s   %12s  %13s  %12s  %-8s\n", i, months[i], avgTemp[i], avgRain[i], plantGrowth[i], plantHeight[i], "  " + maxHeightArray[i]);


        }
        char myDash = '-';
        int y = 14;
        String repeatDashAgain = String.valueOf(myDash).repeat(y);
        System.out.println(repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain);
    }

    public static int getIndexOfMaxHeight(int[] plantHeight) {
        int maxHeight = 0;
        for (int i = 1; i < 12; i++) {
            if (plantHeight[i] > plantHeight[maxHeight]) {
                maxHeight = i;
            }
        }
        return maxHeight;
    }

    public static void main(String[] args) {
        userInput();
    }
}




//import java.util.Scanner;
//
//public class GardeningPlanner_RonakBasnet {
//
//    public static void userInput() {
//
//
//    }
//
//
//    public static void main(String[] args) {
//
//
//        char myDash = '-';
//        int n = 89;
//        int y = 14;
//        String repeatDash = String.valueOf(myDash).repeat(n);
//        System.out.println("\n" + repeatDash);
//
//        System.out.print("Welcome to the CSC 215 Gardening Planner!");
//
//        System.out.println("\n" + repeatDash);
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("- Enter minimum temperature for plant: ");
//        int minTemp = input.nextInt();
//
//        System.out.print("- Enter maximum temperature for plant: ");
//        int maxTemp = input.nextInt();
//
//        System.out.print("- Enter maximum rainfall for plant: ");
//        int minRain = input.nextInt();
//
//        System.out.println(repeatDash + "\n");
//
//        String repeatDashAgain = String.valueOf(myDash).repeat(y);
//        System.out.println(repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain);
//
//
//        int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
//        int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};
//        // to print month names in output
//        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
//        // to store plant growth and height calculations
//        int[] plantGrowth = new int[12];
//        int[] plantHeight = new int[12];
//        String[] maxHeightArray = new String[12];
//
//
//        int plantGrowthVar;
//
//
//        // --- start of calculations on Plant Growth -----
//        // if avgTemp <minm temp or > maxTemp, plantGrowth is -1 else avgRainfall - minRainforall
//        for (int i = 0; i < avgTemp.length; i++) {
//            if (avgTemp[i] < minTemp || avgTemp[i] > maxTemp) {
//                plantGrowth[i] = -1;
//            } else {
//                plantGrowth[i] = avgRain[i] - minRain;
//            }
//        }
//        // --- End of calculations on Plant Growth -----
//
//        // --- start of calculations on Plant Height -----
//        // plantHeight first element + sumofpreviousplantgrowths
//        // First element remains the same
//        plantHeight[0] = plantGrowth[0];
//
//        // for all the arrays, it's 12 months, so can do length or directly 12
//        for (int i = 1; i < 12; i++) {
//            plantHeight[i] = plantHeight[i - 1] + plantGrowth[i];
//
//        }
//        // --- End ---
//
//        // just assigning "MAX" in max index of array
//
//
//        final String textColor = "\u001B[30m" + "\u001B[43m";
//        final String cancelColor = "\u001B[0m";
//
//
//        int maxIndex = getIndexOfMaxHeight(plantHeight);
//        maxHeightArray[maxIndex] = textColor + "MAX" + cancelColor;
//
//
//        // Display the results in a tabular format
//        // \t fot tab(space) and \n for new line
//        System.out.print("INDEX          MONTH          TEMPERATURE    RAINFALL       PLANT GROWTH   PLANT HEIGHT\n");
//        for (int i = 0; i < 12; i++) {
//
//            System.out.printf(" %-10s  %5s  %12s   %11s  %13s  %13s  %-8s\n", i, months[i], avgTemp[i], avgRain[i], + plantGrowth[i], plantHeight[i], "  " + maxHeightArray[i]);
//
//            if(plantGrowth[i] == 1 && plantGrowth[i] == 2){
//            System.out.print("+" + plantGrowth[i]);
//
//            }
//
//            if(months[i].equals("Dec")){
//                System.out.printf(" %-10s  %5s  %12s   %11s  %13s  %13s  %-8s\n", i, months[i], avgTemp[i], avgRain[i], plantGrowth[i], plantHeight[i], "  " + textColor + "MAX" + cancelColor);
//            }else if(plantHeight[i] == 9){
//
//            }
//        }
//
//
//        System.out.println(repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain);
//    }
//
//    //method to get maximum index of array
//    public static int getIndexOfMaxHeight(int[] plantHeight) {
//        int maxHeight = 0;
//        for (int i = 1; i < 12; i++) {
//            if (plantHeight[i] > plantHeight[maxHeight]) {
//                maxHeight = i;
//            }
//        }
//        return maxHeight;
//    }
//
//
//    public static void plantGrowth() {
//
//    }
//
//    public static void plantHeight() {
//
//    }
//
//    public static void maxHeight() {
//
//    }
//
//
//}
//


//
//
//import java.util.Scanner;
//
//public class GardeningPlanner_RonakBasnet {
//
//    public static void userInput() {
//        char myDash = '-';
//        int n = 89;
//        String repeatDash = String.valueOf(myDash).repeat(n);
//        System.out.println("\n" + repeatDash);
//
//        System.out.print("Welcome to the CSC 215 Gardening Planner!");
//
//        System.out.println("\n" + repeatDash);
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("- Enter minimum temperature for plant: ");
//        int minTemp = input.nextInt();
//
//        System.out.print("- Enter maximum temperature for plant: ");
//        int maxTemp = input.nextInt();
//
//        System.out.print("- Enter maximum rainfall for plant: ");
//        int minRain = input.nextInt();
//
//        System.out.println(repeatDash + "\n");
//
//
//
//        plantGrowth(minTemp, maxTemp, minRain);
//    }
//
//    public static void plantGrowth(int minTemp, int maxTemp, int minRain) {
//
//        int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
//        int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};
//        // to print month names in output
//        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
//        // to store plant growth and height calculations
//        int[] plantGrowth = new int[12];
//        int[] plantHeight = new int[12];
//        String[] maxHeightArray = new String[12];
//
//
//        // int plantGrowthVar = 0;
//
//
//        // --- start of calculations on Plant Growth -----
//        // if avgTemp <minm temp or > maxTemp, plantGrowth is -1 else avgRainfall - minRainforall
//        for (int i = 0; i < avgTemp.length; i++) {
//            if (avgTemp[i] < minTemp || avgTemp[i] > maxTemp) {
//                plantGrowth[i] = -1;
//            } else {
//                plantGrowth[i] = avgRain[i] - minRain;
//            }
//
//        }
//        plantHeight(plantHeight, plantGrowth);
//        maxHeight(plantHeight, plantGrowth, maxHeightArray, months, avgRain, avgTemp);
//
//
//    }
//
//
//    public static void plantHeight(int[] plantGrowth, int[] plantHeight) {
//
//        plantHeight[0] = plantGrowth[0];
//
//        for (int i = 1; i < 12; i++) {
//            plantHeight[i] = plantHeight[i - 1] + plantGrowth[i];
//
//        }
//
//    }
//
//    public static void maxHeight(int[] plantHeight, int[] plantGrowth, String[] maxHeightArray, String [] months, int[]avgTemp, int[] avgRain) {
//
//        final String textColor = "\u001B[30m" + "\u001B[43m";
//        final String cancelColor = "\u001B[0m";
//
//
//        int maxIndex = getIndexOfMaxHeight(plantHeight);
//        maxHeightArray[maxIndex] = textColor + "MAX" + cancelColor;
//
//
//        // Display the results in a tabular format
//        // \t fot tab(space) and \n for new line
//        System.out.print("INDEX          MONTH          TEMPERATURE    RAINFALL       PLANT GROWTH   PLANT HEIGHT\n");
//        for (int i = 0; i < 12; i++) {
//
//            System.out.printf(" %-10s  %5s  %12s   %11s  %13s  %13s  %-8s\n", i, months[i], avgTemp[i], avgRain[i], +plantGrowth[i], plantHeight[i], "  " + maxHeightArray[i]);
//
//            if (plantGrowth[i] == 1 && plantGrowth[i] == 2) {
//                System.out.print("+" + plantGrowth[i]);
//
//            }
//
//            if (months[i].equals("Dec")) {
//                System.out.printf(" %-10s  %5s  %12s   %11s  %13s  %13s  %-8s\n", i, months[i], avgTemp[i], avgRain[i], plantGrowth[i], plantHeight[i], "  " + textColor + "MAX" + cancelColor);
//            } else if (plantHeight[i] == 9) {
//
//            }
//        }
//
//        char myDash = '-';
//        int y = 14;
//        String repeatDashAgain = String.valueOf(myDash).repeat(y);
//        System.out.println(repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain + " " + repeatDashAgain);
//
//    }
//
//    //method to get maximum index of array
//    public static int getIndexOfMaxHeight(int[] plantHeight) {
//        int maxHeight = 0;
//        for (int i = 1; i < 12; i++) {
//            if (plantHeight[i] > plantHeight[maxHeight]) {
//                maxHeight = i;
//            }
//        }
//        return maxHeight;
//    }
//
//
//
//
//
//    public static void main(String[] args) {
//        userInput();
//
//
//
//    }
//}






















