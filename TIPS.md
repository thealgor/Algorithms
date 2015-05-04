1. For Getting Integer Length
int length = Math.log10(1000)+1 (Integer length).
2. For Filling Arrays with a particular value
Arrays.fill(arr,0);
3.Library to Sort an Array
Arrays.sort(arr)4.Always use Math.min
int min = Math.min(min,curr); //instead of if else
5.Typical Max value and min value used
int min= Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
6.Variable Names:
boolean used.boolean found. long from, long to int i,j,k. If already used, use p1, p2,p3 int x,y,z – only for loops. You can also write for and if statement in one line.
7. CompareTo method:
str1.compareTo(str2) 
1) str1==str2 ==> return 0;
2) str1<str2 ==> returns <0
3) str1>str2 ==> returns >0;
8. Convert Arraylist to String[] array:
String[] res = list.toArray(new String[list.size()]);
9. Always be cautious of using Set vs List, Set or Map doesnt allow the key element to be duplicate. If you are adding stuff like names etc, there is a very likely duplicate name. Use lists
10. Remove specific characters from a java string:
  str = str.replace("X","");
  alwasy reassign otherwise, you are not actually replacing it.
11. For converting a character into its "actual" number, you can use this predefined method:
  int v = Character.getNumericValue(c);
12. Always ask for sizes of the variable. Sometimes bruteforce solution can be enough. For n! problems n<=10, bruteforce could be enough.
13.