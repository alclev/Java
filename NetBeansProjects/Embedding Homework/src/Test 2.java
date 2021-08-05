
public class Test {

    public static void main(String[] args) {
        //Embedding test = new Embedding();
        System.out.println(Embedding.countEmbeddings("bar", "ababarra"));
        Embedding.countEmbeddings("bar", "ababarra"); // returns 2

        Embedding.countEmbeddings("cat", "acatbcata"); // returns 2

        Embedding.countEmbeddings("run", "rurrununn"); // returns 3

        Embedding.countEmbeddings("wxyz", "wxyzwxwxyzyz"); // returns 3

        Embedding.countEmbeddings("bar", "bababra"); // returns 0
    }
}
