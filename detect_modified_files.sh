#!/bin/bash

# Define the default branch explicitly (e.g., main or master)
default_branch="main"

# Automatically detect the default branch
default_branch=$(git remote show origin | grep 'HEAD branch' | cut -d' ' -f5)

# Get modified Java files between your branch and the default branch
modified_files=$(git diff --name-only $default_branch...HEAD -- '*.java')

# Output the modified files for debugging
echo "Modified files: $modified_files"

# Initialize variables to store test classes and modified classes
test_classes=""
modified_classes=""

# Loop through the modified files to find corresponding test classes
for file in $modified_files; do
    if [[ $file == *"src/main/java/"* ]]; then
        # Replace src/main/java with src/test/java and change .java to Test.java
        test_file="${file/src\/main\/java/src\/test\/java}"
        test_file="${test_file/.java/Test.java}"

        # Remove any escape characters for debugging
        test_file=$(echo "$test_file" | sed 's/\\//g')

        # Debug output for the expected test file
        echo "Expected test file: $test_file"

        # Add test file to the list if it exists
        if [ -f "$test_file" ]; then
            test_classes+="$test_file "
            # Remove any leading directory path for JaCoCo
            modified_classes+="${file/src\/main\/java/}\n"
        else
            echo "Test file not found: $test_file"
        fi
    fi
done

# Remove escaped newlines
modified_classes=$(echo -e "$modified_classes")

# Debug output for modified classes
echo "Modified classes: $modified_classes"

# Create or update the properties file for JaCoCo
properties_file="jacoco.properties"
echo "Generating $properties_file..."
echo "modifiedClasses=" > "$properties_file"

# If modified_classes is not empty, append to the properties file
if [ -n "$modified_classes" ]; then
    # Loop through the modified classes to generate the properties
    while IFS= read -r class; do
        # Strip the .java extension and add to properties file
        class_without_extension=${class/.java/}
        echo "$class_without_extension" >> "$properties_file"
    done <<< "$modified_classes"
    echo "Properties file generated successfully: $properties_file"
else
    echo "No modified classes found."
fi

# Run tests for the modified files using Jacoco
if [ -n "$test_classes" ]; then
    echo "Running tests for: $test_classes"
    ./mvnw clean test -Dtest="${test_classes##*/}" -Dmaven.jacoco.skip=false

    if [ $? -ne 0 ]; then
        echo "Maven tests failed!"
        exit 1
    else
        echo "Maven tests completed successfully."
    fi
else
    echo "No test classes found for modified files."
fi
