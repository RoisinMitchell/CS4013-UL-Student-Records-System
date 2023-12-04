# CS4013-UL-Student-Records-System
## Overview
This Java project aims to build a student records system for the University of Limerick (UL), applying an object-oriented approach to software design and development. The system will handle various types of academic programs, student progression, and examination boards. The system will store student results, perform Quality Credit Average (QCA) calculations, and allow users to access and manage academic records

The academic regulations that were considered can be found here - https://www.ul.ie/media/38815/download?inline
## Objectives
1.	Apply an object-oriented approach to the design and development of a software application
2.	Apply concepts and techniques introduced in lectures tutorials and labs to the design and development of a small application


## System Requirements
The student records system should:
- Store student results and perform QCA calculation per semester/year/programme 
- Identify students not meeting minimum academic standards for progression
- Allow students to review their transcripts
- Enable faculty to look up transcripts and submit results for modules
- Support departments in holding exam boards to review student progression
- Store files associated with the application as CSV files
- Include a command line interface

## Prerequisite
Prerequisites for running the student record system:

Before executing the program, ensure that the following CSV files exist and are correctly formatted with comma-separated data:

Samples of all of these files can be found in the Records folder

**Students.csv:**
- Contains student details on each line (ID, Address, Programme, Year of Study)
- e.g. 2118737, Yolanda Benoit, 506 Comodo St., LM121, 1

**Transcripts.csv:**
- Stores transcript data on each line (ID, Semester, Academic Year, Semester QCA, Cumulative QCA, QCS, Credits, Module, Grade, Module, Grade…)
- e.g. 2118737, SEM1, 2020/2021, 4.00, 4.00, 120.0, 30, CS4012, A1, CS4141, A1

**Modules.csv:**
- Contains information about the modules (Code, Name, Credits, Quality Hours, Grade Scale)
- e.g. CS4084, Mobile Application Development, 6, 6, 0

**Programmes.csv:**
- Contains details about the academic programmes (Type, Code, Name, Duration, Credits) followed by all the modules associated with
- e.g. BSc, LM121, Computer Science, 4, 120, CS4012, CS4043, CS4141, CS4222, CS4221, CS4182, ET4011, ET4162…

**RepeatStudents.csv:**
- Includes information about students who are repeating modules, semesters and year. (Student ID, Repeat status, Exams to be repeated)
- e.g. 21982892, Repeat Semester
- e.g. 22819209, Repeat Exam, CS4321, CS4212


Additionally, for loading module grades, you must have separate CSV files for each module, formatted as follows:
- The first line of each file should include the following header:
  (Module Code, Semester, Academic Year)
- e.g. CS4012, SEM1, 2022/2023
- Every line after should contain data in the format: Student ID, Grade. e.g. 2182738, A1
- A sample multiple samples of module grades can be found in the Grades folder

## Step Instructions
On start up you will be presented with a command line menu, below are the steps to navigate the menu and program. The following steps must be performed in order. 

1.	**Submit Module Grades:**
- Select menu option 1
- Enter the file name of the module grades

2.	**Hold Exam Review:**
- Select menu option 2
- New menu appears
3.	**Search Transcripts:**
- Select menu option 1
- New menu appears
4.	**Search Transcripts by Student:**
- Select menu option 1
- Enter student ID
- Transcripts by student appear on screen
5.	**Search Transcripts by Programme:**
- Select menu option 2
- Enter programme code
- Transcripts by programme appear on screen
6.	**Go Back:**
- Select menu option 3
- Previous menu appears
7.	**Current Semester Transcripts:**
- Select menu option 2
- Student semester transcripts appear on screen
8.	**Check repeat students:**
- Select menu option 3
- Repeat students appear on screen
9.	**Go Back:**
- Select menu option 4 (Back)
- Previous menu appears
10.	 **Quitting:**
- Select menu option 3 (Quit)
- Closes the program





