package Gobang;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.ImageIcon;


public class Gobang extends javax.swing.JFrame {

    public Gobang() {
        InitComponents();
    }

    private void InitComponents() {
        s_buttonGroup1 = new javax.swing.ButtonGroup();
        s_buttonGroup2 = new javax.swing.ButtonGroup();
        s_jMenuBar2 = new javax.swing.JMenuBar();
        s_jMenu2 = new javax.swing.JMenu();
        s_settingjpanel = new javax.swing.JPanel() {
            public void paint(Graphics g) {
                g.clearRect(0, 0, getSize().width, getSize().height);
                s_settingimage.paintIcon(this, g, 0, 0);
                s_cursorimage.paintIcon(this, g, s_x, s_y);
                paintComponents(g);
            }
        };

        s_settingjpanel.setPreferredSize(new Dimension(650, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        s_gobangboxjlabel = new JLabel(s_blackboximgae);
        add(s_textjlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));
        add(s_settingjpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        //add(s_gobangboxjlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));
        s_textip.setPreferredSize(new Dimension(100, 30));
        s_jMenuBar1 = new javax.swing.JMenuBar();
        s_newstart = new javax.swing.JMenu();
        s_newcomper = new javax.swing.JMenu();
        s_newcomperai = new javax.swing.JMenu();
        s_jMenuItem3 = new javax.swing.JMenuItem();
        s_jMenuItem4 = new javax.swing.JMenuItem();
        s_newplay = new javax.swing.JMenu();
        s_newplayerswhite = new javax.swing.JMenuItem();
        s_newplayip = new javax.swing.JMenu();
        s_jMenu11 = new javax.swing.JMenu();
        s_jMenuItem7 = new javax.swing.JMenuItem();
        s_jMenuItem8 = new javax.swing.JMenuItem();
        s_jMenu10 = new javax.swing.JMenu();
        s_ip = new javax.swing.JMenuItem();
        s_special = new javax.swing.JMenu();
        s_jMenuItem1 = new javax.swing.JMenuItem();
        s_jMenu2.setText("Edit");
        s_jMenuBar2.add(s_jMenu2);
        s_ip.setText("連線開始");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);
        setForeground(java.awt.Color.white);
        setName("GobangJFrame"); // NOI18N
        s_settingjpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        s_newstart.setText("新局");

        s_newcomper.setText("電腦");

        s_newcomperai.setText("智障AI");

        s_jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gobang/drawing/black.png"))); // NOI18N
        s_jMenuItem3.setText("玩家選擇黑棋");
        s_jMenuItem3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewComperAIblackActionPerformed(evt);
            }
        });
        s_newcomperai.add(s_jMenuItem3);
        s_jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gobang/drawing/white.png"))); // NOI18N
        s_jMenuItem4.setText("玩家選擇白棋");
        s_jMenuItem4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewComperAIwhiteActionPerformed(evt);
            }
        });
        s_newcomperai.add(s_jMenuItem4);

        s_newcomper.add(s_newcomperai);

        s_newstart.add(s_newcomper);

        s_newplay.setText("玩家");



        s_newplayerswhite.setText("雙打");
        s_newplayerswhite.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewplayersActionPerformed(evt);
            }
        });


        s_newplay.add(s_newplayerswhite);

        s_newplayip.setText("連線IP");

        s_jMenu10.add(s_textip);
        s_jMenu11.setText("主機");
        s_jMenu10.add(s_ip);

        s_ip.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IptonewplayActionPerformed(evt);
            }
        });

        s_jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gobang/drawing/white.png"))); // NOI18N
        s_jMenuItem7.setText("主機選擇白棋");
        s_jMenu11.add(s_jMenuItem7);
        s_jMenuItem7.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    NewplayipwhiteActionPerformed(evt);
                } catch (Exception ex) {
                    System.out.println("Error : " + ex.getMessage());
                    s_textjlabel.setText("Error : " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        s_jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gobang/drawing/black.png"))); // NOI18N
        s_jMenuItem8.setText("主機選擇黑棋");
        s_jMenu11.add(s_jMenuItem8);
        s_jMenuItem8.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    NewplayipblackActionPerformed(evt);
                } catch (Exception ex) {
                    System.out.println("Error : " + ex.getMessage());
                    s_textjlabel.setText("Error : " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        s_newplayip.add(s_jMenu11);

        s_jMenu10.setText("連線至對方IP");

        s_newplayip.add(s_jMenu10);

        s_newplay.add(s_newplayip);

        s_newstart.add(s_newplay);

        s_jMenuBar1.add(s_newstart);


        s_special.setText("特殊");

        s_jMenuItem1.setText("印出全部棋資料");

        s_jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpecialActionPerformed(evt);
            }
        });
        s_special.add(s_jMenuItem1);

        s_jMenuBar1.add(s_special);

        setJMenuBar(s_jMenuBar1);
        setBounds(0, 0, 800, 700);
    //pack();
    }// </editor-fold>

    private void IptonewplayActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        removeMouseMotionListener(s_procmouse);
        removeMouseListener(s_checkmouseplay2p);
        removeMouseListener(s_checkmouseai);
        removeMouseListener(s_checkmouseplayip);
        removeMouseListener(s_checkmouseplayipserver);
        setTitle("等待伺服器回應");
        s_textjlabel.setText("");
        s_settingimage = new ImageIcon(s_gobangimage.getImage());
        s_ipplayint = s_blackint;
        Newgobangbox();
        addMouseMotionListener(s_procmouse);
        addMouseListener(s_checkmouseplayip);
        s_settingjpanel.updateUI();
        repaint();
        try {
            setTitle("等待伺服器回應");
            s_receive = Receiveint();
            if (s_receive == -1) {
                s_cursorimage = new ImageIcon(s_whiteimage.getImage());
                s_cursorint = s_whiteint;
            }
            if (s_receive == 1) {
                s_cursorimage = new ImageIcon(s_blackimage.getImage());
                s_cursorint = s_blackint;
            }
            s_ipint = s_receive * -1;
            setTitle("伺服器ip:" + s_textip.getText());
            System.out.println("ipint=" + s_ipint + "ipplayint=" + s_ipplayint);
            if (s_ipint != s_ipplayint) {
                System.out.print("接收資料");
                int num = Receiveint();
                s_cursorint *= -1;
                if (s_cursorint == -1) {
                    s_cursorimage = new ImageIcon(s_blackimage.getImage());
                }
                if (s_cursorint == 1) {
                    s_cursorimage = new ImageIcon(s_whiteimage.getImage());
                }
                s_gobangint[num].m_gobangint = s_cursorint;
                Numtoxy(num);
                Playjlabelgobantint();
                s_cursorint *= -1;
                if (s_cursorint == -1) {
                    s_cursorimage = new ImageIcon(s_blackimage.getImage());
                }
                if (s_cursorint == 1) {
                    s_cursorimage = new ImageIcon(s_whiteimage.getImage());
                }
            }

        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
            s_textjlabel.setText("Error : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void NewplayipblackActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        removeMouseMotionListener(s_procmouse);
        removeMouseListener(s_checkmouseplay2p);
        removeMouseListener(s_checkmouseai);
        removeMouseListener(s_checkmouseplayip);
        removeMouseListener(s_checkmouseplayipserver);
        s_ipint = -1;
        setTitle("等待對方連線");
        s_textjlabel.setText("");
        s_settingimage = new ImageIcon(s_gobangimage.getImage());
        s_cursorimage = new ImageIcon(s_blackimage.getImage());
        s_cursorint = s_blackint;
        Newgobangbox();
        s_ipplayint = s_blackint;
        s_ss = new ServerSocket(12345);
        Conveyintserver(s_ipint);
        addMouseMotionListener(s_procmouse);
        addMouseListener(s_checkmouseplayipserver);
        s_settingjpanel.updateUI();
        repaint();
    }

    private void NewplayipwhiteActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        // TODO add your handling code here:
        removeMouseMotionListener(s_procmouse);
        removeMouseListener(s_checkmouseplay2p);
        removeMouseListener(s_checkmouseai);
        removeMouseListener(s_checkmouseplayip);
        removeMouseListener(s_checkmouseplayipserver);
        s_ipint = 1;
        setTitle("等待對方連線");
        s_textjlabel.setText("");
        s_settingimage = new ImageIcon(s_gobangimage.getImage());
        s_cursorimage = new ImageIcon(s_whiteimage.getImage());
        s_cursorint = s_whiteint;
        Newgobangbox();
        s_ipplayint = s_blackint;
        s_ss = new ServerSocket(12345);
        Conveyintserver(s_ipint);
        addMouseMotionListener(s_procmouse);
        addMouseListener(s_checkmouseplayipserver);
        s_settingjpanel.updateUI();
        repaint();
        try {
            System.out.print("接收資料");
            int num = Receiveintserver();
            s_cursorint *= -1;
            if (s_cursorint == -1) {
                s_cursorimage = new ImageIcon(s_blackimage.getImage());
            }
            if (s_cursorint == 1) {
                s_cursorimage = new ImageIcon(s_whiteimage.getImage());
            }
            s_gobangint[num].m_gobangint = s_cursorint;
            Numtoxy(num);
            Playjlabelgobantint();
            s_cursorint *= -1;
            if (s_cursorint == -1) {
                s_cursorimage = new ImageIcon(s_blackimage.getImage());
            }
            if (s_cursorint == 1) {
                s_cursorimage = new ImageIcon(s_whiteimage.getImage());
            }

        } catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
            s_textjlabel.setText("Error : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void SpecialActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int num = 0;
        while (num < 225) {
            System.out.println("numint = " + s_gobangint[num].m_numint +
                    "gobangint = " + s_gobangint[num].m_gobangint +
                    "aiint = " + s_gobangint[num].m_aiint);
            num++;
        }
    }

    private void NewComperAIwhiteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        removeMouseMotionListener(s_procmouse);
        removeMouseListener(s_checkmouseplay2p);
        removeMouseListener(s_checkmouseai);
        removeMouseListener(s_checkmouseplayip);
        removeMouseListener(s_checkmouseplayipserver);
        setTitle("智障AI白棋版");
        s_textjlabel.setText("");
        s_settingimage = new ImageIcon(s_gobangimage.getImage());//修改滑鼠資料
        s_cursorimage = new ImageIcon(s_whiteimage.getImage());
        s_cursorint = s_whiteint;
        Newgobangbox(); //重新設定棋子資料庫
        s_aiint = -1;    //ai棋子選定
        addMouseMotionListener(s_procmouse);
        addMouseListener(s_checkmouseai);
        Aiplay(); //黑棋先下
        s_settingjpanel.updateUI();
        repaint();


    }

    private void NewComperAIblackActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        removeMouseMotionListener(s_procmouse);
        removeMouseListener(s_checkmouseplay2p);
        removeMouseListener(s_checkmouseai);
        removeMouseListener(s_checkmouseplayip);
        removeMouseListener(s_checkmouseplayipserver);
        setTitle("智障AI黑棋版");
        s_textjlabel.setText("");
        s_settingimage = new ImageIcon(s_gobangimage.getImage());
        s_cursorimage = new ImageIcon(s_blackimage.getImage());
        s_cursorint = s_blackint;
        Newgobangbox();
        s_aiint = 1;
        addMouseMotionListener(s_procmouse);
        addMouseListener(s_checkmouseai);
                s_settingjpanel.updateUI();
        repaint();


    }

    private void NewplayersActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        removeMouseMotionListener(s_procmouse);
        removeMouseListener(s_checkmouseplay2p);
        removeMouseListener(s_checkmouseai);
        removeMouseListener(s_checkmouseplayip);
        removeMouseListener(s_checkmouseplayipserver);
        setTitle("玩家雙打");
        s_textjlabel.setText("");
        s_settingimage = new ImageIcon(s_gobangimage.getImage());
        s_cursorimage = new ImageIcon(s_blackimage.getImage());
        Newgobangbox();
        s_cursorint = s_blackint;
        addMouseMotionListener(s_procmouse);
        addMouseListener(s_checkmouseplay2p);
        s_settingjpanel.updateUI();
        repaint();
    }

    void Transform() {
        int num = 0;
        num = s_x / 40;
        s_x = num * 40 + 20;
        num = s_y / 39;
        s_y = num * 39 + 20;
    }

    void Newgobangbox() {
        int m_num = 0;
        if (s_newplayint == 0) {
            s_gobangint = new Gobangboxint[225];
        }
        while (m_num < 225) {
            if (s_newplayint == 0) {
                s_gobangint[m_num] = new Gobangboxint();
                s_gobangint[m_num].m_gobang = new JLabel();
                s_gobangint[m_num].m_gobangint = 0;
            }
            if (s_gobangint[m_num].m_gobangint != 0) {
                s_settingjpanel.remove(s_gobangint[m_num].m_gobang);
                s_gobangint[m_num].m_gobang = new JLabel();
                s_gobangint[m_num].m_gobangint = 0;
                s_gobangint[m_num].m_aiint = 0;

            }
            s_gobangint[m_num].m_numint = m_num;
            m_num++;
            s_settingjpanel.updateUI();
        }
        s_newplayint++;
    }

    boolean Aiintwrong(int m_add, int m_continuousgobang) {
        if ((m_continuousgobang >= 0 && m_continuousgobang <= 14) &&
                m_add < -1) {
            return false;
        }

        if (m_continuousgobang % 15 == 0 &&
                (m_add == -16 || m_add == -1 || m_add == 14)) {
            return false;

        }
        if (m_continuousgobang % 15 == 14 &&
                (m_add == -14 || m_add == 1 || m_add == 16)) {
            return false;
        }
        if ((m_continuousgobang >= 210 && m_continuousgobang <= 224) &&
                (m_add == 14 || m_add == 15 || m_add == 16)) {
            return false;
        }
        return true;
    }

    void Aiinticreaserunning(int m_num, int m_continuousgobangtopnum, int m_continuousgobangendnum,
            int m_continuousgobangtopint, int m_continuousgobangendint, int m_continuous) {
        int m_continuouscursorint = 0;
        int m_continuousint = 0;
        if (m_continuous == 1) {
            m_continuousint = s_oneaiint;
            m_continuouscursorint = s_oneplayint;
        }
        if (m_continuous == 2) {
            m_continuousint = s_twoaiint;
            m_continuouscursorint = s_twoplayint;
        }
        if (m_continuous == 3) {
            m_continuousint = s_threeaiint;
            m_continuouscursorint = s_threeplayint;
        }
        if (m_continuous == 4) {
            m_continuousint = s_fouraiint;
            m_continuouscursorint = s_fourplayint;
        }

        if (m_continuousgobangtopint == 0 && m_continuousgobangendint == 0) {
            if (s_gobangint[m_num].m_gobangint == s_cursorint) {
                s_gobangint[m_continuousgobangtopnum].m_aiint += m_continuouscursorint;
                s_gobangint[m_continuousgobangendnum].m_aiint += m_continuouscursorint;
            } else {
                s_gobangint[m_continuousgobangtopnum].m_aiint += m_continuousint;
                s_gobangint[m_continuousgobangendnum].m_aiint += m_continuousint;
            }
        }

        if (m_continuousgobangtopint != 2) {
            if (s_gobangint[m_num].m_gobangint == s_cursorint) {
                s_gobangint[m_continuousgobangtopnum].m_aiint += m_continuouscursorint;
            } else {
                s_gobangint[m_continuousgobangtopnum].m_aiint += m_continuousint;
            }
        }

        if (m_continuousgobangendint != 2) {
            if (s_gobangint[m_num].m_gobangint == s_cursorint) {
                s_gobangint[m_continuousgobangendnum].m_aiint += m_continuouscursorint;
            } else {
                s_gobangint[m_continuousgobangendnum].m_aiint += m_continuousint;
            }
        }
    }

    boolean Aiintincreasetwoone(int m_add, int m_continuousgobang, int m_num) {
        if (Aiintwrong(m_add, m_continuousgobang)) {
            m_continuousgobang = Continuousincrease(m_continuousgobang, m_add);
            if (s_gobangint[m_continuousgobang].m_gobangint == s_gobangint[m_num].m_gobangint &&
                    Aiintwrong(m_add, m_continuousgobang)) {
                m_continuousgobang = Continuousincrease(m_continuousgobang, m_add);
                if (s_gobangint[m_continuousgobang].m_gobangint == s_gobangint[m_num].m_gobangint ||
                        s_gobangint[m_continuousgobang].m_gobangint == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean Aiintincreaseonetwo(int m_add, int m_continuousgobang, int m_num) {
        if (Aiintwrong(m_add, m_continuousgobang)) {
            m_continuousgobang = Continuousincrease(m_continuousgobang, m_add);
            if (s_gobangint[m_continuousgobang].m_gobangint == s_gobangint[m_num].m_gobangint &&
                    Aiintwrong(m_add, m_continuousgobang)) {
                m_continuousgobang = Continuousincrease(m_continuousgobang, m_add);
                if (s_gobangint[m_continuousgobang].m_gobangint == s_gobangint[m_num].m_gobangint &&
                        Aiintwrong(m_add, m_continuousgobang)) {
                    m_continuousgobang = Continuousincrease(m_continuousgobang, m_add);
                    if (s_gobangint[m_continuousgobang].m_gobangint == s_gobangint[m_num].m_gobangint ||
                            s_gobangint[m_continuousgobang].m_gobangint == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    void Aiintincrease(int m_add, int m_num, int m_continuousgobang, int m_continuous) {
        int m_continuousgobangtopint = 2;
        int m_continuousgobangendint = 2;
        int m_continuousgobangtopnum = 225;
        int m_continuousgobangendnum = 225;
        if (Aiintwrong(m_add, m_continuousgobang)) {
            m_continuousgobangendnum = m_continuousgobang;
            m_continuousgobangendint = s_gobangint[m_continuousgobangendnum].m_gobangint;
        }

        m_add *= -1;
        if (Aiintwrong(m_add, m_num)) {
            m_continuousgobangtopnum = Continuousincrease(m_num, m_add);
            m_continuousgobangtopint = s_gobangint[m_continuousgobangtopnum].m_gobangint;
        }
        m_add *= -1;
        if (m_continuous == 1) {
            m_add = 1;
            while (m_add != 17) {
                m_continuousgobang = m_num;
                if (Aiintwrong(m_add, m_continuousgobang)) {
                    m_continuousgobang = Continuousincrease(m_continuousgobang, m_add);
                    m_continuousgobangendnum = m_continuousgobang;
                    m_continuousgobangendint = s_gobangint[m_continuousgobangendnum].m_gobangint;
                }
                m_add *= -1;
                if (Aiintwrong(m_add, m_num)) {
                    m_continuousgobangtopnum = Continuousincrease(m_num, m_add);
                    m_continuousgobangtopint = s_gobangint[m_continuousgobangtopnum].m_gobangint;
                }
                m_add *= -1;
                if (m_continuousgobangtopint == 0 && m_continuousgobangendint == 0 &&
                        Aiintincreaseonetwo(m_add, m_continuousgobang, m_num)) {
                    s_gobangint[m_continuousgobangendnum].m_aiint += s_onetwo;

                }
                Aiinticreaserunning(m_num, m_continuousgobangtopnum, m_continuousgobangendnum,
                        m_continuousgobangtopint, m_continuousgobangendint, m_continuous);
                m_add = Continuousexitfalse(m_add);
            }
        } else {
            if (Aiintwrong(m_add, m_continuousgobang)) {
                if (m_continuousgobangtopint == 0 && m_continuousgobangendint == 0 &&
                        m_continuous == 2 && Aiintincreasetwoone(m_add, m_continuousgobang, m_num)) {
                    s_gobangint[m_continuousgobangendnum].m_aiint += s_twoone;
                }
                Aiinticreaserunning(m_num, m_continuousgobangtopnum, m_continuousgobangendnum,
                        m_continuousgobangtopint, m_continuousgobangendint, m_continuous);
            }
        }
    }

    void Aiplay() {
        int m_aimax = 0;    //設定ai最好的棋子值
        int m_num = 0;      //檢查棋子代號
        int m_continuous = 0;    //連續數
        int m_continuousgobang = 0;  //待檢查的副棋子
        int m_add = 1;   //判斷相鄰
        while (m_num < 225) {   //清空可能已使用的資料
            s_gobangint[m_num].m_aiint = 0;
            m_num++;
        }


        s_gobangint[112].m_aiint = 2;   //替最一開始創最好位子
        m_num = 0;
        while (m_num < 225) { //判斷每個棋子
            m_continuous = 0;
            m_add = 1;
            m_continuousgobang = m_num;
            while (m_continuousgobang < 225 && m_add != 17) {   //每個副棋子
                if (s_gobangint[m_num].m_gobangint != 0 && s_gobangint[m_num].m_gobangint == s_gobangint[m_continuousgobang].m_gobangint) {
                    m_continuous += 1;
                    if (Continuousexit(m_continuousgobang, m_add, m_num)) {
                        m_continuousgobang = Continuousincrease(m_continuousgobang, m_add);
                    } else if (m_continuous != 5) {
                        Aiintincrease(m_add, m_num, m_continuousgobang, m_continuous);
                        m_add = Continuousexitfalse(m_add);
                        m_continuousgobang = m_num;
                        m_continuous = 0;
                    }
                } else {
                    Aiintincrease(m_add, m_num, m_continuousgobang, m_continuous);
                    m_add = Continuousexitfalse(m_add);
                    m_continuousgobang = m_num;
                    m_continuous = 0;
                }


            }
            m_num++;
        }

        m_num = 0;
        s_aiintmax = new LinkedList();
        while (m_num < 225) {
            if (s_gobangint[m_num].m_gobangint != 0) {
                s_gobangint[m_num].m_aiint = 0;
            }
            if (m_aimax < s_gobangint[m_num].m_aiint) {
                m_aimax = s_gobangint[m_num].m_aiint;
                s_aiintmax = new LinkedList();
                s_aiintmax.add(s_gobangint[m_num]);
            }
            if (m_aimax == s_gobangint[m_num].m_aiint) {
                s_aiintmax.add(s_gobangint[m_num]);
            }
            m_num++;
        }

        Random m_randomint = new Random();
        m_num = m_randomint.nextInt(s_aiintmax.size());
        Gobangboxint airandom = new Gobangboxint();
        airandom = (Gobangboxint) s_aiintmax.get(m_num);
        m_num = airandom.m_numint;
        s_x = ((m_num % 15) * 40) + 20;
        s_y = ((m_num / 15) * 39) + 20;
        if (s_cursorint == -1) {
            s_gobangint[airandom.m_numint].m_gobang = new javax.swing.JLabel(new ImageIcon(s_whiteimage.getImage()));
            s_gobangint[airandom.m_numint].m_gobangint = 1;
        }
        if (s_cursorint == 1) {
            s_gobangint[airandom.m_numint].m_gobang = new javax.swing.JLabel(new ImageIcon(s_blackimage.getImage()));
            s_gobangint[airandom.m_numint].m_gobangint = -1;
        }
        s_settingjpanel.add(s_gobangint[airandom.m_numint].m_gobang,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(s_x, s_y, -1, -1));
        s_settingjpanel.updateUI();
    }

    boolean Winorlose() {
        int m_num = 0;
        int m_continuous = 0;
        int m_continuousgobang = 0;
        int m_add = 1;
        while (m_num < 225 && m_continuous != 5) {
            m_continuous = 0;
            m_add = 1;
            m_continuousgobang = m_num;
            while (m_continuousgobang < 225 && m_add != 17 && m_continuous != 5) {
                if (s_gobangint[m_num].m_gobangint == s_gobangint[m_continuousgobang].m_gobangint) {
                    m_continuous += 1;
                    if (Continuousexit(m_continuousgobang, m_add, m_num)) {
                        m_continuousgobang = Continuousincrease(m_continuousgobang, m_add);
                    } else if (m_continuous != 5) {
                        Aiintincrease(m_add, m_num, m_continuousgobang, m_continuous);
                        m_add = Continuousexitfalse(m_add);
                        m_continuousgobang = m_num;
                        m_continuous = 0;
                    }
                } else {
                    m_add = Continuousexitfalse(m_add);
                    m_continuousgobang = m_num;
                    m_continuous = 0;
                }
            }

            m_num++;
        }

        if (m_continuous == 5) {
            return true;
        } else {
            return false;
        }
    }

    int Continuousincrease(int m_continuousgobang, int m_add) {
        m_continuousgobang += m_add;
        return m_continuousgobang;
    }

    int Continuousexitfalse(int m_add) {
        if (m_add < -14) {
            m_add++;
        } else if (m_add == -14) {
            m_add = -1;
        } else if (m_add == -1) {
            m_add = 1;
        } else if (m_add == 1) {
            m_add = 14;
        } else {
            m_add++;
        }

        return m_add;

    }

    boolean Continuousexit(int m_continuousgobang, int m_add, int m_num) {
        if ((m_continuousgobang >= 210 && m_continuousgobang <= 224) &&
                (m_add == 14 || m_add == 15 || m_add == 16)) {
            return false;
        }
        if (m_continuousgobang % 15 == 14 && (m_add == 1 || m_add == 16)) {
            return false;
        }
        if (m_continuousgobang % 15 == 0 && m_add == 14) {
            return false;
        }

        if (s_gobangint[m_continuousgobang].m_gobangint != s_gobangint[m_num].m_gobangint || s_gobangint[m_continuousgobang].m_gobangint == 0) {
            return false;
        }
        return true;
    }

    boolean Changgobangint() {
        int m_num = 0;
        m_num = ((s_x - 20) / 40) + (((s_y - 20) / 39) * 15);
        if (s_gobangint[m_num].m_gobangint == 0) {
            s_gobangint[m_num].m_gobangint = s_cursorint;
            return true;
        } else {
            return false;
        }
    }

    void Playjlabelgobantint() {
        int m_num = 0;
        m_num = ((s_x - 20) / 40) + (((s_y - 20) / 39) * 15);
        s_gobangint[m_num].m_gobang = new javax.swing.JLabel(new ImageIcon(s_cursorimage.getImage()));
        s_settingjpanel.add(s_gobangint[m_num].m_gobang,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(s_x, s_y, -1, -1));
        s_settingjpanel.updateUI();

    }

    void Numtoxy(int m_num) {
        s_x = ((m_num % 15) * 40) + 20;
        s_y = ((m_num / 15) * 39) + 20;
    }

    int Xytonum() {
        int m_num = 0;
        m_num = ((s_x - 20) / 40) + (((s_y - 20) / 39) * 15);
        return m_num;
    }

    void Ipplay() {
        s_cursorint = s_ipint;
        if (s_ipint == 1) {
            s_cursorimage = new ImageIcon(s_whiteimage.getImage());
        }

        if (s_ipint == -1) {
            s_cursorimage = new ImageIcon(s_blackimage.getImage());
        }
    }

    class Procmouse extends MouseMotionAdapter {

        public void mouseMoved(MouseEvent e) {
            s_x = e.getX() - 20;
            s_y = e.getY() - 70;
            repaint();
        }
    }

    class Checkmouseplayipserver extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int button = e.getButton();
            if (button == e.BUTTON1) {
                if (Boangwrong()) {
                    Transform();
                    if (!Winorlose() && Boangwrong() && Changgobangint()) {
                        Playjlabelgobantint();
                        try {
                            System.out.println("num=" + Xytonum());
                            System.out.print("傳送資料");
                            Conveyintserver(Xytonum());
                            System.out.print("傳送資料end");
                            if (!Winorlose()) {
                                System.out.print("接收資料");
                                int m_num = Receiveintserver();
                                System.out.print("接收資料end");
                                s_cursorint *= -1;
                                if (s_cursorint == -1) {
                                    s_cursorimage = new ImageIcon(s_blackimage.getImage());
                                }
                                if (s_cursorint == 1) {
                                    s_cursorimage = new ImageIcon(s_whiteimage.getImage());
                                }
                                s_gobangint[m_num].m_gobangint = s_cursorint;
                                Numtoxy(m_num);
                                Playjlabelgobantint();
                                s_cursorint *= -1;
                                if (s_cursorint == -1) {
                                    s_cursorimage = new ImageIcon(s_blackimage.getImage());
                                }
                                if (s_cursorint == 1) {
                                    s_cursorimage = new ImageIcon(s_whiteimage.getImage());
                                }

                                if (Winorlose()) {
                                    if (s_cursorint == -1) {
                                        s_textjlabel.setText("白棋勝利");
                                        System.out.println("白棋勝利");
                                    } else if (s_cursorint == 1) {
                                        s_textjlabel.setText("黑棋勝利");
                                        System.out.println("黑棋勝利");
                                    } else {
                                        //   s_textjlabel.setText("亂點");
                                        System.out.println("...亂點");

                                    }
                                    s_cursorimage = new ImageIcon("");
                                    s_cursorint = 0;
                                }
                            }
                        } catch (Exception ex) {
                            System.out.println("Error : " + ex.getMessage());
                            s_textjlabel.setText("Error : " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }

                    if (Winorlose()) {
                        if (s_cursorint == 1) {
                            s_textjlabel.setText("白棋勝利");
                            System.out.println("白棋勝利");
                        } else if (s_cursorint == -1) {
                            s_textjlabel.setText("黑棋勝利");
                            System.out.println("黑棋勝利");
                        } else {
                            //  s_textjlabel.setText("亂點");
                            System.out.println("...亂點");

                        }
                        s_cursorimage = new ImageIcon("");
                        s_cursorint = 0;
                    }
                }
            }
            repaint();
        }
    }

    class Checkmouseplayip extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int button = e.getButton();
            if (button == e.BUTTON1) {
                if (Boangwrong()) {
                    Transform();
                    if (!Winorlose() && Boangwrong() && Changgobangint()) {
                        Playjlabelgobantint();
                        try {
                            System.out.println("num=" + Xytonum());
                            System.out.print("傳送資料");
                            Conveyint(Xytonum());
                            System.out.print("傳送資料end");

                            if (!Winorlose()) {
                                System.out.print("接收資料");
                                int m_num = Receiveint();
                                System.out.print("接收資料end");
                                s_cursorint *= -1;
                                if (s_cursorint == -1) {
                                    s_cursorimage = new ImageIcon(s_blackimage.getImage());
                                }
                                if (s_cursorint == 1) {
                                    s_cursorimage = new ImageIcon(s_whiteimage.getImage());
                                }
                                s_gobangint[m_num].m_gobangint = s_cursorint;
                                Numtoxy(m_num);
                                Playjlabelgobantint();
                                s_cursorint *= -1;
                                if (s_cursorint == -1) {
                                    s_cursorimage = new ImageIcon(s_blackimage.getImage());
                                }
                                if (s_cursorint == 1) {
                                    s_cursorimage = new ImageIcon(s_whiteimage.getImage());
                                }
                                if (Winorlose()) {
                                    if (s_cursorint == -1) {
                                        s_textjlabel.setText("白棋勝利");
                                        System.out.println("白棋勝利");
                                    } else if (s_cursorint == 1) {
                                        s_textjlabel.setText("黑棋勝利");
                                        System.out.println("黑棋勝利");
                                    } else {
                                        // s_textjlabel.setText("亂點");
                                        System.out.println("...亂點");

                                    }
                                    s_cursorimage = new ImageIcon("");
                                    s_cursorint = 0;
                                }
                            }

                        } catch (Exception ex) {
                            System.out.println("Error : " + ex.getMessage());
                            s_textjlabel.setText("Error : " + ex.getMessage());
                            ex.printStackTrace();
                        }
                    }

                    if (Winorlose()) {
                        if (s_cursorint == 1) {
                            s_textjlabel.setText("白棋勝利");
                            System.out.println("白棋勝利");
                        } else if (s_cursorint == -1) {
                            s_textjlabel.setText("黑棋勝利");
                            System.out.println("黑棋勝利");
                        } else {
                            //  s_textjlabel.setText("亂點");
                            System.out.println("...亂點");

                        }
                        s_cursorimage = new ImageIcon("");
                        s_cursorint = 0;
                    }

                }
            }
            repaint();
        }
    }

    class Checkmouseai extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int button = e.getButton();
            if (button == e.BUTTON1) {
                if (Boangwrong()) {
                    Transform();
                    if (Changgobangint()) {
                        Playjlabelgobantint();
                        if (Winorlose()) {
                            if (s_cursorint == 1) {
                                s_textjlabel.setText("白棋勝利");
                                System.out.println("白棋勝利");
                            } else if (s_cursorint == -1) {
                                s_textjlabel.setText("黑棋勝利");
                                System.out.println("黑棋勝利");
                            } else {
                                //  s_textjlabel.setText("亂點");
                                System.out.println("...亂點");

                            }
                            s_cursorimage = new ImageIcon("");
                            s_cursorint = 0;
                        }
                    }

                    Aiplay();
                    if (Winorlose()) {
                        if (s_cursorint == 1) {
                            s_textjlabel.setText("黑棋勝利");
                            System.out.println("黑棋勝利");
                        } else if (s_cursorint == -1) {
                            s_textjlabel.setText("白棋勝利");
                            System.out.println("白棋勝利");
                        } else {
                            // s_textjlabel.setText("亂點");
                            System.out.println("...亂點");

                        }
                        s_cursorimage = new ImageIcon("");
                        s_cursorint = 0;
                    }
                }
            }
            repaint();
        }
    }

    class Checkmouseplay2p extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int button = e.getButton();
            if (button == e.BUTTON1) {
                if (Boangwrong()) {
                    Transform();
                    if (Changgobangint() && Boangwrong()) {
                        Playjlabelgobantint();
                        if (!Winorlose()) {
                            if (s_cursorint == -1) {
                                s_cursorimage = new ImageIcon(s_whiteimage.getImage());
                                s_cursorint = 1;
                            } else {
                                s_cursorimage = new ImageIcon(s_blackimage.getImage());
                                s_cursorint = -1;
                            }
                            s_settingjpanel.updateUI();
                        } else {
                            if (s_cursorint == 1) {
                                s_textjlabel.setText("白棋勝利");
                                System.out.println("白棋勝利");
                            } else if (s_cursorint == -1) {
                                s_textjlabel.setText("黑棋勝利");
                                System.out.println("黑棋勝利");
                            } else {
                                //s_textjlabel.setText("亂點");
                                System.out.println("...亂點");

                            }
                            s_cursorimage = new ImageIcon("");
                            s_cursorint = 0;
                        }
                    }
                }
            }
            repaint();
        }
    }

    boolean Boangwrong() {
        if (s_x > 600 || s_y > 600) {
            return false;
        }

        return true;
    }

    public static void Conveyintserver(int num) throws IOException {
        Socket m_cs;
        InputStream m_ism = null;
        InputStreamReader m_isr = null;
        BufferedReader m_bfr = null;
        OutputStream m_ops; // 在 Socket 上準備好資料流
        OutputStreamWriter m_osw;
        try {
            m_cs = s_ss.accept();
            m_ops = m_cs.getOutputStream(); // 在 Socket 上準備好資料流
            m_osw = new OutputStreamWriter(m_ops);
            s_conveystring = Integer.toString(num);
            m_osw.write(s_conveystring);
            m_osw.close();
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void Conveyint(int m_num) throws IOException {
        Socket m_cs;
        InputStream m_ism = null;
        InputStreamReader m_isr = null;
        BufferedReader m_bfr = null;
        OutputStream m_ops; // 在 Socket 上準備好資料流
        OutputStreamWriter m_osw;
        try {
            m_cs = new Socket(s_textip.getText(), 12345);
            m_ops = m_cs.getOutputStream(); // 在 Socket 上準備好資料流
            m_osw = new OutputStreamWriter(m_ops);
            s_conveystring = Integer.toString(m_num);
            m_osw.write(s_conveystring);
            m_osw.close();
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static int Receiveintserver() {
        int m_num = 0;
        Socket m_cs;
        InputStream m_ism = null;
        InputStreamReader m_isr = null;
        BufferedReader m_bfr = null;
        OutputStream m_ops; // 在 Socket 上準備好資料流
        OutputStreamWriter m_osw;
        try {
            m_cs = s_ss.accept();
            m_ism = m_cs.getInputStream();
            m_isr = new InputStreamReader(m_ism);
            m_bfr = new BufferedReader(m_isr);
            m_num = java.lang.Integer.parseInt(m_bfr.readLine());
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
            ex.printStackTrace();
        }
        return m_num;
    }

    public static int Receiveint() {
        int m_num = 0;
        Socket m_cs;
        InputStream m_ism = null;
        InputStreamReader m_isr = null;
        BufferedReader m_bfr = null;
        OutputStream m_ops; // 在 Socket 上準備好資料流
        OutputStreamWriter m_osw;
        try {
            m_cs = new Socket(s_textip.getText(), 12345);
            m_ism = m_cs.getInputStream();
            m_isr = new InputStreamReader(m_ism);
            m_bfr = new BufferedReader(m_isr);
            m_num = java.lang.Integer.parseInt(m_bfr.readLine());
        } catch (Exception ex) {
            System.out.println("Error :" + ex.getMessage());
            ex.printStackTrace();
        }
        return m_num;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Gobang().setVisible(true);
            }
        });
    }

    public class Gobangboxint {

        public int m_numint;
        public JLabel m_gobang = new JLabel();
        public int m_gobangint = 0;
        public int m_aiint = 0;
    }
    public int s_x;
    public int s_y;
    public ImageIcon s_gobangimage = new javax.swing.ImageIcon(getClass().getResource("/Gobang/drawing/gobangimage.gif"));
    public ImageIcon s_settingimage = new javax.swing.ImageIcon(getClass().getResource("/Gobang/drawing/dog.jpg"));
    public ImageIcon s_blackimage = new javax.swing.ImageIcon(getClass().getResource("/Gobang/drawing/black.png"));
    public final int s_blackint = -1;
    public ImageIcon s_whiteimage = new javax.swing.ImageIcon(getClass().getResource("drawing/white.png"));
    public final int s_whiteint = 1;
    public ImageIcon s_whiteboximgae = new javax.swing.ImageIcon(getClass().getResource("drawing/whitebox.png"));
    public ImageIcon s_blackboximgae = new javax.swing.ImageIcon(getClass().getResource("drawing/blackbox.png"));
    public ImageIcon s_cursorimage = new ImageIcon("");
    public int s_cursorint = -1;
    public Gobangboxint[] s_gobangint;
    public int s_oneplayint = 5;
    public int s_oneaiint = 10;
    public int s_twoplayint = 100;
    public int s_twoaiint = 150;
    public int s_threeplayint = 1000;
    public int s_threeaiint = 1100;
    public int s_onetwo = 5000;
    public int s_twoone = 7000;
    public int s_fourplayint = 100000;
    public int s_fouraiint = 110000;
    public int s_newplayint = 0;
    public int s_aiint = 0;
    public int s_ipint = 0;
    public static String s_conveystring;
    public static ServerSocket s_ss;
    private Checkmouseplayip s_checkmouseplayip = new Checkmouseplayip();
    private Procmouse s_procmouse = new Procmouse();
    private Checkmouseai s_checkmouseai = new Checkmouseai();
    private Checkmouseplay2p s_checkmouseplay2p = new Checkmouseplay2p();
    private Checkmouseplayipserver s_checkmouseplayipserver = new Checkmouseplayipserver();
    public LinkedList s_aiintmax = new LinkedList();
    public JLabel s_gobangboxjlabel;
    public JLabel s_textjlabel = new JLabel("Text!!!");
    public static JTextField s_textip = new JTextField("輸入對方ip");
    public ImageIcon s_gobangboxjlabelimage = new javax.swing.ImageIcon(getClass().getResource("drawing/blackbox.png"));
    public int s_ipplayint = 0;
    public int s_receive;
    private javax.swing.ButtonGroup s_buttonGroup1;
    private javax.swing.ButtonGroup s_buttonGroup2;
    private javax.swing.JMenu s_jMenu10;
    private javax.swing.JMenu s_jMenu11;
    private javax.swing.JMenu s_jMenu2;
    private javax.swing.JMenuItem s_ip;
    private javax.swing.JMenuBar s_jMenuBar1;
    private javax.swing.JMenuBar s_jMenuBar2;
    private javax.swing.JMenuItem s_jMenuItem1;
    private javax.swing.JMenuItem s_jMenuItem3;
    private javax.swing.JMenuItem s_jMenuItem4;
    private javax.swing.JMenuItem s_jMenuItem7;
    private javax.swing.JMenuItem s_jMenuItem8;
    private javax.swing.JMenu s_newcomper;
    private javax.swing.JMenu s_newcomperai;
    private javax.swing.JMenu s_newplay;
    private javax.swing.JMenu s_newplay2p;
    private javax.swing.JMenuItem s_newplayersblack;
    private javax.swing.JMenuItem s_newplayerswhite;
    private javax.swing.JMenu s_newplayip;
    private javax.swing.JMenu s_newstart;
    private javax.swing.JPanel s_settingjpanel;
    private javax.swing.JMenu s_special;
}