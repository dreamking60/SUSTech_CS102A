public class Compare {
    public void Compare(String s1, String s2){
        int k = 0;

        k = s1.indexOf(s2,k);
        Compare(s1,s2);
    }
}
