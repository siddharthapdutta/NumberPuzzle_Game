import java.awt.*;
import java.util.Arrays;
import java.util.Collections;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		// Obtaining ID of clicked button to update empty cell ID
		int buttonClickedId = 0;
		int counter = 0;
		for (Button button : buttons) {
			if (button.equals(buttonClicked)) {
				buttonClickedId = counter;
				break;
			}
			counter++;
		}
		game.setEmptyCellId(buttonClickedId);

		swapButton(buttons[emptyCellId], buttons[buttonClickedId]);
		return buttonClickedId;
	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		Integer temp[] = new Integer[15];
		for(int i = 0 ; i < temp.length; i++)
			temp[i] = i+1;
		Collections.shuffle(Arrays.asList(temp));
		for (int i = 0; i < temp.length; i++)
			arr[i] = temp[i];
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		getIntegerArrayOfButtonIds(buttons);

		return winner;
	}
}