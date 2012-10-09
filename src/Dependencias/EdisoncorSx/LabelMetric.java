/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dependencias.EdisoncorSx;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Edisoncor
 */
public class LabelMetric extends JLabel{
    
    private float shadowOffsetX;
    private float shadowOffsetY;
    private Color colorDeSombra = Color.BLACK;
    private int direccionDeSombra = 60;
    private int distanciaDeSombra = 4;
    
    public LabelMetric(){
        computeShadow();
        Font font = new Font("Arial", Font.BOLD, 14);
        setFont(font);
        Color foreground = Color.WHITE;
        setForeground(foreground);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        Insets insets = getInsets();
        
        int width = getWidth() - insets.left - insets.right;
        int height = getHeight() - insets.top - insets.bottom;
        
        
       
        
        FontMetrics fm = getFontMetrics(getFont());
        if(getText()==null)
            setText("  ");
        TextLayout layout = new TextLayout(getText().length()<=0? " ":getText(),
                getFont(),
                g2.getFontRenderContext());
        Rectangle2D bounds = layout.getBounds();
        
        int x = (int) (getWidth() - insets.left - insets.right -
                bounds.getWidth()) / 2;
        if(getHorizontalAlignment()!=CENTER){
            x = insets.left;
        }
        //x -= 2;
        int y = (getHeight() - insets.top - insets.bottom -
                 fm.getMaxAscent() - fm.getMaxDescent()) / 2;
        y += fm.getAscent() - 1;
        
        
        g2.setColor(colorDeSombra);
        layout.draw(g2,
                x + (int) Math.ceil(shadowOffsetX),
                y + (int) Math.ceil(shadowOffsetY));
        g2.setColor(getForeground());
        layout.draw(g2, x, y);
    }
    
    private void computeShadow() {
        double rads = Math.toRadians(direccionDeSombra);
        shadowOffsetX = (float) Math.cos(rads) * distanciaDeSombra;
        shadowOffsetY = (float) Math.sin(rads) * distanciaDeSombra;
    }


   

    public Color getColorDeSombra() {
        return colorDeSombra;
    }

    public void setColorDeSombra(Color colorDeSombra) {
        this.colorDeSombra = colorDeSombra;
    }

    public int getDireccionDeSombra() {
        return direccionDeSombra;
    }

    public void setDireccionDeSombra(int direccionDeSombra) {
        this.direccionDeSombra = direccionDeSombra;
        computeShadow();
        repaint();
    }

    public int getDistanciaDeSombra() {
        return distanciaDeSombra;
    }

    public void setDistanciaDeSombra(int distanciaDeSombra) {
        this.distanciaDeSombra = distanciaDeSombra;
        computeShadow();
        repaint();
    }

}
