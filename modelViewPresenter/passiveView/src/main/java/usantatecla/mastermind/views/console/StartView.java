package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;

public class StartView implements usantatecla.mastermind.views.StartView {

    public void write(){
        Message.TITLE.writeln();
    }

}
