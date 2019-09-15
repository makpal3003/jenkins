#!/bin/bash
PID$(sudo lsof -i:5000   | awk '{print $2}' | grep [[:digit:]])"
kill $PID 2> /dev/null