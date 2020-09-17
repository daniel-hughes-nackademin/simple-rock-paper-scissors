public enum Choice {
    ROCK,
    PAPER,
    SCISSORS;

    public static Choice getRandom(){
        return values()[(int) (Math.random()* values().length)];
    }
}
