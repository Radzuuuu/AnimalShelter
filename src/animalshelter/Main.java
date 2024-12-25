
package animalshelter;


import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Specify the image name (must be in the same directory as the program)
        String imageName = "Loading Screen.jpg"; // Replace with your image file name
        LoadingScreen loadingScreen = new LoadingScreen(imageName);

        // Simulate a loading process
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(30); // Simulate some work being done
                loadingScreen.updateProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Dispose the loading screen
        loadingScreen.dispose();

        // Launch the main GUI
        SwingUtilities.invokeLater(() -> {
            ShelterGUI gui = new ShelterGUI();
            gui.setVisible(true);
        });
    }
}


