package code.sorts;

import java.awt.*;

/**
 * class: SelectionSort
 * desc:  This class is used for running a simulation of selection sort.
 */
public class SelectionSort extends Sort
{

  /**
   * Draws the intial graph and sets values for v and d
   * @param values: The set of data to be sorted.
   * @param delay: The delay (in milliseconds) in between each step of the algorithm
   */
  public SelectionSort(int[] values, int delay)
  {
    super(values, delay, "Selection Sort");
  }

  /**
   * This runs the simulation for Insertion sort
   */
  public void runSort()
  {
    for (int rightLimit = bars.length; rightLimit > 0; rightLimit--)
    {
      int max = 0;
      for (int i = 0; i < rightLimit; i++)
      {
        if(running == false)
        {
          uncolorBar(max);
          return;
        }
        colorBar(i, Color.YELLOW);

        // New max
        if(compare(i,max) > 0)//if ( bars[i].height > bars[max].height )
        {
          uncolorBar(max);
          max = i; // set new max indexValue
          colorBar(max, Color.GREEN);
        }
        else{
          uncolorBar(i);
        }
        repaint();
      }
      swap(max,rightLimit-1);
      repaint();
      clearBarColors();
    }
    clearBarColors();
  }
}