import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionServer extends ElementContainer implements ActionListener{

     ActionServer(){
        //common keys
        bOne.addActionListener(this);
        bTwo.addActionListener(this);
        bThree.addActionListener(this);
        bFour.addActionListener(this);
        bFive.addActionListener(this);
        bSix.addActionListener(this);
        bSeven.addActionListener(this);
        bEight.addActionListener(this);
        bNine.addActionListener(this);
        bZero.addActionListener(this);
        bAdd.addActionListener(this);
        bSub.addActionListener(this);
        bMul.addActionListener(this);
        bDiv.addActionListener(this);
        bPoint.addActionListener(this);
        bEqual.addActionListener(this);
        bDel.addActionListener(this);
        bClear.addActionListener(this);
        bSquare.addActionListener(this);
        bSqrt.addActionListener(this);
        bCube.addActionListener(this);
        bPercent.addActionListener(this);
        bMod.addActionListener(this);
        bOneByN.addActionListener(this);
        //bPlusMinus.addActionListener(this);
        //scientific keys
        bSin.addActionListener(this);
        bCos.addActionListener(this);
        bTan.addActionListener(this);
        bAsin.addActionListener(this);
        bAcos.addActionListener(this);
        bAtan.addActionListener(this);
        bSinH.addActionListener(this);
        bCosH.addActionListener(this);
        bTanH.addActionListener(this);
        bPowerOfTen.addActionListener(this);
        bLog.addActionListener(this);
        bLn.addActionListener(this);
        bAbs.addActionListener(this);
        bExit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked "+e.getActionCommand());
        tfDisplay.setText(e.getActionCommand());
    }
}
