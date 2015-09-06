#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Insert a nickname of an observer to be inregistered."
    exit 1
fi


curl --verbose --request DELETE http://localhost:8888/observer/$1
