#!/bin/bash

cd "$(dirname "$0")" || exit 1

echo "========== RUN TEST CASES =========="

mvn clean test
TEST_EXIT_CODE=$?

echo "========== OPEN ALLURE REPORT =========="

if [ -d target/allure-results ]; then
    mvn io.qameta.allure:allure-maven:3.1.0:serve
else
    echo "Allure results not found!"
fi

exit $TEST_EXIT_CODE