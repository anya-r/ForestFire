import java.util.*;

public class BacktrackingProbs

{
    private void printBinaryHelper(int digits, String soFar)
    {
        if (soFar.length() == digits)
            System.out.print(soFar + " ");
        else
        {
            printBinaryHelper(digits, soFar + 0);
            printBinaryHelper(digits, soFar + 1);

        }
    }
    public void printBinary(int digits)
    {
        printBinaryHelper(digits, "");
    }




    private void climbStairsHelper(int steps, String sol)
    {
        if (steps < 0)
            return;
        if (steps == 0)
        {
            System.out.println(sol);
            return;
        }
        climbStairsHelper(steps - 1, sol + "1 ");
        climbStairsHelper(steps - 2, sol + "2 ");

    }
    public void climbStairs(int steps)
    {
        climbStairsHelper(steps, "");
    }


    //campsite
    private void campsiteHelper(int x, int y, String soFar)
    {
        if (x == 0 && y == 0)
            System.out.println(soFar + " ");
        //
        if (x > 0)
            campsiteHelper(x - 1, y, soFar + "E ");    
        if (y > 0)
            campsiteHelper(x, y - 1, soFar + "N "); 
        if (x > 0 && y > 0)
            campsiteHelper(x - 1, y - 1, soFar + "NE "); 
    }
    public void campsite(int x, int y)
    {
        campsiteHelper(x, y, "");
    }



    //get max
    private int getMaxHelper(int i, List<Integer> nums, int limit, int sum)
    {
        if (i >= (nums.size() - 1))
        {
            if ((sum + nums.get(i)) > limit)
            {
                return sum;
            }
            return sum + nums.get(i);
        }

        if (sum + nums.get(i) <= limit)
        {
            return getMaxHelper(i + 1, nums, limit, sum + nums.get(i));
        }
        return getMaxHelper(i + 1, nums, limit, sum);

    }
    public int getMax(List<Integer> nums, int limit)
    {
        int x = getMaxHelper(0, nums, limit, 0);
        System.out.println(x);
        return x;
    }
   



    //make change
    private int makeChangeHelper(int amount, List<Integer> coins, int ways)
    {
        System.out.println(ways);
        if (amount <= 0)
            ways++;

        
        if (amount > 25)
            makeChangeHelper(amount - coins.get(3), coins, ways++);
        if (amount > 10)
            makeChangeHelper(amount - coins.get(2), coins, ways++);
        if (amount > 5)
            makeChangeHelper(amount - coins.get(1), coins, ways++);
        if (amount > 1)    
            makeChangeHelper(amount - coins.get(0), coins, ways++);
        return 0;
    

    }
    // public int makeChange(int amount)
    // {
    //     int x = makeChangeHelper(amount, Arrays.asList(1, 5, 10,25), 0);
    //     System.out.println(x);
    //     return x;
    // }

    // private void makeChangePrintHelper()
    // {

    // }
    // public void makeChangePrint()
    // {

    // }

    // private String longestCommonSubHelper(String a, String b, int i)
    // {
    //     if (i >=  a.length())
    //         return longestCommonSubHelper(a.substring(i + 1), b.substring(i + 1), i);

    // }
    // public String longestCommonSub(String a, String b)
    // {
    //     return longestCommonSubHelper(a, b, 0);
    // }

    public void allAB(int n, String x)
    {
        if (x.length() == n)
            System.out.println(x + "");
        else
        {
            allAB(n, x + "a");
            allAB(n, x + "b");
        }
        
        
    
    }
    public int minValue(int i, int[] nums, int min)
    {
        if (i <= nums.length)
            return min;
        if ()
    }


    public static void main(String[] args) 
    {
        BacktrackingProbs x = new BacktrackingProbs();
        // x.printBinary(3);
        // System.out.println();
        // x.climbStairs(4);
        //x.campsite(2, 1);
        //x.getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19);
        //x.makeChange(25);
        x.allAB(2, "");
    }
}
