#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Insert a nickname of a new observer as a parameter."
    exit 1
fi

if [ -z $1 ]; then
    echo "Observer name must not be zero length."
    exit 1
fi

BODY="{
    \"nickname\" : \"$1\"
}"

echo "Body prepared:"
echo "$BODY"

curl --request POST --data "$BODY" --verbose --header "Content-Type:application/json" 0.0.0.0:8888/observer/
