import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;
import java.util.ArrayList;

public class mnister {
    public static void main (String args[]) {
        // Read file
        ArrayList<String[]> images = null;
        try {
            images = ReadFromFile("/home/serpial/Documents/twotwelvetasktwo/test-10.txt");
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i=0; i<images.size();i++) {
            makeAstrisky(images.get(i));
        }
    }

    private static void makeAstrisky(String[] number) {
        String[] line;

        System.out.println(number[0].charAt(0));
        for (int i=0; i<number.length; i++) {
            line = number[i].split("[\t ]+");
            for (int j=1; j<line.length;j++) {
                if (Integer.parseInt(line[j]) != 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    private static ArrayList<String[]> ReadFromFile(String fileName) throws Exception {
        ArrayList<String[]> numbers=new ArrayList<>();;
        ArrayList<String> allLines=new ArrayList<>();
        File fl = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fl));
        String tempStr = br.readLine();
        
        while (tempStr!= null) {
            allLines.add(tempStr);
            tempStr = br.readLine();
        }

        char currentNum = allLines.get(0).charAt(0);

        String theNumber[] = new String[28];
        for (int i=0; i<allLines.size(); i++) {
            if (allLines.get(i).charAt(0) != currentNum) {
                currentNum = allLines.get(i).charAt(0);
                numbers.add(theNumber);
                theNumber = new String[28];
            }
            theNumber[i%28] = allLines.get(i);
        }
        return numbers;
    }
}
