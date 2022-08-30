package launcher;
import gui.*;
import entities.*;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student ezequiel = new Student(12323, "Aguilar", "Ezequiel", "ezequielmaximiliano123@gmail.com", "https://github.com/EzeAguilar", "/images/descarga.jpg");
            	SimplePresentationScreen a = new SimplePresentationScreen(ezequiel);
            	a.setVisible(true);
            }
        });
    }
}