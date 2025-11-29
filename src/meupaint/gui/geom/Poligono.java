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
        
        int centroX = x1;
        int centroY= y1;
        
        double incrementoAngulo = 2.0 * Math.PI / quantidadeLados;
        
        for (int i = 0; i < quantidadeLados; i++) {
            
            double novoAngulo =  angulo + i * incrementoAngulo;
       
            x[i] = centroX + (int) ( raio * Math.cos( novoAngulo) );
            y[i] = centroY + (int) ( raio * Math.sin( novoAngulo) );
        }
        
        g2d.setColor( corPreenchimento );
        g2d.fillPolygon( x, y, quantidadeLados );
        
        g2d.setColor( corContorno );
        g2d.drawPolygon( x, y, quantidadeLados );
        
        g2d.dispose();
        
    }
    
}
