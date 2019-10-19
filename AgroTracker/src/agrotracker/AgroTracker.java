/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrotracker;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLFrameHyperlinkEvent;

class Hyperactive implements HyperlinkListener {
    
    private JEditorPane editorPane;
    
    public Hyperactive(JEditorPane editorPane){
        this.editorPane = editorPane;
    }
    
    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) 
    { 
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) 
        { 
            HyperlinkEvent.EventType type = e.getEventType();
            final URL url = e.getURL();
            if (type == HyperlinkEvent.EventType.ENTERED) {
                System.out.println("URL: " + url);
            } else if (type == HyperlinkEvent.EventType.ACTIVATED) {
            System.out.println("Activated");

            Document doc = editorPane.getDocument();
                try {
                    editorPane.setPage(url);
                } catch (IOException ex) {
                    Logger.getLogger(Hyperactive.class.getName()).log(Level.SEVERE, null, ex);
                }
            }    
        } 
    } 
}

public class AgroTracker{

	public AgroTracker() throws IOException{
		JFrame frame = new JFrame("Agro Tracker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {
                    JEditorPane editorPane = new JEditorPane("file:ArquivosHTML/loginPage.html");
                    editorPane.setEditable(false);

                    Hyperactive hyperlinkListener = new Hyperactive(editorPane);
                          editorPane.addHyperlinkListener(hyperlinkListener);
                          JScrollPane scrollPane = new JScrollPane(editorPane);
                          frame.add(scrollPane);
                } catch (IOException e) {
                          System.err.println("Unable to load: " + e);
                }

		frame.setBounds(50, 50, 600, 500);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws IOException{
		AgroTracker iniciaSistema = new AgroTracker();
	}
}
   
