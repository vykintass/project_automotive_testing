***Steps to Set Up and Run the Tests
1. Create a Directory and Clone the GitHub Repository:
Open your terminal or command prompt and execute the following commands to create a directory and clone the repository:

bash
Copy code
mkdir automotive_testing
cd automotive_testing
git clone https://github.com/vykintass/project_automotive_testing.git

2. Open the Project in IntelliJ IDEA:

Launch IntelliJ IDEA.
Click on File > Open.
Navigate to the cloned project_automotive_testing directory and click OK.
3. Run the Tests:

In the IntelliJ Project Explorer, navigate to src/test/java/lt/techin/vd.
Right-click on the vd folder.
Select Run 'All Tests' or use the corresponding context menu option to run all tests within this directory.
4. Ensure All Necessary Services are Running:

pgAdmin: Ensure pgAdmin is running to manage your PostgreSQL database.
Visual Studio Code (VSCode): Ensure VSCode is running as it might be required for some integration or configuration tasks within your testing setup.
Troubleshooting
5. If the tests do not run successfully, verify the following:
The project is opened correctly in IntelliJ without any errors.
pgAdmin is connected to the correct PostgreSQL database and is running.
VSCode is running and properly configured if it is needed for the tests.
All necessary dependencies are installed. You can check the pom.xml file for Maven dependencies and ensure they are correctly resolved.
