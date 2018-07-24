package model;

import java.io.Serializable;

public class Client implements Serializable, IClientModel {
    private StringBuilder localHistory;
    private String name;
    private FileSystem fs;

    public Client(String name) {
        this.name = name;
        this.localHistory = new StringBuilder();
        this.fs = new FileSystem();
        this.localHistory.append(getHistory());
    }

    @Override
    public boolean sendMessage(String msg) {
        try {
            fs.setAppendText(name + ": " + msg);
            return true;
        } catch (Exception e) {
            System.err.println("Ошибка отправки сообщения");
            return false;
        }
    }

    @Override
    public StringBuilder getHistory() {
        StringBuilder sb;

        sb = fs.getText();
        if (sb.length() > 0) {
            return sb;
        } else
            return sb;
    }

    @Override
    public synchronized StringBuilder getLastMessage() {
        StringBuilder tempString = new StringBuilder();
        StringBuilder tempHistory = getHistory();

        tempString.append(tempHistory.substring(localHistory.length()));
        //localHistory.append(tempString);

        return tempString;
    }

    @Override
    public void addLocalHistory(String msg) {
        localHistory.append(msg);
    }
}
