package functional.principles;

public class ImpureMethod {
    int m = 5;
    // Nakhales : chon be meghdari kharej az khodesh bastegi dare.
    public int sum(int a, int b){
        return a + b + m;
    }
    // Nakhales : chon yek meghdar kharej as khodesh ra tagiir mide.
    public int nakhales2(int a, int b){
        m++;
        return a + b;
    }
    // Nakhales : chon dar console tageer ijad mikonad.
    public void print(String s){
        System.out.println(s);
    }
}
