#!/bin/bash

IDS=$(ls src/| cut -b 2-)

rm -f readme.md

for ID in $IDS
do
    title=$(curl https://www.nowcoder.com/practice/$ID 2>/dev/null | grep 'questionTitle'| cut -b 17-|rev| cut -b 3-|rev)
    echo $title >> readme.md
    echo ''  >> readme.md
    echo https://www.nowcoder.com/practice/$ID >> readme.md
    echo ''  >> readme.md
done