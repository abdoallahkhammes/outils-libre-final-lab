#!/bin/bash

echo "==================================="
echo "Pricing Engine - Test Suite"
echo "==================================="
echo ""

echo "1. Running Unit Tests (JUnit)..."
echo "-----------------------------------"
mvn clean test

if [ $? -eq 0 ]; then
    echo "✅ Unit tests passed!"
else
    echo "❌ Unit tests failed!"
    exit 1
fi

echo ""
echo "2. Running Integration Tests (Python)..."
echo "-----------------------------------"
python3 scripts/integration_test.py

if [ $? -eq 0 ]; then
    echo "✅ Integration tests passed!"
else
    echo "❌ Integration tests failed!"
    exit 1
fi

echo ""
echo "==================================="
echo "🎉 All tests passed successfully!"
echo "==================================="
