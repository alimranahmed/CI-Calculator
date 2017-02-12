import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionServer extends ElementContainer implements ActionListener{

     ActionServer(int width, int height){
         super(width, height);
        //common keys
        for(String key : this.buttonHolderMap.keySet()){
           this.buttonHolderMap.get(key).addActionListener(this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked "+e.getActionCommand());
        System.out.println(e.getSource());
        this.inputDisplay.setText(this.inputDisplay.getText()+e.getActionCommand());
    }
}
