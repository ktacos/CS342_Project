package code;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * An extension of JCheckBoxMenuItem that doesn't close the menu when selected.
 *
 * @author Darryl
 * http://www.coderanch.com/t/497325/GUI/java/popup-clicking-JCheckBoxMenuItem
 * http://tips4java.wordpress.com/2010/09/12/keeping-menus-open/
 */
public class StayOpenCheckBoxMenuItem extends JCheckBoxMenuItem {

  /**
   * Gets the path of the menu so it can be re-displayed
   */
  private static MenuElement[] path;
  {
    getModel().addChangeListener(new ChangeListener() {

      @Override
      public void stateChanged(ChangeEvent e) {
        if (getModel().isArmed() && isShowing()) {
          path = MenuSelectionManager.defaultManager().getSelectedPath();
        }
      }
    });
  }

  /**
   * @see JCheckBoxMenuItem#JCheckBoxMenuItem(String)
   */
  public StayOpenCheckBoxMenuItem(String text) {
    super(text);
  }

  /**
   * Overridden to reopen the menu.
   * @param pressTime the time to "hold down" the button, in milliseconds
   */
  @Override
  public void doClick(int pressTime) {
    super.doClick(pressTime);
    MenuSelectionManager.defaultManager().setSelectedPath(path);
  }
}
