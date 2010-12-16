#!/bin/bash
for file in `ls *.png`
do
	for size in 1 4 16 64 256
	do
		convert $file -resize ${size}x${size} $file.$size
	done
done

