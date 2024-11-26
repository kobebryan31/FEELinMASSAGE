# Massage Reservation Management System

<div align="center">
  <img src="https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Logo.jpg" alt="Logo" />
</div>

## Table of Contents

Overview

Concepts Explanation

SDG Integration

Instructions

Sample Output

Acknowledgement

## Overview

The **Massage Reservation Management System** is a Java-based application that simplifies the booking process for massage services. It is designed to showcase the principles of Object-Oriented Programming (OOP) while meeting practical requirements for managing reservations in a real-world setting, such as a spa or wellness center.

## Concepts Explanation

<div align="center">
<img src="https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Principles.png" alt="Image" style="width: 50%; height: auto;" />
</div>

###### 1. Encapsulation

Definition: **Encapsulation** is the bundling of data _(variables)_ and methods _(functions)_ that operate on the data into a single unit, typically a class. It also involves restricting access to certain details by using access modifiers like private, protected, and public.

In the Code:

The Reservation class encapsulates the customer's details, service, date, and time.
Fields such as _firstName, lastName, contactNumber, date, and time_ are declared private. These fields can only be accessed or modified via getter and setter methods _(though not explicitly defined in this code, we use toString() for controlled access)_.

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Encapsulation.png)

###### 2. Abstraction

Definition: **Abstraction** hides complex implementation details and exposes only the essential features. It focuses on what an object does rather than how it does it.

In the Code:

The Service class is an abstraction of all massage services. It provides common properties _(name and roomId)_ and methods _(getName(), getRoomId())_.
Specific massage types _(ex: SwedishMassage, DeepTissueMassage)_ extend the Service class, inheriting its properties and behaviors while hiding the implementation details from the user.

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Abstraction.png)

###### 3. Inheritance

Definition: **Inheritance** allows a class _(child)_ to acquire the properties and behaviors of another class _(parent)_, enabling code reuse and the creation of hierarchical relationships.

In the Code:

The SwedishMassage, DeepTissueMassage, and other specific services inherit from the Service class. This reduces code duplication, as common properties _(name, roomId)_ are defined once in Service.

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Inheritance.png)

###### 4. Polymorphism

Definition: **Polymorphism** allows objects of different types to be treated as objects of a common supertype. It enables a single interface to represent different underlying forms _(method overriding or method overloading)_.

In the Code:

The Service class is the base type for all massage services. An array of Service[] SERVICES is used to store instances of different service types _(SwedishMassage, DeepTissueMassage, etc.)_. These child classes override the toString() method to provide specific behavior for displaying service information.

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Polymorphism.png)

## SDG Integration

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/SDG%203%20Good%20Health%20and%20Well-Being.jpg)

 This project aligns with **SDG 3: Good Health and Well-being**  by promoting relaxation and stress relief through various massage services, which contribute to mental and physical well-being. The system enables users to easily book therapeutic massages, helping to improve overall health and reduce stress, which are essential for a healthier life. By offering diverse types of massages, the system can cater to different health needs, such as pain relief, relaxation, and mental wellness. Additionally, it provides an accessible platform for individuals to prioritize self-care, thereby supporting the achievement of good health for all.

## Instructions

You can run the Java program using the java command and you’ll see a menu in the terminal:

###### Follow the on-screen prompts to;

**Make a Reservation:** Enter the required information like your name, service choice, time, and date.

**View Reservations:** See a list of all current reservations.

**Delete a Reservation:** Select a reservation by number to delete.

**Exit:** Select to exit the terminal.

## Sample Output

###### Choice 1

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Choice%201.png)

###### Choice 2

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Choice%202.png)

###### Conflict Schedule

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Conflict%20Schedule.png)

###### Choice 3

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Choice%203.png)

###### Choice view

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Choice%20View.png)

###### Choice 4

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Choice%204.png)

## Acknowledgement

