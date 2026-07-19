#!/bin/bash 
dir=$1 
if [ ! -d "$dir" ]; then 
echo "Error: '$dir' is not a directory" > /dev/stderr 
exit 1  
fi 
for file in "$dir"/*; do 
if [ -f "$file" -a ! -x "$file" ]; then 
echo "$file" 
fi 
done