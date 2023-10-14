# Starter kit for pact-java

A starter kit for selenium using java.

## Table of Contents

- [Project Description](#project-description)
- [Business Flow](#business-flow)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Project Description

This is a sample project that demonstrates the usage of Selenium with Java. It has some boilerplate code for UI automation framework.

The project is built using Java and the following technologies:

- [Selenium](https://www.selenium.dev/): Selenium HQ.
- [TestNG](https://testng.org/doc/): A test runner for Java.
- [Maven](https://maven.apache.org/): A build automation tool for Java projects.


## Prerequisites

Before getting started, ensure that the following software is installed on your system:

- Java Development Kit (JDK)
- Add JAVA_HOME to Environment Variables (Windows)
- Add JAVA_HOME in .zshrc or .bash_profile folder (Mac)
- Apache Maven
- IDE
- SelectorHub/Chropath extension (Optional)

## Installation

To set up the project, follow these steps:

1. Clone the repository:

   ```shell
   git clone https://github.com/RajatADP/selenium-starter.git
   ```

2. Navigate to the project directory:

   ```shell
   cd selenium-starter
   ```

3. Build the project using Maven:

   ```shell
   mvn clean install -DskipTests=true
   ```
This will download the required dependencies and compile the project.

4. Run test using Maven:

   ```shell
   mvn clean test
   ```

5. Run test with environment variables:

   ```shell
   mvn clean test -Denvironment=qa
   ```

This will run testNG.xml file


## Contributing

Contributions to this sample project are welcome! If you would like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them.
4. Push your changes to your forked repository.
5. Submit a pull request to the original repository.

Please ensure that your code adheres to the project's coding standards and includes appropriate tests.


## Authors

- RajatM \<rjtmishra009@gmail.com\>

Feel free to contact if you have any questions or feedback.

That's it! You can update the template with the relevant information. Happy testing!