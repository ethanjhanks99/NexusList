# Table of Contents

# Security and Privacy

## Data

The platform will manage 2 distinct types of data:

    1. **User Information**: Information, including email address and password, related to individual user accounts
    2. **Logs**: Information about the operation of the server. Includes access logs, and logging of other operations as is appropriate.

### Encryption

All data should be encrypted both in motion and at rest. At reast, the data stored in the database should be encrypted using either disk encryption or Transparent Data Encryption. Logs should also be stored in an encrypted filesystem. In motion, all data transfer should occur over encrypted channels of communication, such as SSH or HTTPS, on top of Tailscale's encryted channel WireGuard.

### User Information

User information should be treated as personally identifying information (PII). Email addresses should only be exposed as nexessary for administration of user registration. Passwords should not be stored direcly. When a password is created, it will be encoded using the Spring Boot Security dependency, specifically using BCrypt encoding.
