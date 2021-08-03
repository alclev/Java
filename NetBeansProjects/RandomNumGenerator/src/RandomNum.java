
import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    private List<Integer> ary;
    private double rangeMax;
    private int sizeOfList;

    public RandomNum(int sizeOfList, int rangeMax) {
        ary = new ArrayList<Integer>();
        this.rangeMax = rangeMax;
        this.sizeOfList = sizeOfList;
    }

    private int Generator() {
        return (int) (1 + Math.random() * rangeMax);
    }

    public String SetOfRandNums() {
        int i = 0;
        while (i < sizeOfList) {
            Integer num = Generator();
            if (!ary.contains(num)) {
                ary.add(num);
                i++;
            }
        }
        return ary.toString();
    }

    public int getSize() {
        return ary.size();
    }
}
