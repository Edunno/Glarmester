package glarmester.presentation;

import glarmester.logic.FrameType;

/**
 *
 * @author RODA
 */
public interface UI {

    public double getFrameHeight();
    public double getFrameWidth();
    public FrameType getFrameType();
    public void displayPrice(double price);
    
}
