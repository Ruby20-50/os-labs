#!/bin/sh 
 
if [ $# -ne 3 ]; then 
        echo "Usage: quiz.sh Frage A1 A2" > /dev/stderr 
        exit 1 
fi 
 
while true; do 
        echo "$1 ($2/$3):" 
        read antwort 
 
        if [ "$antwort" = "$2" ]; then 
                exit 0 
        elif [ "$antwort" = "$3" ]; then 
                exit 1 
        else 
                echo "Bitte $2 oder $3 eingeben!" 
 
        fi 
done