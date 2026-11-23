#!/bin/bash

getNameExt(){
	
	ext=""
	name=""
	fullname=$1
	i=0
	currentChar=""
	
	bucket=0
	
	while [ $i -lt ${#fullname} ]; do
		if [[ "$currentChar" == "." && bucket -eq 0 ]]; then
			bucket=1
		fi
		
		currentChar=${fullname:$i:1}
		
		# echo $bucket $currentChar
		
		if [[ "$currentChar" == "." ]]; then
			:
		elif [[ $bucket -eq 0 ]]; then
			name=$name$currentChar
		else 
			ext=$ext$currentChar
		fi
		
		i=$(( $i + 1 ))
	
	done	
	
	echo "Name" $name", Ext" $ext
	

}

init(){
	case $1 in 
		
		"txt")
			echo "Text"
		;;
		
		"java")
			echo "Java"
		;;
		
		"cpp")
			echo "C++"
		;;
		
		"c")
			echo "C"
		;;
		
		"py")
			echo "Python"
		;;
		
		"sh")
			echo "Bash Shell Script"
		;;
		
		"lnu")
			echo "LenNox UNO"
		;;
		
		"nx")
			echo "LenNox"
		;;
		
		*)
			echo "Unknown"
		;;
	esac
}


fileName=$1





