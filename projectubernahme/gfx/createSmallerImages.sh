#!/bin/bash
rm *.png.*
for file in `ls *.png`
do
	echo "Working on $file ..."
	for size in 1 2 4 8 16 32 64 128 256
	do
		convert $file -resize ${size}x${size} $file.$size
	done
done

