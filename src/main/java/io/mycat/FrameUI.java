package io.mycat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by jiang on 2016/12/1 0001.
 */
public class FrameUI extends JFrame implements WindowListener {
    private JTextArea jTextArea = new JTextArea(40, 40);
    public FrameUI() throws HeadlessException {
        jTextArea.setFont(new Font(Font.DIALOG,0,30));
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        setLayout(new BorderLayout());
        add(jTextArea, BorderLayout.CENTER);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBounds(360, 300, 400, 400);
        addWindowListener(this);
        requestFocus();

    }

    public void settest(String s) {
        jTextArea.setText(s);

    }
    public static void main(String[] args) {

        MycatStartup.startmain(args);

    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

       int i= JOptionPane.showConfirmDialog(this, "确定退出并关闭mycat吗？");
        if (i == JOptionPane.OK_OPTION) {

            java.lang.System.exit(0);

        }
        java.lang.System.out.println(i);


    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {


    }
}
