package notification;

// We can add new observer time to time
// For Example for Now - We have the ConsolerNotifier
// Later on Observer - 
// EmailNotifier
// SmsNotifier 
public interface Subject {
    void registerObservers(Observer o);

    void removeObservers(Observer o);

    void notifyObservers(String message);
}