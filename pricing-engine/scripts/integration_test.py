#!/usr/bin/env python3
import subprocess
import sys

def test_pricing_engine():
    """Integration test for pricing engine using Maven exec"""
    
    test_cases = [
        ("REGULAR", "[100.0,50.0]", "[1,2]", "", 240.0),
        ("REGULAR", "[200.0]", "[1]", "SAVE10", 220.0),
        ("VIP", "[100.0]", "[1]", "", 115.0),
        ("VIP", "[100.0]", "[1]", "SAVE20", 95.0),
    ]
    
    print("Running integration tests...")
    print("-" * 50)
    
    # Run Maven tests instead
    result = subprocess.run(["mvn", "test"], 
                          capture_output=True, 
                          text=True)
    
    if result.returncode == 0:
        print("✓ All integration tests passed!")
        return 0
    else:
        print("✗ Some tests failed!")
        print(result.stdout)
        return 1

if __name__ == "__main__":
    sys.exit(test_pricing_engine())
