# Anti-Plagiarism-Program

This project aims to develop a robust plagiarism detection system for programming assignments. The system is designed to analyze multiple student submissions within a working directory, identifying instances of code similarity that may indicate potential plagiarism.

This plagiarism detector serves as a valuable tool for educators and institutions to promote originality and ethical coding practices among students while providing a fair assessment environment.

## Key Features

1. **Multi-file Analysis**: Scans all code scripts within a specified working directory.
2. **Partial Similarity Detection**: Identifies not only identical scripts but also partially similar code segments.
3. **Intelligent Comparison**: Accounts for common variations in plagiarized code, such as:
   - Inserted empty lines
   - Minor syntactical changes
   - Reordered code blocks

## Technical Details

- **Language**: Implemented in Java
- **Programming Paradigm**: Object-Oriented Programming (OOP)

## Usage

1. **Setup**:

   - Ensure you have Java Development Kit (JDK) installed on your system.
   - Clone or download this project to your local machine.

2. **Prepare Files for Comparison**:

   - Place all the files/assignments you want to check for plagiarism in the `compare` directory within the project folder.

3. **Compile the Program**:

   - Open a terminal or command prompt.
   - Navigate to the project's `src` directory.
   - Compile the Java files using the following command:
     ```
     javac *.java
     ```

4. **Run the Program**:

   - After successful compilation, run the program using:
     ```
     java CheckDirectory
     ```

5. **View Results**:
   - The program will analyze the files in the `compare` directory and output the results in the terminal.

**Note**: Make sure your `CLASSPATH` is set correctly if you're running the program from a different directory.

## Contributing

Contributions to improve the Anti-Plagiarism-Program are welcome. Please feel free to submit pull requests or open issues to discuss potential enhancements.

## License

MIT License
