package meupaint.gui.geom;

import java.awt.Graphics2D;

/**
 * Um polígono regular.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Poligono extends Forma {

    protected int quantidadeLados;
    protected int[] x;
    protected int[] y;

    public Poligono( int quantidadeLados ) {
        this.quantidadeLados = quantidadeLados;
        x = new int[quantidadeLados];
        y = new int[quantidadeLados];
    }
    
    @Override
    public void desenhar( Graphics2D g2d ) {
        
        g2d = ( Graphics2D ) g2d.create();
        
        double raio = Math.hypot( x2 - x1, y2 - y1 );
        double angulo = Math.atan2( y2 - y1, x2 - x1 );
        
        // desenho de um círculo só para mostrar algo na tela
        g2d.setColor(  corContorno );
        g2d.drawOval( x1 - (int) raio, y1 - (int) raio, (int) raio * 2, (int) raio * 2 );
        g2d.drawString( String.format( "polígono %d lados", quantidadeLados ), x1, y1 );
        
        
        // sua implementação aqui
        
        
        g2d.dispose();
        
    }
    
}
