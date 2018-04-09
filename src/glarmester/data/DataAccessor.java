package glarmester.data;

import glarmester.logic.FrameType;

/**
 *
 * @author RODA
 */
public interface DataAccessor {

    public double getGlassprice();
    public double getFramePrice(FrameType type);
    
}
