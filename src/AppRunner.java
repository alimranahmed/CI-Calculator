import javax.swing.*;

public class AppRunner {
    public static void main(String[] CHAND){
        Container frame = new Container();
        frame.setTitle("CI- Calculator");
        frame.setSize(350, 500);
        frame.getContentPane().setBackground(Container.windowColor);
        frame.setLocationRelativeTo(null);
        //frame.setMaximizedBounds(new Rectangle(300, 200));
        frame.setResizable(false);
        ImageIcon img = new ImageIcon("screenshot.png");
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
