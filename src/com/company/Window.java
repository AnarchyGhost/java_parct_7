package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class Window extends JFrame {
    static final int SCREEN_WIDTH= Toolkit.getDefaultToolkit().getScreenSize().width;
    static final int SCREEN_HEIGHT= Toolkit.getDefaultToolkit().getScreenSize().height;
    private final JDesktopPane dp = new JDesktopPane();
    JLabel[] p1Cards =new JLabel[5];
    JLabel p1Card=new JLabel("First Player's cards");
    JLabel p2Card=new JLabel("Second Player's cards");
    JLabel[] p2Cards =new JLabel[5];
    JLabel[] fCards =new JLabel[10];
    JLabel[] cards =new JLabel[10];
    JButton start;

    private void startGame(){
        Stack<Integer> firstCards=new Stack<>();
        Stack<Integer> secondCards=new Stack<>();
        int result;
        for(int i=4;i>=0;i--){
            firstCards.add(Integer.valueOf(p1Cards[i].getText()));
            secondCards.add(Integer.valueOf(p2Cards[i].getText()));
        }
        Play play=new Play();
        result=play.playing(firstCards,secondCards);
        if(result!=1060)JOptionPane.showMessageDialog(null, "Win "+result%10+" player Steps: "+result/10,"Result",JOptionPane.INFORMATION_MESSAGE);
        else JOptionPane.showMessageDialog(null, "botva","Result",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    private void createLabels(){
        for (int i=0;i<5;i++){
            p1Cards[i]=new JLabel(new ImageIcon("src/com/company/res/FPSlot.png"));
            p2Cards[i]=new JLabel(new ImageIcon("src/com/company/res/SPSlot.png"));
            fCards[i]=new JLabel();
            fCards[i+5]=new JLabel();
            cards[i]=new JLabel();
            cards[i+5]=new JLabel();
            cards[i+5].setIcon(new ImageIcon(new ImageIcon("src/com/company/res/card"+(i+5)+".png").getImage().getScaledInstance(this.getPreferredSize().width/25*3, this.getPreferredSize().height/6, Image.SCALE_DEFAULT)));
            cards[i].setIcon(new ImageIcon(new ImageIcon("src/com/company/res/card"+(i)+".png").getImage().getScaledInstance(this.getPreferredSize().width/25*3, this.getPreferredSize().height/6, Image.SCALE_DEFAULT)));
            p1Cards[i].setIcon(new ImageIcon(new ImageIcon("src/com/company/res/FPSlot.png").getImage().getScaledInstance(this.getPreferredSize().width/25*3, this.getPreferredSize().height/6, Image.SCALE_DEFAULT)));
            p2Cards[i].setIcon(new ImageIcon(new ImageIcon("src/com/company/res/SPSlot.png").getImage().getScaledInstance(this.getPreferredSize().width/25*3, this.getPreferredSize().height/6, Image.SCALE_DEFAULT)));
            fCards[i].setIcon(new ImageIcon(new ImageIcon("src/com/company/res/slot.png").getImage().getScaledInstance(this.getPreferredSize().width/25*3, this.getPreferredSize().height/6, Image.SCALE_DEFAULT)));
            fCards[i+5].setIcon(new ImageIcon(new ImageIcon("src/com/company/res/slot.png").getImage().getScaledInstance(this.getPreferredSize().width/25*3, this.getPreferredSize().height/6, Image.SCALE_DEFAULT)));
        }

        p1Card.setHorizontalAlignment(SwingConstants.CENTER);
        p1Card.setVerticalAlignment(SwingConstants.CENTER);
        p2Card.setHorizontalAlignment(SwingConstants.CENTER);
        p2Card.setVerticalAlignment(SwingConstants.CENTER);

    }
    private void completeWindow(){
        dp.setBounds(this.getBounds());
        dp.setLocation(0,0);
        p1Card.setBounds(this.getPreferredSize().width/25,this.getPreferredSize().height/30,this.getPreferredSize().width/25*3,this.getPreferredSize().height/6);
        dp.add(p1Card);
        for(int i=1;i<=5;i++){
            p1Cards[i-1].setBounds(this.getPreferredSize().width/25*(i+1)+this.getPreferredSize().width/25*3*i,this.getPreferredSize().height/30,this.getPreferredSize().width/25*3,this.getPreferredSize().height/6);
            dp.add(p1Cards[i-1]);
        }

        p2Card.setBounds(this.getPreferredSize().width/25,this.getPreferredSize().height*7/30,this.getPreferredSize().width/25*3,this.getPreferredSize().height/6);
        dp.add(p2Card);
        for(int i=1;i<=5;i++){
            p2Cards[i-1].setBounds(this.getPreferredSize().width/25*(i+1)+this.getPreferredSize().width/25*3*i,this.getPreferredSize().height*7/30,this.getPreferredSize().width/25*3,this.getPreferredSize().height/6);
            dp.add(p2Cards[i-1]);
        }

        start=new JButton("Начать игру");
        start.setBackground(new Color(255,0,0));
        start.setBounds(this.getPreferredSize().width/25,this.getPreferredSize().height/30*18,this.getPreferredSize().width/25*3,this.getPreferredSize().height/30*11);
        dp.add(start);

        for(int i=1;i<=5;i++){
            fCards[i-1].setBounds(this.getPreferredSize().width/25*(i+1)+this.getPreferredSize().width/25*3*i,this.getPreferredSize().height/30*18,this.getPreferredSize().width/25*3,this.getPreferredSize().height/6);
            fCards[i-1].setBackground(Color.RED);
            dp.add(fCards[i-1]);
        }
        for(int i=1;i<=5;i++){
            fCards[i+4].setBounds(this.getPreferredSize().width/25*(i+1)+this.getPreferredSize().width/25*3*i,this.getPreferredSize().height/30*24,this.getPreferredSize().width/25*3,this.getPreferredSize().height/6);
            dp.add(fCards[i+4]);
        }

        for(int i=1;i<=5;i++){
            cards[i-1].setBounds(this.getPreferredSize().width/25*(i+1)+this.getPreferredSize().width/25*3*i,this.getPreferredSize().height/30*18,this.getPreferredSize().width/25*3,this.getPreferredSize().height/6);

            dp.add(cards[i-1],1);
        }
        for(int i=1;i<=5;i++){
            cards[i+4].setBounds(this.getPreferredSize().width/25*(i+1)+this.getPreferredSize().width/25*3*i,this.getPreferredSize().height/30*24,this.getPreferredSize().width/25*3,this.getPreferredSize().height/6);

            dp.add(cards[i+4],1);
        }
        dp.setBackground(new Color(0, 255, 0) );

        add(dp);
    }
    private void addClickers(){
        for(int i=0;i<10;i++) {
            int finalI = i;
            final int[] lastX = {0};
            final int[] lastY = {0};
            cards[i].addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent e) {
    
                }
    
                @Override
                public void mousePressed(MouseEvent e) {
                   for(int i=0;i<5;i++) {
                       if (cards[finalI].getX() + cards[finalI].getWidth() / 2 > p1Cards[i].getX() && cards[finalI].getX() + cards[finalI].getWidth() / 2 < p1Cards[i].getX() + p1Card.getWidth() && cards[finalI].getY() + cards[finalI].getHeight() / 2 > p1Cards[i].getY() && cards[finalI].getY() + cards[finalI].getHeight() / 2 < p1Cards[i].getY() + p1Cards[i].getHeight()) {
                           cards[finalI].setBounds(p1Cards[i].getBounds());
                           p1Cards[i].setText(null);
                           break;
                       } else if ((cards[finalI].getX() + cards[finalI].getWidth() / 2 > p2Cards[i].getX()) && (cards[finalI].getX() + cards[finalI].getWidth() / 2 < p2Cards[i].getX() + p2Card.getWidth()) && (cards[finalI].getY() + cards[finalI].getHeight() / 2 > p2Cards[i].getY()) && (cards[finalI].getY() + cards[finalI].getHeight() / 2 < p2Cards[i].getY() + p2Cards[i].getHeight())) {
                           cards[finalI].setBounds(p2Cards[i].getBounds());
                           p2Cards[i].setText(null);
                           break;
                       }
                   }
                   lastX[0] =getMousePosition().x;
                   lastY[0] =getMousePosition().y;
                }
    
                @Override
                public void mouseReleased(MouseEvent e) {
                    boolean f = false;
                    for (int i = 0; i < 5; i++) {
                        if (p1Cards[i].getText()==null&&cards[finalI].getX() + cards[finalI].getWidth() / 2 > p1Cards[i].getX() && cards[finalI].getX() + cards[finalI].getWidth() / 2 < p1Cards[i].getX() + p1Card.getWidth() && cards[finalI].getY() + cards[finalI].getHeight() / 2 > p1Cards[i].getY() && cards[finalI].getY() + cards[finalI].getHeight() / 2 < p1Cards[i].getY() + p1Cards[i].getHeight()) {
                            cards[finalI].setBounds(p1Cards[i].getBounds());
                            f = true;
                            p1Cards[i].setText(""+finalI);
                            break;
                        } else if (p2Cards[i].getText()==null&&(cards[finalI].getX() + cards[finalI].getWidth() / 2 > p2Cards[i].getX()) && (cards[finalI].getX() + cards[finalI].getWidth() / 2 < p2Cards[i].getX() + p2Card.getWidth()) && (cards[finalI].getY() + cards[finalI].getHeight() / 2 > p2Cards[i].getY()) && (cards[finalI].getY() + cards[finalI].getHeight() / 2 < p2Cards[i].getY() + p2Cards[i].getHeight())){
                            cards[finalI].setBounds(p2Cards[i].getBounds());
                            f = true;
                            p2Cards[i].setText(""+finalI);
                            break;
                        }
                    }
                    if(!f)cards[finalI].setBounds(fCards[finalI].getBounds());
                }
    
                @Override
                public void mouseEntered(MouseEvent e) {
                }
    
                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            cards[i].addMouseMotionListener(new MouseMotionAdapter() {

                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    if(lastY[0] !=0&& lastX[0] !=0)
                    cards[finalI].setBounds(cards[finalI].getBounds().x+(getMousePosition().x- lastX[0]),cards[finalI].getBounds().y+(getMousePosition().y- lastY[0]),cards[finalI].getBounds().width,cards[finalI].getBounds().height);
                    lastX[0] =getMousePosition().x;
                    lastY[0] =getMousePosition().y;
                }
            });
        }

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setAlwaysOnTop(false);
                startGame();

            }
        });
    }

    Window(){
        setLayout(null);
        setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        setLocation(0,0);

        createLabels();
        completeWindow();
        addClickers();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);
        setTitle("Пьяница");
        setVisible(true);
        pack();
    }
}
