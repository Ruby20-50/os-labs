#!/bin/bash 
# 
        backup_dir="backup" 
 
postfix=$1 
input="" 
 
if [ ! -d "$backup_dir" ]; then 
        mkdir "$backup_dir" 
fi 
for file in *$postfix; do 
        if [ -f "$file" ]; then 
                echo -n "Datei '$file' sicher? (j/n)" 
                read input 
                if [ "$input" = "j" -o $input = "J"]; then 
                cp $file ./$backup_dir/ 
                        echo "User: hat j oder J eingegeben!!" 
                fi 
        fi 
done 
