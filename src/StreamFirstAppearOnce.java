import java.util.*;

public class StreamFirstAppearOnce {
/******************Method 1************************/
//    record frequency || just use a hashSet to record if appeared or not
    HashMap<Character, Integer> cache = new HashMap<>();
//    record order
    LinkedList<Character> str = new LinkedList<>();

    //Insert one char from stringstream
    public void Insert1(char ch)
    {
        if (cache.containsKey(ch)) cache.put(ch, cache.get(ch) + 1);
        else {
            cache.put(ch, 1);
            str.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce1()
    {
        for (char c : str) {
            if (cache.get(c) == 1) return c;
        }
        return '#';
    }

/*******************Method 2************************/

    ArrayDeque<Character> data = new ArrayDeque<>();
    int[] cnt = new int[128];

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        cnt[ch] += 1;
        if (cnt[ch] == 1) data.addLast(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while(!data.isEmpty() && cnt[data.getFirst()] >= 2) data.removeFirst();
        if (data.isEmpty()) return '#';
        return data.peekFirst();
    }

    public static void main(String[] args) {
        StreamFirstAppearOnce s = new StreamFirstAppearOnce();
        s.Insert('g');
        assert(s.FirstAppearingOnce() == 'g');
        s.Insert('o');
        assert(s.FirstAppearingOnce() == 'g');
        s.Insert('o');
        assert(s.FirstAppearingOnce() == 'g');
        s.Insert('g');
        assert(s.FirstAppearingOnce() == '#');
        s.Insert('l');
        assert(s.FirstAppearingOnce() == 'l');
        s.Insert('e');
        assert(s.FirstAppearingOnce() == 'l');

    }
}
