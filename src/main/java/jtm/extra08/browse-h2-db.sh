#!/bin/bash
cdir=$(dirname "$0")
java -jar ~/.m2/repository/com/h2database/h2/1.4.196/h2-1.4.196.jar -url jdbc:h2:./$cdir/database -user sa
