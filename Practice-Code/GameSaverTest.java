import java.io.*;

public class GameSaverTest {
	public static void main(String[] args) {
		GameCharacter one = new GameCharacter(50,"Elf",new String[] {"bow","sword"});
		GameCharacter two = new GameCharacter(200,"troll", new String[] {"bare hands","big ax"});
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			os.writeObject(one);
			os.writeObject(two);
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		one = null;
		two = null;
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			
			System.out.println(oneRestore.getType());
			System.out.println(twoRestore.getType());
		}	catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}