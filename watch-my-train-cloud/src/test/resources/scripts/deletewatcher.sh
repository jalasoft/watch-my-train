#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Zadej nazev watchera jako parametr!!!!"
    exit 1
fi


curl --verbose --request DELETE http://localhost:8888/watcher/$1
