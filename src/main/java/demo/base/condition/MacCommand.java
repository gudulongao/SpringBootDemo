package demo.base.condition;

public class MacCommand implements ICommand {
    @Override
    public String showListCommand() {
        return "ls";
    }
}
