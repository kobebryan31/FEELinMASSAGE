# Massage Reservation Management System

![image](https://github.com/kobebryan31/FEELinMASSAGE/blob/main/Image/Logo.jpg)

## Table of Contents

Overview

Concepts Explanation

SDG Integration

Instructions

Sample Output

Acknowledgement

## Overview

The Massage Reservation Management System is a Java-based application that simplifies the booking process for massage services. It is designed to showcase the principles of Object-Oriented Programming (OOP) while meeting practical requirements for managing reservations in a real-world setting, such as a spa or wellness center.

## Concepts Explanation

###### 1. Encapsulation

Definition: Encapsulation is the bundling of data (variables) and methods (functions) that operate on the data into a single unit, typically a class. It also involves restricting access to certain details by using access modifiers like private, protected, and public.

In the Code:

The Reservation class encapsulates the customer's details, service, date, and time.
Fields such as firstName, lastName, contactNumber, date, and time are declared private. These fields can only be accessed or modified via getter and setter methods (though not explicitly defined in this code, we use toString() for controlled access).

###### 2. Abstraction

Definition: Abstraction hides complex implementation details and exposes only the essential features. It focuses on what an object does rather than how it does it.

In the Code:

The Service class is an abstraction of all massage services. It provides common properties (name and roomId) and methods (getName(), getRoomId()).
Specific massage types (ex: SwedishMassage, DeepTissueMassage) extend the Service class, inheriting its properties and behaviors while hiding the implementation details from the user.

###### 3. Inheritance

Definition: Inheritance allows a class (child) to acquire the properties and behaviors of another class (parent), enabling code reuse and the creation of hierarchical relationships.

In the Code:

The SwedishMassage, DeepTissueMassage, and other specific services inherit from the Service class. This reduces code duplication, as common properties (name, roomId) are defined once in Service.

###### 4. Polymorphism

Definition: Polymorphism allows objects of different types to be treated as objects of a common supertype. It enables a single interface to represent different underlying forms (method overriding or method overloading).

In the Code:

The Service class is the base type for all massage services. An array of Service[] SERVICES is used to store instances of different service types (SwedishMassage, DeepTissueMassage, etc.). These child classes override the toString() method to provide specific behavior for displaying service information.

