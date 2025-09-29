import javax.swing.JFrame;

// Sets the size for the UI
public class testTicTacToe
{
    public static void main(String[] args)
    {
        // Constructor call
        ticTacToeFrame ui = new ticTacToeFrame();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ui.pack();

        ui.setVisible(true);
    }
}