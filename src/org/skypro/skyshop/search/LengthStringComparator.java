package org.skypro.skyshop.search;

import java.util.Comparator;

public class LengthStringComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int res = Integer.compare(s2.searchTerm().length(), s1.searchTerm().length());
        if (res == 0) {
            res = s2.searchTerm().compareTo(s1.searchTerm());
        }
        return res;
    }
}

