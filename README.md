## Sorting Service
Web service for sorting numbers using different algorithms with Spring Boot.
It returns not only the array of ordered numbers but also the steps that were performed to get to the final result.

### Available Algorithms:
- BUBBLE_SORT
- INSERTION_SORT
- SELECTION_SORT

### Input:
```JSON
{
    "algorithmName": "BUBBLE_SORT",
    "numbers": [1, 7, 5]
}
```

### Output:
```JSON
{
    "numbers": [
        1,
        7,
        5
    ],
    "sortedNumbers": [
        1,
        5,
        7
    ],
    "operations": [
        {
            "indexCompared": 0,
            "indexComparedWith": 1,
            "type": "COMPARE"
        },
        {
            "indexCompared": 1,
            "indexComparedWith": 2,
            "type": "COMPARE"
        },
        {
            "indexSwapped": 1,
            "indexSwappedBy": 2,
            "type": "SWAP"
        },
        {
            "indexCompared": 0,
            "indexComparedWith": 1,
            "type": "COMPARE"
        }
    ]
}
```

