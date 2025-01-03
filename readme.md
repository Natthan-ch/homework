Student CSV Sorter
A Java program for sorting and searching student records from CSV files.
Features

Sort students by:

Student ID (-n)
First Name (-f)
Last Name (-l)

Search students by first name (-s)
Filter records containing "2115"

Requirements

Java Runtime Environment (JRE) 8 or higher
CSV file with columns: ID, Student ID, First Name, Last Name

Usage 
java CSVSorter [option] [filepath] [search_name]

Options:

-n Sort by Student ID
-f Sort by First Name
-l Sort by Last Name
-s Search by First Name (requires search_name parameter)

Input File Format
CSV file with columns in this order:
ID,Student_ID,First_Name,Last_Name

Example
1,672115013,Natthan,Champathip

Examples
Sort by student ID:
java CSVSorter -n students.csv


Search for student:
java CSVSorter -s students.csv Natthan

Implementation Details

Uses Selection Sort algorithm
Vector data structure for storage
Case-insensitive name search
Trims whitespace from CSV fields

Error Handling

Missing file error message
Invalid command message
Missing search name message
Input validation for CSV fields
