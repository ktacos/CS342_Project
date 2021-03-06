package code.sorts;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is used to run an implementation of shell sort
 * @author Thomas Clay
 */
public class ShellSort extends Sort {
  /**
   * Sets sort name to "Shell Sort" in {@link code.sorts.Sort#Sort(int[], int, String)}
   * @param values to sort
   * @param delay to use during sort (milliseconds)
   */
  public ShellSort(int[] values, int delay){
    super(values, delay, "Shell Sort");
  }

  /**
   * @return  a list of gaps based on the size of the values array (N).
   *          These gaps are based on Shell's original sequence, of N/(2^k)
   *          e.g. N/2, N/4, N/8, ..., 1
   */
  private List<Integer> makeGaps(){
    int divisor = 2;
    int nextNumber = values.length/2;
    LinkedList<Integer> gaps = new LinkedList<Integer>();
    gaps.add(nextNumber);
    while(nextNumber > 1){
      divisor *= 2;
      nextNumber = values.length/divisor;
      gaps.add(nextNumber);
    }
    System.out.println(gaps.toString());
    return gaps;
  }


  /**
   * Adds color to the {@link #compare(int, int)} process
   * @see #compare(int, int)
   */
  private int colorCompare(int a, int b){
    colorBar(a, Color.RED);
    colorBar(b, Color.RED);
    repaint();
    return compare(a, b);
  }

  /** Runs Shell Sort */
  @Override
  protected void runSort() {
    for(int gap : makeGaps()){
      for(int i = gap; i < values.length; i++){
        if(!running) return;
        for(int j = i; j >= gap && colorCompare(j - gap, j) > 0; j -= gap){
          colorBar(i, Color.GREEN);
          if(!running) return;
          swap(j, j-gap);
          uncolorBar(j);
          uncolorBar(j - gap);
        }
        clearBarColors();
      }
    }
    clearBarColors();
  }

}
