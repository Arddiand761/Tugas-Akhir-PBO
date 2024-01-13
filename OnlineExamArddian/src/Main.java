import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton[] jb = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, now = 0;
    int[] m = new int[20];

    OnlineTest(String s) {
        super(s);
        getContentPane().setBackground(new Color(178, 255, 255));
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setBackground(new Color(0, 128, 128));
        b2.setBackground(new Color(178, 238, 238));
        add(b1);
        add(b2);
        set();
        l.setBounds(40, 30, 2050, 40);
        jb[0].setBounds(50, 80, 200, 20);
        jb[0].setBackground(new Color(64, 224, 208));
        jb[1].setBounds(50, 110, 200, 20);
        jb[1].setBackground(new Color(64, 224, 208));
        jb[2].setBounds(50, 140, 200, 20);
        jb[2].setBackground(new Color(64, 224, 208));
        jb[3].setBounds(50, 170, 200, 20);
        jb[3].setBackground(new Color(64, 224, 208));
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;

            current++;
            set();

            if (current == 19) {
                b1.setEnabled(false);
                b2.setText("Result");
                b2.setBackground(Color.GREEN);
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 19)
                b2.setText("Result");

            setVisible(false);
            setVisible(true);

        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            JOptionPane.showMessageDialog(this, "Nilai=" + count * 5);
            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("1.Apa nama tradisi unik Suku Jawa dalam menyambut tamu yang baru datang?");
            jb[0].setText("Sogokan");
            jb[1].setText("Selametan");
            jb[2].setText("Seba");
            jb[3].setText(" Sedekah Laut");
        }
        if (current == 1) {
            l.setText("2: Jenis musik tradisional yang berasal dari Suku Jawa adalah?");
            jb[0].setText("Angklung");
            jb[1].setText("Gamelan");
            jb[2].setText("Saron");
            jb[3].setText("Rebab");
        }
        if(current==2)
        {
            l.setText("3: Apa nama sajian kuliner khas Suku Jawa yang terbuat dari nasi kuning dan hidangan lauk?");
            jb[0].setText(" Nasi Goreng");jb[1].setText("Nasi Campur");jb[2].setText("Nasi Kuning");jb[3].setText("Nasi Uduk");
        }
        if(current==3)
        {
            l.setText("4: Pakaian adat tradisional Suku Jawa untuk wanita disebut?");
            jb[0].setText("Kebaya");jb[1].setText("Batik");jb[2].setText("Jarik");jb[3].setText("Blangkon");
        }
        if(current==4)
        {
            l.setText("5: Apa nama upacara tradisional Suku Jawa yang dilakukan ketika bayi menginjak usia 40 hari?");
            jb[0].setText("Siraman");jb[1].setText(" Turun Tanah");jb[2].setText("Midodareni");jb[3].setText("Tahlilan");
        }
        if(current==5)
        {
            l.setText("6: Wayang Kulit, seni pertunjukan tradisional Suku Jawa, menggunakan layar dari bahan apa?");
            jb[0].setText("Kertas");jb[1].setText("Kulit kambing");jb[2].setText("Kain songket");jb[3].setText(" Logam");
        }
        if(current==6)
        {
            l.setText("7: Apa nama istana keraton yang terkenal di Yogyakarta, yang masih dihuni oleh keluarga keraton? ");
            jb[0].setText(" Keraton Solo");jb[1].setText("Keraton Yogyakarta");jb[2].setText("Keraton Cirebon");
            jb[3].setText("Keraton Kasepuhan");
        }
        if(current==7)
        {
            l.setText("8: Tarian tradisional dari Suku Jawa yang menggambarkan kehidupan petani adalah?");
            jb[0].setText(" Tari Reog Ponorogo");jb[1].setText(" Tari Saman");jb[2].setText("Tari Topeng");
            jb[3].setText("Tari Bedhaya");
        }
        if(current==8)
        {
            l.setText("9: Apa nama senjata tradisional Suku Jawa yang berbentuk keris?");
            jb[0].setText(" Golok");jb[1].setText("Kujang ");jb[2].setText("Sundang");jb[3].setText(" Kris");
        }
        if(current==9)
        {
            l.setText("10: Nama tradisi adat Suku Jawa dalam menyambut bulan Ramadan adalah?");
            jb[0].setText(" Ngalap Berkah");jb[1].setText("Sedekah Bumi");jb[2].setText("Ruwatan");
            jb[3].setText(" Puasa Suro");
        }
        if(current == 10)
        {
            l.setText("11: Apa nama festival seni budaya yang rutin diadakan di Solo, Jawa Tengah?");
            jb[0].setText("  Festival Kebudayaan Borobudur");jb[1].setText("Festival Jember Fashion Carnival");jb[2].setText("Festival Wayang Kulit");
            jb[3].setText(" Solo Batik Carnival");
        }
        if(current == 11)
        {
            l.setText("12: Apa nama alat musik tradisional Jawa yang merupakan jenis gendang besar?");
            jb[0].setText("  Kendang");jb[1].setText("Sedekah Bumi");jb[2].setText("Ruwatan");
            jb[3].setText(" Puasa Suro");
        }
        if(current == 12)
        {
            l.setText("13: Apa nama puisi Jawa yang biasanya disampaikan secara lisan dan memiliki irama khusus?");
            jb[0].setText(" Wayang Kulit");jb[1].setText(" Kidung");jb[2].setText("Tembang");
            jb[3].setText("Jaranan");
        }
        if(current == 13)
        {
            l.setText("14: Siapa pendiri kerajaan Mataram yang menjadi cikal bakal Kerajaan Mataram Islam?");
            jb[0].setText("  Sultan Agung Hanyakrakusuma");jb[1].setText(" Senopati");jb[2].setText("Panembahan Senopati");
            jb[3].setText("  Sultan Agung Adi Prabu Hanyakrakusuma");
        }
        if(current == 14)
        {
            l.setText("15: Apa nama tarian tradisional yang biasa dipentaskan dalam upacara pernikahan di Jawa?");
            jb[0].setText(" Tari Srimpi");jb[1].setText("Tari Jaipong");jb[2].setText("Tari Kebyar");
            jb[3].setText(" Tari Legong");
        }
        if(current == 15)
        {
            l.setText("16: Seni ukir tradisional dari Jawa yang biasanya menghiasi bangunan atau perabot rumah adalah?");
            jb[0].setText(" Wayang Kulit");jb[1].setText("Ukir Jawa");jb[2].setText("Batik");
            jb[3].setText(" Kain Ikat");
        }
        if(current == 16)
        {
            l.setText("17: Apa nama istilah dalam Suku Jawa yang menggambarkan perjalanan spiritual untuk mencapai kesempurnaan?");
            jb[0].setText(" Wayang");jb[1].setText("Samadi");jb[2].setText("Slametan");
            jb[3].setText(" Rukun");
        }
        if(current == 17)
        {
            l.setText("18: Apa nama upacara adat Jawa yang dilakukan untuk membersihkan diri dari energi negatif?");
            jb[0].setText(" Ruwatan");jb[1].setText(" Selametan");jb[2].setText("Nyadran");
            jb[3].setText(" Naloni Mitoni");
        }
        if (current == 18) {
            l.setText("19: Batik motif Parang Rusak memiliki makna apa dalam budaya Jawa?");
            jb[0].setText(" Kesejahteraan");
            jb[1].setText("Kekuatan");
            jb[2].setText("Kesempurnaan");
            jb[3].setText(" Keharmonisan");
        }
        if (current == 19) {
            l.setText("20: Apa nama permainan tradisional Jawa yang menggunakan lingkaran bambu dan bola sebagai alat utama?");
            jb[0].setText(" Egrang");
            jb[1].setText(" Bakiak");
            jb[2].setText(" Sepak Bola");
            jb[3].setText(" Congklak");
        }
        l.setBounds(40, 30, 2050, 40);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 300, 20);
    }

    boolean check() {
        // Fungsi check diubah sesuai dengan nomor urut pertanyaan
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[1].isSelected());
        if(current==2)
            return(jb[2].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[1].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[3].isSelected());
        if(current==9)
            return(jb[3].isSelected());
        if(current==10)
            return (jb[3].isSelected());
        if(current==11)
            return (jb[0].isSelected());
        if(current==12)
            return (jb[2].isSelected());
        if(current==13)
            return (jb[2].isSelected());
        if(current==14)
            return (jb[0].isSelected());
        if(current==15)
            return (jb[1].isSelected());
        if(current==16)
            return (jb[1].isSelected());
        if(current==17)
            return (jb[0].isSelected());
        if (current == 18)
            return (jb[1].isSelected());
        if (current == 19)
            return (jb[0].isSelected());
        return false;
    }

    public static void main(String[] args) {
        new OnlineTest("Apakah Kamu seorang jawa sejati?");
    }
}
