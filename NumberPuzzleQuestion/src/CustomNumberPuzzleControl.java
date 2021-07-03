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
		
		// Check if button is okay to swap
		int diff = Math.abs(buttonClickedId - emptyCellId);
		if (diff == 1 || diff == 4) {
			swapButton(buttons[emptyCellId], buttons[buttonClickedId]);
			emptyCellId = buttonClickedId;
			game.setEmptyCellId(emptyCellId);
		}

		return emptyCellId;
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
		
		int arr[] = getIntegerArrayOfButtonIds(buttons);
		for (int i = 0; i < 15; i++) {
			if (arr[i] != i+1) {
				winner = false;
				break;
			}
		}
		return winner;
	}
}