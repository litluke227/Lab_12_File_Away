import java.util.Scanner;

public class SafeInput {
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern){
        String value = "";
        boolean done = false;
        do{
            System.out.print(prompt +":");
            value = pipe.nextLine();
            if(value.matches(regExPattern)){
                done = true;

            }
            else{
                System.out.println("\n Invalid Input: " + value);
            }

        }while(!done);
        return value;
    }

    public static String getNonZeroLenString(Scanner pipe, String prompt){
        String retString = "";
        do{
            System.out.println("\n" +prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt){
        int input = 0;
        boolean done = false;
        do{
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextInt()){
                input = pipe.nextInt();
                done = true;
            }
            else{
                System.out.println("Invalid input!");
            }
            pipe.nextLine();
        }while(!done);
        return input;

    }

    public static double getDouble(Scanner pipe, String prompt){
        double input = 0.0;
        boolean done = false;
        do{
            System.out.println("\n" + prompt + ": ");
            if (pipe.hasNextDouble()){
                input = pipe.nextDouble();
                done = true;
            }
            else{
                System.out.println("Invalid input!");
            }
            pipe.nextLine();
        }while(!done);
        return input;

    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int input = 0;
        boolean done = false;
        do{
            System.out.println("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()){
                input = pipe.nextInt();
                if (input >= low && input <= high){
                    done = true;
                }
                else{
                    System.out.println("Invalid number, try again in the range.");
                }
            }
        }while(!done);
        return input;

    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high){
        double input = 0;
        boolean done = false;
        do{
            System.out.println("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()){
                input = pipe.nextDouble();
                if (input >= low && input <= high){
                    done = true;
                }
                else{
                    System.out.println("Invalid number, try again in the range.");
                }
            }
        }while(!done);
        return input;

    }
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        String input = "";
        boolean done = false;
        do{
            System.out.println("\n" + prompt + " [Y/N]: ");
            input = pipe.nextLine();
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")){
                done = true;
            }
            else{
                System.out.println("Please enter Y or N");
            }
        }while(!done);
        return input.equalsIgnoreCase("Y");
    }
        public static void prettyHeader(String msg) {
            final int totalWidth = 60;
            final int borderWidth = 3;
            final int innerWidth = totalWidth - (2 * borderWidth);
            for (int i = 0; i < totalWidth; i++) {
                System.out.print("*");
            }
            System.out.println();
            int msgLength = msg.length();
            int leftPadding = (innerWidth - msgLength) / 2;
            int rightPadding = innerWidth - msgLength - leftPadding;
            System.out.print("***");
            for (int i = 0; i < leftPadding; i++) {
                System.out.print(" ");
            }
            System.out.print(msg);
            for (int i = 0; i < rightPadding; i++) {
                System.out.print(" ");
            }
            System.out.println("***");
            for (int i = 0; i < totalWidth; i++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }


