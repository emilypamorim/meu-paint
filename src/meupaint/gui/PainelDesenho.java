package meupaint.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import meupaint.gui.geom.Forma;

/**
 * Um painel de desenho.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class PainelDesenho extends JPanel {

    private List<Forma> formas;
    private Forma formaTemporaria;
    
    public PainelDesenho() {
        formas = new ArrayList<>();
    }
    
    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        
        Graphics2D g2d = ( Graphics2D ) g.create();
        
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        g.setColor( Color.WHITE );
        g.fillRect( 0, 0, getWidth(), getHeight() );
        
        for ( Forma forma : formas ) {
            forma.desenhar( g2d );
        }
        
        if ( formaTemporaria != null ) {
            formaTemporaria.desenhar( g2d );
        }
        
        g2d.dispose();
        
    }
    
    public void adicionarForma( Forma forma ) {
        formas.add( forma );
    }

    public void setFormaTemporaria( Forma formaTemporaria) {
        this.formaTemporaria = formaTemporaria;
    }
    
    public void removerUltimaForma(){
        if (!formas.isEmpty()) {
            formas.remove(formas.size() - 1);
            repaint();
        }
    }
    
}
