
import java.util.List;

public class NewClass {
    public void insert (List<String> list, String element) {
    int index = 0;
    while (element.compareTo(list.get(index)) < 0)
        index++;
    list.add(index, element);

}
    public static void main(String [] args){
        
    }
}
