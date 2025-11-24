package meupaint.gui.geom;

import java.awt.Graphics2D;

/**
 * Uma linha.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Linha extends Forma {

    @Override
    public void desenhar( Graphics2D g2d ) {
        
        g2d = ( Graphics2D ) g2d.create();
        
        g2d.setColor( corContorno );
        g2d.drawLine( x1, y1, x2, y2 );
        
        g2d.dispose();
        
    }
    
}
