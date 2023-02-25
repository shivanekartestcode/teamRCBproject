package test.practice;

import java.util.Comparator;
import java.util.Map;

public class EntryComparator implements Comparator<Map.Entry<Integer,String>>
{
    @Override
    public int compare(Map.Entry<Integer,String>entry1,Map.Entry<Integer,String>entry2)
    {
        return entry2.getValue().compareTo(entry1.getValue());
        //reverse order of entry on basis of reverse values
    }
}
