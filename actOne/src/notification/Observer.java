
//This separete file is made so that
//OrderService still follows Single Responsibility Principle
//And this file is separate so that
//This file can also follow the OCP
//Open for Extension--Closed for Modification
public interface Observer{
    void update(String message);
}