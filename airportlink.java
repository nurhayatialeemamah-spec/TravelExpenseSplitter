import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

class airportlink implements ItemListener, WindowListener, ActionListener {  
    Frame fr;
    Panel pn1, pn2;
    Label lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9, lb10, lb11, lb12;
    TextField t1;
    Button bn1, bn2;
    Choice c1, c2;
    TextArea textArea;

    public static void main(String args[]) {
        airportlink ob = new airportlink();
        ob.init();
    }
    
    public void init() {
        fr = new Frame("Airport Link Fare Calculator Program");
        pn1 = new Panel();
        pn2 = new Panel();
        
        lb1 = new Label("Calculate Airport Link Fare");
        lb1.setForeground(Color.blue);
        lb4 = new Label("Departure Station");
        lb5 = new Label("Destination Station");
        lb6 = new Label("Number of Passengers");
        lb7 = new Label(" Person(s)");
        lb8 = new Label("         ");
        lb9 = new Label("         ");
        lb10 = new Label("         ");
        lb11 = new Label("         ");

        textArea = new TextArea(50, 50); // with 50 rows and 50 columns 
        
        t1 = new TextField();
            
        bn1 = new Button("Calculate");
        bn2 = new Button("Clear");
        
        c1 = new Choice();
        c2 = new Choice();
        c1.addItem("Please select a station");
        c1.addItem("Phaya Thai");
        c1.addItem("Ratchaprarop");
        c1.addItem("Makkasan");
        c1.addItem("Ramkhamhaeng");
        c1.addItem("Hua Mak");
        c1.addItem("Ban Thap Chang");
        c1.addItem("Lat Krabang");
        c1.addItem("Suvarnabhumi");    
        
        c2.addItem("Please select a station");
        c2.addItem("Phaya Thai");
        c2.addItem("Ratchaprarop");
        c2.addItem("Makkasan");
        c2.addItem("Ramkhamhaeng");
        c2.addItem("Hua Mak");
        c2.addItem("Ban Thap Chang");
        c2.addItem("Lat Krabang");
        c2.addItem("Suvarnabhumi");
        
        pn1.setLayout(new GridLayout(4, 3)); // with 4 rows and 3 columns 
        pn1.add(lb8);
        pn1.add(lb1);
        pn1.add(lb9);
        pn1.add(lb4);
        pn1.add(c1);
        pn1.add(lb10);
        pn1.add(lb5);
        pn1.add(c2);
        pn1.add(lb11);
        pn1.add(lb6);
        pn1.add(t1);
        pn1.add(lb7);

        pn2.add(bn1);
        pn2.add(bn2);        
        pn2.add(textArea);
         
        fr.setLayout(new GridLayout(3, 1)); // with 3 rows and 1 column
        fr.add(pn1);
        fr.add(pn2);      

        Color bgColor = new Color(255, 255, 102);  // Yellow color
        fr.setBackground(bgColor);  // Set yellow background

        bn1.setBackground(Color.green);
        bn2.setBackground(Color.red);

        c1.addItemListener(this);
        c2.addItemListener(this);
        bn1.addActionListener(this);
        bn2.addActionListener(this);

        fr.addWindowListener(this);
        fr.setSize(450, 450);
        fr.setResizable(false);
        fr.setVisible(true); 
    }

    public void actionPerformed(ActionEvent e) {
        String startStation = c1.getSelectedItem().toString();
        String finalStation = c2.getSelectedItem().toString();
        int startStationIndex = c1.getSelectedIndex();
        int finalStationIndex = c2.getSelectedIndex();
        int stationAmount = 0;
        int ticketPrice;
        int totalPayment;    
        int passengerAmount = 0;

        try {
            passengerAmount = Integer.parseInt(t1.getText());
        } catch (NumberFormatException error) {
            textArea.setText("Please enter the number of passengers as a positive integer.");
        }

        if (e.getSource() == bn1) {        
            if ((startStationIndex != 0) && (finalStationIndex != 0)) {
                if (startStationIndex > finalStationIndex) {
                    stationAmount = startStationIndex - finalStationIndex;
                } else {
                    stationAmount = finalStationIndex - startStationIndex;
                }

                if (stationAmount > 7) {          ticketPrice = 50; }
                else if (stationAmount == 7) {    ticketPrice = 45; }
                else if (stationAmount == 6) {    ticketPrice = 40; }
                else if (stationAmount == 5) {    ticketPrice = 35; }
                else if (stationAmount == 4) {    ticketPrice = 30; }
                else if (stationAmount == 3) {    ticketPrice = 25; }
                else if (stationAmount == 2) {    ticketPrice = 20; }
                else {                            ticketPrice = 15; }

                if (passengerAmount > 0) {
                    totalPayment = ticketPrice * passengerAmount;  
                    textArea.setText(
                        "Departure Station: " + startStation + "\n" +
                        "Destination Station: " + finalStation + "\n" +
                        "Number of Stations: " + stationAmount + "\n" +
                        "Number of Passengers: " + passengerAmount + " person(s)\n" +
                        "Ticket Price (per person): " + ticketPrice + " Baht\n" +
                        "Total Price: " + totalPayment + " Baht"
                    );
                } else {
                    textArea.setText("Please enter the number of passengers as a positive integer.");
                }            
            } else {
                textArea.setText("Please select both a departure and destination station.");
            }

        } else if (e.getSource() == bn2) {    
            textArea.setText("");  
            t1.setText("");
        }
    }

    public void itemStateChanged(ItemEvent e) { }
    public void windowOpened(WindowEvent e) { }
    public void windowClosed(WindowEvent e) { }
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowIconified(WindowEvent e) { }
    public void windowDeiconified(WindowEvent e) { }
    public void windowActivated(WindowEvent e) { }
    public void windowDeactivated(WindowEvent e) { }
}
