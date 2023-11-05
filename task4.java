import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Random;

public class task4  {

    public static void task4_var4()
    {
        JFrame fr=new JFrame("Изобразить в окне приложения вращающийся отрезок");
        fr.setPreferredSize( new Dimension(400,400));
        final JPanel pan= new JPanel();
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        Timer tm= new Timer(75, new ActionListener(){
            double i=Math.PI/180;
            double angle=0;
            int x=60;
            int y=60;
            Random random = new Random();
            @Override
            public void actionPerformed(ActionEvent arg0) {
                angle=angle+i;
                int red = random.nextInt(1,256);
                int green = random.nextInt(1,256);
                int blue = random.nextInt(1,256);
                Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);
                GeneralPath path=new GeneralPath();
                gr.translate(130, 130);
                path.append(new Polygon(new int []{x,y },new int[]{x,-y},2),true);
                AffineTransform tranforms = AffineTransform.getRotateInstance(angle, x, y);
                gr.transform(tranforms);
                gr.setColor(new Color(red, green, blue));
                gr.draw(path);
                


            }});
        tm.start();
    }
}