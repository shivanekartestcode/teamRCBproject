package test.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main implements Comparator<Integer>{



   public void selectionSort()
   {
        int[]arr={9,8,7,6,5,4,3,2,1};
        int min_index,temp;
        for(int i=0;i<=arr.length-2;i++)//no of passes//positions where lowest element can be kept
        {
            min_index=i;
            for(int j=i+1;j<=arr.length-1;j++)//size of the unsorted sub-array decreases with every pass by 1
            {
                if(arr[min_index]>arr[j])
                {
                    min_index=j;
                }
            }//inner loop
            //swap the minimum element with the beginning of the sorted sub-array
            temp=arr[min_index];
            arr[min_index]=arr[i];
            arr[i]=temp;
        }
        PrintWriter pw=new PrintWriter(System.out);
        pw.println(Arrays.toString(arr));
        pw.flush();
        return;
        //pw.flush();//unreachable code compile time error
   }

   public static void bubbleSort()
   {
       int arr[]= {9, 8, 7, 6, 5, 4, 3, 2, 1};
       //bubble the largest element to the end of the array with every pass
       //for an array of N elements, N-1 passes are required
       //if N-1 elements are sorted in N-1 passes, Nth element is automatically sorted
       //we compare if adjacent elements are out of order
       //if adjacent elements are out of order, swap them
       //arr[j+1]=AIOBE arr.length-2
       int temp;
       for(int i=0;i<=arr.length-2;i++)//N-1 passes
       {
           for(int j=0;j<=arr.length-2;j++)//[arr[j+1]=AIOBE-arr.length-2
           {
               if(arr[j]>arr[j+1])//compare if adjacent elements are out of order
               {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
               }
           }
       }
       PrintWriter pw=new PrintWriter(System.out);
       pw.println(Arrays.toString(arr));
       pw.flush();
       pw.close();
       return;
       //pw.close();//unreachable code
   }

   public static void linearSearch()
   {
       int arr[]=new int[]{1,2,3,4,5,6,7,8,9};
       Scanner scanner=new Scanner(System.in);
       int key=scanner.nextInt();
       int index=-1;
       for(int i=0;i<=arr.length-1;i++)
       {
           if(arr[i]==key)
           {
               index=i;
           }
       }
       PrintWriter pw=new PrintWriter(System.out);
       if(index!=-1)
       {
           pw.println("The element " + key + " has been found at index " + index);
           pw.flush();
       }
       else
       {
           pw.println("The element "+key+" has not been found in the array at any index");
           pw.flush();
       }
       pw.close();
       return;
   }

   public static void binarySearch()throws IOException
   {
       Scanner scanner=new Scanner(System.in);
       System.out.println("Enter number of array elements");
       int N=(int)scanner.nextFloat();
       int[]arr=new int[N];
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String[]elements=br.readLine().trim().split("\\s+");
       for(int i=0;i<=N-1;i++)
       {
           arr[i]=Integer.parseInt(elements[i]);
       }
       PrintWriter pw=new PrintWriter(System.out);
       pw.println(Arrays.toString(arr));
       pw.flush();

      /* pw.println("Enter the key to be searched");
       pw.flush();//must*/
       //int key=(int)Float.parseFloat(scanner.next());//gives trouble program gets stuck 65.7899f, works with debug point here
       /*String keyString=scanner.next();
       int key=Integer.parseInt(keyString);*/
       int key=scanner.nextInt();//always debug here else program stuck

       int l=0,r=arr.length-1,pos=-1,mid;
       while(l<=r)
       {
           mid=(l+r)/2;

           if(arr[mid]==key)
               pos=mid;
           else if(arr[mid]>key)
               r=mid-1;
           else if(arr[mid]<key)
               l=mid+1;
       }
       if(pos!=-1)
       {
           pw.println("The key "+key+" has been found at index "+pos);
           pw.flush();
       }else {
           pw.println("The key "+key+" has not been found in the array");
           pw.flush();
       }
       pw.close();
       return;
       //unreachable code here//pw.close()//compile time error
   }

   public static void secondLargest()
   {
       int[]arr={1,2,3,4,5,6,7,8,9};
       int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE;
       for(int i=0;i<=arr.length-1;i++)
       {
           if(arr[i]>max1)
               max1=arr[i];
       }
       PrintWriter pw=new PrintWriter(System.out);
       pw.println("Laregst element is "+max1);
       pw.flush();
       for(int i=0;i<=arr.length-1;i++)
       {
           if(arr[i]>max2 && arr[i]<max1)
               max2=arr[i];
       }
       pw.println("Second largest element is "+max2);
       pw.flush();
       pw.close();
       return;
   }

   static void secondLargestWay2()
   {
       int[]arr=new int[]{9,8,7,6,5,4,3,2,1};
       Arrays.sort(arr);
       System.out.println(arr[arr.length-2]);

   }

   static void frequencyOfChars()
   {
       String str1="Nag p urNam gpurNagpur  Ward haPune    BangaloreChennai".toUpperCase().trim().replaceAll("\\s+","");
       HashMap<Character,Integer> hmap=new HashMap<Character,Integer>();
       for(int i=0;i<=str1.length()-1;i++)
       {
           if(hmap.get(str1.charAt(i))==null)
           {
               hmap.put(str1.charAt(i),1);
           }
           else
           {
               hmap.put(str1.charAt(i),hmap.get(str1.charAt(i))+1);
           }
       }//for

       PrintWriter pw=new PrintWriter(System.out);
       Set<Map.Entry<Character,Integer>>entries=hmap.entrySet();
       for(Map.Entry<Character,Integer>temp:entries)
       {
           pw.println("The occurrences of "+temp.getKey()+"  are "+temp.getValue());
           pw.flush();
       }
       pw.close();
       return;
   }//method

    public static void frequencyOfWords()
    {
        String wordSequence=new String("This is world world world is nice                very very very very   nice");
        String[]words=wordSequence.trim().toUpperCase().split("\\s+");
        Map<String,Integer>lhmap=new LinkedHashMap<String,Integer>();
        for(int i=0;i<=words.length-1;i++)
        {
            if(lhmap.get(words[i])==null)
            {
                lhmap.put(words[i],1);
            }else
            {
                lhmap.put(words[i],lhmap.get(words[i])+1);
            }
        }
        PrintWriter pw=new PrintWriter(System.out);
        Iterator<Map.Entry<String,Integer>>itr=lhmap.entrySet().iterator();
        Map.Entry<String,Integer>temp;
        while(itr.hasNext())
        {
            temp=itr.next();
            pw.println("The occurrences of word "+temp.getKey()+" are "+temp.getValue());
            pw.flush();
        }
        pw.close();
        return;
        //pw.close()//unreachable code compile time error
    }//method

    public static void printUniqueNumsAsTheyOccur()//print Unique elements as they occur
    {
        int[]arr=new int[]{5,1,-99,5,5,5,73,45,73,73};
        HashMap<Integer,Integer>hmap=new HashMap<Integer,Integer>();
        PrintWriter pw=new PrintWriter(System.out);
        for(int i=0;i<=arr.length-1;i++)
        {
            if(hmap.get(arr[i])==null)
            {
                pw.println("UniqueNumber="+arr[i]);
                pw.flush();
                hmap.put(arr[i],1);
            }
            else
            {
                hmap.put(arr[i],hmap.get(arr[i])+1);
            }
        }//for
        pw.close();
        return;
        //unreachable code
    }//method

    public static void removeDuplicatesOneLineArray()
    {
        int arr[]=new int[]{1,2,1,2,12,1,2,1,2,3,4,4,4,4,5,5,5,5,5,5,6,6,7,8,8,-99,-99};
        Set<Integer>set1=new HashSet<Integer>();
        for(int i=0;i<=arr.length-1;i++)
        {
            set1.add(arr[i]);
        }
        System.out.println(set1);
    }

    public static void removeDuplicatesOneLineArrayList()
    {
        PrintWriter pw=new PrintWriter(System.out);
        ArrayList<Integer>alist=new ArrayList();
        int[]arr=new int[]{1,2,22,2,2,2,2,2,3,4,3,4,3,4,3,4,3,5,5,5,5,7,7,7,78,8,8,8,9,9,9,9,9,9,11,1,11,11,111};
        for(int temp:arr)
        {
            alist.add(temp);
        }
        pw.println(alist);
        pw.flush();

        Set<Integer>set=new HashSet<Integer>(alist);
        pw.println("Unique elements "+set);
        pw.flush();
        pw.close();
        return;
        //unreachable code here
    }//method

    public static void reverseStringManyWays()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String");
        String str1=br.readLine();
        //iterative way TC=O(N) SC=O(N);-------------------------------------------
        String revString="";//Never take this string as null
        for(int i=str1.length()-1;i>=0;i--)
        {
            revString+=str1.charAt(i);
        }
        System.out.println("Using Iterative way O(N) "+revString);

        //using Mutable strings
        StringBuilder sb=new StringBuilder(str1);
        sb.reverse();
        System.out.println("Using StringBuilder="+sb);

        StringBuffer sb1=new StringBuffer(str1);
        sb1.reverse();
        System.out.println("Using StringBuffer="+sb1);

        //using stack
        Stack<Character>stack=new Stack<Character>();
        char[]letters=str1.toCharArray();
        for(int i=0;i<=letters.length-1;i++)
        {
            stack.push(letters[i]);
        }
        System.out.println("Stack is"+stack);
        Collections.reverse(stack);
        System.out.println("String reversed by Collections.reverse() method is"+stack);

        System.out.println("Enter String");
        str1=br.readLine();
        letters=str1.toCharArray();
        for(int i=0;i<=letters.length-1;i++)
        {
            stack.push(letters[i]);
        }
        revString="";//reset revString to empty String again
        for(int i=0;i<=stack.size()-1;i++)
        {
            revString+=stack.pop();
        }
        System.out.println(revString);

        System.out.println("Enter String");
        str1=br.readLine();
        char[]letters2=str1.toCharArray();
        //inplace algorithm to reverse a string
        //TC=O(N) SC=O(1)
        char temp;
        for(int i=0,j=letters2.length-1;i<=letters2.length-1;i++,j--)
        {
            if(i<j)
            {
                temp=letters2[i];
                letters2[i]=letters2[j];
                letters2[j]=temp;
            }
        }
        String reverseString=new String(letters2);
        System.out.println("Reversed String by in-place swapping is "+reverseString);

    }//method

    public static void reverseArrayManyWays()
    {
        int[]arr=new int[]{1,2,3,4,5,6,7,8,9};

        //using another array----------------------------------------------------------
        //TC =O(N) SC=O(N) for a new array to store
        int[]reversedArr=new int[arr.length];

        for(int i=arr.length-1,j=0;i>=0;i--,j++)//2 loop counters
        {
            reversedArr[j]=arr[i];
        }
        System.out.println("Array Reversed by another array is"+Arrays.toString(reversedArr));

        //using in-place algorithm in-place swapping
        arr=new int[]{1,2,3,4,5,6,7,8,9};
        int temp;
        for(int i=0,j=arr.length-1;i<=arr.length-1;i++,j--)//2 counters
        {
            if(i<j)
            {
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        System.out.println("Reversal of array by inplace algorithm  swapping is"+Arrays.toString(arr));
    }//method

    public static void reverseArrayListManyWays()
    {
        //reverse arraylist by Collections.reverse() method TC=O(N) SC=O(1) In place algorithm--------------
        List<Integer>alist=new ArrayList<Integer>();
        for(int i=22;i<=31;i++)
        {
            alist.add(i);
        }
        Collections.reverse(alist);
        System.out.println("ArrayList reversed by Collections.sort()"+ alist);

        //reverse arraylist by another arraylist
        alist.clear();
        for(int i=15;i<=24;i++)
        {
            alist.add(i);
        }

        for(int i=0,j=alist.size()-1;i<=alist.size()-1;i++,j--)
        {
            if(i<j)
            {
                /***********************************************
                temp=alist.get(i);
                alist.set(i,alist.get(j));
                alist.set(j,temp);
                ***********************************************///does not work
                Collections.swap(alist,i,j);
            }
        }//for
        System.out.println("ArrayList reversed by Collections.swap(alist,i,j) is "+ alist);
        ArrayList<Integer>reverse=new ArrayList<Integer>(alist.size());//VITAL

        //reverse arraylist by custom comparator
        alist.clear();
        for(int i=99;i<=107;i++)
        {
            alist.add(i);
        }
        Collections.sort(alist,new Main());
        System.out.println("ArrayList reversed by custom comparator is "+alist);

    }//method

    //custom comparator for Integer-------------------------------------VITAL
    @Override
    public int compare(Integer i1,Integer i2)
    {
        return i2.compareTo(i1);
        //reverse sorting
    }//method

    public static void reverseHashMapByValues()
    {
        HashMap<Integer,String>hmap=new HashMap<Integer,String>();
        String[]keyValues={"1:Nagpur","2:Pune","3:Bangalore","4:Delhi","5:Chennai","6:Cuttack","7:Cochin"};
        String[]temp;
        for(int i=0;i<=keyValues.length-1;i++)
        {
            temp=keyValues[i].split(":");
            hmap.put(Integer.parseInt(temp[0]),temp[1].trim().toUpperCase());
        }

        Set<Map.Entry<Integer,String>>entries=hmap.entrySet();
        List<Map.Entry<Integer,String>>list11=new ArrayList<Map.Entry<Integer,String>>(entries);
        Collections.sort(list11,new EntryComparator());
        for(int i=0;i<=list11.size()-1;i++)
        {
            System.out.println("The Key is "+list11.get(i).getKey()+" The value is "+list11.get(i).getValue());
        }
    }//method

    public static void armstrongPrimeReversePaliandrome()throws IOException
    {

        //prime---------------------------------------------------------------------------------------
        System.out.println("Enter range of numbers to be checked prime separated by space");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]rangenums=br.readLine().trim().split("\\s+");
        int lower=Integer.parseInt(rangenums[0]);
        int upper=Integer.parseInt(rangenums[1]);
        boolean isPrime;
        int primeCount=0;
        for(int number=lower;number<=upper;number++)//loop of numbers in range [lower,upper]
        {
            isPrime=true;//set isPrime per number
            inner: for(int divisor=2;divisor<=number/2;divisor++)//named for VITAL
            {
                if(number==1)
                {
                    isPrime=false;
                }
                else if(number%divisor==0)
                {
                    isPrime=false;
                    break inner;
                }
            }//inner loop of divisors[2,n/2]
            if(isPrime)
            {
                System.out.print(number + " ");
                primeCount++;
            }//prime condition

                /*System.out.println();*///do not put it here//wrong place
        }//outer for all numbers to be checked prime
        System.out.println();
        System.out.println("Count of primes between "+lower  +" and "+upper +" is "+primeCount);
        //-------------------------------------------------------------------------------------prime end----------
        //reverse of a number
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number to reverse");
        int num=Integer.parseInt(scanner.next());
        //for paliandrome preserve original number
        int temp=num;
        int rem;
        long revNum=0;

        while(temp>0)
        {
            rem=temp%10;
            temp=temp/10;
            revNum=10*revNum+rem;
        }
        System.out.println("Reversed Number is "+revNum);////////////////////////VITAL
        if(revNum==num)
            System.out.println("Number "+num+" is paliandrome");
        else
            System.out.println("Number "+num+" is not paliandrome");
        //reverse of a number------------------------------------------------------------end----------------------------
        //Armstrong numbers in a range
        System.out.println("Enter range of nums for armstrong ");
        lower=Integer.parseInt(scanner.next());
        upper=Integer.parseInt(scanner.next());
        long armstrongSum;//do not set it 0 here

        for(int number=lower;number<=upper;number++)//loop for all numbers to be checked in range [lower,upper]
        {
            temp=number;//preserve original number in number, reduce temp inside loop
            armstrongSum=0;///armstrongSum=0 MUST happen here ONLY---------------------------VITAL
            while(temp>0)
            {
                rem=temp%10;///Not temp*10 but temp%10-silly mistake--------------------------VITAL
                temp=temp/10;
                armstrongSum+=Math.pow(rem,3);
            }//loop to reduce temp to zero
            if(armstrongSum==number)
                System.out.print(number+" ");
        }
        System.out.println();
        //end of armstrong numbers----------------------------------------------------------------------------------------------
    }//method

    public static void charToIntAndIntToChar()
    {
        ///////////////////////
        int A='A';
        System.out.println(A);

        ////////////////////////
        char ch1=65;
        System.out.println(ch1);
        ///////////////////////////
        int space=' ',star='*';
        System.out.println(space+"   "+star);

        //////////////////////////////////
        int[]arr=new int[]{'A','Z','*','%','a','z','0','9',' '};
        for(int i=0;i<=arr.length-1;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        //////////////////////////////////
        char[]chars=new char[]{65,90,97,122,48,32,57};
        for(char temp:chars)
        {
            System.out.print(temp+" ");
        }
        System.out.println();

    }//method

    public static void countAlphaDigitsCharsSpacesTwoWays()
    {
        String word="NagpurPun  eAmnaravati874893             5908390482982 79473  89437   59735********$$%%$#@@!!(()_++_(*&^%%$$";
        char[]letters=word.toCharArray();
        //////////////////////way1//////////////////////////////////////////////////////////////////////
        int digitCount=0,alphaCount=0,spaceCount=0,specialCount=0;
        for(int i=0;i<=letters.length-1;i++)
        {
            if(Character.isDigit(letters[i]))
            {
                digitCount++;
            }
            else if(Character.isSpaceChar(letters[i]))
            {
                spaceCount++;
            }
            else if(Character.isAlphabetic(letters[i]))
            {
                alphaCount++;
            }
            else
            {
                specialCount++;
            }
        }//for loop
        System.out.println("Number of alphabets is "+alphaCount+"\n"+
                "Number of digits is "+digitCount+"\n"+
                "Number of spaces is "+spaceCount+"\n"+
                "Number of special characters is "+specialCount);
        //////////////////////////////////WAY1////////////////////////////////////////////////////////////
        /////////////////////////////////WAY2/////////////////////////////////////////////////////////////
        //reset all counts for way 2
        digitCount=0;
        alphaCount=0;
        spaceCount=0;
        specialCount=0;

        for(int i=0;i<=letters.length-1;i++)
        {
            if( (letters[i]>=65 && letters[i]<=90) || (letters[i]>=97 && letters[i]<=122))
                alphaCount++;
            else if(letters[i]==32)
                spaceCount++;
            else if(letters[i]>=48 && letters[i]<=57)
                digitCount++;
            else
                specialCount++;
        }//for loop
        System.out.println("Number of alphabets is "+alphaCount+"\n"+
                "Number of digits is "+digitCount+"\n"+
                "Number of spaces is "+spaceCount+"\n"+
                "Number of special characters is "+specialCount);
    }//method

    public static void findAllSubStringsAndCountThem()
    {
        String str1="AMARAVATI";
        int subStringCount=0;
        for(int i=0;i<=str1.length()-1;i++)
        {
            for(int j=i+1;j<=str1.length()-1;j++)
            {
                System.out.println(str1.substring(i,j));
                subStringCount++;
            }
        }
        System.out.println("Number of substrings="+subStringCount);
    }//method

    public static void findCommonUncommonElementsInArrays()
    {
        int []arr1=new int[]{1,2,3,4,5,6,7,8,9};
        int arr2[]={1,1,1,1,1,1,1,3,3,3,3,3,3,6,6,6,6,6,6,7};

        List<Integer>union=new ArrayList<Integer>();
        int i,j;
        for( i=0,j=0;i<=arr1.length-1 && j<=arr2.length-1;i++,j++)
        {
            if(arr1[i]<arr2[j])
            {
                System.out.print(arr1[i]);
                ++i;
            }
            else if(arr2[j]<arr1[i])
            {
                System.out.print(arr2[j]);
                j+=1;
            }
            else if(arr1[i]==arr2[j])
            {
                    i++;
                    j++;
                    //do not print common element
            }
        }
        //remaining from arr1
        for(;i<=arr1.length-1;i++)
            System.out.print(arr1[i]);
        for(;j<=arr1.length-1;j++)
            System.out.print(arr2[j]);
        //System.out.println(union);
    }//method



    public static void main(String[] args)throws IOException {

        //this.selectionSort();//doesn't work
        //super.toString();//doesn't work

        //start-------------------------------------------------------------
        //new Main().selectionSort();
        //bubbleSort();
        //linearSearch();
        //binarySearch();
        //secondLargest();
        //secondLargestWay2();
        //frequencyOfChars();
        //frequencyOfWords();
        //printUniqueNumsAsTheyOccur();
        //removeDuplicatesOneLineArray();
        //removeDuplicatesOneLineArrayList();
        //reverseStringManyWays();
        //reverseArrayManyWays();
        //reverseArrayListManyWays();
        //reverseHashMapByValues();
        //armstrongPrimeReversePaliandrome();
        //charToIntAndIntToChar();
        //countAlphaDigitsCharsSpacesTwoWays();
        //findAllSubStringsAndCountThem();//O(N^3) time
        findCommonUncommonElementsInArrays();
        return;
    }//main
}


