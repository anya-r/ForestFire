public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell(); 
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method here
     */
    public void recursiveFire(int x, int y)
    {
       
        // if (y< 0 ||x < 0 ||y >= SIZE || x >= SIZE)
        // {
        // if ( myGrid[y][x].getStatus() != FireCell.GREEN)
        //     return;
        // }
        if (y< 0 ||x < 0 ||y >= SIZE || x >= SIZE || myGrid[y][x].getStatus() != FireCell.GREEN)
            return;
		myGrid[y][x].setStatus(FireCell.BURNING);

        //above
        recursiveFire(x, y + 1);
        //below
		recursiveFire(x, y - 1);
        //right
		recursiveFire(x + 1, y);
        //left
		recursiveFire(x - 1, y);
    }
     

    public void solve()
    {
        //call recursive method on all trees
        for (int i = 0; i < SIZE; i++) 
        {
			if (myGrid[SIZE - 1][i].getStatus() == FireCell.GREEN) 
            {
				recursiveFire(i, SIZE - 1);
				
			}
		}
        //check if any cell in top row is burning
        int i = 0;
		while (i < SIZE)
        {
            if (myGrid[0][i].getStatus() == FireCell.BURNING) 
            {
                System.out.println("onnet is in trouble!");
                break;
            }
            i++;
        }
        if (i == SIZE - 1)
            System.out.println("onnet is safe!");

		myView.updateView(myGrid);


    }

}
