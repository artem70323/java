package model.parseFile;

public abstract class ParserThread extends Thread {

    @Override
    public void run() {
        parse();
    }

    public abstract void parse();
}
