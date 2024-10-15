# Rideshare Driver Validation System

## Overview
The **Rideshare Driver Validation System** is a back-end application designed to simulate validating prospective drivers for the rideshare platform. It uses Java and object-oriented design principles, with a focus on SOLID principles. The system ensures that drivers meet specific criteria based on their license, vehicle information, and driving history before they are accepted into the platform.

## Features
- **Driver Validation**: Validates prospective drivers based on their age, license information, vehicle details, and driving history.
- **License Checks**: Ensures that the driver's license is valid, and checks for any discrepancies between the provided name, birthdate, and the information on the license.
- **Vehicle Validation**: Verifies the vehicle's make, model, year, and insurance status, ensuring that the driver is eligible to use the vehicle for rideshare purposes.
- **Violation Checks**: Evaluates the driver's history for any moving or non-moving violations that would disqualify them from being accepted.
- **Driver Pool Management**: Manages a pool of accepted drivers, ensuring that the system only retains unique drivers, with support for multiple vehicles per driver.

## Technologies
- **Java**
- **JUnit**
- **Java Collections Framework**
- **Functional Programming**
- **SOLID Principles**
- **Builder Design Pattern**

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/jshuang2/RideShare_Driver_Validation_System.git
   ```
2. Navigate to the proejct directory:
   ```
   cd RideShare_Driver_Validation_System
   ```
3. Build the project using grade:
   ```
   gradle build
4. Run the application:
   ```
   gradle run
   ```
5. Follow the directions displayed in the terminal to navigate through the application.
