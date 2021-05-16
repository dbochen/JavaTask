# Java Academy Technical Task

## Additional assumptions
The below list contains assumptions made in the solution beyond the ones given in the task
* Every special character acts like a space, meaning that it divides the words. E.g. `global%logic` will be processed 
  by the code as two separate words `global` and `logic`.
* The set of characters in the output has not defined order. This means that 
  `{(l,o,g), 6} = 0.27 (4/15)` is equivalent to `{(g,l,o), 6} = 0.27 (4/15)`
  
## Input
The input data can be passed both from the console and from file. Program asks
the user for the desired way of entering the data and guides him though the process.
When the program gives options `1` or `2`, every other character than `1` is treated as `2`.

The solution can be easily extended for adding other types of input data by creating another
implementation of `DataReader` class.

### Input file format

When choosing the input from file, first line should contain the set of 
characters we are looking for in the text, and the next lines the text to analyse. For example:
```
LOGIC
"I love to work in global logic!"
```

## Output 

The program prints the result in the console in the following format:
```
{[o], 8} = 0,20 (1/5)
{[f, j], 6} = 0,40 (2/5)
{[s, d], 2} = 0,40 (2/5)
TOTAL Frequency: 0,24 (5/21)
```
After printing the above message, the program asks the user if he wants to save
the result to a file.