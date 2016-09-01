#!/bin/sh
cat "$1" | grep "$2" -A $3
sleep 3
clear