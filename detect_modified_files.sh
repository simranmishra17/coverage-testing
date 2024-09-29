#!/bin/bash

# Define the default branch explicitly (e.g., main or master)
default_branch="main"

# Get modified Java files between your branch (SM-1) and the default branch
modified_files=$(git diff --name-only $default_branch...SM-1 -- '*.java')

# Output the modified files for debugging
echo "Modified files: $modified_files"

# Process the modified files if any
for file in $modified_files
do
    echo "Processing file: $file"
done
