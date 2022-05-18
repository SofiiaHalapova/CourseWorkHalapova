package courseWorkHalapova;

import java.util.HashMap;
import java.util.Map;

public class Model{
    private String firstNum;
    private String comRat;
    private String numTerms;

    public Model(String firstNum, String comRat, String numTerms){
        this.firstNum = firstNum;
        this.comRat = comRat;
        this.numTerms = numTerms;
    }

    public String getFirstNum() {
        return firstNum;
    }

    public String getComRat() {
        return comRat;
    }

    public String getNumTerms() {
        return numTerms;
    }

    public Map<Integer, Long> getDegrees(int firstNum, int comRat, int n) {
        Map<Integer, Long> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.put(firstNum, (long) Math.pow(comRat, firstNum));
            firstNum++;
        }
        return result;
    }

}

