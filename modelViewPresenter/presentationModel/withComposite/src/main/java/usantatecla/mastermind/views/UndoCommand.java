package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;

class UndoCommand extends Command {

	UndoCommand(PlayController playController) {
		super(Message.UNDO_COMMAND.getMessage(), playController);
	}

	@Override
	protected void execute() {
		this.playController.undo();
		new GameView(this.playController);
	}

	@Override
	protected boolean isActive() {
		return this.playController.undoable();
	}
	
}
