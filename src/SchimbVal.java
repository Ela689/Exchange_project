
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class SchimbVal extends JFrame implements ActionListener{
    JComboBox fromcountry,tocountry;
    JButton convert,reset,exit;
    JLabel fromunit,tounit;
    TextField fromtext;
    TextField Answer;

    String[] currencyUnits=
            {
                    "units",
                    "MDL",
                    "RON",
                    "USD",
                    "GBP",
                    "UAH",
                    "RUB",
                    "CHF",
                    "EUR",
            };

    double MDL = 24.19;
    double RON = 5.94;
    double US_Dollar = 1.31;
    double GBP = 1;
    double UAH = 38.36;
    double RUB = 104.37;
    double CHF = 1.24;
    double EUR = 1.20;

    SchimbVal()
    {
        setBounds(300,60,790,700);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel maintitle = new JLabel("Currency Converter");
        maintitle.setBounds(150,30,650,60);
        maintitle.setFont(new Font("Open Sans",Font.BOLD,50));
        maintitle.setForeground(Color.white);
        add(maintitle);

        JLabel from = new JLabel("From");
        from.setBounds(10,160,55,50);
        from.setFont(new Font("Open Sans",Font.BOLD,20));
        from.setForeground(Color.white);
        add(from);

        fromcountry = new JComboBox(new String[] { "Select One..", "Moldova", "Romania", "USA", "UK", "Ukraine", "Russia", "Switzerland", "EU"});
        fromcountry.setBounds(100,165,200,40);
        fromcountry.setFont(new Font("Open Sans",Font.BOLD,20));
        //fromcountry.setForeground(Color.white);
        fromcountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                fromcountryItemStateChanged(evt);
            }
        });
        add(fromcountry);

        fromtext = new TextField();
        fromtext.setBounds(350,165,250, 40);
        fromtext.setFont(new Font("Open Sans",Font.BOLD,20));
        fromtext.setForeground(Color.BLACK);
        add(fromtext);

        fromunit = new JLabel("Unit");
        fromunit.setBounds(655,185,200,40);
        fromunit.setFont(new Font("Open Sans",Font.BOLD,15));
        fromunit.setForeground(Color.BLACK);
        add(fromunit);

        JLabel to = new JLabel("To");
        to.setBounds(10,310,50,50);
        to.setFont(new Font("Open Sans",Font.BOLD,20));
        to.setForeground(Color.white);
        add(to);

        tocountry = new JComboBox(new String[] { "Select One..", "Moldova", "Romania", "USA", "UK", "Ukraine", "Russia", "Switzerland", "EU" });
        tocountry.setBounds(100,310,200,40);
        tocountry.setFont(new Font("Open Sans",Font.BOLD,20));
        //tocountry.setForeground(Color.white);
        tocountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                tocountryItemStateChanged(evt);
            }
        });
        add(tocountry);

        Answer = new TextField(" ");
        Answer.setBounds(350,310,250, 40);
        Answer.setFont(new Font("Open Sans",Font.BOLD,20));
        Answer.setForeground(Color.BLACK);
        add(Answer);

        tounit = new JLabel("Unit");
        tounit.setBounds(655,290,250,90);
        tounit.setFont(new Font("Open Sans",Font.BOLD,15));
        tounit.setForeground(Color.BLACK);
        add(tounit);

        convert = new JButton("Convert Currency");
        convert.setBounds(100,450,200,40);
        convert.setFont(new Font("Open Sans",Font.BOLD,15));
        convert.addActionListener(this);
        add(convert);


        reset = new JButton("Reset");
        reset.setBounds(450,450,200,40);
        reset.setFont(new Font("Open Sans",Font.BOLD,15));
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(reset);

        exit = new JButton("Exit");
        exit.setBounds(300,550,100,40);
        exit.setFont(new Font("Open Sans",Font.BOLD,15));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(exit);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        //reset panel
        fromcountry.setSelectedIndex(0);
        tocountry.setSelectedIndex(0);
        fromtext.setText(null);
        Answer.setText(null);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        //to Exit
        System.exit(0);
    }

    public static void main(String[] args)
    {
        new SchimbVal();
    }


    private void fromcountryItemStateChanged(java.awt.event.ItemEvent evt) {
        //units
        int position = fromcountry.getSelectedIndex();
        fromunit.setText(currencyUnits[position]);
    }

    private void tocountryItemStateChanged(java.awt.event.ItemEvent evt) {
        //units
        int position = tocountry.getSelectedIndex();
        tounit.setText(currencyUnits[position]);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == convert) {
            if (fromcountry.getSelectedIndex() == 0 || tocountry.getSelectedIndex() == 0 || fromtext.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);

            } else {
                double amountToChange = Double.parseDouble(fromtext.getText());
                double amountInPounds = 0.0;
                //From Ammout change into pounds
                switch (fromcountry.getSelectedItem().toString()) {
                    case "Moldova":
                        amountInPounds = amountToChange / MDL;
                        break;
                    case "Romania":
                        amountInPounds = amountToChange / RON;
                        break;
                    case "USA":
                        amountInPounds = amountToChange / US_Dollar;
                        break;
                    case "UK":
                        amountInPounds = amountToChange / GBP;
                        break;
                    case "Ukraine":
                        amountInPounds = amountToChange / UAH;
                        break;
                    case "Russia":
                        amountInPounds = amountToChange / RUB;
                        break;
                    case "Switzerland":
                        amountInPounds = amountToChange / CHF;
                        break;
                    case "EU":
                        amountInPounds = amountToChange / EUR;
                        break;
                    default:
                        amountInPounds = 0.0;
                }

                double newamount = 0.0;
                switch (tocountry.getSelectedItem().toString()) {
                    case "Moldova":
                        newamount = amountInPounds * MDL;
                        break;
                    case "Romania":
                        newamount = amountInPounds * RON;
                        break;
                    case "USA":
                        newamount = amountInPounds * US_Dollar;
                        break;
                    case "UK":
                        newamount = amountInPounds * GBP;
                        break;
                    case "Ukraine":
                        newamount = amountInPounds * UAH;
                        break;
                    case "Russia":
                        newamount = amountInPounds * RUB;
                        break;
                    case "Switzerland":
                        newamount = amountInPounds * CHF;
                        break;
                    case "EU":
                        newamount = amountInPounds * EUR;
                        break;
                    default:
                        newamount = amountInPounds = 0.0;
                }
                String amount = String.format("%.2f", newamount);
                Answer.setText(amount);
            }
        }


    }
}