
public class Embedding {

    String conc;
    int tot = 0;

    private String aStr;
    private String bStr;

    public Embedding(String aStr, String bStr) {
        this.aStr = aStr;
        this.bStr = bStr;
    }

    public Embedding() {

    }

    public static int countEmbeddings(String aStr, String bStr) {
        String conc;
        int tot = 0;
        if (bStr.indexOf(aStr) == -1) {
            return tot;
        } else {
            conc = bStr.substring(0, bStr.indexOf(aStr)) + bStr.substring(bStr.indexOf(aStr) + aStr.length());

            return tot + 1 + countEmbeddings(aStr, conc);
        }

    }
}
