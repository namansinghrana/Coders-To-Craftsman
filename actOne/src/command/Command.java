package command;

//We created the Command interface 
//This command design pattern helps in 
//encapsulating the request and
//separating the sender from the receiver.
public interface Command {
    void execute();
    void undo();
}
