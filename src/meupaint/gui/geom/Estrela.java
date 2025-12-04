package meupaint.gui.geom;

import java.awt.Graphics2D;

/**
 * Uma estrela gerada com dois raios (externo e interno).
 */
public class Estrela extends Poligono {

    public Estrela(int quantidadeLados) {
        super(quantidadeLados);
    }

    @Override
    public void desenhar(Graphics2D g2d) {

        g2d = (Graphics2D) g2d.create();

        int centroX = x1;
        int centroY = y1;
        double anguloInicial = Math.atan2(y2 - y1, x2 - x1);

        // raio que representa as pontas da estrela
        double raioExterno = Math.hypot(x2 - x1, y2 - y1);

        // raio que representa o ponto do vale entre as pontas da estrela
        double proporcaoRaioInterno = 0.45; //
        double raioInterno = raioExterno * proporcaoRaioInterno;

        int totalVertices = quantidadeLados * 2;


        double incrementoAngulo = Math.PI / quantidadeLados;

        int[] xs = new int[totalVertices];
        int[] ys = new int[totalVertices];

        // calcula cada vértice alternando raio externo / interno
        for (int i = 0; i < totalVertices; i++) {
            double ang = anguloInicial + i * incrementoAngulo;
            double raioAtual = (i % 2 == 0) ? raioExterno : raioInterno;

            xs[i] = centroX + (int) (raioAtual * Math.cos(ang));
            ys[i] = centroY + (int) (raioAtual * Math.sin(ang));
        }

        // desenha preenchimento e contorno usando o novo polígono estrelado
        g2d.setColor(corPreenchimento);
        g2d.fillPolygon(xs, ys, totalVertices);

        g2d.setColor(corContorno);
        g2d.drawPolygon(xs, ys, totalVertices);

        g2d.dispose();
    }

}
