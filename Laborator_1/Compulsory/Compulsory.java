public class lab1 {
    public static void main(String args[]) {
        System.out.println("Hello world!");
        String languages[] =  {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        n=n*3;
        n=n+0b10101;
        n=n+0xFF;
        n=n*6;

        int result;
        do
        {
            result = 0;
            while(n>0)
            {
                result=result+n%10;
                n=n/10;
            }
            n=result;
        }while(result>9);

        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
