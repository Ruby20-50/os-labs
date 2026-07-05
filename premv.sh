#!/bin/bash 
if [ $# -ne 2 ]; then 
echo "Usage: premv.sh <old-prefix> <new-prefix>" > /dev/stderr 
exit 1 
fi 
oldprefix=$1 
newprefix=$2 
for file in $oldprefix*; do 
if [ -f "$file" ]; then 
suffix="${file#$oldprefix}"   # saves everything AFTER the old prefix 
mv "$file" "$newprefix$suffix" 
fi 
done 
