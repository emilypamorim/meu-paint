package meupaint.gui.geom;

import java.awt.Graphics2D;

/**
 * Um retângulo.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Retangulo extends Forma {

    @Override
    public void desenhar( Graphics2D g2d ) {
        
        g2d = ( Graphics2D ) g2d.create();
        
        g2d.setColor( corPreenchimento );
        g2d.fillRect( 
            x1 < x2 ? x1 : x2, 
            y1 < y2 ? y1 : y2, 
            Math.abs( x2 - x1 ), 
            Math.abs( y2 - y1 )
        );
        
        g2d.setColor( corContorno );
        g2d.drawRect( 
            x1 < x2 ? x1 : x2, 
            y1 < y2 ? y1 : y2, 
            Math.abs( x2 - x1 ), 
            Math.abs( y2 - y1 )
        );
        
        g2d.dispose();
        
    }
    
}
