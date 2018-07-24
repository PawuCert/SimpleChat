package presenter;

import model.Client;
import view.EventEnum;
import view.MainForm;

public interface IClientPresenter {
    void setModel(Client client);

    Client getModel();

    void setView(MainForm form);

    MainForm getView();

    String getHistory();

    void run();

    void sendMessage(String msg);

    StringBuilder getLastMessage();

    void updateFormToModel();

    void updateModelToFrom(EventEnum e);
}
