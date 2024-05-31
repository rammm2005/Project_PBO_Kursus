/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Rama Dev
 */
import java.awt.*;
import javax.swing.*;

public class RoundedPanelExample extends JFrame
{
    public RoundedPanelExample()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Rounded Panel Example");
        setResizable(true);
        setDefaultLookAndFeelDecorated(true);
        setSize(500, 500);

        Container pane = getContentPane();
        pane.setLayout(null);
        pane.setBackground(Color.LIGHT_GRAY);

        JPanel p1 = new RoundedPanel(10, Color.CYAN);
        p1.setBounds(10,10,100,60);
        p1.setOpaque(false);
        pane.add(p1);

        JPanel p2 = new RoundedPanel(15, Color.RED);
        p2.setBounds(150,10,50,50);
        p2.setOpaque(false);
        pane.add(p2);

        JPanel p3 = new RoundedPanel(30);
        p3.setBounds(230,10,100,150);
        p3.setOpaque(false);
        pane.add(p3);

        JPanel p4 = new RoundedPanel(20);
        p4.setBounds(10,200,100,100);
        p4.setBackground(Color.GREEN);
        p4.setOpaque(false);
        pane.add(p4);

        JPanel p5 = new RoundedPanel(200);
        p5.setBounds(150,200,200,200);
        p5.setBackground(Color.BLUE);
        p5.setOpaque(false);
        pane.add(p5);
    }

    public static void main(String[] args) 
    {
        RoundedPanelExample gui = new RoundedPanelExample();
        gui.setVisible(true);
    }

    class RoundedPanel extends JPanel
    {
        private Color backgroundColor;
        private int cornerRadius = 15;

        public RoundedPanel(LayoutManager layout, int radius) {
            super(layout);
            cornerRadius = radius;
        }

        public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
            super(layout);
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        public RoundedPanel(int radius) {
            super();
            cornerRadius = radius;
        }

        public RoundedPanel(int radius, Color bgColor) {
            super();
            cornerRadius = radius;
            backgroundColor = bgColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            //Draws the rounded panel with borders.
            if (backgroundColor != null) {
                graphics.setColor(backgroundColor);
            } else {
                graphics.setColor(getBackground());
            }
            graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
        }
    }
}
