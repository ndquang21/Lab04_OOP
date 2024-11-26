package Lab_01;
import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
		
		JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
		
//		int option = JOptionPane.showOptionDialog(
//			    null, "Do you want to change to the first class ticket?", null, JOptionPane.YES_NO_OPTION,
//			    JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Yes", "No"},"Yes"
//			);
//			System.exit(0);
	}
}
