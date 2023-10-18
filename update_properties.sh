#!/bin/bash

# Assign the filename

filename="gradle.properties"
if [ -e "$filename" ]; then
  sed -i "s,.*BASE_URL.*,BASE_URL=\"$4\"," $filename
  sed -i "s/.*MAP_KEY.*/MAP_KEY=\"$5\"/" $filename
  sed -i "s/.*RETRY_ATTEMPTS.*/RETRY_ATTEMPTS=$6/" $filename
  sed -i "s/.*THRESHOLD_VALUE.*/THRESHOLD_VALUE=$7/" $filename
else
  touch gradle.properties
  # shellcheck disable=SC2129
  echo "BASE_URL=\"$4\"" >> gradle.properties
  echo "MAP_KEY=\"$5\"" >> gradle.properties
  echo "RETRY_ATTEMPTS=$6" >> gradle.properties
  echo "THRESHOLD_VALUE=$7" >> gradle.properties
fi