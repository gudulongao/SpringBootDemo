package demo.base.condition;

public class WindowsCommand implements ICommand{
    @Override
    public String showListCommand() {
        return "dir";
    }
}
