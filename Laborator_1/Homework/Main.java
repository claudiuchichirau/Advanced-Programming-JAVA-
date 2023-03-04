public class Main {
    public static void CreateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i + j >= n)
                    matrix[i][j] = i + j + 1 - n;
                else
                    matrix[i][j] = i + j + 1;

            }

        if (n < 30000) {
            for (int i = 0; i < n; i++) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    line.append(matrix[i][j] + " ");
                }
                System.out.println(line);
            }
        }
    }

    public static void main(String[] args) {

        if (args.length == 0)
            System.out.println("Nu exista argumente");

        int n=0;
        try
        {
            n = Integer.parseInt(args[0]);
        }
        catch (Exception e)
        {
            System.out.println(("Argumentul dat este invalid!"));
        }

        CreateMatrix(n);

        if (n >= 30000) {
            long startTime = System.currentTimeMillis();

            int k = 0;
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    k++;
                }

            long endTime = System.currentTimeMillis();

            System.out.println("Running time: " + (endTime - startTime));
        }
    }
}
