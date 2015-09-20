#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Ocekavam 1 parametr a to vlak"
    exit 1
fi

curl -request GET --verbose http://localhost:8888/train/$1
