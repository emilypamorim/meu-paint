package meupaint.gui.geom;

import java.awt.Graphics2D;

/**
 * Uma estrela.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Estrela extends Poligono {

    public Estrela( int quantidadeLados ) {
        super( quantidadeLados );
    }
    
    @Override
    public void desenhar( Graphics2D g2d ) {
        
        g2d = ( Graphics2D ) g2d.create();
        
        double raio = Math.hypot( x2 - x1, y2 - y1 );
        double angulo = Math.atan2( y2 - y1, x2 - x1 );
        
        // desenho de um círculo só para mostrar algo na tela
        g2d.setColor(  corContorno );
        g2d.drawOval( x1 - (int) raio, y1 - (int) raio, (int) raio * 2, (int) raio * 2 );
        g2d.drawString( String.format( "estrela %d pontas", quantidadeLados ), x1, y1 );
        
        
        // sua implementação aqui
        
        
        g2d.dispose();
        
    }
    
}
