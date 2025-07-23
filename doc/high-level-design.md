# NexusList High Level Design

## Security and Privacy

### Data

The platform will manage at least 2 distinct types of data:

* **User Information**: This is information such as email addresses and passwords related to user accounts.
* **Logs**: Information about the operation of the server. This includes access logs, and logging of other operations as appropriate.

#### Encryption

Data will be encrypted both at rest an in motion. While at reast, data stored in the database will be encrypted using either disk encryption or Transparent Data Encryption. Logs will also be stored in an encrypted filesystem. In motion, data will be transferred across encrypted channels such as HTTPS.

#### User Information

All user information will be treated as personally identifying information. Email addresses should only be exposed as necessary for administration of user registration. Passwords should not be stored directly. When a password is created it will be encoded using Java Spring encoding algorithms from Java Spring Security.

#### Logs

Access logs, security logs, and other logs about the function of the server should be collected and stored on the server. These logs will be used to perform systems administration and security audits.

### Distributed Denial of Service Attacks (DDOS)

The system should be designed to be efficient and durable so as to limit the risk of DDOS attacks. Additionally, after deployment, a third party caching service such as Cloudfare should be leveraged to help detect and mitigate DDOS attacks

### Secure Code Guidlines

* Never trust the user: Always make sure to thoroughly sanitize user inputs
  * Sanatizing user input on the client side is not enough. Ensure that inputs are sanitized on both the client and server.
* Never include keys or other credentials in the source code. If credentials are included in the source at any point, ensure they are removed and invalidated.
* When possible use prebuilt and well trusted security features.
* Refrain from giving overly detailed error messages
* Ensure that dependencies are up to date, and check for upstream vulnerabilities using tools such as `npm audit`
* Follow the principle of least permission. Each user should only have permission to access information or perform actions that are absolutely necessary.
* Ensure that computationally intensive functions are properly rate limited or otherwise restricted, to limit the rist of distributed denial of service attacks.

### Other Best Practices

* The server should be stored in a secure location, and only authorized people should have access to it.
* Firewalls should be properly configured to only expose strictly necessary ports.
  * SSH should not be exposed to the internet.
* Procedures for the audit of security logs, physical security, and security procedures should be established, and regularly conducted.
* The server and any other hardware that the system runs on should be updated regularly
* Maintain a list of 3rd party services and software, and ensure that their security limitations are understood and accounted for.
