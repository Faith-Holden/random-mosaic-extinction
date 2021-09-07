package solution;

import javafx.scene.paint.Color;

public class RandomMosaicExtinction {

    final static int ROWS = 20;        // Number of rows in mosaic.
    final static int COLUMNS = 30;     // Number of columns in mosaic.
    final static int SQUARE_SIZE = 20; // Size of each square in mosaic.

    static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    public static void main(String[] args) {
        Mosaic.open( ROWS, COLUMNS, SQUARE_SIZE, SQUARE_SIZE );
        fillWithRandomColors();
        while (true) {
            setToSampledColor(currentRow, currentColumn);
            randomMove();
//            The following line allows for a slight delay. I disabled it because I prefer for the extinction to be as fast as possible
//            Mosaic.delay(5);
        }
    }

//---------------HFH edits----------------------
    static Color colorSample(int rowNum, int colNum){
        int directionNum = (int)(4*Math.random());
        switch (directionNum) {
            case 0:
                rowNum--;
                if (rowNum < 0)
                    rowNum = ROWS - 1;
                break;
            case 1:
                colNum++;
                if (colNum >= COLUMNS)
                    colNum = 0;
                break;
            case 2:
                rowNum ++;
                if (rowNum >= ROWS)
                    rowNum = 0;
                break;
            case 3:
                colNum--;
                if (colNum < 0)
                    colNum = COLUMNS - 1;
                break;
        }
        return Mosaic.getColor(rowNum, colNum);
    }
    static void setToSampledColor(int rowNum, int colNum){
        Color sampledColor = colorSample(rowNum, colNum);
        Mosaic.setColor(rowNum,colNum, sampledColor);
    }

//----------------End of HFH edits-------------------

    /**
     * Fills the window with randomly colored squares.
     * Precondition:   The mosaic window is open.
     * Postcondition:  Each square has been set to a random color. 
     */
    static void fillWithRandomColors() {
        for (int row=0; row < ROWS; row++) {
            for (int column=0; column < COLUMNS; column++) {
                changeToRandomColor(row, column);  
            }
        }
    }  // end fillWithRandomColors

    /**
     * Changes one square to a new randomly selected color.
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been set to a random color.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void changeToRandomColor(int rowNum, int colNum) {
        int red = (int)(256*Math.random());    // Choose random levels in range
        int green = (int)(256*Math.random());  //     0 to 255 for red, green, 
        int blue = (int)(256*Math.random());   //     and blue color components.
        Mosaic.setColor(rowNum,colNum,red,green,blue);  
    }  // end changeToRandomColor

    /**
     * Move the disturbance.
     * Precondition:   The global variables currentRow and currentColumn
     *                 are within the legal range of row and column numbers.
     * Postcondition:  currentRow or currentColumn is changed to one of the
     *                 neighboring positions in the grid -- up, down, left, or
     *                 right from the current position.  If this moves the
     *                 position outside of the grid, then it is moved to the
     *                 opposite edge of the grid.
     */
    static void randomMove() {
        currentColumn=(int)(COLUMNS*Math.random());
        currentRow=(int)(ROWS*Math.random());

    }  // end randomMove

} // end class RandomMosaicWalk2
