package hw3_20001976_PhamBaThang.bai4;

import java.io.File;
import java.util.Scanner;

class GetText {
    static Scanner input = new Scanner(System.in);

    private static String[] fromFile() {
        System.out.print("Input your link to file:");
        try {
            File textFile = new File(input.nextLine());
            StringBuilder contents = new StringBuilder();
            input = new Scanner(textFile);
            while (input.hasNextLine()) {
                contents.append(input.nextLine().toLowerCase().replaceAll("[-+.^:,]", ""));
            }
            return contents.toString().split("\\s+");
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private static String[] fromInput() {
        System.out.println("Input your paragraph:");
        String contents = input.nextLine().toLowerCase().replaceAll("[-+.^:,]", "");
        return contents.split("\\s+");
    }

    public static String[] getText() {
        String option = "";
        while (!option.equals("1") && !option.equals("2") && !option.equals("0")) {
            System.out.print("Option:\n1.From File\n2.From Input\n0.Exit\nInput your option:");
            option = input.nextLine();
        }
        switch (option) {
            case "1":
                return fromFile();
            case "2":
                return fromInput();
            case "0":
                System.exit(0);
        }
        return null;
    }
}
