package com.ui;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

    private int rPicArr[][] = new int[4][4];
    private int white_x = 0;
    private int white_y = 0;
    private String imgPath = "src\\res\\image\\animal\\animal3\\";
    private int step = 0;
    private static final int[][] winArr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };
    JMenuBar gMenuBar = new JMenuBar();
    JMenu funcMenu = new JMenu("Function");
    JMenu aboutMenu = new JMenu("About");
    JMenu cgPicJMenu = new JMenu("Change Picture");
    JMenuItem animalItem = new JMenuItem("Animal");
    JMenuItem sportItem = new JMenuItem("Sport");
    JMenuItem girlItem = new JMenuItem("Girl");
    JMenuItem restartItem = new JMenuItem("Restart");
    JMenuItem reloginItem = new JMenuItem("Re-login");
    JMenuItem closeItem = new JMenuItem("Close Game");
    JMenuItem aboutItem = new JMenuItem("WeChat");

    public GameJFrame() {
        initFrame();
        initData();
        initImage();
        initMenuBar();
    }

    private void initFrame() {
        this.setSize(603, 680);
        this.setTitle("Picture Puzzle Game v1.0");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    private void initMenuBar() {
        restartItem.addActionListener(this);
        reloginItem.addActionListener(this);
        closeItem.addActionListener(this);
        aboutItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);
        girlItem.addActionListener(this);
        cgPicJMenu.add(animalItem);
        cgPicJMenu.add(sportItem);
        cgPicJMenu.add(girlItem);
        funcMenu.add(cgPicJMenu);
        funcMenu.add(restartItem);
        funcMenu.add(reloginItem);
        funcMenu.add(closeItem);
        aboutMenu.add(aboutItem);
        gMenuBar.add(funcMenu);
        gMenuBar.add(aboutMenu);
        this.setJMenuBar(gMenuBar);
        this.setVisible(true);
    }

    private void initImage() {
        this.getContentPane().removeAll();
        if (isWin()) {
            showWin();
        }
        JLabel stpLabel = new JLabel("Steps: " + step);
        stpLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stpLabel);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JLabel jLabel = new JLabel(new ImageIcon(imgPath + rPicArr[i][j] + ".jpg"));
                jLabel.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                this.getContentPane().add(jLabel);
            }
        }
        JLabel bgLabel = new JLabel(new ImageIcon("src\\res\\image\\background.png"));
        bgLabel.setBounds(40, 40, 508, 560);
        this.getContentPane().add(bgLabel);
        this.getContentPane().repaint();
    }

    private void initData() {
        int randomArr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        for (int i = 0; i < randomArr.length; i++) {
            Random r = new Random();
            int ri = r.nextInt(randomArr.length);
            int temp = randomArr[i];
            randomArr[i] = randomArr[ri];
            randomArr[ri] = temp;
        }

        for (int i = 0; i < randomArr.length; i++) {
            if (randomArr[i] == 0) {
                this.white_x = i / 4;
                this.white_y = i % 4;
            }
            rPicArr[i / 4][i % 4] = randomArr[i];
        }
    }

    public boolean isWin() {
        for (int i = 0; i < rPicArr.length; i++) {
            for (int j = 0; j < rPicArr[i].length; j++) {
                if (rPicArr[i][j] != winArr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void showWin() {
        JLabel winJLabel = new JLabel(new ImageIcon("src\\res\\image\\win.png"));
        winJLabel.setBounds(203, 283, 197, 73);
        this.getContentPane().add(winJLabel);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 65) {
            this.getContentPane().removeAll();
            JLabel allPicJLabel = new JLabel(new ImageIcon(imgPath + "all.jpg"));
            allPicJLabel.setBounds(83, 134, 420, 420);
            this.getContentPane().add(allPicJLabel);
            JLabel bgLabel = new JLabel(new ImageIcon("src\\res\\image\\background.png"));
            bgLabel.setBounds(40, 40, 508, 560);
            this.getContentPane().add(bgLabel);
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (isWin()) {
            return;
        }
        int key = e.getKeyCode();
        System.out.println(key);
        if (key == 37/*Leftarrow*/ || key == 72) {
            System.out.println("left");
            if (white_y != 3) {
                rPicArr[white_x][white_y] = rPicArr[white_x][white_y + 1];
                rPicArr[white_x][++white_y] = 0;
                step++;
                initImage();
            }
        } else if (key == 38/*Uparrow*/ || key == 75) {
            System.out.println("up");
            if (white_x != 3) {
                rPicArr[white_x][white_y] = rPicArr[white_x + 1][white_y];
                rPicArr[++white_x][white_y] = 0;
                step++;
                initImage();
            }
        } else if (key == 39/*Rightarrow*/ || key == 76) {
            System.out.println("right");
            if (white_y != 0) {
                rPicArr[white_x][white_y] = rPicArr[white_x][white_y - 1];
                rPicArr[white_x][--white_y] = 0;
                step++;
                initImage();
            }
        } else if (key == 40/*Downarrow*/ || key == 74) {
            System.out.println("down");
            if (white_x != 0) {
                rPicArr[white_x][white_y] = rPicArr[white_x - 1][white_y];
                rPicArr[--white_x][white_y] = 0;
                step++;
                initImage();
            }
        } else if (key == 65) {
            initImage();
        } else if (key == 87) {
            for (int i = 0; i < winArr.length; i++) {
                for (int j = 0; j < winArr[i].length; j++) {
                    rPicArr[i][j] = winArr[i][j];
                }
            }
            white_x = 3;
            white_y = 3;
            initImage();
        } else if (key == 82) {
            step = 0;
            initData();
            initImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object opt = e.getSource();
        if (opt == restartItem) {
            step = 0;
            initData();
            initImage();
        } else if (opt == reloginItem) {
            System.out.println("Re-login");
            this.setVisible(false);
            new LoginJFrame();
        } else if (opt == closeItem) {
            System.exit(0);
        } else if (opt == aboutItem) {
            JDialog aboutJDialog = new JDialog();
            aboutJDialog.setSize(258, 364);
            JLabel aboutJLabel = new JLabel(new ImageIcon("src\\res\\image\\about.jpg"));
            aboutJLabel.setBounds(0, 0, 258, 364);
            aboutJDialog.getContentPane().add(aboutJLabel);
            aboutJDialog.setAlwaysOnTop(true);
            aboutJDialog.setLocationRelativeTo(null);
            aboutJDialog.setModal(true);
            aboutJDialog.setVisible(true);
        } else if (opt == animalItem) {
            imgPath = "src\\res\\image\\animal\\animal" + (new Random().nextInt(7) + 1) + "\\";
            initData();
            initImage();
        } else if (opt == sportItem) {
            imgPath = "src\\res\\image\\sport\\sport" + (new Random().nextInt(9) + 1) + "\\";
            initData();
            initImage();
        } else if (opt == girlItem) {
            imgPath = "src\\res\\image\\girl\\girl" + (new Random().nextInt(12) + 1) + "\\";
            initData();
            initImage();
        }
    }
}
