package ca.leesoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuMatrix {
    List<List<Integer>> _matrix;
    public SudokuMatrix(){
        _matrix = new ArrayList<>();
    }

    private SudokuMatrix(List<List<Integer>> matrix){
        _matrix = matrix;
    }
    public void addFromLineString(String line){
        char[] chars = line.toCharArray();
        List<Integer> lineList = new ArrayList<>();
        for(int i=0; i< chars.length; i ++){
            lineList.add(Character.getNumericValue(chars[i]));
        }
        _matrix.add(lineList);
    }
    public void inspector(){
        _matrix.forEach(lineElement->{
            lineElement.forEach(element->{
                System.out.print(element+",");
            });
            System.out.println("");
        });
    }
    public boolean validateLine(){
        for (List<Integer> line : _matrix) {
            Set<Integer> verifier = new HashSet<>();
            if(line.size()!=this._matrix.size()){
                return false;
            }
            for (Integer num : line) {
                if(verifier.contains(num)){
                    return false;
                }else{
                    verifier.add(num);
                }
            }
        }
        return true;
    }

    public SudokuMatrix transform(){
        List<List<Integer>> matrix = this._matrix;
        List<List<Integer>> returnMatrix =  new ArrayList<>();

        for (List<Integer> line : matrix) {
            int count = 0;
            for (Integer integer : line) {
                final List<Integer> row;
                if(returnMatrix.size() <= count){
                    row = new ArrayList<>();
                    returnMatrix.add(row);
                }else {
                    row = returnMatrix.get(count);
                }
                row.add(integer);
                count ++ ;
            }

        }

        return new SudokuMatrix(returnMatrix);
    }
}
