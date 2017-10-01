package ca.leesoft;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception{
        final String filePath;
        if(args.length == 0){
            System.out.println("Need to provide the source file path");
            System.exit(1);
            return;
        }else{
            filePath = args[0];
        }
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        SudokuMatrix matrix = new SudokuMatrix();
        try {

            while (true){
                String line = br.readLine();
                if(line == null){
                    break;
                }
                matrix.addFromLineString(line);
            }
            matrix.inspector();
            if(matrix.validateLine() && matrix.transform().validateLine()){
                System.out.println("It is correct");
            }else{
                System.out.println("It is incorrect");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            br.close();
        }
    }
}
