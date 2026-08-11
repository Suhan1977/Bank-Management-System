

# Bank Management System (Java)

## Overview

The Bank Management System is a comprehensive Java application that simulates essential banking operations such as account creation, login, balance inquiry, deposits, withdrawals, and more. Designed with modular classes and clear structure, this system provides a foundation for understanding core banking functionalities implemented in Java.

## Features

- User registration and login
- Deposit and withdrawal operations
- Balance inquiry
- Fast cash withdrawal
- Account signup with multiple steps
- Admin functionalities
- Secure PIN management
- Mini statement generation

## Folder Structure

```
src/
└── bank/
    └── management/
        └── system/
            ├── Admin.java
            ├── Admin_Display.java
            ├── BalanceEnquiry.java
            ├── Con.java (renamed to ConTemp.java also replaced outside the folder)
            ├── Deposit.java
            ├── FastCash.java
            ├── Login.java
            ├── Main_Class.java
            ├── Mini.java
            ├── Pin.java
            ├── Signup.java
            ├── Signup2.java
            ├── Signup3.java
            └── Withdrawl.java
```

*Note:* The file `Con.java` has been renamed to `ConTemp.java` and is not located in any folder; it exists at the root level of your project directory.

## Prerequisites

- Java Development Kit (JDK) 8 or above installed
- An IDE like IntelliJ IDEA, Eclipse, or any text editor
- Basic knowledge of Java programming

## Setup Instructions

1. **Clone or download the project:**
   
   ```bash
   git clone <repository_url>
   ```

2. **Navigate to the project directory:**

   ```bash
   cd path/to/your/project
   ```

3. **Ensure the `ConTemp.java` file is at the root level of your project directory.**

4. **Compile the Java files:**

   ```bash
   javac -d bin src\bank\management\system\*.java
   ```

5. **Run the main class:**

   ```bash
   java -cp bin bank.management.system.Main_Class
   ```

## Usage

- Launch the application and follow the on-screen prompts for registration, login, and banking operations.
- Use the menu options to perform deposit, withdrawal, balance inquiry, and other features.

## Contributing

Contributions are welcome! Please fork the repository, make your changes, and submit a pull request.

## License

This project is for educational purposes. Feel free to modify and use it as needed.

---

If you'd like, I can generate this as a downloadable `.md` file or customize it further.
