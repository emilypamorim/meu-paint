package meupaint.gui.geom;

import java.awt.Graphics2D;

/**
 * Um triângulo equilátero.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Triangulo extends Poligono {
    
    public Triangulo() {
        // invoca o construtor da superclasse (Poligono)
        // passando 3 como a quantidade de lados
        super( 3 );
    }
    
    @Override
    public void desenhar( Graphics2D g2d ) {
        
        g2d = ( Graphics2D ) g2d.create();
        
        // x1 e y1 representa o centro do triângulo
        // x2 e y2 representa a posição atual do mouse
        // o triângulo é inscrito em uma circunferência cujo raio é
        // a distância do centro até a posição do mouse
        
        // calcula o raio usando o teorema de pitágoras
        double raio = Math.hypot( x2 - x1, y2 - y1 );
        
        // cálculo do ângulo (em radianos) entre o centro e a posição do mouse
        // esse ângulo determina a rotação do triângulo
        double angulo = Math.atan2( y2 - y1, x2 - x1 );
        
        // vamos calcular os vértices
        
        // o primeiro vértice é a posição que está o mouse
        x[0] = x2;
        y[0] = y2;
        
        // o cálculo dos outros vértices usa a conversão de coordenadas polares
        // para cartesianas:
        // x = centroX + raio * cos( ângulo )
        // y = centroY + raio * sin( ângulo )
        
        // vértice 2: rotacionado 120 graus em relação ao primeiro vértice
        x[1] = x1 + (int) ( raio * Math.cos( angulo + Math.toRadians( 120 ) ) );
        y[1] = y1 + (int) ( raio * Math.sin( angulo + Math.toRadians( 120 ) ) );
        
        // vértice 3: rotacionado 240 graus em relação ao primeiro vértice
        x[2] = x1 + (int) ( raio * Math.cos( angulo + Math.toRadians( 240 ) ) );
        y[2] = y1 + (int) ( raio * Math.sin( angulo + Math.toRadians( 240 ) ) );
        
        // desenha o triângulo
        g2d.setColor( corPreenchimento );
        g2d.fillPolygon( x, y, quantidadeLados );
        
        g2d.setColor( corContorno );
        g2d.drawPolygon( x, y, quantidadeLados );
        
        g2d.dispose();
        
    }
    
}
