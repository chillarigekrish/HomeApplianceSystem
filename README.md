Home Appliance Control System

Description:
This project is a Smart Home Appliance Control System designed to manage various home appliances like Lights, Fans, and Air Conditioners. Users can control the appliances (turn them on or off), and schedule system-wide updates. The system is designed with modularity, allowing easy extension for additional appliances in the future.

Key Features:
- Turn appliances on or off.
- Control appliance states (like fan speed or air conditioner mode).
- Schedule yearly system updates to turn off all appliances.
- Extensible architecture using design patterns like Command and Strategy.

Components:
1. Appliances:
   - Light: Can be turned on/off.
   - Fan: Can be controlled with three speeds (0 = off, 1 = low, 2 = high).
   - Air Conditioner: Can be turned on/off with mode control.

2. Controller:
   - A central controller that manages the state of all appliances.

3. Scheduler:
   - A scheduler that can trigger yearly updates to turn off all appliances automatically at a specific time.

4. Tests:
   - JUnit 5 tests for appliances and system behavior (e.g., turning appliances on/off, system updates).

Installation Instructions:
1. Clone the repository:
   git clone https://github.com/your-username/home-appliance-system.git
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Ensure that you have JDK 8 or higher installed and configured.
4. Add necessary dependencies (JUnit 5, Mockito) if your IDE does not auto-import them.

Usage:
- Run the `Main.java` class to initialize and simulate the control of appliances.
- Use the `SmartHomeApplianceController` to manage the appliances and invoke scheduled updates.
- You can modify appliance states by calling methods like `turnOn()`, `turnOff()`, and `setSpeed(int newSpeed)`.

Example Usage:
- To turn on the light:
   `Light light = new Light();`
   `light.turnOn();`

- To set fan speed to high:
   `Fan fan = new Fan();`
   `fan.setSpeed(2);`

- To schedule an automatic system update:
   `SmartHomeApplianceController controller = new SmartHomeApplianceController();`
   `HomeApplianceSystemUpdate updateScheduler = new HomeApplianceSystemUpdate(controller);`
   `updateScheduler.scheduleYearlyUpdate();`

Testing:
1. Run unit tests using JUnit 5 in your IDE.
2. Alternatively, run tests via Maven or Gradle:
   - Maven: `mvn test`

Project Structure:
- src: Contains the main application code, including appliances, controller, and scheduler.
- tests: Contains unit tests for appliances, controller, and scheduler functionality.