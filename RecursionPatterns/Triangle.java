// package RecursionPatterns;/]

public class Triangle {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //Print using Recursion
        TriangleP1(5);
        Triangle2(5, 0);
        Triangle3(5, 0);
    }
    public static void TriangleP1(int n)
    {
        if(n==0) return;
        for(int i=0;i<n;i++)
        {
            System.out.print("#");
        }
        System.out.println();
        TriangleP1(n-1);
    }

    //We remove for loop from above code
    //for that we have to take one more variable
    public static void Triangle2(int row,int col)
    {
        if(row==0)
        return;
        else{
            if (col<row)
            {
                System.out.print("$");
                Triangle2(row, col+1);
            }
            else{
                System.out.println();
                Triangle2(row-1, 0);
            }
        }
    }

    //To reverse The Triangle

    public static void Triangle3(int row,int col)
    {
        if(row==0)
        return;
        else{
            if (col<row)
            {
                Triangle3(row, col+1);
                System.out.print("-");
            }
            else{
                Triangle3(row-1, 0);
                System.out.println();
            }
        }
    }
}
