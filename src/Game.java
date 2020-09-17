import javax.swing.*;


public class Game {
    private static final String TITLE = "Rock Paper Scissors";
    private int numberOfTies = 0;
    private final Player player = new Player();
    private final Player computer = new Player();

    public static void main(String[] args) {
        new Game().start();
    }

    private void start() {
        boolean keepPlaying = true;
        while (keepPlaying){
            Object[] options = {"PLAY", "RESET"};
            String message = String.format("You: %d - Computer: %d - Ties: %d", player.getScore(), computer.getScore(), numberOfTies);
            int input = JOptionPane.showOptionDialog(null, message, TITLE,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (input == JOptionPane.OK_OPTION){
                playRound();
            }
            else if(input == JOptionPane.NO_OPTION){
                reset();
            }
            else {
                keepPlaying = false;
            }
        }
    }

    private void reset() {
        player.setScore(0);
        computer.setScore(0);
        numberOfTies = 0;
    }

    private void playRound() {
        player.setChoice(null);
        player.setChoice(
                (Choice) JOptionPane.showInputDialog(null, "Which will you pick?", TITLE, JOptionPane.QUESTION_MESSAGE, null, Choice.values(), Choice.values()[0])
        );
        if(player.getChoice() == null){
            return;
        }
        computer.setChoice(Choice.getRandom());
        JOptionPane.showMessageDialog(null, "The computer chose " + computer.getChoice() + "!", TITLE, JOptionPane.PLAIN_MESSAGE);

        checkWinnerAndUpdateScore();
    }

    private void checkWinnerAndUpdateScore() {
        if (player.getChoice() == computer.getChoice()){
            numberOfTies++;
                JOptionPane.showMessageDialog(null, "It's a tie!", TITLE, JOptionPane.INFORMATION_MESSAGE);
        }
        else if (player.getChoice() == Choice.ROCK && computer.getChoice() == Choice.SCISSORS ||
                player.getChoice() == Choice.SCISSORS && computer.getChoice() == Choice.PAPER ||
                player.getChoice() == Choice.PAPER && computer.getChoice() == Choice.ROCK) {
            player.addPoint();
            JOptionPane.showMessageDialog(null, "You Won!", TITLE, JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            computer.addPoint();
            JOptionPane.showMessageDialog(null, "The computer won!", TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }


}
