// We can add new observer time to time
// For Example for Now - We have the ConsolerNotifier
// Later on Observer - 
// EmailNotifier
// SmsNotifier 
public interface Subject{
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver(String message);
}