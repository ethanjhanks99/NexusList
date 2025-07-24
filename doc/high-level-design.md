# NexusList High Level Design

# Security and Privacy

## Data

The platform will manage at least 2 distinct types of data:

* **User Information**: This is information such as email addresses and passwords related to user accounts.
* **Logs**: Information about the operation of the server. This includes access logs, and logging of other operations as appropriate.

### Encryption

Data will be encrypted both at rest an in motion. While at reast, data stored in the database will be encrypted using either disk encryption or Transparent Data Encryption. Logs will also be stored in an encrypted filesystem. In motion, data will be transferred across encrypted channels such as HTTPS.

### User Information

All user information will be treated as personally identifying information. Email addresses should only be exposed as necessary for administration of user registration. Passwords should not be stored directly. When a password is created it will be encoded using Java Spring encoding algorithms from Java Spring Security.

### Logs

Access logs, security logs, and other logs about the function of the server should be collected and stored on the server. These logs will be used to perform systems administration and security audits.

## Distributed Denial of Service Attacks (DDOS)

The system should be designed to be efficient and durable so as to limit the risk of DDOS attacks. Additionally, after deployment, a third party caching service such as Cloudfare should be leveraged to help detect and mitigate DDOS attacks

## Secure Code Guidlines

* Never trust the user: Always make sure to thoroughly sanitize user inputs
  * Sanatizing user input on the client side is not enough. Ensure that inputs are sanitized on both the client and server.
* Never include keys or other credentials in the source code. If credentials are included in the source at any point, ensure they are removed and invalidated.
* When possible use prebuilt and well trusted security features.
* Refrain from giving overly detailed error messages
* Ensure that dependencies are up to date, and check for upstream vulnerabilities using tools such as `npm audit`
* Follow the principle of least permission. Each user should only have permission to access information or perform actions that are absolutely necessary.
* Ensure that computationally intensive functions are properly rate limited or otherwise restricted, to limit the rist of distributed denial of service attacks.

## Other Best Practices

* The server should be stored in a secure location, and only authorized people should have access to it.
* Firewalls should be properly configured to only expose strictly necessary ports.
  * SSH should not be exposed to the internet.
* Procedures for the audit of security logs, physical security, and security procedures should be established, and regularly conducted.
* The server and any other hardware that the system runs on should be updated regularly
* Maintain a list of 3rd party services and software, and ensure that their security limitations are understood and accounted for.

# Hardware Platforms

This portion of the design covers what hardware the application will run on and what technologies will be used to ensure a friendly user experience regardless of their device.

## Web App

The web app is the most simple to implement. It will simply be a React frontend. The React front end will be containerized separate from the backend, and will be served to the user through a browser. This implementation will use mobil-first principles, to ensure users do not have a miserable experience if they were to click a link that takes them to the browser on their phone.

## Desktop App

The desktop app will be implemented using Electron. This implementation should not be too difficult, as it shares the same core as the web app does. This implementation is run client side, which means the web app will have to host the install files, and the users will have to download and install their files on their own machine (.dmg for MacOS, .exe for Windows, will need to figure out Linux).

## Mobile Apps

The mobile version of the app will be implemented using React Native. The mobile version of the app will take more rework than the desktop app. For Android users, I simply need to share the .apk file with them. For apple users, I will need to subscribe to be an apple developer and upload the app to TestFlight.

### Feature Parity

The mobile implementaion will aim to maintain feature parity across iOS and Android platforms to ensure that all users, regardless of device, have access to the same core features. Platform-specific enhancements, such as the use of iOS's Haptic Touch or Android's notifications integration, will be considered to improve the native experience where applicable.

## Feature Differences Between Web/Desktop and Mobile Apps

The only feature difference of note will be the keyboard shortcuts. The goal is for the web/desktop apps to have robust keyboard capabilities that can help improve user workflow.

# User Interface

## TODO

* Describe the general look of the UI.
* Come up with a prototype color scheme.

# Frameworks and Tools

This application will have a 3-tiered architecture: a React frontend, a Spring backend, and a PostgreSQL database.

## Frontend

React was chosen for it's modularity and its ability to reuse components. It has the flexability required for this project and will make creating an aesthetically pleasing app easy. At this time a component library has not been chosen, though possible options are ChakraUI, Ant Design, React-Bootstrap, and PrimeReact.

## Backend

The backend will use a Spring RestAPI. Spring is a Java-based framework that excels at making RestAPIs. 

## Database

PostgreSQL is a reliable open source relational database that offers great scalability.

## Tools

### Electron

Electron is a framework used to bring React apps to desktops, including those running MacOS, Windows and Linux.

### React Native

React Native is a framework that allows you to build mobile apps for both iOS and Android using React.

# Internal Componenets
