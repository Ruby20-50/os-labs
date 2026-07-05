#!/bin/bash 
if [ $# -ne 3 ]; then 
echo "Usage: calc.sh <int> <operator> <int>" > /dev/stderr 
exit 1 
fi 
num1=$1 
operator=$2 
num2=$3 
case "$operator" in 
ADD)  echo $(( num1 + num2 )) ;; 
SUB)  echo $(( num1 - num2 )) ;; 
MULT) echo $(( num1 * num2 )) ;; 
DIV)  echo $(( num1 / num2 )) ;; 
MOD)  echo $(( num1 % num2 )) ;; 
EXP)  echo $(( num1 ** num2 )) ;; 
*)   
esac 
A5: 
 echo "Usage: calc.sh <int> <operator> <int>" > /dev/stderr 
exit 1 ;; 
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
