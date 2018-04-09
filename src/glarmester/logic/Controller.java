package glarmester.logic;

import glarmester.presentation.TUI;
import glarmester.presentation.UI;
import glarmester.data.DataAccessor;
import glarmester.data.DataAccessorDataBase;

/**
 *
 * @author RODA
 */
public class Controller {
    public static final boolean DEBUG = true;
    private UI ui = new TUI();
//    private DataAccessor data = new DataAccessorFile();
    private DataAccessor data = new DataAccessorDataBase();
    private PriceCalculator logic = new PriceCalculator();
    
    public void go() {
        // Get input
        double height = ui.getFrameHeight();
        //System.out.println("Height = " + height);
        double width = ui.getFrameWidth();
        //System.out.println("Width = " + width);
        FrameType type = ui.getFrameType();
        //System.out.println("Type = " + type.toString());
        
        // Calculate price
        double price = logic.calculatePrice(height, width, type, data);
        
        // Display result
        ui.displayPrice(price);
        System.exit(0);
    }
    
}
