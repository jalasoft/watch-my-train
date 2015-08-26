#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Insert name as a parameters."
    exit 1
fi

BODY="{
    \"name\" : \"$1\"
}"

echo "Body prepared:"
echo "$BODY"

curl --request POST --data "$BODY" --verbose --header "Content-Type:application/json" 0.0.0.0:8888/watcher/
