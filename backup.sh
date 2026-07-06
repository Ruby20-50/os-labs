#!/bin/bash 

# Name of the folder where backups will be stored
backup_dir="backup" 
 
postfix=$1  # First command-line argument = file ending/pattern to match (e.g. "txt")
input=""        # Holds the user's j/n answer

 # Create the backup folder only if it doesn't already exist
if [ ! -d "$backup_dir" ]; then 
        mkdir "$backup_dir" 
fi 

# Loop over every file in the current directory ending with $postfix
for file in *$postfix; do 
         # Make sure it's a regular file (not a directory)
        if [ -f "$file" ]; then 
                echo -n "Datei '$file' sicher? (j/n)" 
                read input 
                 # If the user typed "j" or "J", copy the file into the backup folder
                if [ "$input" = "j" -o $input = "J"]; then 
                cp $file ./$backup_dir/ 
                        echo "User: hat j oder J eingegeben!!" 
                fi 
        fi 
done 
