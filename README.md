---

# 🧪 Sauce Demo Test Automation Project

## 📌 Overview

This project is a **test automation framework and manual test suite** for the Sauce Demo web application.
It demonstrates my skills in **Quality Assurance, test case design, and test automation using Selenium WebDriver with Java and TestNG**.

The goal of this project is to ensure the core functionalities of the application are working as expected through both **manual and automated testing approaches**.

---

## 🚀 Project Type

* Manual Testing (Test Case Design)
* UI Test Automation
* Regression Testing Practice
* Selenium Automation Framework (In Progress / Ongoing)

---

## 🧰 Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Git & GitHub

---

## 📂 Project Structure

```
ecommerce/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │
│   │   │   ├── base/
│   │   │   │   └── BaseScript.java
│   │   │
│   │   │
│   │   │   ├── pages/                     # Page Object Model (POM) classes
│   │   │   │   ├── BasePage.java
│   │   │   │   └── LoginPage.java
│   │   │
│   │   │   ├── flows/                     # Business workflows / user journeys
│   │   │   │   └── LoginFlow.java
│   │   │
│   │   │   ├── utils/                     # Helper classes and reusable utilities
│   │   │   │   └── JsonReader.java
│   │
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/                     # TestNG test classes
│
├── src/test/resources/
│   ├── plans/                             # TestNG XML suite files
│   │   └── test-suite.xml
│   ├── data/
│   │   └── loginData/
│
├── test-cases/                            # Manual test cases (Excel / Docs)
│
├── pom.xml

```

---

## 🧪 Modules Covered

### 🔐 Login Module

* Valid login
* Invalid login
* Empty fields validation
* Locked out user handling

### 🛒 Items / Products Module

* Add items to cart
* Remove items from cart
* Product display validation
* Sorting (A-Z, Z-A, Price low to high, high to low)

### 🛍️ Cart Module

* Verify added items
* Remove items from cart
* Checkout navigation

### 💳 Checkout Module (planned / in progress)

* User information validation
* Order summary
* Order completion

---

## ⚙️ How to Run the Project

### Run Tests using Maven

```bash
mvn clean test
mvn clean test "-DsuiteFile=src/test/resources/plans/Login_Suite.xml"
```

### Run TestNG Suite

Run the XML file from:

```
src/test/resources/plans/Test_Runner.xml
src/test/resources/plans/Login_Suite.xml
```

---

## 📊 Test Strategy

This project follows:

* **Page Object Model (POM)** for maintainability
* **TestNG framework** for test execution and grouping
* **Regression testing approach** for validating stable features
* **Reusable methods** to reduce duplication

---

## 🧾 Manual Test Cases

Manual test cases are available under:

```
will upload soon
```

They cover:

* Functional testing
* UI validation
* Negative scenarios
* Edge cases

---

## 🧠 Learning Goals

This project is part of my continuous learning in QA automation:

* Improve automation framework design
* Strengthen Java + Selenium skills
* Practice scalable test structure
* Simulate real-world QA workflows

---

## 📌 Status

🚧 Work in Progress

* Automation framework setup ongoing
* Test cases continuously being refined
* More modules will be added soon

---

## 👩‍💻 Author

**Ashley Radovan**
QA Analyst Associate
Automation Tester passionate about improving software quality through structured testing and automation.

---

## ⭐ Notes

This project is intended for learning and portfolio purposes. Improvements and contributions to best practices are ongoing.

---
